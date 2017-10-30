ohgrePortal.controller('DashBoardController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {



    function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

    var getCustomerInfo=function(req){


        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){

            console.log(data);

            $scope.customerInfo=JSON.parse(data.CustomerInfoResult);

            console.log($scope.customerInfo);

            
        }).error(function(data, status, headers, config){

        });

    }

     PrimeService.getProductData().success(function(data, status, headers, config){

         console.log();

         if(!isEmpty(data)){
             
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             
             getCustomerInfo(req);
         }else{
			location.href=$rootScope.homeUrl+".html";

         }
     }).error(function(data, status, headers, config){

     });

    $scope.logout=function(){
        PrimeService.logout().success(function(data, status, headers, config){

            location.href=$rootScope.homeUrl+".html";            
        }).error(function(data, status, headers, config){
            
        });
        
    }


}]);

