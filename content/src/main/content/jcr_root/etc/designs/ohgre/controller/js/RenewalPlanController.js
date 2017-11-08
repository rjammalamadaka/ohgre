ohgrePortal.controller('RenewalPlanController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {


    ohgre.removeStore("promoCodeInfo");
    $scope.formButton="Apply Promo Code";

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
        if(req.rateClassCode =="01"){
            PromoCode=ResPromoCode;
        }else if(req.rateClassCode =="04"){
            PromoCode=ComPromoCode;
        }
      /*  if(req.PromoCode){

            PromoCode=req.PromoCode;
        }*/

        PrimeService.getQuotes(req.LDC,PromoCode,req.rateClassCode).success(function(data, status, headers, config){

            //console.log(data);
            if(data && data.responseStatus=="0"){
                $scope.products={};
                if(data.Customer && data.Customer.length>0){
                    if(!flag){
						flag=true;
                        $scope.defaultProducts=data.Customer[0].Product;

                    }
                    $scope.products=data.Customer[0].Product;
                    updateProductFinePrint();
                    console.log($scope.products);
                }
            }

        }).error(function (data,status, headers, config){

            console.log("error");
        });


    }


       var getCustomerInfo=function(req){


        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){

            console.log(data);

            $scope.customerInfo=JSON.parse(data.CustomerInfoResult);

            console.log($scope.customerInfo);


        }).error(function(data, status, headers, config){

        });

    }

           var updateProductFinePrint = function(){

        angular.forEach($scope.products, function(value, key){


            if($scope.products[key].ProductCode =="COJ"  || $scope.products[key].ProductCode =="COK"){

                $scope.guaranteeProduct=$scope.products[key];

                console.log("$scope.guaranteeProduct");
                console.log($scope.guaranteeProduct);

            }

            var ProductFinePrintText = value.ProductFinePrintText.split(".");
            var lastword=ProductFinePrintText[ProductFinePrintText.length-1];
            if(!(lastword.length>1))
            ProductFinePrintText.pop();
			$scope.products[key].ProductFinePrintText = ProductFinePrintText;

        });

    }


     PrimeService.getProductData().success(function(data, status, headers, config){

         console.log();

         if(!isEmpty(data)){
             $scope.productData=data;
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             $scope.ldc=data.LDC;
             getCustomerInfo(req);
             getQuotes(data);

         }else{
			location.href=$rootScope.homeUrl+".html";

         }
     }).error(function(data, status, headers, config){

     });


     $scope.logout=function(){
        PrimeService.logout().success(function(data, status, headers, config){

            location.href=$rootScope.homeUrl+".html";            
        }).error(function(data, status, headers, config){

        });

    }




/*var promocode="RAF25";
     PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){


                 if(data && data.responseStatus =="0"){

                     console.log(data);

                 }else if(data && data.responseStatus =="1"){
						$scope.serverError=data.responsemessage;

                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });

*/

     //Code for controlling Accordian display

     $scope.displayAddlInfo = function(product){
        console.log("Inside Function");
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
		console.log("showMobileAccord");

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

    $scope.submitPromoCode =function(){
		$scope.serverError=null;
        $scope.showgiftcardmsg=null;
		$scope.renewalPlanPromo.submited = true;

        if($scope.formButton=="CLEAR"){
			ohgre.removeStore("promoCodeInfo");
            $scope.products=$scope.defaultProducts;
            $scope.formButton="Apply Promo Code";
            $('#submit-promo-code').removeClass("inactive");
            $scope.promocode=null;
       }else if($scope.renewalPlanPromo.$valid){
           $('#submit-promo-code').addClass("inactive");
            PrimeService.getPromoCodeInfo($scope.promocode).success(function(data, status, headers, config){
                //$('#submit-promo-code').removeClass("inactive");
                $scope.formButton="CLEAR";
                if(data && data.responseStatus =="0"){                    
                    console.log(data);
                    if(data.LDCList.length>0){
						console.log("code expired");
						var ldcinfo=null;

                        for(var i=0;i<data.LDCList.length;i++){
							var temp=data.LDCList[i];
                            if(temp.LDCCode == $scope.ldc){
                                ldcinfo=temp;
								break;
                            }
                        }

                        if(!ldcinfo){
 							$scope.serverError="Please enter a valid promocode"; 
                        }
                         ohgre.store("promoCodeInfo",data);

                        if(ldcinfo && ldcinfo.promotion[0].GiftCardEligible == "Y"){
                        	var giftCardValue=Number(ldcinfo.promotion[0].GiftCardValue);
                            if(giftCardValue>0){

								$scope.showgiftcardmsg=true;
                                $scope.giftCardValue=giftCardValue;
                               $scope.GIFTCARDVALUE =giftCardValue;
                            }
                        }

                        if(ldcinfo && ldcinfo.promotion[0].PromotionExpired=="Y"){
                            if(ldcinfo.promotion[0].BackupPromotionCode){
                                var req={};
                                $scope.serverError="Unfortunately this promotion has expired but we have some great plans below"; 
                                req.AccountNumber=$scope.productData.AccountNumber; 
                                req.LDC=$scope.productData.LDC;
                                req.PromoCode=ldcinfo.promotion[0].BackupPromotionCode;
                                req.rateClassCode=$scope.productData.rateClassCode;
                                getQuotes(req);

                            }else{
                                $scope.serverError="Sorry the promotion code you entered has expired"; 
                            }
                        }
                    }else{
                        var req={};
						req.AccountNumber=$scope.productData.AccountNumber; 
						req.LDC=$scope.productData.LDC;
						req.PromoCode=$scope.promocode;
                        req.rateClassCode=$scope.productData.rateClassCode;
						getQuotes(req);
                    }

                }else if(data && data.responseStatus =="1"){
                    $scope.serverError="Please enter a valid Promo code";                    
                }

            }).error(function (data,status, headers, config){  
               // $('#submit-promo-code').removeClass("inactive");
                $scope.formButton="CLEAR";
                console.log("error");
            });
        }
    }

    $scope.planSelectRenewal =function(product){

		console.log(product);
        $scope.selectedProduct=product;

        console.log($scope.selectedProduct.ProductDescription);

		console.log($scope.customerInfo);
		console.log($scope.productData);

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

         PrimeService.setProductData(req).success(function(data, status, headers, config){  

             location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 

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
			formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,8)+'-'+accountNumber.substring(8,10)+'-'+accountNumber.substring(10,11);
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

}]);

