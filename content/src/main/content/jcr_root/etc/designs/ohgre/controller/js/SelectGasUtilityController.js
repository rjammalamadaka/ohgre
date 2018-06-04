ohgrePortal.controller('SelectGasUtilityController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {

 var portalname=$rootScope.portalname;
    ohgre.removeStore("promoCodeInfo");
    ohgre.removeStore("promocode");
var standardpromocode=null;
 $("input[name=location_type_select][value='residential']").prop("checked",true);


    $scope.submit = function(){

        var ldcCode=$('#fixed-plans-button').val();
         var locationType=$("input[name='location_type_select']:checked"). val();    

            if(locationType=="residential" && $rootScope.resstdpromocode){
                standardpromocode=$rootScope.resstdpromocode;
            }else if(locationType=="commercial" &&  $rootScope.commstdpromocode){
                standardpromocode= $rootScope.commstdpromocode;
            }

        if(standardpromocode && standardpromocode.length>0){
            PrimeService.getPromoCodeInfo(standardpromocode).success(function(data, status, headers, config) {
                 data.standardpromocode=true;
                 ohgre.store("promoCodeInfo",data); 
                ohgre.store("promocode",standardpromocode);
                if(ldcCode){
                    var hashParam=encodeURIComponent("ldc="+ldcCode+'&lctype='+locationType);
                    if(portalname =="oh"){
                        location.href="/content/onlyong/rate-plans.html?"+hashParam;
                    }else{
                        location.href="/content/gre/rate-plans.html?"+hashParam;
                    }
                }

            }).error(function (data,status, headers, config){

            });
        }else{
              if(ldcCode){
                    var hashParam=encodeURIComponent("ldc="+ldcCode+'&lctype='+locationType);
                    if(portalname =="oh"){
                        location.href="/content/onlyong/rate-plans.html?"+hashParam;
                    }else{
                        location.href="/content/gre/rate-plans.html?"+hashParam;
                    }
                }
        }

    }

        PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
             $scope.ldcinfo=data.LDCList;

             setTimeout(function(){ $rootScope.bindClickEvent(); }, 10);


         }


         }).error(function (data,status, headers, config){

         });


}]);