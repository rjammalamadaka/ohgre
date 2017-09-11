ohgrePortal.controller('OfferPromoController', ['$scope', '$rootScope', '$http','$window', 'PrimeService',function ($scope, $rootScope,$http,$window,PrimeService) {

	$scope.displayPlans =false;
     var processPromotionInfo=function(promoInfo){
         if(promoInfo.LDCList.length>0){
              $scope.ldcinfo=promoInfo.LDCList;
             setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
             var ldc=promoInfo.LDCList[0];
             $scope.promotion=ldc.promotion[0];
             $scope.giftCardValue=$scope.promotion.GiftCardValue; 
             $scope.GIFTCARDVALUE=Number($scope.giftCardValue);


         }
     }


    $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
        if(newValue){
			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });


    $scope.viewPlans =function(){
		var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){

            PrimeService.getQuotes(ldcCode,$scope.promotion.PromotionCode).success(function(data, status, headers, config){
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

    var promoLDC = angular.fromJson($window.sessionStorage.getItem('promoLDC'));

    if(promoLDC !== undefined && promoLDC !== ""){
		$scope.ldcinfo=promoLDC;
        setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
    }
    else{

        PrimeService.getLdcInfo().success(function(data, status, headers, config){
                 if(data && data.responseStatus =="0"){
                     $scope.ldcinfo=data.LDCList;
                     setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });
    }


}]);

