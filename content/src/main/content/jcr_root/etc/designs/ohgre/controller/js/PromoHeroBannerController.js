 ohgrePortal.controller('PromoHeroBannerController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    jQuery('#popup-spinner-wrap').show();
   // $rootScope.prmoProduct=[];

 var portalname=$rootScope.portalname;


     var getPromoCodeInfo =function(promocode){
		/* PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){

         }).error(function (data,status, headers, config){

             console.log("error");
         });*/

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

                 if($rootScope.promotion.PromotionExpired =="Y"){

                     if($rootScope.promotion.BackupPromotionCode.length>0){
                                    location.href=$rootScope.homeUrl+"/backuppromo.html";
                     }else{
 									location.href=$rootScope.homeUrl+"/promotion-error.html";
                     }
                 }

                 for(var i=0;i<promoInfo.LDCList.length;i++){
					 var ldc=promoInfo.LDCList[i];
                     var ldcCode=ldc.LDCCode;
                      var promotion=ldc.promotion[0];
                     if(promotion.PromotionExpired =="N"){
                         console.log("required ldc");
                         //console.log(ldc);
                         //$rootScope.enrollLdc=ldc;
                         $rootScope.ldcForEnrollPromo=ldc;
                         $rootScope.enrollPromoCode=promotion.PromotionCode;
                              break;                              
                      }

                 }

             }

             }else if(data && data.responseStatus =="1"){

                 //ohgre.store("promoCodeInfo",{});
                            location.href=$rootScope.homeUrl+"/promotion-error.html";
                     }

  /*if(data.LDCList && data.LDCList.length >0){
							//$window.sessionStorage.setItem('promoLDC',angular.toJson(data.LDCList));
                            var ldclist= data.LDCList[0];
                             var promotion=ldclist.promotion[0];
                             ohgre.store("promoCodeInfo",data);
                             if(promotion.PromotionExpired =="Y"){
                                    location.href=$rootScope.homeUrl+"/backuppromo.html";
                             }else if(data.LDCList && redirectUrl){
                                    location.href=redirectUrl+".html";
                            }else if(data.LDCList && data.LDCList.length!=0 && !redirectUrl){
                                if(data.LDCList.length ==1){
                                    location.href=$rootScope.homeUrl+"/promo-general.html";
                                }else{
                                    location.href=$rootScope.homeUrl+"/generic-promo.html";
                                }
                            }else{
                                location.href=$rootScope.homeUrl+"/promo-general.html";
                            }
                         }*/



         }).error(function (data,status, headers, config){

             console.log("error");
         });

     }else{
			processStorePromoInfo();

     }
    $scope.heightConstant = false;
    $scope.displayPromocode = true;

    if(location.pathname.indexOf("404")>0 || location.pathname.indexOf("maintenance")>0 || location.pathname.indexOf("500")>0)
    {
		$scope.heightConstant = true;
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
                   //console.log(product.productCode);
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

}]);

