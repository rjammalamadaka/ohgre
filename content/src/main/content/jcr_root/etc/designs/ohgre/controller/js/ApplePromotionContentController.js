ohgrePortal.controller('ApplePromotionContentController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    var portalname=$rootScope.portalname;

  var processPromotionInfo=function(promoInfo){



              if(promoInfo && promoInfo.LDCList.length>0){
                  var ldc=promoInfo.LDCList[0];
                  var ldcCode=ldc.LDCCode;
                  var promotion=ldc.promotion[0];

                  promotionCode=null;
                  if(promotion && promotion.PromotionCode){
                      if(promotion.PromotionExpired =="Y"){
                          promotionCode= promotion.BackupPromotionCode; 
                      }else{
                          promotionCode=promotion.PromotionCode; 

                      }
                  }

                  if( promotion &&  promotion.RateClassCode){
                      $scope.rateClassCode=promotion.RateClassCode;
                  }

                  PrimeService.getQuotes(ldcCode,promotionCode,$scope.rateClassCode).success(function(data, status, headers, config){

                      if(data && data.responseStatus =="0"){
                          var customer=data.Customer[0];
                          $scope.productList= customer.Product;
                          setTimeout(function(){ $rootScope.bindAccordian(); }, 10);
                      }

                  }).error(function (data,status, headers, config){


                  });

              }

    }

    $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
         
        if(newValue){

			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });


 if(!$rootScope.hashParams.promocode){

	//var promoInfo=ohgre.store("promoCodeInfo");
   //  processPromotionInfo(promoInfo);


 }



    $scope.getNumber =function(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }

    } 



}]);

