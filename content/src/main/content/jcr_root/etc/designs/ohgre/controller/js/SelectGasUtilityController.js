ohgrePortal.controller('SelectGasUtilityController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {

 var portalname=$rootScope.portalname;

 $("input[name=location_type_select][value='residential']").prop("checked",true);


    $scope.submit = function(){

        var ldcCode=$('#fixed-plans-button').val();
         var locationType=$("input[name='location_type_select']:checked"). val();    

        if(ldcCode){
		   var hashParam=encodeURIComponent("ldc="+ldcCode+'&lctype='+locationType);
            if(portalname =="oh"){
         	location.href="/content/onlyong/rate-plans.html?"+hashParam;
            }else{
                location.href="/content/gre/rate-plans.html?"+hashParam;
            }
        }
    }

        PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
               console.log(data.LDCList);
             $scope.ldcinfo=data.LDCList;


             setTimeout(function(){ $rootScope.bindClickEvent(); }, 10);


         }


         }).error(function (data,status, headers, config){

             console.log("error");
         });


}]);