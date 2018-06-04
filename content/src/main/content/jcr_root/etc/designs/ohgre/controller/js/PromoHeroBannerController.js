 ohgrePortal.controller('PromoHeroBannerController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    jQuery('#popup-spinner-wrap').show();
   // $rootScope.prmoProduct=[];

    var portalname=$rootScope.portalname;
    $scope.hasEmptyHeader = ($('#primary-header > .container').length === 0) ? 1 : 0;

     var getPromoCodeInfo =function(promocode){
		/* PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){

         }).error(function (data,status, headers, config){

         });*/

     }
     var getBackupPromocodeInfo=function(promocode){
         PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){
				ohgre.store("promoCodeInfo",data);
                location.href=$rootScope.homeUrl+"/backuppromo.html";
         }).error(function(data, status, headers, config){

         });
     }
     var processStorePromoInfo=function(){

  			var promoInfo=ohgre.store("promoCodeInfo");
            if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0){
                var ldc=promoInfo.LDCList[0];
                $rootScope.promotion=ldc.promotion[0];
                $rootScope.promotionInfo=true;
                var date = new Date($scope.promotion.PromotionExpiratonDate),
                locale = "en-us",
                month = date.toLocaleString(locale, { month: "long" });
                $rootScope.expdate=month+" "+date.getDate()+", "+date.getFullYear();
                $scope.DELTAMILES=$scope.promotion.DSMAwardMiles;
               $scope.GIFTCARDVALUE=$scope.promotion.GiftCardValue;


               for(var i=0;i<promoInfo.LDCList.length;i++){
                    var ldc=promoInfo.LDCList[i];
                    var ldcCode=ldc.LDCCode;
                    var promotion=ldc.promotion[0];
                    if(promotion.PromotionExpired =="N"){
                        $rootScope.promotion=ldc.promotion[0];
                        $rootScope.ldcForEnrollPromo=ldc;
                        $rootScope.enrollPromoCode=promotion.PromotionCode;
                        $scope.DELTAMILES=$scope.promotion.DSMAwardMiles;

                        break;
                    }else if(promotion.PromotionExpired =="Y" && promotion.BackupPromotionCode.length>0){
                        $rootScope.promotion=ldc.promotion[0];
 						$rootScope.ldcForEnrollPromo=ldc;
                        $rootScope.enrollPromoCode=promotion.BackupPromotionCode;
                       // getPromoCodeInfo(promotion.BackupPromotionCode);
                        break;
                    }

                }

            }

          jQuery('#popup-spinner-wrap').hide();
     }

     if($rootScope.hashParams.promocode){
         PrimeService.getPromoCodeInfo($rootScope.hashParams.promocode).success(function(data, status, headers, config){
              jQuery('#popup-spinner-wrap').hide();
             var promoInfo=ohgre.store("promoCodeInfo",data);
             $rootScope.promotionInfo=true;
             if(data && data.responseStatus =="0"){

             if(promoInfo && promoInfo.LDCList.length>0){
                 var ldc=promoInfo.LDCList[0];
                 $rootScope.promotion=ldc.promotion[0];
                 var date = new Date($scope.promotion.PromotionExpiratonDate),
                     locale = "en-us",
                     month = date.toLocaleString(locale, { month: "long" });
                 $rootScope.expdate=month+" "+date.getDate()+", "+date.getFullYear();
               $scope.DELTAMILES=$scope.promotion.DSMAwardMiles;
               $scope.GIFTCARDVALUE=$scope.promotion.GiftCardValue;
                 if($rootScope.promotion.PromotionExpired =="Y"){

                     if($rootScope.promotion.BackupPromotionCode.length>0){
                         getBackupPromocodeInfo($rootScope.promotion.BackupPromotionCode);
                         /*promoInfo.LDCList[0].promotion[0].PromotionCode=$rootScope.promotion.BackupPromotionCode;
                         ohgre.store("promoCodeInfo",promoInfo);
                         location.href=$rootScope.homeUrl+"/backuppromo.html";
                         */
                     }else{
 						location.href=$rootScope.homeUrl+"/promotion-error.html";
                     }
                 }

                 for(var i=0;i<promoInfo.LDCList.length;i++){
					 var ldc=promoInfo.LDCList[i];
                     var ldcCode=ldc.LDCCode;
                      var promotion=ldc.promotion[0];
                     if(promotion.PromotionExpired =="N"){

                         //$rootScope.enrollLdc=ldc;
                         $rootScope.ldcForEnrollPromo=ldc;
                         $rootScope.enrollPromoCode=promotion.PromotionCode;
                              break;
                      }

                 }

             }

             }else if(data && data.responseStatus =="1"){

                            location.href=$rootScope.homeUrl+"/promotion-error.html";
                     }

          }).error(function (data,status, headers, config){


         });

     }else{
			processStorePromoInfo();

     }
    $scope.heightConstant = false;
    $scope.displayPromocode = true;

    if(location.pathname.indexOf("404")>0 || location.pathname.indexOf("backuppromo")>0 || location.pathname.indexOf("maintenance")>0 || location.pathname.indexOf("500")>0)
    {
		//$scope.heightConstant = true;
        $scope.displayPromocode = false;
    }


    $scope.displayPromotionLogo =function(){

        if(location.pathname.indexOf("switch")>0 || location.pathname.indexOf("special_offer")>0){
			return true;
        }else{
			return false;
        }

   }
    $scope.getBannerclass =function(){
        if(location.pathname.indexOf("switch")>0 || location.pathname.indexOf("special_offer")>0){
            return "one-third";
        }else{
            return "flush";
        }
    }
  var getPromoGroups= function(promotionCode){
        OhGreService.getPromoGroups().success(function(data, status, headers, config){
            for (var property in data) {
    			if (data.hasOwnProperty(property) && property != "jcr:primaryType") {
                    var childNode=data[property];
                    for(var childproperty in childNode){
                        if(childNode.hasOwnProperty(childproperty) && childproperty != "jcr:primaryType"){
                            var url=childNode[childproperty];

                            if(childproperty == promotionCode){
							var promoinfo={};
							promoinfo.code=childproperty;
                            promoinfo.url=url;
                            $scope.promoInfo=promoinfo;
                                break;
                            }
                        }
                    }
    			}
			}
        }).error(function (data,status, headers, config){ });
    }

  	$rootScope.notexpired=true;
  if($rootScope.hashParams.isExpired){
	$rootScope.notexpired=false;
  }
    $rootScope.getPromoCodeInfoForEnroll=function(ldc){
        PrimeService.getPromocodesForEnrollment(ldc).success(function(data, status, headers, config){

            var promotionProduct=null;
            var products=[];

            var enrollmentResult=JSON.parse(data.GetPromoCodesForEnrollmentResult);
            if(enrollmentResult && enrollmentResult.responseStatus =="0"){
			      for(var i =0;i<enrollmentResult.promotion.length;i++){
					var promotion=enrollmentResult.promotion[i];
                    if(promotion && promotion.promotionCode && promotion.promotionCode==$rootScope.enrollPromoCode){
            			promotionProduct=promotion.product;
                        break;
                    }
                }
                for(var j=0;j<promotionProduct.length;j++){
                   var product= promotionProduct[j];
					products.push(product.productCode);
                }
                 $rootScope.prmoProduct=products;

            }



        }).error(function (data,status, headers, config){


        });


    }

    //enrollLdc
    $rootScope.$watch('enrollLdc', function (newValue, oldValue, scope) {
       if(newValue){
		    //$scope.promotioncode = newValue.toUpperCase();
           $rootScope.getPromoCodeInfoForEnroll($rootScope.enrollLdc.LDCCode);

       }
	}, true);


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

}]);
