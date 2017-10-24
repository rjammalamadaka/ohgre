ohgrePortal.controller('EnrollCustomerController', ['$scope', '$rootScope', '$http', 'PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    $scope.displaystepscontainer=false;
    $scope.businessName=false;
    $scope.showgiftcardmessage=false;
    $scope.primeErrorMessage=null;
    $scope.reviewdisplay=true;
	$scope.showpromocodeconfirmation=false;
    $scope.deltaskymilesaccountnumberprovidelater=false;
    $scope.sendRafEmailReq={};

    $scope.dsmEnrollReq={};

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
        setPromotionInfoByLDC(data.LDC);
        $rootScope.product=data;
		var rateClass=$rootScope.product.rateClassCode;
        if(data.referralcode){
        	//data.referralcode
            $scope.rafcode=data.referralcode;
        }
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

    // Validating if the User Entered name is matching with business name in Prime response
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
        else{
			return true;
        }

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
           jQuery('#popup-spinner-wrap').show();
       PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
            console.log(data);
           jQuery('#popup-spinner-wrap').hide();
             if(data){
                 $rootScope.customerInfo=JSON.parse(data.CustomerInfoResult);
                  updateenrollrequestobj($rootScope.customerInfo);
                 if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="0"){
                     console.log($rootScope.customerInfo); 
                     $scope.phoneNumber= $rootScope.customerInfo.phoneNumber;
                      $rootScope.showexistingcustomer=true;
                     $rootScope.gbplandisplay=false;

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
                         if((validateCommercialName($rootScope.customerInfo.businessName.toLowerCase())) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                             $('#lastnamezipcodeerror').show();  
                             return false;
                         }else{
							$('#popupconfirm').addClass('show-popup');
                         }
                     }else{

                     	$('#popupconfirm').addClass('show-popup');
                     }

                     if($rootScope.customerInfo.productCode =="COK" || $rootScope.customerInfo.productCode=="COJ"){

                        var pricingDesc= $rootScope.customerInfo.pricingDesc;

 							var pricingDescArray=pricingDesc.split('Term');
                         if(pricingDescArray.length>0){
                         	$rootScope.gbplandisplay=true;
                          //  $rootScope.gbplandescription=pricingDesc.split('Term')[0].trim();

							$rootScope.gbplandescription=$rootScope.customerInfo.contractPrice;
                         }

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
					//location.href="/content/onlyong/maintenance.html";
                 }



             }else{


             }

          /* 

            */
		 }).error(function (data,status, headers, config){
			jQuery('#popup-spinner-wrap').hide();
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
        }else{
            data.mailAddress1=$scope.billingaddressone;            
            data.mailAddress2=$scope.billingaddresstwo;
            data.mailCity=$scope.billingaddresscity;
            data.mailStateCode=$scope.billingaddressstate;
            data.mailZipCode=$scope.billingaddresszip;
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

    $scope.reviewauthorizesubmit1 =function(){
		$scope.formfour.submited = true;

        if($scope.formfour.$valid && !$scope.flag){

            if($scope.promotionInfo && $scope.promotionInfo.DSMEligible =="Y"){
                $scope.reviewdisplay=false;
				$scope.reviewdisplaydeltaskymiles =true;
            }else if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
				$scope.reviewdisplay=false;
				$scope.reviewdisplayvisa =true;
            }else if($scope.promotionInfo && $scope.promotionInfo.RAFAdvertising =="Y"){
                $scope.reviewdisplay=false;
                $scope.reviewdisplayraf =true;
            }else{
				$scope.reviewauthorizesubmit();
            }

        }

    }

    $scope.continuedeltaskymiles =function(from){

        if(from =="fromdelta"){
			$scope.deltaskymilesaccountnumberprovidelater=true;
        }

        $scope.continuefromdeltaskymiles=true;
		 if($scope.promotionInfo && $scope.promotionInfo.RAFAdvertising  =="Y"){
              $scope.reviewdisplaydeltaskymiles =false;
              $scope.reviewdisplayraf =true;
         }else{
			  $scope.reviewauthorizesubmit();
         }

    }

    $scope.sendemailwithmoreinfo =function(){
		$scope.sendRafEmailReq.emailAddress=$scope.enrollReq.emailAddress;
        PrimeService.sendRafEmail($scope.sendRafEmailReq).success(function(data, status, headers, config){
			console.log(data);

        }).error(function(data, status, headers, config){

                console.log(data);
        });

    }
    $scope.reviewauthorizesubmit =function(){

        $scope.primeErrorMessage=null;
		//$scope.formfour.submited = true;

        if($scope.formfour.$valid && !$scope.flag){
			console.log("data submit to prime");
            $scope.flag=true;

            if($scope.showgiftcardmessage){
				$scope.showgiftcardmessage=false;
                $scope.showgiftcardmessageconfirmation=true;
            }
			jQuery('#popup-spinner-wrap').show();
            PrimeService.enrollCustomer($scope.enrollReq).success(function(data, status, headers, config){
                console.log(data);
                 $scope.flag=false;
                jQuery('#popup-spinner-wrap').hide();
                if(data){
                   var enrollCustomerResult = JSON.parse(data.EnrollCustomerResult);
                    if(data.enrollId){
						$scope.enrollId=data.enrollId;
                    }
                    console.log(enrollCustomerResult);
                    if(enrollCustomerResult.responseStatus =="1"){
                   		 $scope.primeErrorMessage=enrollCustomerResult.responseMessage;
                    }else if(enrollCustomerResult.responseStatus =="0"){
                        $scope.sendRafEmailReq.custID=enrollCustomerResult.custID;
						gotNextStep(5);
                    }
                }

            }).error(function(data, status, headers, config){
                jQuery('#popup-spinner-wrap').hide();
                 $scope.flag=false;
                console.log(data);
            });

        }
    }

    var displaypromocodeconfirmation =function(step,back){

         if(step ==2 || step ==3){
             if($scope.promotionInfo && $scope.promotionInfo.PromotionCode){
				$scope.showpromocodeconfirmation=true;
             }
        }else{
			$scope.showpromocodeconfirmation=false;
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

        displaypromocodeconfirmation(step,back);

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

    $rootScope.redirectToStandardPricingPlan =function(){

		var locationType = 'residential';
        ohgre.removeStore("promoCodeInfo");
        if($rootScope.product.RateClassCode == '04'){
			locationType = 'commercial';
        }

			location.href=$rootScope.homeUrl+"/rate-plans.html#ldc="+$rootScope.product.LDC+'&lctype='+locationType;
    }

    $rootScope.enrollselectalternateplans =function(){

			var locationType = 'residential';

        ohgre.removeStore("promoCodeInfo");
        if($rootScope.customerInfo.rateClass == '04'){
			locationType = 'commercial';
        }

			location.href=$rootScope.homeUrl+"/rate-plans.html#ldc="+$rootScope.product.LDC+'&lctype='+locationType;
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

    $scope.dsmEnrollSubmit =function(){
		$scope.invaliddeltaskymilesaccountnumber=false;
        $scope.deltaskymiles.submited = true;
		 var checkNumber=-1;
        if($scope.deltaskymiles.$valid && !$scope.flag){

       		checkNumber=validateDeltaSkyMilesNumber($scope.dsmAccountNumber);
             if(checkNumber ==3){
				$scope.invaliddeltaskymilesaccountnumber=true;
             }else if(checkNumber==0){
                 $scope.flag=true;
                 $scope.dsmEnrollReq.firstName=$scope.enrollReq.firstName;
                 $scope.dsmEnrollReq.lastName=$scope.enrollReq.lastName;
                 $scope.dsmEnrollReq.dsmfirstName=$scope.dsmFirstName;
                 $scope.dsmEnrollReq.dsmlastName=$scope.dsmLastName;
                 $scope.dsmEnrollReq.dsmEmail=$scope.enrollReq.emailAddress;
                 $scope.dsmEnrollReq.dsmAccountNumber=$scope.dsmAccountNumber;
                 // $scope.dsmEnrollReq.dsmPhone= $scope.enrollReq.phoneNumber;
                 $scope.dsmEnrollReq.LDCAccountNumber=$scope.enrollReq.account;
                 $scope.dsmEnrollReq.LDCName=$scope.enrollReq.LDC;

                 PrimeService.dsmEnroll($scope.dsmEnrollReq).success(function(data, status, headers, config){
                     $scope.flag=false;
                     console.log(data);
                     if(data.message =="Success"){
                     $scope.reviewauthorizesubmit();
                     }

                 }).error(function(data, status, headers, config){
                     $scope.flag=false;
                     console.log(data);
                 });

             }

        }

    }

      var updateenrollrequestobj=function(data){
        if(data.LDC)
		$scope.enrollReq.LDC=data.LDC;
        if(data.productCode && $scope.enrollReq.productCode == undefined)
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
        if(data.renewalContractExistsInd)
        $scope.enrollReq.renewalContractExistsInd=data.renewalContractExistsInd;    


    }

      var setPromotionInfoByLDC =function(ldc){

            var promoinfo=ohgre.store("promoCodeInfo");
                if(promoinfo && promoinfo.LDCList && promoinfo.LDCList.length>0 && promoinfo.LDCList[0].promotion && promoinfo.LDCList[0].promotion.length>0){
                    //console.log($rootScope.product.LDC);
                    var temp=null;
                    for(var i=0; i<promoinfo.LDCList.length;i++){
                        if(promoinfo.LDCList[i].LDCCode ==ldc){
                            temp=promoinfo.LDCList[i].promotion[0];
                            break;
                        }
            
                    }
                    //var data= promoinfo.LDCList[0].promotion[0];
                    var data=temp;
                    $scope.promotionInfo=data;
                    updateenrollrequestobj(data);
                }
      }
    /*var promoinfo=ohgre.store("promoCodeInfo");
    if(promoinfo && promoinfo.LDCList && promoinfo.LDCList.length>0 && promoinfo.LDCList[0].promotion && promoinfo.LDCList[0].promotion.length>0){
		console.log($rootScope.product.LDC);
        var temp=null;
        for(var i=0; i<promoInfo.LDCList.length;i++){
            if(promoInfo.LDCList[i].LDCCode ==$rootScope.product.LDC){
				temp=promoinfo.LDCList[i].promotion[0];
                break;
            }

        }
        //var data= promoinfo.LDCList[0].promotion[0];
        var data=temp;
        $scope.promotionInfo=data;
        updateenrollrequestobj(data);
    }
*/
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

   var validateDeltaSkyMilesNumber=function (sknum) {
       var smn = sknum;
       var integerCheck = 0,
           smnStatus = 4,
           smn01;
       
       var getSingleDigit = function(x) {
           if (x > 9) {
               var a,
                   b;
               
               a = x.toString();
               b = parseInt(a.substring(0, 1)) + parseInt(a.substring(1, 2));
               
               return b;
           }
           
           else
               return parseInt(x);
       };
       
       var regex=/^[0-9]+$/;
       if (sknum.match(regex)) {
           integerCheck = 1;
       }
       
       if(integerCheck > 0) {
           if(smn.length < 10) {
               smnStatus = 2;
           }
           else {
               smn01 = smn.substring(0, 1) * 2;
               smn02 = parseInt(smn.substring(1, 2));
               smn03 = smn.substring(2, 3) * 2;
               smn04 = parseInt(smn.substring(3, 4));
               smn05 = smn.substring(4, 5) * 2;
               smn06 = parseInt(smn.substring(5, 6));
               smn07 = smn.substring(6, 7) * 2;
               smn08 = parseInt(smn.substring(7, 8));
               smn09 = smn.substring(8, 9) * 2;
               chkDigit = parseInt(smn.substring(9, 10));
               
               smn01 = getSingleDigit(smn01);
               smn03 = getSingleDigit(smn03);
               smn05 = getSingleDigit(smn05);
               smn07 = getSingleDigit(smn07);
               smn09 = getSingleDigit(smn09);
               
               intOdds = smn01 + smn03 + smn05 + smn07 + smn09;
               intEvens = smn02 + smn04 + smn06 + smn08;
               
               intRemainder = (intOdds + intEvens) % 10;
               
               if ((intRemainder == 0) && (chkDigit == 0)) { smnStatus = 0; }
               else if ((10 - intRemainder) == chkDigit) { smnStatus = 0; }
               else { smnStatus = 3; }
           }
           
       }
       
       else {
           smnStatus = 4;
       }
       
       return smnStatus;
   }


   $scope.$watch('dsmAccountNumber', function (newValue, oldValue, scope) {
       if(newValue && newValue.length>0){
		$scope.invaliddeltaskymilesaccountnumber=false;
       }
	}, true);

}]);

