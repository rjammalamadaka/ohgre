ohgrePortal.factory("PortalService", ['$http','$scope' ,'$rootScope', function ($http,$scope, $rootScope) {


    var config = {
        responsetype : 'json',
        headers : {
            'Content-Type' :'application/json'
        }
    }
    
    
    var getQuotes=function(){        
        return $http.get("/bin/getQuotes",config);        
    }
    
    return {
        getQuotes : getQuotes
    }

}])
