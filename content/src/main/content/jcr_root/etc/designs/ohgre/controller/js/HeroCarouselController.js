ohgrePortal.controller('HeroCarouselController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

    ohgre.store("promoCodeInfo",null);

    $scope.redirectPromoLanding =function(e){
        e.preventDefault();
        var promocode = $(e.target).data('promocode');
        var promoPath = $(e.target).data('promopath');
        if(promocode){
        	var  url="/bin/getPromoCodeInfo?portalName="+$rootScope.portalname+"&promotionCode="+promocode;
            $http.get(url).success(function(data, status, headers, config){

                if(data && data.responseStatus =="0"){                    
                    if(data.LDCList && data.LDCList.length >0){
                        var ldclist= data.LDCList[0];
                        var promotion=ldclist.promotion[0];
                        ohgre.store("promoCodeInfo",data);
                        if(promoPath){
							location.href=promoPath+".html";
                        }
                    }
                }

   			 }).error(function (data,status, headers, config){
                  ohgre.store("promoCodeInfo",null);
                 console.log("error");
             });

        }else if(promoPath){
			location.href=promoPath+".html";
        }

    }

  

}]);

