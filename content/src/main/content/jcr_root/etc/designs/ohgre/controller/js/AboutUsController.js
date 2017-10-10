ohgrePortal.controller('AboutUsController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

    var promocode=$("#promocode").data("promocode");
    PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
               console.log(data.LDCList);
               $scope.ldcinfo=data.LDCList;
               setTimeout(function(){ $rootScope.bindClickEvent();}, 10);
         }
       }).error(function (data,status, headers, config){ });

     $scope.viewplans = function(){
        var ldcCode=$('#fixed-plans-button').val();
         if(ldcCode){
            getPromoGroups(promocode);

			PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){
				var redirectUrl="";
                 if($scope.promoInfo && $scope.promoInfo.url){
					redirectUrl=$scope.promoInfo.url;
                 }else{
					redirectUrl="";
                 }

                 if(data && data.responseStatus =="0"){

                     if(data.LDCList && data.LDCList.length >0 && redirectUrl){
                          ohgre.store("promoCodeInfo",data);
							location.href=redirectUrl+".html#fromabout=true&ldc="+ldcCode;
                       }

                 }else if(data && data.responseStatus =="1"){
						$scope.serverError=data.responsemessage;

                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });

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

}]);

