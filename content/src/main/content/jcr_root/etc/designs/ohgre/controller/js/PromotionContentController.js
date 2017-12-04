ohgrePortal.controller('PromotionContentController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {


      var portalname=$rootScope.portalname;
	 $scope.displayPlans =false;



    var processPromotionInfo=function(promoInfo){

    if(promoInfo.LDCList.length>0){
        $scope.ldcInfo=promoInfo;
        var ldc=promoInfo.LDCList[0];
        $scope.promotion=ldc.promotion[0];
        $scope.giftCardValue=$scope.promotion.GiftCardValue;
        $scope.DELTAMILES=$scope.promotion.DSMAwardMiles;
         var date = new Date($scope.promotion.PromotionExpiratonDate),
                     locale = "en-us",
                     month = date.toLocaleString(locale, { month: "long" });
         $scope.EXPIRATIONDATE=  month+" "+date.getDate()+" ,"+date.getFullYear();


    }

         if($rootScope.hashParams.ldc && $rootScope.hashParams.fromabout){
                $scope.displayPlans =true;

               if( $scope.promotion &&  $scope.promotion.RateClassCode){
				$scope.rateClassCode=$scope.promotion.RateClassCode;
            }

             var promotionCode=null;
                  if($scope.promotion && $scope.promotion.PromotionCode){
                      if($scope.promotion.PromotionExpired =="Y"){
                          promotionCode= $scope.promotion.BackupPromotionCode; 
                      }else{
                          promotionCode=$scope.promotion.PromotionCode; 

                      }
                  }

               var url="/bin/getQuotes?portalName="+portalname+"&ldcCode="+$rootScope.hashParams.ldc+"&promotionCode="+promotionCode+"&rateClassCode="+$scope.rateClassCode;
                 $http.get(url).success(function(data, status, headers, config){
                     $scope.Quotes=data;
                     if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                          $scope.displayPlans = true;
                         $scope.Customer=$scope.Quotes.Customer;
                         $scope.products=$scope.Customer[0].Product;
                         setTimeout(function(){ $rootScope.bindAccordian(); }, 10);

                     }else{


                     }

                 }).error(function (data,status, headers, config){

                     console.log("error");
                 });


         }

    }

    var getBackupPromoCodeInfo=function(promocode){


         PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config) {
				processPromotionInfo(data);

         }).error(function(data, status, headers, config) {

        });
    }
     $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
          if(newValue){

              var promoInfo=ohgre.store("promoCodeInfo");

              if($rootScope.hashParams.isExpired){
                     if(promoInfo.LDCList.length>0){
                            var ldc=promoInfo.LDCList[0];
                            var promotion=ldc.promotion[0];
                         if(promotion.BackupPromotionCode){
							getBackupPromoCodeInfo(promotion.BackupPromotionCode);
                         }else{
							processPromotionInfo(promoInfo);
                         }
                     }

              }else{
     				processPromotionInfo(promoInfo);
              }
        }
    });


     $scope.viewPlans =function(){

		var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){

            if($scope.ldcInfo && $scope.ldcInfo.LDCList && $scope.ldcInfo.LDCList.length>0){

                for(var i=0;i<$scope.ldcInfo.LDCList.length;i++){
                    if(ldcCode==$scope.ldcInfo.LDCList[i].LDCCode){

						$scope.rateClassCode=$scope.ldcInfo.LDCList[i].promotion[0].RateClassCode;
                        if($scope.ldcInfo.LDCList[i].promotion[0].RateClassCode.length==0){
                            var promoInfo=ohgre.store("promoCodeInfo");
                          var locationType=promoInfo.locationType;
                            if(locationType=="residential"){
								$scope.rateClassCode="01";
                            }else if(locationType=="commercial"){
								$scope.rateClassCode="04";	
                            }
                        }
                        break;
                    }
                }


                if($scope.rateClassCode.length ==0){
					$scope.rateClassCode="01";
                }

            }

 				var promotionCode=null;
                  if($scope.promotion && $scope.promotion.PromotionCode){
                      if($scope.promotion.PromotionExpired =="Y"){
                          promotionCode= $scope.promotion.BackupPromotionCode; 
                      }else{
                          promotionCode=$scope.promotion.PromotionCode; 

                      }
                  }

           /*  if( $scope.promotion &&  $scope.promotion.RateClassCode){
				$scope.rateClassCode=$scope.promotion.RateClassCode;
            }
*/
			PrimeService.getQuotes(ldcCode,promotionCode,$scope.rateClassCode).success(function(data, status, headers, config){
                 $scope.Quotes=data;
                 if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                     $scope.displayPlans = true;
                     $scope.Customer=$scope.Quotes.Customer;
                     $scope.products=$scope.Customer[0].Product;
                     setTimeout(function(){ $rootScope.bindAccordian(); }, 10);

                 }else{

                 }

             }).error(function (data,status, headers, config){
                 console.log("error");
             });
        }

    }

     PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
             $scope.ldcinfo=data.LDCList;
             setTimeout(function(){ $rootScope.bindClickEvent(); }, 10);
         }

         }).error(function (data,status, headers, config){

             console.log("error");
         });


}]);

