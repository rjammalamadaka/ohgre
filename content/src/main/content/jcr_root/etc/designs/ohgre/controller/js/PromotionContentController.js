ohgrePortal.controller('PromotionContentController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {


     var portalname=$("#primary-header").data("portalname");
	 $scope.displayPlans =false;

	//var promoInfo=ohgre.store("promoCodeInfo");

    var processPromotionInfo=function(promoInfo){

    if(promoInfo.LDCList.length>0){
        var ldc=promoInfo.LDCList[0];
        $scope.promotion=ldc.promotion[0];
        $scope.giftCardValue=$scope.promotion.GiftCardValue;

    }

         if($rootScope.hashParams.ldc && $rootScope.hashParams.fromabout){
                $scope.displayPlans =true;


               var url="/bin/getQuotes?portalName="+portalname+"&ldcCode="+$rootScope.hashParams.ldc+"&promotionCode="+$scope.promotion.PromotionCode;
                 $http.get(url).success(function(data, status, headers, config){
                     $scope.Quotes=data;
                     if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                          $scope.displayPlans = true;
                         $scope.Customer=$scope.Quotes.Customer;
                         $scope.products=$scope.Customer[0].Product;

                     }else{


                     }

                 }).error(function (data,status, headers, config){

                     console.log("error");
                 });


         }

    }

     $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
        // console.log(newValue);
        if(newValue){

			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });


     $scope.viewPlans =function(){

		var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){
            var url="/bin/getQuotes?portalName="+portalname+"&ldcCode="+ldcCode+"&promotionCode="+$scope.promotion.PromotionCode;
             $http.get(url).success(function(data, status, headers, config){
                 $scope.Quotes=data;
                 if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                      $scope.displayPlans = true;
                     $scope.Customer=$scope.Quotes.Customer;
                     $scope.products=$scope.Customer[0].Product;

                 }else{


                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });
        }

    }

     var url="/bin/getLDCInfoServlet?portalName="+portalname;
     $http.get(url).success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
               console.log(data.LDCList);
             $scope.ldcinfo=data.LDCList;


             setTimeout(function(){ $rootScope.bindClickEvent(); }, 10);


         }


         }).error(function (data,status, headers, config){

             console.log("error");
         });


}]);

