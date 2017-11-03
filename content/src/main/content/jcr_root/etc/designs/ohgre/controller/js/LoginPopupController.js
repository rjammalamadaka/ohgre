ohgrePortal.controller('LoginPopupController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {



    $scope.lctype="residential";

    $scope.setLdcInfo= function(mainValue,description){

        var ldc=mainValue;
        console.log("setLdcInfo");
        console.log(mainValue);
        console.log(description);
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
         $scope.$apply();

    }


    var getFormatedAccountNumber= function(){

        var accountNumber=null;
		var ldc = $scope.ldc;
        if(ldc =="MIC"){
            accountNumber=$scope.an4;
        }else if(ldc =="MCG"){
             accountNumber=$scope.an1+"-"+$scope.an2+"-"+$scope.an3+"-"+$scope.an4;
        }else if(ldc =="VED"){
             accountNumber=$scope.an1+"-"+$scope.an2+"-"+$scope.an3+"-"+$scope.an4;
        }else if(ldc =="DEO"){
             accountNumber=$scope.an1+"-"+$scope.an2+"-"+$scope.an3+"-"+$scope.an4;
        }else if(ldc =="DUK"){
			 accountNumber=$scope.an1+"-"+$scope.an2+"-"+$scope.an3+"-"+$scope.an4;
        }else if(ldc =="COH"){
 			accountNumber=$scope.an1+"-"+$scope.an2+"-"+$scope.an3+"-"+$scope.an4;
        }
		$rootScope.formatedacno=accountNumber;

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
    }

    var getLdcInfo=function(){
        PrimeService.getLdcInfo().success(function(data, status, headers, config){
            if(data && data.responseStatus =="0"){
                console.log(data.LDCList);
                $rootScope.ldcinfo=data.LDCList;
                setTimeout(function(){ $scope.loginPopupBindClickEvent(); }, 10);
            }


        }).error(function(data, status, headers, config){

        });
    }
    $scope.showLoginPopup= function(){

		     getLdcInfo();
            jQuery("#login-popup-wrapper").addClass("show-popup");

    }

    $scope.closeConfirm =function(){
        jQuery("#popupconfirm").removeClass("show-popup");
 		jQuery("#login-popup-wrapper").addClass("show-popup");

    }

    $scope.loginSubmit =function(){
$scope.errorMessage=null;
	    $scope.loginform.submited = true;
        if($scope.loginform.$valid || (($scope.ldc=="MIC") && $scope.loginform.lastName.$valid && $scope.loginform.zipcode.$valid && $scope.loginform.an4.$valid)){
            //$scope.lctype
			//$scope.ldc
            //$scope.lastName
            //$scope.zipcode

            //$scope.formatedacno
            getFormatedAccountNumber();
		  $scope.accountnumber=null;
           if($scope.ldc == "DUK"){
            $scope.accountnumber=$scope.an1+$scope.an2+$scope.an3;
           }else if($scope.ldc == "VED"){
			 $scope.accountnumber=$scope.an2+$scope.an3;
           }else if($scope.ldc == "MIC"){
 			$scope.accountnumber=$scope.an4;
           }else{
			 $scope.accountnumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
           }
            var req={};
            req.AccountNumber=$scope.accountnumber; 
            req.LDC=$scope.ldc;
            PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){

                if(data){
                 $scope.customerInfo=JSON.parse(data.CustomerInfoResult);
                    if($scope.customerInfo && $scope.customerInfo.responseStatus=="0"){
						//if($scope.lctype =="residential" && $scope.customerInfo.lastName !=)
                        if(($scope.lctype=="residential")&&(($scope.customerInfo.lastName.toLowerCase()!=$scope.lastName.toLowerCase()) || ($scope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase()))){
							$scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                        }else if(($scope.lctype=="commercial")&&(validateCommercialName($scope.customerInfo.businessName.toLowerCase())) || ($scope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
							$scope.errorMessage="We could not locate your account. Please check to make sure you have entered your information correctly below.";
                        }else{
							jQuery("#login-popup-wrapper").removeClass("show-popup");
                        	jQuery("#popupconfirm").addClass("show-popup");
                        }

                    }

                    console.log($scope.customerInfo);
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

        req.AccountNumber=$scope.accountnumber;

         PrimeService.setProductData(req).success(function(data, status, headers, config){            
            console.log(data);
            location.href=$rootScope.homeUrl+'/myaccount.html';

        }).error(function (data,status, headers, config){

            console.log("error");
        });


    }



}]);
