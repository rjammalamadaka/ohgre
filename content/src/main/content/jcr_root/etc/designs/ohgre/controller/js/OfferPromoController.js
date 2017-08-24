ohgrePortal.controller('OfferPromoController', ['$scope', '$rootScope', '$http','$window',function ($scope, $rootScope,$http,$window) {

	$scope.displayPlans =false;
     var processPromotionInfo=function(promoInfo){
         if(promoInfo.LDCList.length>0){
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
            var url="/bin/getQuotes?portalName="+$rootScope.portalname+"&ldcCode="+ldcCode+"&promotionCode="+$scope.promotion.PromotionCode;
             $http.get(url).success(function(data, status, headers, config){
                 $scope.Quotes=data;
                 if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                      $scope.displayPlans = true;
                     $scope.Customer=$scope.Quotes.Customer;
                     $scope.products=$scope.Customer[0].Product;

                 }else{         }

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

        var url="/bin/getLDCInfoServlet?portalName="+$rootScope.portalname;
         $http.get(url).success(function(data, status, headers, config){
                 if(data && data.responseStatus =="0"){
                     $scope.ldcinfo=data.LDCList;
                     setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
                 }
    
             }).error(function (data,status, headers, config){
    
                 console.log("error");
             });
    }


}]);

