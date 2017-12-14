ohgrePortal.controller('ReferAFriendController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

    $scope.step2=false;

    var updateCustomerInfoReq={};
    var bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            console.log(val);
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
          var description=$(this).find('span').text();
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $scope.setLdcInfo(mainValue,description);
             $('#fixed-plans-button').val(mainValue);

          $scope.errorInfo=null;
          $scope.$apply();

		});

    }


$scope.termsupdate=false;
     $rootScope.redirecttohome =function(){
			//location.href=$rootScope.homeUrl+".html";
          jQuery("#raf-terms-popup").removeClass("show-popup");
          jQuery("#login-inactive-popup").addClass("show-popup");




    }

     $rootScope.closeDeclinePopup =function(){

				jQuery("#login-inactive-popup").removeClass("show-popup");
     }
    $scope.setLdcInfo =function(ldc,description){
		$scope.ldc=ldc;
        $scope.ldcdesc=description;
         $scope.an1=null;
        $scope.an2=null;
        $scope.an3=null;
        $scope.an4=null;

         $scope.an1r=false;
        $scope.an3r=false;
         $scope.an4r=false;

        $scope.an1required=true;
        $scope.an2required=true;
        $scope.an3required=true;
        $scope.an4required=true;


        if(ldc == "COH"){
			$scope.an1minl="8";
		    $scope.an2minl="3";
            $scope.an3minl="3";
            $scope.an4minl="1";
            $scope.an3="000";
            $scope.an3r=true;


        }else if(ldc == "DUK"){
			$scope.an1minl="4";
		    $scope.an2minl="4";
            $scope.an3minl="2";
            $scope.an4minl="1";

        }else if(ldc == "DEO"){
			$scope.an1minl="1";
		    $scope.an2minl="4";
            $scope.an3minl="4";
            $scope.an4minl="4";

        }else if(ldc == "VED"){
			$scope.an1minl="2";
		    $scope.an2minl="9";
            $scope.an3minl="7";
            $scope.an4minl="1";
            $scope.an1="03";
            $scope.an4="0";
            $scope.an1r=true;
            $scope.an4r=true;

        }else if(ldc == "MCG"){
            console.log("MCG values set");
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(ldc == "MIC"){
             console.log("MIC values set");
            $scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";

            $scope.an1required=false;
            $scope.an2required=false;
            $scope.an3required=false;
        }

         $scope.raf.submited = false;
         $scope.raf.lastname.$visited=false; 
        $scope.lastname=null;
       // $scope.raf.$setUntouched();
        $scope.raf.$setPristine();
         $scope.$apply();
    }

    PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
               console.log(data.LDCList);
             $scope.ldcinfo=data.LDCList;
             setTimeout(function(){ bindClickEvent(); }, 10);
         }

         }).error(function (data,status, headers, config){

             console.log("error");
         });

    $scope.referafriendsubmit =function(){
        var ldc=jQuery('#fixed-plans-button').val();
        if(ldc){
			$scope.step2=true;
        }
    }

    $scope.referafriendcancel =function(){
         $scope.errorInfo=null;
			$scope.step2=false;

    }
      var req={};

    $scope.referafriendstep2submit =function(){

        $scope.raf.submited = true;
         $scope.errorInfo=null;

        if($scope.raf.$valid){

            /*if($scope.ldc == "MIC"){
                req.AccountNumber=$scope.an4;
            }else{
				req.AccountNumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
            }*/



             if($scope.ldc == "DUK"){
            req.AccountNumber=$scope.an1+$scope.an2+$scope.an3;
           }else if($scope.ldc == "VED"){
			 req.AccountNumber=$scope.an2+$scope.an3;
           }else if($scope.ldc == "MIC"){
 			req.AccountNumber=$scope.an4;
           }else{
			 req.AccountNumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
           }
                req.LDC=$scope.ldc;

                    PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
                        console.log(data);
                        if(data && data.CustomerInfoResult){
                        var customerInfo=JSON.parse(data.CustomerInfoResult);
                            console.log(customerInfo);
                            if(customerInfo.responseStatus ==1){
								$scope.step2=false;
                                $scope.errorInfo="We were unable to find your account. Please try again or call "+$scope.mobilenumber+" for assistance";

                            }else if(customerInfo.responseStatus ==0){
                                var regex = /[^a-zA-Z]/g;
                                var businessName=customerInfo.businessName;
                                businessName = businessName.replace(regex,"");
                                var lastName=$scope.lastname.replace(regex,"");
                                businessName=businessName.substring(0,5);
                                lastName=lastName.substring(0,5);

                                if((customerInfo.rateClass=="01" && $scope.lastname.toUpperCase() == customerInfo.lastName.toUpperCase())||(customerInfo.rateClass=="04" && lastName.toUpperCase() == businessName.toUpperCase())){

                                    if(customerInfo.raftermsCondAcknowledgedInd !='Y'){

                                        if(customerInfo.raftermsCondAcknowledgedDate =="1/1/1900"){
                                            $scope.termsupdate=false;
                                        }else{
											$scope.termsupdate=true;

                                        }
                                    jQuery('#raf-terms-popup').addClass('show-popup');
                                    updateCustomerInfoReq.custID=customerInfo.custID;
                                    updateCustomerInfoReq.account=customerInfo.account;
                                    updateCustomerInfoReq.ldc=customerInfo.ldc;
                                    } else if(customerInfo.raftermsCondAcknowledgedInd =='Y'){
                                    setProductData();
                                   }
                                }else{
									$scope.errorInfo="We found an account that matches the account number but not the last name. For further inquiries, please call "+$scope.mobilenumber+".";

                                }
                        	}
                        }

                    }).error(function (data,status, headers, config){

                        console.log("error");
                    });

        }
    }

    var setProductData =function(){
        PrimeService.setProductData(req).success(function(data, status, headers, config){            
            console.log(data);
            location.href=$rootScope.homeUrl+'/raf-authenticated.html';

        }).error(function (data,status, headers, config){

            console.log("error");
        });

    }

    $rootScope.acceptrafterms =function(){
        updateCustomerInfoReq.RAFTermsCondAcknowledgedInd="Y";
        jQuery('#popup-spinner-wrap').show();
        PrimeService.rafUpdateCustomerInfo(updateCustomerInfoReq).success(function(data, status, headers, config){
            console.log(data);
            jQuery('#popup-spinner-wrap').hide();
            if(data.ResponseStatus ==0){ 
            	setProductData();
            }
        }).error(function (data,status, headers, config){
			jQuery('#popup-spinner-wrap').hide();
            console.log("error");
        });
    }
    $rootScope.closeacceptrafterms =function(){
		jQuery('#raf-terms-popup').removeClass('show-popup');

    }
    jQuery('#close-window').click(function(){
        jQuery('#raf-terms-popup').removeClass('show-popup');
    });


    if($rootScope.hashParams && $rootScope.hashParams.refferalcode){
		jQuery('#popup-spinner-wrap').show();

        var req ={};
        req.custId=$rootScope.hashParams.refferalcode;

        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
            if(data && data.CustomerInfoResult){
                        var customerInfo=JSON.parse(data.CustomerInfoResult);
                            console.log(customerInfo);
                            if(customerInfo.responseStatus ==1){
                                $scope.errorInfo="We were unable to find your account. Please try again or call "+$scope.mobilenumber+" for assistance";
                                jQuery('#popup-spinner-wrap').hide();
                            }else if(customerInfo.responseStatus ==0){
                                //var req={};

                                req.LDC=customerInfo.ldc;
                                req.LdcDesc=customerInfo.ldcdesc;
                                req.AccountNumber=customerInfo.account;
                                req.referralcode=customerInfo.custID;
                                req.ProductDescription=customerInfo.productDesc;
                                req.ProductCode=customerInfo.productCode;

                                 if(customerInfo.raftermsCondAcknowledgedInd !='Y'){
									jQuery('#popup-spinner-wrap').hide();
                                    updateCustomerInfoReq.custID=customerInfo.custID;
                                    updateCustomerInfoReq.account=customerInfo.account;
                                    updateCustomerInfoReq.ldc=customerInfo.ldc;

                                    jQuery('#raf-terms-popup').addClass('show-popup');
                                 }else{
                                     
                                     PrimeService.setProductData(req).success(function(data, status, headers, config){            
                                         console.log(data);
                                         location.href=$rootScope.homeUrl+'/raf-authenticated.html';
                                         
                                     }).error(function (data,status, headers, config){
                                         
                                         console.log("error");
                                     });
                                 }
                            }
            }else{
				jQuery('#popup-spinner-wrap').show();
            }

        }).error(function (data,status, headers, config){
			jQuery('#popup-spinner-wrap').hide();
            console.log("error");
        });

    }

}]);

