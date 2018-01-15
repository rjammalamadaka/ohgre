ohgrePortal.controller('RenewalPlanController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {


    $scope.showgiftcardmsg=false;
    ohgre.removeStore("promoCodeInfo");
    $scope.formButton="Apply Promo Code";
     $scope.guaranteeProductDisplay=false;

      function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }


    var flag=false;


    var getQuotes=function(req){

        var PromoCode=null;

        var ResPromoCode=$("#renew-plan-select").data("respromocode");
		var ComPromoCode=$("#renew-plan-select").data("compromocode");

        if($scope.promocode && $scope.promocode.length>0){
			PromoCode=$scope.promocode;
        }else{
            if(req.rateClassCode =="01"){
                PromoCode=ResPromoCode;
            }else if(req.rateClassCode =="04"){
                PromoCode=ComPromoCode;
            }
        }
      /*  if(req.PromoCode){

            PromoCode=req.PromoCode;
        }*/

        PrimeService.getQuotes(req.LDC,PromoCode,req.rateClassCode).success(function(data, status, headers, config){

             jQuery('#popup-spinner-wrap').hide();
            if(data && data.responseStatus=="0"){
                $scope.products={};
                if(data.Customer && data.Customer.length>0){

					var customer=data.Customer[0];
					var getQuotesProductsList=[];
                    for(var i=0;i<customer.Product.length;i++){
                        if($rootScope.prmoProduct.indexOf(customer.Product[i].ProductCode) !=-1){
                            getQuotesProductsList.push(customer.Product[i]);

                        }

                    };
                    $scope.products=getQuotesProductsList;//$scope.Customer[0].Product;

 					if(!flag){
						flag=true;
                        $scope.defaultProducts=$scope.products;

                    }
                   // $scope.products=data.Customer[0].Product;


                    updateProductFinePrint();
                }
            }

        }).error(function (data,status, headers, config){

        });


    }


    var getPromoCodeInfoForEnroll=function(ldc){
        PrimeService.getPromocodesForEnrollment(ldc).success(function(data, status, headers, config){
            var promotionProduct=null;
            var products=[];
            var enrollmentResult=JSON.parse(data.GetPromoCodesForEnrollmentResult);
            if(enrollmentResult && enrollmentResult.responseStatus =="0"){
			      for(var i =0;i<enrollmentResult.promotion.length;i++){
					var promotion=enrollmentResult.promotion[i];
                    if(promotion && promotion.promotionCode && promotion.promotionCode==$rootScope.enrollPromoCode.toUpperCase()){
            			promotionProduct=promotion.product;
                        break;
                    }
                }
                if(promotionProduct && promotionProduct.length>0)
                for(var j=0;j<promotionProduct.length;j++){
                   var product= promotionProduct[j];
					products.push(product.productCode);
                }
                 $rootScope.prmoProduct=products;
               // getQuotes($scope.productData);

            }
        }).error(function (data,status, headers, config){ });

    }



       var getCustomerInfo=function(req){


        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){


            $scope.customerInfo=JSON.parse(data.CustomerInfoResult);


        }).error(function(data, status, headers, config){

        });

    }

           var updateProductFinePrint = function(){

        angular.forEach($scope.products, function(value, key){


            if($scope.products[key].ProductCode =="COJ"  || $scope.products[key].ProductCode =="COK"){

                 $scope.guaranteeProduct=$scope.products[key];
                 $scope.guaranteeProductDisplay=true;

            }

            var ProductFinePrintText = value.ProductFinePrintText.split(".");
            var lastword=ProductFinePrintText[ProductFinePrintText.length-1];
            if(!(lastword.length>1))
            ProductFinePrintText.pop();
			$scope.products[key].ProductFinePrintText = ProductFinePrintText;

        });

    }


     PrimeService.getProductData().success(function(data, status, headers, config){


         if(!isEmpty(data)){
             $scope.productData=data;
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             $scope.ldc=data.LDC;
             getCustomerInfo(req);
             getPromoCodeInfoForEnroll(data.LDC);

             if(data.rateClassCode == "01"){
                   $rootScope.enrollPromoCode=$("#renew-plan-select").data("respromocode");
             }else if(data.rateClassCode == "04"){
                 $rootScope.enrollPromoCode=$("#renew-plan-select").data("compromocode");

             }
             getDefaultPromoctionInfo();
            // getQuotes(data);

         }else{
			location.href=$rootScope.homeUrl+".html";

         }
     }).error(function(data, status, headers, config){

     });



    $rootScope.$watch('prmoProduct', function (newValue, oldValue, scope) {

        if(newValue && newValue.length>0){
           // getQuotesForViewPlans();
            //var promoInfo=ohgre.store("promoCodeInfo");
            //processPromotionInfo(promoInfo,newValue);
            getQuotes($scope.productData);
        }
    });


     $scope.logout=function(){
      jQuery('#logout-popup').show();
    }

   $scope.confirmlogout =function(){
		$rootScope.commonLogout();
    }

    $scope.cancellogout=function(){
		jQuery('#logout-popup').hide();
    }


/*var promocode="RAF25";
     PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){


                 if(data && data.responseStatus =="0"){


                 }else if(data && data.responseStatus =="1"){
						$scope.serverError=data.responsemessage;

                 }

             }).error(function (data,status, headers, config){

             });

*/

     //Code for controlling Accordian display

     $scope.displayAddlInfo = function(product){
        if(product != undefined){

        	if(product.displayAccordian == undefined)
        	{
				product.displayAccordian = true;
        	}
       		else if(product.displayAccordian){
				product.displayAccordian = false;
        	}
        	else if(!product.displayAccordian){
				product.displayAccordian = true;
        	}
      }


    }

    $scope.showMobileAccord = function(product){

		if(product != undefined){

        if(product.displayMobAccord == undefined)
        {
			product.displayMobAccord = true;
        }
        else if(product.displayMobAccord){
			product.displayMobAccord = false;
        }
        else if(!product.displayMobAccord){
			product.displayMobAccord = true;
        }
      }

    }


    var getPromocodeInfo=function(promocode){

          PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){

               if(data.LDCList.length>0){
						var ldcinfo=null;

                        for(var i=0;i<data.LDCList.length;i++){
							var temp=data.LDCList[i];
                            if(temp.LDCCode == $scope.ldc){
                                ldcinfo=temp;
								break;
                            }
                        }
						ProcessPromotionInformation(ldcinfo,data,true);

                    }


          }).error(function(data, status, headers, config){

          });

    }

    var ProcessPromotionInformation=function(ldcinfo,data,isBackUpPromo){


                            if(ldcinfo && ldcinfo.promotion[0] && ldcinfo.promotion[0].PromotionExpired =="Y" && ldcinfo.promotion[0].BackupPromotionCode.length>0 && !$scope.backuppromoapplied){
                                 $scope.serverError="Unfortunately this promotion has expired but we have some great plans below"; 
                              //  $scope.showpromosuccessdmsg=false;
								//$scope.showgiftcardmsg=false;
                                $scope.showmsg=true;
                                $scope.backuppromoapplied=true;
								$rootScope.enrollPromoCode=ldcinfo.promotion[0].BackupPromotionCode;
								getPromocodeInfo(ldcinfo.promotion[0].BackupPromotionCode);
                                return false;                    
                            }else{
 								$scope.showmsg=false;
                            }

       					 if(!ldcinfo){
 							$scope.serverError="Sorry, we are unable to find that promotion code. Please call us at "+$scope.mobilenumber+" so we may further assist you."; 
                            jQuery('#popup-spinner-wrap').hide();
                        }


                        if(ldcinfo.promotion[0].RateClassCode.length>0 && $scope.productData.rateClassCode.length>0 && (ldcinfo.promotion[0].RateClassCode != $scope.productData.rateClassCode)){

                            $scope.serverError="Sorry, we are unable to find that promotion code. Please call us at "+$scope.mobilenumber+" so we may further assist you";
                            return false;

                         }

                        if(ldcinfo && ldcinfo.promotion[0].GiftCardEligible == "Y"){
                        	var giftCardValue=Number(ldcinfo.promotion[0].GiftCardValue);
                            if(giftCardValue>0){
                               ohgre.store("promoCodeInfo",data);
								$scope.showgiftcardmsg=true;
                                $scope.giftCardValue=giftCardValue;
                                $scope.GIFTCARDVALUE =giftCardValue;
                            }
                        }

                        if(ldcinfo && ldcinfo.promotion[0].PromotionExpired=="N"){
								$scope.showpromosuccessdmsg=true;
                            	ohgre.store("promoCodeInfo",data);
                        }

                        if(ldcinfo && ldcinfo.promotion[0].CustomerTypeCode=="NEW"){
								ohgre.removeStore("promoCodeInfo");
                                jQuery('#popup-spinner-wrap').hide();
                                $scope.serverError="Sorry you are not eligible for this offer."; 
                            	$scope.showgiftcardmsg=false;
                            	$scope.showpromosuccessdmsg=false;

                        }else  if(ldcinfo && ldcinfo.promotion[0].PromotionExpired=="Y"){
                            if(ldcinfo.promotion[0].BackupPromotionCode){
                                 $rootScope.enrollPromoCode=ldcinfo.promotion[0].BackupPromotionCode;
                                var req={};
                                $scope.serverError="Unfortunately this promotion has expired but we have some great plans below"; 
                                 getPromoCodeInfoForEnroll($scope.productData.LDC);


                            }else{
                                 jQuery('#popup-spinner-wrap').hide();
                                $scope.serverError="Sorry the promotion code you entered has expired"; 
                            }
                        }else if(ldcinfo && ldcinfo.promotion[0]){
                             $rootScope.enrollPromoCode=$scope.promocode;
                            getPromoCodeInfoForEnroll($scope.productData.LDC);

                        }

                            if(isBackUpPromo){
 								  $scope.showpromosuccessdmsg=false;
								  $scope.showgiftcardmsg=false;
                            }

        $scope.appliedpromocode=ldcinfo.promotion[0].PromotionCode;

        jQuery('#popup-spinner-wrap').hide();

    }

    $scope.submitPromoCode =function(){
		$scope.serverError=null;
        $scope.showgiftcardmsg=false;

        if($scope.formButton=="CLEAR"){
            $scope.showpromosuccessdmsg=false;
			ohgre.removeStore("promoCodeInfo");
            $scope.products=$scope.defaultProducts;
            $scope.formButton="Apply Promo Code";
            $('#submit-promo-code').removeClass("inactive");
            $scope.promocode=null;
            getDefaultPromoctionInfo();
       }else if($scope.renewalPlanPromo.$valid){
           $scope.renewalPlanPromo.submited = true;

           $('#submit-promo-code').addClass("inactive");
           jQuery('#popup-spinner-wrap').show();
            PrimeService.getPromoCodeInfo($scope.promocode).success(function(data, status, headers, config){
                //$('#submit-promo-code').removeClass("inactive");
                $scope.formButton="CLEAR";
               // jQuery('#popup-spinner-wrap').hide();
                if(data && data.responseStatus =="0"){                    

                    if(data.LDCList.length>0){
						var ldcinfo=null;

                        for(var i=0;i<data.LDCList.length;i++){
							var temp=data.LDCList[i];
                            if(temp.LDCCode == $scope.ldc){
                                ldcinfo=temp;
								break;
                            }
                        }
						ProcessPromotionInformation(ldcinfo,data,false);

                    }else{
                        $rootScope.enrollPromoCode=$scope.promocode;
                        getPromoCodeInfoForEnroll($scope.productData.LDC);
                       /* var req={};
						req.AccountNumber=$scope.productData.AccountNumber; 
						req.LDC=$scope.productData.LDC;
						req.PromoCode=$scope.promocode;
                        req.rateClassCode=$scope.productData.rateClassCode;
						getQuotes(req);*/
                    }



                }else if(data && data.responseStatus =="1"){
                    $scope.serverError="Please enter a valid Promo code";    
                    jQuery('#popup-spinner-wrap').hide();

                }

            }).error(function (data,status, headers, config){  
               // $('#submit-promo-code').removeClass("inactive");
                jQuery('#popup-spinner-wrap').hide();
                $scope.formButton="CLEAR";
            });
        }
    }

    $scope.planSelectRenewal =function(product){

        $scope.selectedProduct=product;
        $scope.test=product;

        // $scope.$apply();
        if($scope.customerInfo.existingCustomerInd=="Y" && $scope.customerInfo.renewalContractExistsInd=="Y"){

            $('#popupwithrenewal').addClass('show-popup');
        }else{
            var earlyTermChargeAmt= Number($scope.customerInfo.earlyTermChargeAmt);
            if(earlyTermChargeAmt>0){
                $rootScope.showearlyterminationfee=true;
                $('#popupetc').addClass('show-popup');                
            }else{
				//location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 
                $scope.continueenroll();
            }
        }

    }

    $scope.continueenroll =function(){
         var req={};

        req.QuoteDescription=$scope.selectedProduct.QuoteDescription;
		req.ProductDescription=$scope.selectedProduct.ProductDescription;
        req.ProductCode=$scope.selectedProduct.ProductCode;
        req.LdcDesc= $scope.productData.ldcDesc;
        req.LDC= $scope.productData.LDC;
		req.FixedPricePerTherm=$scope.selectedProduct.FixedPricePerTherm;
        req.AccountNumber=$scope.productData.AccountNumber;
        req.RateClassCode=$scope.productData.rateClassCode;
        req.dukNumber= $scope.productData.dukNumber;

         PrimeService.setProductData(req).success(function(data, status, headers, config){  


             if($rootScope.IsIE()){

				setTimeout(function(){ window.location.href=$rootScope.homeUrl+"/customer_lookup.html?fromRenewal=true"; });
             }else{
				setTimeout(function(){ window.location.href=$rootScope.homeUrl+"/customer_lookup.html?fromRenewal=true"; });
                                }
             //setTimeout(function(){ location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; });

             return false;

         }).error(function (data,status, headers, config){ 

         });


    }

    $scope.redirecttodashboard =function(){
        location.href=$rootScope.homeUrl+"/myaccount.html";

    }
   // /content/onlyong/myaccount.html#

     $scope.getFormatedAccountnumber =function(accountNumber){
        var formattedNumber="";
        if(accountNumber){
			var ldc="";
            if($scope.productData && $scope.productData.LDC){
			ldc=$scope.productData.LDC;
            }
			if(ldc == "COH"){       
			formattedNumber=accountNumber.substring(0,8)+'-'+accountNumber.substring(8,11)+'-000-'+accountNumber.substring(14,15);
			}else if(ldc == "DUK"){
			formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,8)+'-'+accountNumber.substring(8,10)+'-'+$scope.productData.dukNumber;
			}else if(ldc == "DEO"){
			formattedNumber=accountNumber.substring(0,1)+'-'+accountNumber.substring(1,5)+'-'+accountNumber.substring(5,9)+'-'+accountNumber.substring(9,13);
			}else if(ldc == "VED"){
			formattedNumber="03-"+accountNumber.substring(2,11)+"-"+accountNumber.substring(11,18)+"-0";
			}else if(ldc == "MCG"){
			formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,7)+'-'+accountNumber.substring(7,11)+'-'+accountNumber.substring(11,12);
			}else if(ldc == "MIC"){
			formattedNumber=accountNumber;
			}
			return formattedNumber;
        }else{return "";}
}


        $scope.showDeskAccordGuarantee =function(){


        if($scope.displayGuranteedAccord){
            $scope.displayGuranteedAccord=false;
        }else{
			$scope.displayGuranteedAccord=true;
        }

    }


        var getDefaultPromoctionInfo =function(){

                var ResPromoCode=$("#renew-plan-select").data("respromocode");
				var ComPromoCode=$("#renew-plan-select").data("compromocode");

            if($scope.productData && $scope.productData.rateClassCode =="01"){
				$rootScope.enrollPromoCode=ResPromoCode;
            }else if($scope.productData && $scope.productData.rateClassCode =="04"){
				$rootScope.enrollPromoCode=ComPromoCode;
            }


            PrimeService.getPromoCodeInfo($rootScope.enrollPromoCode).success(function(data, status, headers, config){
				 ohgre.store("promoCodeInfo",data);

            }).error(function(data, status, headers, config){

            });
        }

}]);

