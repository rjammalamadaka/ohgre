ohgrePortal.factory('PrimeService', ['$http','$rootScope',function($http,$rootScope){

    var config = {
        responsetype : 'json',
        headers : {
            'Content-Type' :'application/json'
        }
    }
    var getQuotes =function(ldc,promotionCode){
		var url="/bin/getQuotes?portalName="+$rootScope.portalname+"&ldcCode="+ldc+"&promotionCode="+promotionCode;
        return $http.get(url,config);
    }

    var getPromoCodeInfo =function(promotionCode){
		var	url="/bin/getPromoCodeInfo?portalName="+$rootScope.portalname+"&promotionCode="+promotionCode;
		return $http.get(url,config);
    }
    var getLdcInfo=function(){
		var url="/bin/getLDCInfoServlet?portalName="+$rootScope.portalname;
		return $http.get(url,config);
    }
    var getProductData=function(){
		var url="/bin/getProductData?"+new Date().getTime();
		return $http.get(url,config);
    }
    var getCustomerInfo=function(requestInfo){
		var url="/bin/getCustomerInfo";
		return $http.post(url,angular.toJson(requestInfo),config);
    }
    return {
        getQuotes:getQuotes,
        getPromoCodeInfo:getPromoCodeInfo,
        getLdcInfo:getLdcInfo,
        getProductData:getProductData,
        getCustomerInfo:getCustomerInfo
    }               
}]);

ohgrePortal.factory('OhGreService', ['$http','$rootScope',function($http,$rootScope){

    var config = {
        responsetype : 'json',
        headers : {
            'Content-Type' :'application/json'
        }
    }
    var getPromoGroups =function(){
		 var url='';
        if($rootScope.portalname =="oh"){
			url='/content/onlyong/promotions/oh.infinity.json';
    	}else if($rootScope.portalname =="gre"){
			url='/content/onlyong/promotions/gre.infinity.json';
    	}
        return $http.get(url,config);
    }

    return {
        getPromoGroups:getPromoGroups
    }               
}]);


