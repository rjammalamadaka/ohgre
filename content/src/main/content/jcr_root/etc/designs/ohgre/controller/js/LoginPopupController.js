ohgrePortal.controller('LoginPopupController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {



    $rootScope.lctype="residential";


    $scope.setLdcInfo= function(mainValue,description){

        var ldc=mainValue;
        $scope.lastName=null;
        $scope.zipcode=null;
        $('#lastnamezipcodeerror').hide();
        $scope.errorMessage=null;

        $scope.loginform.submited = false;


        $scope.loginform.$setPristine();


		$scope.ldc=mainValue;
        $scope.ldcdesc=description;
        $scope.an1=null;
        $scope.an2=null;
        $scope.an3=null;
        $scope.an4=null;

        $scope.an1required=true;
        $scope.an2required=true;
        $scope.an3required=true;
        $scope.an4required=true;

        $scope.an1r=false;
        $scope.an3r=false;
        $scope.an4r=false;

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
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(ldc == "MIC"){
            $scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";

            $scope.an1required=false;
            $scope.an2required=false;
            $scope.an3required=false;
        }
         $scope.$apply();


        	$('.accountnumber').hide();


            if( ldc=="COH"){
                $('#coh-accno').show();
            }

            if( ldc=="DEO"){
                $('#deo-accno').show();
            }

            if( ldc=="DUK"){
                $('#duk-accno').show();
            }

            if( ldc=="VED"){
                $('#ved-accno').show();
            }
            if( ldc=="MCG"){
				 $('#mcg-accno').show();
            }

            if( ldc=="MIC"){
				 $('#mic-accno').show();
            }



    }


    var getFormatedAccountNumber= function(){

       return getAccountNumber($scope.ldc);

    }

     var validateCommercialName = function(businessName){

        var regex = /[^a-zA-Z]/g;
        var businessName = businessName.replace(regex,"");
       // businessName = businessName.substring(0, 5);


        var userEnteredName = $scope.lastName.toLowerCase();
		userEnteredName = userEnteredName.replace(regex,"");

		userEnteredName = userEnteredName.substring(0, 5);


        if(userEnteredName.length ==5){
            if(businessName.indexOf(userEnteredName) !== -1){
                return false;
            }
            else{
                return true;
            }
        }
	 }
    $scope.loginPopupBindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            $rootScope.ldcDesc= obj.context.innerText;
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
          var description=$(this).find('span').text();
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

           $scope.setLdcInfo(mainValue,description);
            $scope.$apply();

		});



        $('input[type=radio]').click(function(event){
            $scope.lctype=this.value;
             $scope.$apply();
        });

    }

    $scope.closeLoginPopup=function(){
			jQuery("#login-popup-wrapper").removeClass("show-popup");
        location.reload(true);
    }

    var getLdcInfo=function(){
        PrimeService.getLdcInfo().success(function(data, status, headers, config){
            if(data && data.responseStatus =="0"){
                $rootScope.ldcinfo=data.LDCList;
                setTimeout(function(){ $scope.loginPopupBindClickEvent(); }, 10); 
            }


        }).error(function(data, status, headers, config){

        });
    }
    $scope.showLoginPopup= function(){
		//event.preventDefault();
        getLdcInfo();
        jQuery("#login-popup-wrapper").addClass("show-popup");
		UTILS.preventBodyScroll();
    }

    $scope.closeConfirm =function(){
        jQuery("#popupconfirm").removeClass("show-popup");
 		jQuery("#login-popup-wrapper").addClass("show-popup");

    }

    $scope.loginSubmit =function(){
$scope.errorMessage=null;

        $('#lastnamezipcodeerror').hide(); 


	    $scope.loginform.submited = true;
        if(isAccountNumberValid($scope.ldc) &&$scope.loginform.$valid){
            //$scope.lctype
			//$scope.ldc
            //$scope.lastName
            //$scope.zipcode
            var accno=getAccountNumber($scope.ldc);;

            //$scope.formatedacno
            $scope.formatedacno=getFormatedAccountNumber();
		  $scope.accountnumber=null;

            var req={};

            var accountNumberForBE= accno.replace(/\-/g, "");

            if($scope.ldc=="DUK"){
                accountNumberForBE=accountNumberForBE.substring(0,accountNumberForBE.length-1);
            }
            if($scope.ldc=="VED"){
               accountNumberForBE= accountNumberForBE.substring(2,accountNumberForBE.length-1);
            }
            req.AccountNumber=accountNumberForBE;; 
            req.LDC=$scope.ldc;
 $scope.accountnumber=accno.replace(/\-/g, "");
            PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){

                if(data){
                 $scope.customerInfo=JSON.parse(data.CustomerInfoResult);

                    if($scope.customerInfo && $scope.customerInfo.b2BCustomerInd && $scope.customerInfo.b2BCustomerInd=="Y"){
						 $('#lastnamezipcodeerror').show(); 
							 $scope.errorMessage="Please call us at 1.888.466.4427 to discuss plan options for your account.";
                        return;
                    }

                    if($scope.customerInfo && $scope.customerInfo.responseStatus=="0"){


						//if($scope.lctype =="residential" && $scope.customerInfo.lastName !=)
                        var accountStatus=$rootScope.getCustomerStatus($scope.customerInfo.accountStatus);

                        if(($scope.customerInfo.rateClass == "01" && $scope.lctype=="residential") || ($scope.customerInfo.rateClass == "04" && $scope.lctype=="commercial")){



                            if(accountStatus =="Inactive"){
                                jQuery("#login-popup-wrapper").removeClass("show-popup");
                                jQuery("#login-inactive-popup").addClass("show-popup");

                            }else if($scope.customerInfo.b2BCustomerInd =="Y"){
                                $scope.errorMessage="Please call us at "+$rootScope.mobilenumber+" to discuss plan options for your account";
                                $('#lastnamezipcodeerror').show();
                            }else if(($scope.lctype=="residential")&&(($scope.customerInfo.lastName.toLowerCase()!=$scope.lastName.toLowerCase()) || ($scope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase()))){
                                $scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                                $('#lastnamezipcodeerror').show();
                            }else if(($scope.lctype=="commercial")&&(validateCommercialName($scope.customerInfo.businessName.toLowerCase())) || ($scope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                                $scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                                $('#lastnamezipcodeerror').show();
                            }else{
                                jQuery("#login-popup-wrapper").removeClass("show-popup");
                                jQuery("#popupconfirm").addClass("show-popup");
                            }

                        }else{
							 $('#lastnamezipcodeerror').show(); 
							 $scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                        }

                    }else{

                        $('#lastnamezipcodeerror').show(); 
						$scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                    }

                }

            }).error(function(data, status, headers, config){

            });

        }
    }

    $scope.confirmLogin=function(){
        var req={};

        if($scope.lctype =="residential"){
			req.RateClassCode='01';
        }else if($scope.lctype =="commercial"){
			req.RateClassCode='04';
        }
		req.LDC=$scope.ldc;
		req.LdcDesc=$scope.ldcdesc;

         req.AccountNumber=$scope.accountnumber;
        if($scope.ldc =="DUK"){
			req.dukNumber=$scope.accountnumber.substring(10);
        }

         PrimeService.setProductData(req).success(function(data, status, headers, config){            
            location.href=$rootScope.homeUrl+'/myaccount.html';

        }).error(function (data,status, headers, config){

        });


    }

    $scope.closeInactive =function(){
		jQuery("#login-inactive-popup").removeClass("show-popup");
      	 //location.reload(true);

		location.href=$rootScope.homeUrl+"/rate-plans.html#ldc="+$scope.ldc+'&lctype='+$scope.lctype;
    }

    $scope.closeandreload = function(){
            jQuery("#login-inactive-popup").removeClass("show-popup");
             location.reload(true);
    }
}]);

