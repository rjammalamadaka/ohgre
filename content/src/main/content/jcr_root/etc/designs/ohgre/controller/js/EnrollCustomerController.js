ohgrePortal.controller('EnrollCustomerController', ['$scope', '$window', '$rootScope', '$http', 'PrimeService', '$sce',function ($scope, $window, $rootScope, $http, PrimeService, $sce) {

    //     var onlinePromoCodes=["SCORE1C","COMPARE1C","SWITCH", "SCORE1V", "COMPARE1V", "SCORE1DT", "LOWEST1DT", "SCORE1CO", "LOWEST1CO", "10MONTHFIX2018", "10FIX2018", "SCORE3C", "MOVER3C", "SCORE3V", "COMPARE3V", "MOVER3V", "MOVER3V", "DELTA15K"];


    $scope.ccvalues={
        "COH":1,
        "DEO":1,
        "DUK":1,
        "VED":1,
        "MIC":1,
        "MCG":1
    };

   $scope.showcccontent=true;
    $scope.showcc1content=false;
    $scope.showcc2content=false;
   // $scope.cc1show=false;
    //$scope.cc1show=false;
    $scope.iframeurl="";
    $scope.displaystepscontainer=false;
    $scope.businessName=false;
    $scope.showgiftcardmessage=false;
    $scope.primeErrorMessage=null;
    $scope.reviewdisplay=true;
    $scope.showpromocodeconfirmation=false;
    $scope.deltaskymilesaccountnumberprovidelater=false;
    $scope.sendRafEmailReq={};
    $scope.confirmationButton="Back to Home page";
    $scope.specialoffer=true;
    $scope.displaythankyou=false;

    $scope.displayReferalForm=false;

    $rootScope.showVariablePlan=false;

    jQuery('#popup-spinner-wrap').show();

    $('#b2BCustomerIndError').hide();

    $('#productCodeError').hide();

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


    var getFormatedAccountnumberFromAccount =function(accountNumber){

        var formattedNumber="";
        if(accountNumber){
            var ldc=$rootScope.product.LDC;
            if(ldc == "COH"){
                formattedNumber=accountNumber.substring(0,8)+'-'+accountNumber.substring(8,11)+'-000-'+accountNumber.substring(14,15);
            }else if(ldc == "DUK"){
                formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,8)+'-'+accountNumber.substring(8,10)+'-'+$rootScope.product.dukNumber;
            }else if(ldc == "DEO"){
                formattedNumber=accountNumber.substring(0,1)+'-'+accountNumber.substring(1,5)+'-'+accountNumber.substring(5,9)+'-'+accountNumber.substring(9,13);
            }else if(ldc == "VED"){
                formattedNumber="03-"+accountNumber.substring(0,9)+"-"+accountNumber.substring(9,16)+"-0";
            }else if(ldc == "MCG"){
                formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,7)+'-'+accountNumber.substring(7,11)+'-'+accountNumber.substring(11,12);
            }else if(ldc == "MIC"){
                formattedNumber=accountNumber;
            }
            return formattedNumber;

        }else{
            return "";
        }


    }


    PrimeService.getProductData().success(function(data, status, headers, config){

        if(!data.LDC){
            location.href=$rootScope.homeUrl+".html";
            return false;
        }

        if(data.priceChangeFrequency=="D"){
            $rootScope.showVariablePlan=true;
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

        	$('.accountnumber').hide();


            if( data.LDC=="COH"){
                $('#coh-accno').show();
            }

            if( data.LDC=="DEO"){
                $('#deo-accno').show();
            }

            if( data.LDC=="DUK"){
                $('#duk-accno').show();
            }

            if( data.LDC=="VED"){
                $('#ved-accno').show();
            }
            if( data.LDC=="MCG"){
				 $('#mcg-accno').show();
            }

            if( data.LDC=="MIC"){
				 $('#mic-accno').show();
            }

        updateenrollrequestobj(data);

        if($rootScope.hashParams && $rootScope.hashParams.fromRenewal){
            getCustomerInfo(data,true);
            $rootScope.showcurrentplan=true;
            var promoCodeInfo=ohgre.store("promoCodeInfo");
            if(promoCodeInfo && !isEmpty(promoCodeInfo)){
                if($rootScope.product.isDefaultPromoCode=="false")
                    $scope.showpromocodeconfirmation=true;
            }
            $scope.confirmationButton="Back to My Account";

        }else{
            jQuery('#popup-spinner-wrap').hide();
        }

      $scope.ccvalue=  $scope.ccvalues[data.LDC];

        if($scope.ccvalue ==0){
        $scope.showcccontent=false;
        }
        if($scope.ccvalue ==1){
			$scope.showcc1content=true;
        }
        if($scope.ccvalue ==2){
			$scope.showcc2content=true;
        }

    }).error(function (data,status, headers, config){

        if(!data.LDC){
            location.href=$rootScope.homeUrl+".html";
        }
    });

    function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

    var getCustomerInfo=function(req,fromRenewal){

        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
            if(data){
                $rootScope.customerInfo=JSON.parse(data.CustomerInfoResult);
                updateenrollrequestobj($rootScope.customerInfo);
                if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="0"){
                    // $rootScope.account
                    $scope.formatedacno=getFormatedAccountnumberFromAccount($rootScope.customerInfo.account);
                    $scope.phoneNumber= $rootScope.customerInfo.phoneNumber;
                    $scope.existingEmail= $rootScope.customerInfo.emailAddress;

                    $rootScope.showexistingcustomer=true;
                    if(fromRenewal){
                        if(!($scope.customerInfo.existingCustomerInd=="Y" && $scope.customerInfo.renewalContractExistsInd=="Y")){

                            var earlyTermChargeAmt= Number($scope.customerInfo.earlyTermChargeAmt);
                            if(earlyTermChargeAmt>0){
                                $scope.showearlyterminationfee=true;
                            }
                        }

                        if($scope.customerInfo.productCode =="COK" || $scope.customerInfo.productCode=="COJ"){
                            $rootScope.gbplandisplay=true;
                            $rootScope.gbplandescription=$rootScope.customerInfo.contractPrice;
                        }

                    }
                    var customerStatus=$rootScope.getCustomerStatus($rootScope.customerInfo.accountStatus);
                    if(customerStatus =="Active"){
                        if($scope.customerInfo.emailPrefNonTransactionalCd =="Y"){

                            $scope.specialoffer=true;
                        }else{
                            $scope.specialoffer=false;
                        }

                    }else{
                        $scope.specialoffer=false;
                    }

                }
            }

            jQuery('#popup-spinner-wrap').hide();

        }).error(function(data, status, headers, config){
            jQuery('#popup-spinner-wrap').hide();
        });

    }
    $scope.scrollToPageTop=function() {
        jQuery('html,body').animate({
            scrollTop: 0
        }, 1000);

    }
    var getFormatedAccountNumber= function(){

      
        var ldc = $rootScope.product.LDC;

        $rootScope.formatedacno=getAccountNumber(ldc);

        return $rootScope.formatedacno ;

    }

    // Validating if the User Entered name is matching with business name in Prime response
    var validateCommercialName = function(businessName){
        if($rootScope.customerInfo.rateClass =="01")
            return false;
        var regex = /[^a-zA-Z]/g;
        var businessName = businessName.replace(regex,"");
        // businessName = businessName.substring(0, 5);


        var userEnteredName = $scope.lastName.toLowerCase();
        userEnteredName = userEnteredName.replace(regex,"");

        userEnteredName = userEnteredName.substring(0, 5);


        if(userEnteredName.length ==5){
            if(businessName.indexOf(userEnteredName) !== -1){
                return true;
            }
            else{
                return false;
            }
        }else{
            if(businessName ==userEnteredName)
                return true;
            return false;
        }

    }

    var updateBillingAddressInfo=function(){

        $scope.billingaddressone=$rootScope.customerInfo.mailAddress1;
        $scope.billingaddresstwo=$rootScope.customerInfo.mailAddress2;
        $scope.billingaddresscity=$rootScope.customerInfo.mailCity;
        $scope.billingaddressstate=$rootScope.customerInfo.mailStateCode;
        $scope.billingaddresszip=$rootScope.customerInfo.mailZipCode;
    }
    $scope.enrollCustomer =function(step){
        $('#lastnamezipcodeerror').hide();
        $('#b2BCustomerIndError').hide();
        $('#b2BCustomerIndError').hide();
        clearEnrollReqObject(); 
        $rootScope.customerInfo=null;
        $rootScope.formatedacno=null;
        $scope.billingaddressone=null;
$scope.billingaddresstwo=null;
        $scope.billingaddresscity=null;
        $scope.billingaddressstate=null;
        $scope.billingaddresszip=null;
        $scope.phoneNumber=null;
        $scope.existingEmail=null;
        $scope.formone.submited = true;
        getFormatedAccountNumber();
        if(isAccountNumberValid($rootScope.product.LDC) && $scope.formone.$valid && $scope.formone.lastName.$valid && $scope.formone.zipcode.$valid){
            var accountnumber=null;

             var accno=getAccountNumber($rootScope.product.LDC);;
            if($rootScope.product.LDC == "DUK"){
                accountnumber=$scope.an1+$scope.an2+$scope.an3;
            }else if($rootScope.product.LDC == "VED"){
                accountnumber=$scope.an2+$scope.an3;
            }else if($rootScope.product.LDC == "MIC"){
                accountnumber=$scope.an4;
            }else{
                accountnumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
            }
            accountnumber=accno;
            $scope.unformatedaccountnumber=accno;
            var req={};

            var accountNumberForBE=accno.replace(/\-/g, "");

            if($rootScope.product.LDC=="DUK"){
               accountNumberForBE= accountNumberForBE.substring(0,accountNumberForBE.length-1);
            }
            if($rootScope.product.LDC=="VED"){
                accountNumberForBE=accountNumberForBE.substring(2,accountNumberForBE.length-1);
            }
            req.AccountNumber=accountNumberForBE;
            req.LDC=$rootScope.product.LDC;
            jQuery('#popup-spinner-wrap').show();
            PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
                jQuery('#popup-spinner-wrap').hide();
                if(data && data.CustomerInfoResult){
                    $rootScope.customerInfo=JSON.parse(data.CustomerInfoResult);
                    console.log($rootScope.customerInfo.productCode);

                    if($rootScope.customerInfo && $rootScope.customerInfo.b2BCustomerInd && $rootScope.customerInfo.b2BCustomerInd=="Y"){
                        $('#b2BCustomerIndError').show();
                        return;
                    }
                     var promoCodeInfo=ohgre.store("promoCodeInfo");
                    if(promoCodeInfo && !isEmpty(promoCodeInfo)){
                        $scope.showpromocodeconfirmation=true;
                        if(promoCodeInfo && promoCodeInfo.standardpromocode){
							$scope.showpromocodeconfirmation=false;
                        }
                    }
                    updateenrollrequestobj($rootScope.customerInfo);
                    if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus =="0"){
                        $scope.phoneNumber= $rootScope.customerInfo.phoneNumber;
                        $scope.existingEmail= $rootScope.customerInfo.emailAddress;
                        var productInfo={};
                        if($rootScope.product && $rootScope.product.productCode && $rootScope.product.productCode==$rootScope.customerInfo.productCode){
                            productInfo.sameProductCode="Y";
                        }else{
                            productInfo.sameProductCode="N";
                        }
                        var existingCustomerStatus=$rootScope.getCustomerStatus($rootScope.customerInfo.accountStatus);

                        if(existingCustomerStatus=="Active"){
                            //  $rootScope.showcurrentplan=true;

                            if($rootScope.customerInfo.emailPrefNonTransactionalCd =="Y"){

                                $scope.specialoffer=true;
                            }else{
                                $scope.specialoffer=false;
                            }
                        }else{
                            $scope.displayReferalForm=true;
                        }
                        productInfo.existingCustomerStatus=existingCustomerStatus;
                        updateenrollrequestobj(productInfo);
                        $rootScope.showexistingcustomer=true;
                        $rootScope.gbplandisplay=false;

                        updateBillingAddressInfo();

                        if($rootScope.product.customerTypeCode =="NEW" && existingCustomerStatus=="Active" && ($rootScope.customerInfo.serviceZipCode.toLowerCase() == $scope.zipcode.toLowerCase()) && (($rootScope.customerInfo.lastName.toLowerCase() ==$scope.lastName.toLowerCase()) || (validateCommercialName($rootScope.customerInfo.businessName.toLowerCase())))){
                            $('#popupalternate').addClass('show-popup');
                        }

                        else if($rootScope.product.customerTypeCode =="EXISTING" && existingCustomerStatus=="Inactive" && ($rootScope.customerInfo.serviceZipCode.toLowerCase() == $scope.zipcode.toLowerCase()) && (($rootScope.customerInfo.lastName.toLowerCase() ==$scope.lastName.toLowerCase()) || (validateCommercialName($rootScope.customerInfo.businessName.toLowerCase())))){
                            $('#popupalternate').addClass('show-popup');
                        }else if(accountnumber == $rootScope.customerInfo.account && $rootScope.customerInfo.rateClass != $rootScope.product.rateClassCode && ($rootScope.customerInfo.serviceZipCode.toLowerCase() == $scope.zipcode.toLowerCase()) && (($rootScope.customerInfo.lastName.toLowerCase() ==$scope.lastName.toLowerCase()) || (validateCommercialName($rootScope.customerInfo.businessName.toLowerCase())))){
                            $('#popupalternate').addClass('show-popup');
                            return false;
                        }else if($rootScope.product.rateClassCode =="01"){
                            if(($rootScope.customerInfo.lastName.toLowerCase() !=$scope.lastName.toLowerCase()) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                                $('#lastnamezipcodeerror').show();
                                $scope.showpromocodeconfirmation=false;
                                return false;
                            }else{
                                $('#popupconfirm').addClass('show-popup');
                            }
                        }else if($rootScope.product.rateClassCode =="04"){
                            if((!validateCommercialName($rootScope.customerInfo.businessName.toLowerCase())) || ($rootScope.customerInfo.serviceZipCode.toLowerCase() != $scope.zipcode.toLowerCase())){
                                $('#lastnamezipcodeerror').show();
                                $scope.showpromocodeconfirmation=false;
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
                        $scope.displayReferalForm=true;
                        $rootScope.showexistingcustomer=false;
                        var accountNumberInfo={};
                        if($scope.unformatedaccountnumber){

                            var accno=getAccountNumber($rootScope.product.LDC);
                            var accountNumberForBE=accno.replace(/\-/g, "");
                            if($rootScope.product.LDC=="DUK"){
                                accountNumberForBE= accountNumberForBE.substring(0,accountNumberForBE.length-1);
                            }
                            if($rootScope.product.LDC=="VED"){
                                accountNumberForBE=accountNumberForBE.substring(2,accountNumberForBE.length-1);
                            }
                            accountNumberInfo.account=accountNumberForBE;
                            updateenrollrequestobj(accountNumberInfo);
                        }

                        if($scope.product.rateClassCode =="04"){
                            $scope.customerInfo.businessName=$scope.lastName;
                        }

                        if($rootScope.product.customerTypeCode =="EXISTING"){
                            $('#popupnoteligiblefornew').addClass('show-popup');

                        }else{

                            gotNextStep(2);
                        }
                        //location.href="/content/onlyong/maintenance.html";
                    }



                }else{
                    location.href=$rootScope.homeUrl+'/errors/500.html';
                }

                /*

                  */
            }).error(function (data,status, headers, config){
                jQuery('#popup-spinner-wrap').hide();
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

            if($scope.promotionInfo && $scope.promotionInfo.PromotionCode && $scope.promotionInfo.PromotionCode.indexOf('RAF')!= -1 && failcount<1 && (!$scope.rafcode ||$scope.rafcode=="") && $rootScope.customerInfo.responseStatus=='1'){


                $scope.rafErrorMessage="Please enter your friend's referral code";
                failcount=failcount+1;


            }else if($scope.rafcode && $scope.rafcode.length>0){
                var account;
                var ldc;
                if($rootScope.customerInfo.responseStatus =="0"){
                    account=$rootScope.customerInfo.account;
                    ldc=$rootScope.product.LDC;
                }
                PrimeService.checkRafEligibility($scope.rafcode,account,ldc).success(function(data, status, headers, config){
                    if(data.responseStatus == "0"){
                        if(data.rafInfo.AwardIneligibleReason !=="1"){
                            $scope.validPromocode=true;
                            handelsubmityourinformation();
                        }else{
                            failcount=failcount+1;
                            if(failcount<=1){
                                $scope.validPromocode=false;
                                //$scope.primeErrorMessage="RAF code is not valid";
                                $scope.rafErrorMessage="RAF code is not valid";
                            }else{
                                $scope.validPromocode=true;
                                handelsubmityourinformation();
                            }
                        }
                    }else{
                        failcount=failcount+1;
                        $scope.rafErrorMessage="RAF code is not valid";
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

        if($rootScope.product && $rootScope.product.rateClassCode){
            data.rateClassCode=$rootScope.product.rateClassCode;
        }
        if($rootScope.product && $rootScope.product.fixedPricePerTherm){
            data.fixedPricePerTherm=$rootScope.product.fixedPricePerTherm;
        }
        if($rootScope.customerInfo && $rootScope.customerInfo.responseStatus=="0"){
            var accountStatus=$rootScope.getCustomerStatus($scope.customerInfo.accountStatus);
            data.accountStatus=accountStatus;
            data.existingCustomerStatus=accountStatus;
        }
        var tcversion=$('#tcversion').data('tcversion');
        if(tcversion){
            data.tcversion=tcversion;
        }

        /* if($rootScope.customerInfo && $rootScope.customerInfo.renewalContractExistsInd){
             data.renewalContractExistsInd= $rootScope.customerInfo.renewalContractExistsInd;
         }*/
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

        if($scope.existingEmail && (data.emailAddress !=data.existingEmail)){
            data.alternateEmailAddress=data.emailAddress;
        }

        if($scope.ccvalue ==1){
			//console.log($scope.cc1show);
            if($scope.cc1show)data.ccvalue=true
            else data.ccvalue=false;
        }
        if($scope.ccvalue ==2){
			console.log($scope.cc2show);
             if($scope.cc2show)data.ccvalue=true
            else data.ccvalue=false;
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
            $scope.scrollToPageTop();
            gotNextStep(4);

        }

    }

    $scope.reviewauthorizesubmit1 =function(){
        $scope.formfour.submited = true;

        if($scope.formfour.$valid && !$scope.flag){

            /* if($scope.promotionInfo && $scope.promotionInfo.DSMEligible =="Y"){
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
             */

            $scope.reviewauthorizesubmit();
            $scope.scrollToPageTop();
        }

    }

    $scope.continuedeltaskymiles =function(from){

        if(from =="fromdelta"){
            $scope.deltaskymilesaccountnumberprovidelater=true;
        }

        $scope.continuefromdeltaskymiles=true;
       /* if($scope.promotionInfo && $scope.promotionInfo.RAFAdvertising  =="Y"){
            $scope.reviewdisplaydeltaskymiles =false;
            $scope.reviewdisplayvisa=false;
            $scope.reviewdisplayraf =true;
        }else{
            $scope.reviewauthorizesubmit();
        }*/

        if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplaydeltaskymiles =false;
            $scope.reviewdisplayvisa =true;
        }

    }

    $scope.sendemailwithmoreinfo =function(){

        if($scope.existingEmail && ($scope.enrollReq.emailAddress !=$scope.existingEmail)){

            $scope.enrollReq.alternateEmailAddress=$scope.enrollReq.emailAddress;
        }
        $scope.enrollReq.emailTypeCode="RAFGEN";


       // $scope.reviewauthorizesubmit();

        	$scope.sendRafEmailReq.emailAddress=$scope.enrollReq.emailAddress;
            PrimeService.sendRafEmail($scope.sendRafEmailReq).success(function(data, status, headers, config){

                 $scope.continueTwoPromotions();

            }).error(function(data, status, headers, config){
 				$scope.continueTwoPromotions();
            });

    }
    $scope.reviewauthorizesubmit =function(){

        $scope.primeErrorMessage=null;
        //$scope.formfour.submited = true;

        if($scope.formfour.$valid && !$scope.flag){
            $scope.flag=true;

            if($scope.showgiftcardmessage){
                $scope.showgiftcardmessage=false;
                $scope.showgiftcardmessageconfirmation=true;
            }
            jQuery('#popup-spinner-wrap').show();
            PrimeService.enrollCustomer($scope.enrollReq).success(function(data, status, headers, config){
                $scope.flag=false;
                jQuery('#popup-spinner-wrap').hide();
                if(data){
                    var enrollCustomerResult = JSON.parse(data.EnrollCustomerResult);
                    if(data.enrollId){
                        $scope.enrollId=data.enrollId;
                    }
                    if(enrollCustomerResult.responseStatus =="1" || enrollCustomerResult.responseStatus =="-1"){
                        //$scope.primeErrorMessage=enrollCustomerResult.responseMessage;
                        ohgre.removeStore("promoCodeInfo");
                        //$scope.sendRafEmailReq.custID=enrollCustomerResult.custID;
                        $scope.displaythankyou=true;
                        gotNextStep(5);
                        document.title="Confirmation Page";

                    }else if(enrollCustomerResult.responseStatus){

                        $scope.sendRafEmailReq.custID=enrollCustomerResult.custID;
                        if($scope.promotionInfo && ($scope.promotionInfo.DSMEligible =="Y" || $scope.promotionInfo.GiftCardEligible =="Y" || $scope.promotionInfo.RAFAdvertising =="Y")){
                            $scope.displaythankyou=true;
 						     gotNextStep(5);
                             document.title="Confirmation Page";
                             $scope.continuePromotions=true; 
                             $scope.confirmationButton="Continue";
                        }else{
                            $scope.displaythankyou=true;
                            ohgre.removeStore("promoCodeInfo");
                        	gotNextStep(5);
                        	document.title="Confirmation Page";
                        }
                    }
                }
                $scope.scrollToPageTop();

            }).error(function(data, status, headers, config){
                jQuery('#popup-spinner-wrap').hide();
                $scope.flag=false;
                location.href=$rootScope.homeUrl+'/errors/500.html';
            });

        }
    }

    var displaypromocodeconfirmation =function(step,back){

        if(step ==2 || step ==3){
            if($scope.promotionInfo && $scope.promotionInfo.PromotionCode){
                if($rootScope.product.isDefaultPromoCode=="false")
                    $scope.showpromocodeconfirmation=true;
            }
        }else{
            $scope.showpromocodeconfirmation=false;
        }

    }
    var gotNextStep= function(step,back){
        // $scope.displaystepscontainer=true;

        var eventname=null;
        if($rootScope.portalname =='oh'){
            eventname='oh-journey';
        }else{
            eventname='gr-journey';
        }
        if(!back){
            if(step ==2){
                dataLayer.push({'event':'oh-journey','step':'your-information'});

            }else if(step ==3){
                dataLayer.push({'event':'oh-journey','step':'accept-terms'});
            }else if(step ==4){
                dataLayer.push({'event':'oh-journey','step':'review'});

            }else if(step ==5){
                dataLayer.push({'event':'oh-journey','step':'thank-you'});

            }

        }

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
        $scope.scrollToPageTop();
        if(step ==1){

            if($rootScope.hashParams && $rootScope.hashParams.fromRenewal){
                window.history.back();
            }else{
                $('.steps-container').hide();
                $rootScope.showcurrentplan=false;
                $rootScope.showearlyterminationfee=false;
            }

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

        if($scope.enrollReq.existingCustomerStatus=="Active"){
            $rootScope.showcurrentplan=true;
        }


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
        phonenumber=phonenumber.replace(/ /g,'');

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

                if($scope.promotionInfo && $scope.promotionInfo.PromotionCode){
                    $scope.dsmEnrollReq.PromotionCode=$scope.promotionInfo.PromotionCode;
                }
                if($rootScope.portalname =="oh"){
                    $scope.dsmEnrollReq.portalName ="oh";
                }else{
                    $scope.dsmEnrollReq.portalName ="gre";
                }

                PrimeService.dsmEnroll($scope.dsmEnrollReq).success(function(data, status, headers, config){
                    $scope.flag=false;
                   // if(data.message =="Success"){
                        //$scope.reviewauthorizesubmit();
                        /*if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
                            $scope.reviewdisplay=false;
                            $scope.reviewdisplaydeltaskymiles =false;
                            $scope.reviewdisplayvisa =true;
                        }*/
                        $scope.continueLastPromotions();
                   // }

                }).error(function(data, status, headers, config){
                    $scope.flag=false;
                     $scope.continueLastPromotions();
                });

            }

        }

    }

    var updateenrollrequestobj=function(data){

        /*if(data.PromotionCode){
            if(onlinePromoCodes.indexOf(data.PromotionCode)!=-1){
               data.PromotionCode= data.PromotionCode.concat("ONLINE");
            }
        }*/


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
        if(data.custID)
            $scope.enrollReq.custID=data.custID;
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
        if(data.sameProductCode)
            $scope.enrollReq.sameProductCode=data.sameProductCode;
        if(data.existingCustomerStatus)
            $scope.enrollReq.existingCustomerStatus=data.existingCustomerStatus;
        if(data.alternateEmailAddress)
            $scope.enrollReq.alternateEmailAddress=data.alternateEmailAddress;
        if(data.rateClassCode)
            $scope.enrollReq.rateClassCode=data.rateClassCode;
        if(data.fixedPricePerTherm)
            $scope.enrollReq.fixedPricePerTherm=data.fixedPricePerTherm;
        if(data.tcversion)
            $scope.enrollReq.tcversion=data.tcversion;
        if(data.OriginalPromoCode)
            $scope.enrollReq.originalPromoCode=data.OriginalPromoCode;
        if($scope.ccvalue ==1 && $scope.cc1show){
			$scope.enrollReq.ccvalue=$scope.cc1show.toString();
        }
        if($scope.ccvalue ==2 && $scope.cc2show){
			$scope.enrollReq.ccvalue=$scope.cc2show.toString();
        }
    }

    var setPromotionInfoByLDC =function(ldc){

        var promoinfo=ohgre.store("promoCodeInfo");
        if(promoinfo && promoinfo.LDCList && promoinfo.LDCList.length>0 && promoinfo.LDCList[0].promotion && promoinfo.LDCList[0].promotion.length>0){
            var temp=null;
            for(var i=0; i<promoinfo.LDCList.length;i++){
                if(promoinfo.LDCList[i].LDCCode ==ldc){
                    temp=promoinfo.LDCList[i].promotion[0];
                    break;
                }

            }
            //var data= promoinfo.LDCList[0].promotion[0];
            var data=temp;
            if(promoinfo.LDCList[0].OriginalPromoCode && promoinfo.LDCList[0].OriginalPromoCode.length>0){
                data.OriginalPromoCode=promoinfo.LDCList[0].OriginalPromoCode;
            }
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
    var continuePromotions=function(){

        if($scope.promotionInfo && $scope.promotionInfo.RAFAdvertising =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplayraf =true;
        }else if($scope.promotionInfo && $scope.promotionInfo.DSMEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplaydeltaskymiles =true;
        }else if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplayvisa =true;
        }else{
			$scope.displaythankyousection();
        }
    }

   $scope.continueTwoPromotions=function(){
		$scope.reviewdisplayraf =false;
         if($scope.promotionInfo && $scope.promotionInfo.DSMEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplaydeltaskymiles =true;
        }else if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplayvisa =true;
        }else{
			$scope.displaythankyousection();
        }
    }

      $scope.continueLastPromotions=function(){
		$scope.reviewdisplayraf =false;
         $scope.reviewdisplaydeltaskymiles=false;
       if($scope.promotionInfo && $scope.promotionInfo.GiftCardEligible =="Y"){
            $scope.reviewdisplay=false;
            $scope.reviewdisplayvisa =true;
        }else{
			$scope.displaythankyousection();
        }
    }
   $scope.displaythankyousection=function(){
       $("#thank-you").removeClass("active-step").addClass("step-complete");
       $scope.displaythankyou=false;
        $scope.reviewdisplayvisa =false;
       $scope.displaythankyousectionpage=true;
   }
    $scope.gotoHomePage = function(){
        //location.href=$rootScope.homeUrl+".html";
        if($scope.continuePromotions){
            console.log("continue promotions");
            $scope.displaythankyou=false;
            continuePromotions();

        }else{
            if($rootScope.hashParams && $rootScope.hashParams.fromRenewal){    
                location.href=$rootScope.homeUrl+"/myaccount.html";    
            }else{    
                location.href=$rootScope.homeUrl+".html";
            }
        }
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




    if($rootScope.hashParams && $rootScope.hashParams.fromRenewal){
        gotNextStep(2);

    }


    $scope.getDisplayPromocode = function(promocode){
        if(promocode){
            var index=promocode.indexOf("ONLINE");
            if(index != -1){
                return promocode.substr(0,index);
            }else{
                return promocode;
            }
        }else{ return "";

        }


    }


    $scope.$watch('iframeurl', function (newValue, oldValue, scope) {
        if(newValue && newValue.length>0){
            $scope.url = $sce.trustAsResourceUrl('https://docs.google.com/gview?url='+location.origin+newValue+'&embedded=true');
        }
    }, true);


}]);

