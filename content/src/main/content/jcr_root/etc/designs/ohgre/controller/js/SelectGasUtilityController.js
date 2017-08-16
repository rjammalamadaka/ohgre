ohgrePortal.controller('SelectGasUtilityController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

var portalname=$("#primary-header").data("portalname");
 $("input[name=location_type][value='residential']").prop("checked",true);


    $scope.submit = function(){

        var ldcCode=$('#fixed-plans-button').val();
         var locationType=$("input[name='location_type']:checked"). val();    

        if(ldcCode){
		   var hashParam=encodeURIComponent("ldc="+ldcCode+'&lctype='+locationType);
            if(portalname =="oh"){
         	location.href="/content/onlyong/rate-plans.html#"+hashParam;
            }else{
                location.href="/content/gre/rate-plans.html#"+hashParam;
            }
        }
    }


}]);