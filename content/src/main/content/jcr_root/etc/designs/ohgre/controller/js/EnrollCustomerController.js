ohgrePortal.controller('EnrollCustomerController', ['$scope', '$rootScope', '$http', 'PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    $scope.displaystepscontainer=false;
    $scope.businessName=false;
    $scope.showgiftcardmessage=false;
    $scope.primeErrorMessage=null;

    var failcount=0;

    $('.steps-container').hide();

    $rootScope.showcurrentplan=false;
    $rootScope.showearlyterminationfee=false;
    $rootScope.showexistingcustomer=false;

    $scope.enrollReq={};
    if($rootScope.portalname=='oh'){
		$scope.enrollReq.portalname="oh";
        $scope.addressstate="OH";
    }else if($rootScope.portalname=='gre'){
		$scope.enrollReq.portalname="gre";
        $scope.addressstate="MI";
    }

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


        updateenrollrequestobj(data);

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
		$rootScope.formatedacno=accountNumber;

    }
    $scope.enrollCustomer =function(step){
			$('#lastnamezipcodeerror').hide(); 
        clearEnrollReqObject();
        getFormatedAccountNumber();

			$scope.formone.submited = true;
       if($scope.formone.$valid || (($rootScope.product.LDC=="MIC") && $scope.formone.lastName.$valid && $scope.formone.zipcode.$valid && $scope.formone.an4.$valid)){
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
           $scope.unformatedaccountnumber=accountnumber;
        var req={};
        req.AccountNumber=accountnumber;
		req.LDC=$rootScope.product.LDC;
       PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
            console.log(data);
             if(data){
                 $rootScope.customerInfo=JSON.parse(data.CustomerInfoResult);
                  updateenrollrequestobj($rootScope.customerInfo);
                 if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="0"){
                     console.log($rootScope.customerInfo); 
                     $scope.phoneNumber= $rootScope.customerInfo.phoneNumber;
                      $rootScope.showexistingcustomer=true;

                     if($rootScope.product.customerTypeCode =="NEW"){
                         $('#popupalternate').addClass('show-popup');

                     }else if(accountnumber == $rootScope.customerInfo.account && $rootScope.customerInfo.rateClass != $rootScope.product.rateClassCode){
                         $('#popupalternate').addClass('show-popup');
                         return false;
                     }else if($rootScope.product.rateClassCode =="01"){
                         if(($rootScope.customerInfo.lastName.toLowerCase() !=$scope.lastName.toLowerCase()) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                             $('#lastnamezipcodeerror').show();  
                             return false;
                         }else{
							$('#popupconfirm').addClass('show-popup');
                         }
                     }else if($rootScope.product.rateClassCode =="04"){
                         if(($rootScope.customerInfo.businessName.toLowerCase() !=$scope.lastName.toLowerCase()) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
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
					$rootScope.showexistingcustomer=false;
                     var accountNumberInfo={};
                     if($scope.unformatedaccountnumber){
					 accountNumberInfo.account=$scope.unformatedaccountnumber;
                     updateenrollrequestobj(accountNumberInfo);
                     }

                     if($rootScope.product.customerTypeCode =="EXISTING"){
 							$('#popupnoteligiblefornew').addClass('show-popup');

                     }else{

							gotNextStep(2);
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


    $scope.submityourinformation =function(){

        $scope.formtwo.submited = true;
		$scope.primeErrorMessage=null;
        $scope.rafErrorMessage=null;
        if($scope.formtwo.$valid){

           // console.log($scope.promotionInfo.PromotionCode);
            if($scope.promotionInfo && $scope.promotionInfo.PromotionCode && $scope.promotionInfo.PromotionCode.indexOf('RAF')!= -1 && failcount<2 && (!$scope.rafcode ||$scope.rafcode=="")){


                  $scope.rafErrorMessage="Please enter your friend's referal code";
                 failcount=failcount+1;


            }else if($scope.rafcode && $scope.rafcode.length>0 && failcount<2){
                var account;
                var ldc;
                if($rootScope.customerInfo.responseStatus =="0"){
                  account=$rootScope.customerInfo.account;
                  ldc=$rootScope.product.LDC;  
                }
                PrimeService.checkRafEligibility($scope.rafcode,account,ldc).success(function(data, status, headers, config){
                    if(data.responseStatus == "0"){
                        if(data.rafInfo.AwardEligible =="Y"){
                             $scope.validPromocode=true;
                        	handelsubmityourinformation();
                        }else{
                            failcount=failcount+1;
                            $scope.validPromocode=false;
							$scope.primeErrorMessage="RAF code is not valid";
                        }
                    }else{
                        failcount=failcount+1;
						$scope.primeErrorMessage="RAF code is not valid";
                    }

                }).error(function(data, status, headers, config){

                });

            }else{
                handelsubmityourinformation();

            }
        }else{


        }


    }
    var handelsubmityourinformation=function(){


        var hearabout=$('.dropdown-trigger .value').find('span').html();


        var data={};

        if($scope.billingaddressone)
			 data.mailAddress1=$scope.billingaddressone;
        if($scope.billingaddresstwo)
			 data.mailAddress2=$scope.billingaddresstwo;
        if($scope.billingaddresscity)
            data.mailCity=$scope.billingaddresscity;
		if($scope.billingaddressstate)
            data.mailStateCode=$scope.billingaddressstate;
		if($scope.billingaddresszip)
            data.mailZipCode=$scope.billingaddresszip;
        if(hearabout)
            data.hearAboutUs=hearabout;
        if($scope.rafcode)
            data.RAFCode=$scope.rafcode;

        if($scope.firstName){
			data.firstName=$scope.firstName;
        }

        if($scope.businessName){
			if($scope.lastName){
                data.lastName=$scope.commerlastName;
                data.businessName=$scope.lastName;
            }
        }else{
            if($scope.lastName){
                data.lastName=$scope.lastName;
            }
        }

        if($scope.customerInfo.emailAddress)
        data.emailAddress=$scope.customerInfo.emailAddress;      
        if($scope.addressone)
        data.serviceAddress1=$scope.addressone;
        if($scope.addresstwo)
        data.serviceAddress2=$scope.addresstwo;
        if($scope.customerInfo.serviceCity)
        data.serviceCity=$scope.customerInfo.serviceCity;
        if($scope.addressstate)
        data.serviceStateCode=$scope.addressstate;
        if($scope.zipcode)
        data.serviceZipCode=$scope.zipcode;
        if($scope.phoneNumber){
		data.phoneNumber=$scope.phoneNumber;
        }

        if($scope.samebilling){
            if($scope.addressone)
                 data.mailAddress1=$scope.addressone;
            if($scope.addresstwo)
                 data.mailAddress2=$scope.addresstwo;
            if($scope.customerInfo.serviceCity)
                data.mailCity=$scope.customerInfo.serviceCity;
            if($scope.addressstate)
                data.mailStateCode=$scope.addressstate;
            if($scope.zipcode)
                data.mailZipCode=$scope.zipcode;
        }

        if($scope.specialoffer){
			data.specialoffer=$scope.specialoffer;
        }
        updateenrollrequestobj(data);


        gotNextStep(3);


    }

    $scope.accepttermsandcond =function(){
 		$scope.formthree.submited = true;



        if($scope.formthree.$valid){

            if($scope.promotionInfo && $scope.promotionInfo.GiftCardValue){
                $scope.giftCardValue =Number($scope.promotionInfo.GiftCardValue);
                if($scope.giftCardValue>0){
                    $scope.showgiftcardmessage=true;
                }
            }

			gotNextStep(4);

        }

    }

    $scope.reviewauthorizesubmit =function(){

        $scope.primeErrorMessage=null;
		$scope.formfour.submited = true;

        if($scope.formfour.$valid && !$scope.flag){
			console.log("data submit to prime");
            $scope.flag=true;

            if($scope.showgiftcardmessage){
				$scope.showgiftcardmessage=false;
                $scope.showgiftcardmessageconfirmation=true;
            }

            PrimeService.enrollCustomer($scope.enrollReq).success(function(data, status, headers, config){
                console.log(data);
                 $scope.flag=false;
                if(data){
                   var enrollCustomerResult = JSON.parse(data.EnrollCustomerResult);
                    console.log(enrollCustomerResult);
                    if(enrollCustomerResult.responseStatus =="1"){
                   		 $scope.primeErrorMessage=enrollCustomerResult.responseMessage;
                    }else if(enrollCustomerResult.responseStatus =="0"){
						gotNextStep(5);
                    }
                }

            }).error(function(data, status, headers, config){
                 $scope.flag=false;
                console.log(data);
            });

        }
    }

    var gotNextStep= function(step,back){
       // $scope.displaystepscontainer=true;
        if(!back)
        $('.steps-container').show();

 					$('.active-form').removeClass('active-form');
        if(step ==2 || back){
            $('.active-step').removeClass('active-step');}
            else{
                     $('.active-step').removeClass('active-step').addClass("step-complete");
            }
                     $('#step-through >div:nth-child('+step+')').addClass('active-form');
        if(!back){
                     $('.steps-container > div:nth-child('+step+')').addClass('active-step');
        }else{
			 $('.steps-container > div:nth-child('+step+')').addClass('active-step').removeClass('step-complete');
        }

    }

    $scope.gotoPreviousStep =function(step){
        if(step ==1){
             $('.steps-container').hide();
            $rootScope.showcurrentplan=false;
            $rootScope.showearlyterminationfee=false;

        }
        if(step==3){
			$scope.showgiftcardmessage=false;
        }
        if(step==4){
			$scope.showgiftcardmessageconfirmation=false;
        }
        $scope.primeErrorMessage=null;
		gotNextStep(step,true);
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
                            $scope.displaystepscontainer=true;
                            gotNextStep(2);


                        }, 500);
                        }else if(earlyTermChargeAmt>0){

                            $rootScope.showearlyterminationfee=true;

                                $('#popupconfirm').removeClass('show-popup');

                            setTimeout(function(){ 
                                $('#popupetc').addClass('show-popup');

                            }, 500);
                        }


            }else if($rootScope.customerInfo.existingCustomerInd=="Y" && $rootScope.customerInfo.activeContractInd =="Y" && $rootScope.customerInfo.renewalContractExistsInd=="N"){

                 var earlyTermChargeAmt= Number($rootScope.customerInfo.earlyTermChargeAmt);
                 $rootScope.showearlyterminationfee=true;

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
 			$scope.displaystepscontainer=true;
        gotNextStep(2);
    }

    $rootScope.enrollselectalternateplans =function(){

			location.href=$rootScope.homeUrl+"/plans-detail.html";
    }

    $rootScope.popuprenewalcontinue =function(){
		//second step
        $rootScope.showcurrentplan=true;
        $scope.displaystepscontainer=true;
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

    $scope.phoneformatchange =function(number){

        var phonenumber=$("#phonenumber").val();
        phonenumber=phonenumber.replace("(","").replace(")","").replace(" ","").replace("-","");
        if(phonenumber && phonenumber.indexOf('-') ==-1 && phonenumber.length>3){
           var formatedNumber="("+phonenumber.substring(0,3)+") "+phonenumber.substring(3,6)+"-"+phonenumber.substring(6);
            $("#phonenumber").val(formatedNumber); 
            $scope.phoneNumber=formatedNumber;
        }
    }


      var updateenrollrequestobj=function(data){
        if(data.LDC)
		$scope.enrollReq.LDC=data.LDC;
        if(data.productCode)
		$scope.enrollReq.productCode=data.productCode;
        if(data.account)
		$scope.enrollReq.account=data.account;
        if(data.premise)  
        $scope.enrollReq.premise=data.premise;
        if(data.premise)  
        $scope.enrollReq.premise=data.premise;
        if(data.firstName)  
        $scope.enrollReq.firstName=data.firstName;
        if(data.lastName)  
        $scope.enrollReq.lastName=data.lastName;
        if(data.businessName)
        $scope.enrollReq.businessName=data.businessName;
        if(data.mailAddress1)
        $scope.enrollReq.mailAddress1=data.mailAddress1;
        if(data.mailAddress2)
        $scope.enrollReq.mailAddress2=data.mailAddress2;
        if(data.mailCity)
        $scope.enrollReq.mailCity=data.mailCity;
        if(data.mailStateCode)
        $scope.enrollReq.mailStateCode=data.mailStateCode;
        if(data.mailZipCode)
        $scope.enrollReq.mailZipCode=data.mailZipCode;
        if(data.phoneNumber)
        $scope.enrollReq.phoneNumber=data.phoneNumber;
        if(data.emailAddress)
        $scope.enrollReq.emailAddress=data.emailAddress;      
        if(data.serviceAddress1)
        $scope.enrollReq.serviceAddress1=data.serviceAddress1;
        if(data.serviceAddress2)
        $scope.enrollReq.serviceAddress2=data.serviceAddress2;
        if(data.serviceCity)
        $scope.enrollReq.serviceCity=data.serviceCity;
        if(data.serviceStateCode)
        $scope.enrollReq.serviceStateCode=data.serviceStateCode;
        if(data.serviceZipCode)
        $scope.enrollReq.serviceZipCode=data.serviceZipCode;
        if(data.activeContractInd)
        $scope.enrollReq.activeContractInd=data.activeContractInd;
        if(data.PromotionCode)
        $scope.enrollReq.PromotionCode=data.PromotionCode;
        if(data.hearAboutUs)
		$scope.enrollReq.CustLeadSourceCode=data.hearAboutUs;
        if(data.RAFCode)
		$scope.enrollReq.RAFCode=data.RAFCode;
        if(data.responseStatus)
        $scope.enrollReq.responseStatus=data.responseStatus;
        if(data.specialoffer)
        $scope.enrollReq.specialoffer=data.specialoffer;
        if(data.businessName)
        $scope.enrollReq.businessName=data.businessName;


    }

    var promoinfo=ohgre.store("promoCodeInfo");
    if(promoinfo && promoinfo.LDCList && promoinfo.LDCList.length>0 && promoinfo.LDCList[0].promotion && promoinfo.LDCList[0].promotion.length>0){
        var data= promoinfo.LDCList[0].promotion[0];
        $scope.promotionInfo=data;
        updateenrollrequestobj(data);
    }

    $scope.gotoHomePage = function(){
		location.href=$rootScope.homeUrl+".html";
    }

   var clearEnrollReqObject =function(){
	    $scope.enrollReq={};
       if($scope.promotionInfo){
        	updateenrollrequestobj($scope.promotionInfo);
       }
       updateenrollrequestobj($rootScope.product);
		if($rootScope.portalname=='oh'){
		$scope.enrollReq.portalname="oh";       
		}else if($rootScope.portalname=='gre'){
		$scope.enrollReq.portalname="gre";       
		}
    }

   $scope.acceptterms =function(pdffilepath){
	   if(pdffilepath)
       window.open(pdffilepath);

   }


}]);

