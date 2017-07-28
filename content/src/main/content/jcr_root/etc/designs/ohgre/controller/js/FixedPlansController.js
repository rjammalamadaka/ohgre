ohgrePortal.controller('FixedPlansController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

var portalname=$("#primary-header").data("portalname");

    $scope.viewplans = function(){

        var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){
		console.log(ldcCode);
            if(portalname =="oh"){
         	location.href="/content/onlyong/rate-plans.html#ldc="+ldcCode;
            }else{
                location.href="/content/gre/rate-plans.html#ldc="+ldcCode;
            }
        }
    }

}]);

