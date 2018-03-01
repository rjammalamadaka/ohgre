ohgrePortal.controller('CancelContractController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

// $scope.formButton="Apply Promo Code";

    $scope.guaranteeProductDisplay=false;

    $scope.showVariablePlan=false;

      function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }


    var flag=false;

    var getDefaultPromoCodeByRateClassCode =function(rateClassCode){

         var ResPromoCode=$("#cancel-plan-wrapper").data("respromocode");
        var ComPromoCode=$("#cancel-plan-wrapper").data("compromocode");
        if(rateClassCode =="01"){
			return ResPromoCode;
        }else if(rateClassCode =="04"){
			return ComPromoCode;
        }
    }

    var getQuotes=function(req){
		var PromoCode=null;
       /* var ResPromoCode=$("#cancel-plan-wrapper").data("respromocode");
        var ComPromoCode=$("#cancel-plan-wrapper").data("compromocode");
        if(req.rateClassCode =="01"){
			PromoCode=ResPromoCode;
        }else if(req.rateClassCode =="04"){
			PromoCode=ComPromoCode;
        }
        */
       /* if(req.PromoCode){            
            PromoCode=req.PromoCode;
        }*/

        PromoCode =getDefaultPromoCodeByRateClassCode(req.rateClassCode);

        PrimeService.getQuotes(req.LDC,PromoCode,req.rateClassCode).success(function(data, status, headers, config){


            if(data && data.responseStatus=="0"){
                $scope.products={};
                if(data.Customer && data.Customer.length>0){
                    if(!flag){
						flag=true;
                        $scope.defaultProducts=data.Customer[0].Product;

                    }

                    var productInfo=data.Customer[0].Product;

                    var productsList=[];

                    for(var i=0;i<productInfo.length;i++){

                        if($rootScope.prmoProduct.indexOf(productInfo[i].ProductCode) !=-1){
								productsList.push(productInfo[i]);
                        }
                    }

                  $scope.products=productsList;
                  updateProductFinePrint();
                }
            }

        }).error(function (data,status, headers, config){


        });


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


    var getPromoCodeInfoForEnroll=function(ldc){
        PrimeService.getPromocodesForEnrollment(ldc).success(function(data, status, headers, config){
            var promotionProduct=null;
            var products=[];

            var defaultPromoCode=getDefaultPromoCodeByRateClassCode($scope.productData.rateClassCode);

            var enrollmentResult=JSON.parse(data.GetPromoCodesForEnrollmentResult);
            if(enrollmentResult && enrollmentResult.responseStatus =="0"){
			      for(var i =0;i<enrollmentResult.promotion.length;i++){
					var promotion=enrollmentResult.promotion[i];
                    if(promotion && promotion.promotionCode && promotion.promotionCode==defaultPromoCode.toUpperCase()){
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

    var ProcessPromotionInformation =function(ldcinfo){
        getQuotes($scope.productData);

    }
    var getPromocodeInfo=function(){
         var defaultPromoCode=getDefaultPromoCodeByRateClassCode($scope.productData.rateClassCode);

         PrimeService.getPromoCodeInfo(defaultPromoCode).success(function(data, status, headers, config){

              ohgre.store("promoCodeInfo",data);
               if(data.LDCList.length>0){
						var ldcinfo=null;

                        for(var i=0;i<data.LDCList.length;i++){
							var temp=data.LDCList[i];
                            if(temp.LDCCode ==  $scope.productData.LDC){
                                ldcinfo=temp;
								break;
                            }
                        }
						ProcessPromotionInformation(ldcinfo);

                    }


          }).error(function(data, status, headers, config){

          });


    }

     $rootScope.$watch('prmoProduct', function (newValue, oldValue, scope) {

        if(newValue && newValue.length>0){
           // getQuotesForViewPlans();
            getPromocodeInfo();

            //var promoInfo=ohgre.store("promoCodeInfo");
            //processPromotionInfo(promoInfo,newValue);
            //getQuotes($scope.productData);
        }
    });


     PrimeService.getProductData().success(function(data, status, headers, config){


         if(!isEmpty(data)){
            /* if(data.LDC == "COH"){
 				$scope.guaranteeProductDisplay=true;
             }*/
             $scope.productData=data;
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             getCustomerInfo(req);
             //getQuotes(data);
            // getDefaultPromoctionInfo();
             getPromoCodeInfoForEnroll(data.LDC);

         }else{
			location.href=$rootScope.homeUrl+".html";

         }
     }).error(function(data, status, headers, config){

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


        $scope.planSelectRenewal =function(product){

            $scope.showVariablePlan=false;
           if(product.PriceChangeFrequency=="D"){
			$scope.showVariablePlan=true;
      		}
              $scope.selectedProduct=product;

        if($scope.customerInfo.existingCustomerInd=="Y" && $scope.customerInfo.renewalContractExistsInd=="Y"){
             $('#popupwithrenewal').addClass('show-popup');
        }else{
            var earlyTermChargeAmt= Number($scope.customerInfo.earlyTermChargeAmt);
            if(earlyTermChargeAmt>0){
                $rootScope.showearlyterminationfee=true;
                $('#popupetc').addClass('show-popup');                
            }else{
                 $scope.continueenroll();
				//location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 
            }
        }

    }

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


    $scope.continueenroll =function(){
         var req={};

        req.QuoteDescription=$scope.selectedProduct.QuoteDescription;
		req.ProductDescription=$scope.selectedProduct.ProductDescription;
        req.ProductDescriptionFriendly=$scope.selectedProduct.ProductDescFriendly;                                      
        req.ProductCode=$scope.selectedProduct.ProductCode;
        req.LdcDesc= $scope.productData.ldcDesc;
        req.LDC= $scope.productData.LDC;
		req.FixedPricePerTherm=$scope.selectedProduct.FixedPricePerTherm;
        req.AccountNumber=$scope.productData.AccountNumber;
        req.RateClassCode=$scope.productData.rateClassCode;
        req.dukNumber= $scope.productData.dukNumber;
        req.PriceChangeFrequency=$scope.selectedProduct.PriceChangeFrequency;
        req.isDefaultPromoCode=true;


         PrimeService.setProductData(req).success(function(data, status, headers, config){  

             if($rootScope.IsIE()){

				setTimeout(function(){ window.location.href=$rootScope.homeUrl+"/customer_lookup.html?fromRenewal=true"; });
             }else{
				setTimeout(function(){ window.location.href=$rootScope.homeUrl+"/customer_lookup.html?fromRenewal=true"; });
                                }

               //setTimeout(function(){ location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; });

            // location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 
             return false;

         }).error(function (data,status, headers, config){ 

         });


    }

    $scope.redirecttodashboard =function(){
        location.href=$rootScope.homeUrl+"/myaccount.html";

    }

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

			var promocode;
           var ResPromoCode=$("#cancel-plan-wrapper").data("respromocode");
           var ComPromoCode=$("#cancel-plan-wrapper").data("compromocode");

           if($scope.productData && $scope.productData.rateClassCode =="01"){
              promocode=ResPromoCode;
           }else if($scope.productData && $scope.productData.rateClassCode =="04"){
               promocode=ComPromoCode;
           }


           PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){
               ohgre.store("promoCodeInfo",data);

           }).error(function(data, status, headers, config){

           });
       }


}]);

