ohgrePortal.controller('EnrollCustomerController', ['$scope', '$rootScope', '$http', 'PrimeService',function ($scope, $rootScope,$http,PrimeService) {



    $scope.businessName=false;

 $rootScope.showcurrentplan=false;

    PrimeService.getProductData().success(function(data, status, headers, config){

        if(!data.LDC){
          location.href=$rootScope.homeUrl+".html";
            return false;
        }
        $rootScope.product=data;
		var rateClass=$rootScope.product.rateClassCode;
        if(rateClass =="04"){
			$scope.businessName=true;
        }
        $scope.an1r=false;
        $scope.an3r=false;
        $scope.an4r=false;        
        if(data.LDC == "COH"){
			$scope.an1minl="8";
		    $scope.an2minl="3";
            $scope.an3minl="3";
            $scope.an4minl="1";
            $scope.an3="000";
            $scope.an3r=true;

        }else if(data.LDC == "DUK"){
			$scope.an1minl="4";
		    $scope.an2minl="4";
            $scope.an3minl="2";
            $scope.an4minl="1";

        }else if(data.LDC == "DEO"){
			$scope.an1minl="1";
		    $scope.an2minl="4";
            $scope.an3minl="4";
            $scope.an4minl="4";

        }else if(data.LDC == "VED"){
			$scope.an1minl="2";
		    $scope.an2minl="9";
            $scope.an3minl="7";
            $scope.an4minl="1";
            $scope.an1="03";
            $scope.an4="0";
            $scope.an1r=true;
            $scope.an4r=true;

        }else if(data.LDC == "MCG"){
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(data.LDC == "MIC"){

            $scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";

        }

    }).error(function (data,status, headers, config){

         if(!data.LDC){
          location.href=$rootScope.homeUrl+".html";
        }
    });


    var getFormatedAccountNumber= function(){

        var accountNumber=null;
		var ldc = $rootScope.product.LDC;
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
		$scope.formatedacno=accountNumber;

    }
    $scope.enrollCustomer =function(step){
			$('#lastnamezipcodeerror').hide(); 
        getFormatedAccountNumber();

			$scope.formone.submited = true;
       if($scope.formone.$valid || (($rootScope.product.LDC=="MIC") && $scope.formone.lastname.$valid && $scope.formone.zipcode.$valid && $scope.formone.an4.$valid)){
 			var accountnumber=null;
            console.log($scope.formone.$valid);
           if($rootScope.product.LDC == "DUK"){
            accountnumber=$scope.an1+$scope.an2+$scope.an3;
           }else if($rootScope.product.LDC == "VED"){
			 accountnumber=$scope.an2+$scope.an3;
           }else if($rootScope.product.LDC == "MIC"){
 			accountnumber=$scope.an4;
           }else{
			 accountnumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
           }
        var req={};
        req.AccountNumber=accountnumber;
		req.LDC=$rootScope.product.LDC;
       PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
            console.log(data);
             if(data){
                 $rootScope.customerInfo=JSON.parse(data.CustomerInfoResult);
                 if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="0"){
                     console.log($rootScope.customerInfo);

                     if($rootScope.product.customerTypeCode =="NEW"){
                         $('#popupalternate').addClass('show-popup');

                     }else if(accountnumber == $rootScope.customerInfo.account && $rootScope.customerInfo.rateClass != $rootScope.product.rateClassCode){
                         $('#popupalternate').addClass('show-popup');
                         return false;
                     }else if($rootScope.product.rateClassCode =="01"){
                         if(($rootScope.customerInfo.lastName.toLowerCase() !=$scope.lastname.toLowerCase()) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                             $('#lastnamezipcodeerror').show();  
                             return false;
                         }else{
							$('#popupconfirm').addClass('show-popup');
                         }
                     }else if($rootScope.product.rateClassCode =="04"){
                         if(($rootScope.customerInfo.businessName.toLowerCase() !=$scope.lastname.toLowerCase()) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                             $('#lastnamezipcodeerror').show();  
                             return false;
                         }else{
							$('#popupconfirm').addClass('show-popup');
                         }
                     }else{

                     	$('#popupconfirm').addClass('show-popup');
                     }
                     // need to work on RateClassCode
                   /*  $('.active-form').removeClass('active-form');
                     $('.active-step').removeClass('active-step');
                     $('#step-through >div:nth-child('+step+')').addClass('active-form');
                     $('.steps-container > div:nth-child('+step+')').addClass('active-step');*/

                 }else if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="1"){

                     if($rootScope.product.customerTypeCode =="EXISTING"){
 							$('#popupnoteligiblefornew').addClass('show-popup');

                     }else{

                             $('.active-form').removeClass('active-form');
                             $('.active-step').removeClass('active-step');
                             $('#step-through >div:nth-child('+step+')').addClass('active-form');
                             $('.steps-container > div:nth-child('+step+')').addClass('active-step');

                     }

                 }
             }else{


             }

          /* 

            */
		 }).error(function (data,status, headers, config){

             console.log("error");
         });


        }else{

		return;
        }


    }

    var gotNextStep= function(step){
 					$('.active-form').removeClass('active-form');
                     $('.active-step').removeClass('active-step');
                     $('#step-through >div:nth-child('+step+')').addClass('active-form');
                     $('.steps-container > div:nth-child('+step+')').addClass('active-step');

    }
    $rootScope.enrollconfirm =function(){


        if($rootScope.product.rateClassCode == "New"){
			$('#popupconfirm').removeClass('show-popup');

              setTimeout(function(){ 
                $('#popupalternate').addClass('show-popup');

            }, 500);


        }else{

            if($rootScope.customerInfo.existingCustomerInd=="Y" && $rootScope.customerInfo.activeContractInd =="N" && $rootScope.customerInfo.renewalContractExistsInd=="N"){


                var earlyTermChargeAmt= Number($rootScope.customerInfo.earlyTermChargeAmt);
						if(earlyTermChargeAmt == 0){


						$('#popupconfirm').removeClass('show-popup');

                        setTimeout(function(){ 
                            gotNextStep(2);

                        }, 500);
                        }else if(earlyTermChargeAmt>0){

                                $('#popupconfirm').removeClass('show-popup');

                            setTimeout(function(){ 
                                $('#popupetc').addClass('show-popup');

                            }, 500);
                        }


            }else if($rootScope.customerInfo.existingCustomerInd=="Y" && $rootScope.customerInfo.activeContractInd =="Y" && $rootScope.customerInfo.renewalContractExistsInd=="N"){

                 $('#popupconfirm').removeClass('show-popup');

                    setTimeout(function(){ 
                        $('#popupetc').addClass('show-popup');

                    }, 500);



            }else if($rootScope.customerInfo.existingCustomerInd=="Y" && $rootScope.customerInfo.renewalContractExistsInd=="Y"){

  					$('#popupconfirm').removeClass('show-popup');

                    setTimeout(function(){ 
                        $('#popupwithrenewal').addClass('show-popup');

                    }, 500);
            }
        }

    }

    $rootScope.enrolltryagain =function(){
		$('#popupconfirm').removeClass('show-popup');
    }

    $rootScope.enrollselectandcontinue =function(){

        $rootScope.showcurrentplan=true;

			$('#popupetc').removeClass('show-popup');

        gotNextStep(2);
    }

    $rootScope.enrollselectalternateplans =function(){

			location.href=$rootScope.homeUrl+"/plans-detail.html";
    }

    $rootScope.popuprenewalcontinue =function(){
		//second step
var step =2;
        $('.active-form').removeClass('active-form');
                     $('.active-step').removeClass('active-step');
                     $('#step-through >div:nth-child('+step+')').addClass('active-form');
                     $('.steps-container > div:nth-child('+step+')').addClass('active-step');

        $('.popup-wrapper').removeClass('show-popup');

    }

    $rootScope.redirecttohome =function(){

			location.href=$rootScope.homeUrl+".html";
    }

}]);

