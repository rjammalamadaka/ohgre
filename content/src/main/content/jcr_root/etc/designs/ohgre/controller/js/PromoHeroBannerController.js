ohgrePortal.controller('PromoHeroBannerController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

 var portalname=$("#primary-header").data("portalname");



     if($rootScope.hashParams.promocode){


 			var url="/bin/getPromoCodeInfo?portalName="+portalname+"&promotionCode="+$rootScope.hashParams.promocode;
             $http.get(url).success(function(data, status, headers, config){
 				var promoInfo=ohgre.store("promoCodeInfo",data);
				$rootScope.promotionInfo=true;
                 console.log(promoInfo);

                  if(promoInfo && promoInfo.LDCList.length>0){
                var ldc=promoInfo.LDCList[0];
                //console.log(ldc.promotion[0]);
                $scope.promotion=ldc.promotion[0];
                 //var expdate=$scope.promotion.PromotionExpiratonDate;
        
                var date = new Date($scope.promotion.PromotionExpiratonDate),
               locale = "en-us",
               month = date.toLocaleString(locale, { month: "long" });
                $scope.expdate=month+" "+date.getDate()+" ,"+date.getFullYear();
        
            }


              }).error(function (data,status, headers, config){

                 console.log("error");
             });

     }else{

         var promoInfo=ohgre.store("promoCodeInfo");
         $rootScope.promotionInfo=true;
            console.log(promoInfo);
            if(promoInfo && promoInfo.LDCList.length>0){
                var ldc=promoInfo.LDCList[0];
                //console.log(ldc.promotion[0]);
                $scope.promotion=ldc.promotion[0];
                 //var expdate=$scope.promotion.PromotionExpiratonDate;
        
                var date = new Date($scope.promotion.PromotionExpiratonDate),
               locale = "en-us",
               month = date.toLocaleString(locale, { month: "long" });
                $scope.expdate=month+" "+date.getDate()+" ,"+date.getFullYear();
        
            }

     }

    $scope.displayPromotionLogo =function(){

        if(location.pathname.indexOf("switch")>0){
			return true;
        }else{
			return false;
        }

   }
    $scope.getBannerclass =function(){
        if(location.pathname.indexOf("switch")>0){
            return "one-third";
        }else{
            return "flush";
        }
    }
    

}]);

