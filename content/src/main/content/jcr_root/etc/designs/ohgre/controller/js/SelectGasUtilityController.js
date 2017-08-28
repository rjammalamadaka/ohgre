ohgrePortal.controller('SelectGasUtilityController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

 var portalname=$rootScope.portalname;

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