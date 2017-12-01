ohgrePortal.factory('PrimeService', ['$http','$rootScope',function($http,$rootScope){

    var config = {
        responsetype : 'json',
        headers : {
            'Content-Type' :'application/json'
        }
    }
    var getQuotes =function(ldc,promotionCode,rateClassCode){
		var url="/bin/getQuotes?portalName="+$rootScope.portalname+"&ldcCode="+ldc+"&promotionCode="+promotionCode+"&rateClassCode="+rateClassCode;
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
    var checkRafEligibility=function(rafcode,account,ldc){

        var url="/bin/checkRafEligibility";
        if(rafcode){
			url=url+"?rafCode="+rafcode;
        }
        if(account){
			url=url+"&account="+account;
        }
        if(ldc){
			url=url+"&ldc="+ldc;
        }
        return $http.get(url,config);
    }
    var enrollCustomer =function(requestInfo){
		var url="/bin/enrollCustomer";
		return $http.post(url,angular.toJson(requestInfo),config);
    }

    var moving =function(requestInfo){
		var url="/bin/moving";
		return $http.post(url,angular.toJson(requestInfo),config);
    }
    var setProductData =function(requestInfo){
		var url="/bin/setProductData";
		return $http.post(url,angular.toJson(requestInfo),config);
    }

    var sendRafEmail =function(requestInfo){
		var url="/bin/sendRafEmail";
		return $http.post(url,angular.toJson(requestInfo),config);
    }

    var dsmEnroll =function(requestInfo){
		var url="/bin/DSMEnrollment";
		return $http.post(url,angular.toJson(requestInfo),config);
    }
    var rafUpdateCustomerInfo =function(requestInfo){
		var url="/bin/rafUpdateCustomerInfo";
		return $http.post(url,angular.toJson(requestInfo),config);
    }

    var wcRequest =function(requestInfo){
		var url="/bin/whatCount";
		return $http.post(url,angular.toJson(requestInfo),config);
    }

    var logout=function(){
		var url="/bin/logout?"+new Date().getTime();
		return $http.get(url,config);
    }
   var getPromoCodeGroupInfo =function(promotionCode){
		var	url="/bin/getPromoGroupInfo?portalName="+$rootScope.portalname+"&promoCode="+promotionCode;
		return $http.get(url,config);
    }
    return {
        getQuotes:getQuotes,
        getPromoCodeInfo:getPromoCodeInfo,
        getLdcInfo:getLdcInfo,
        getProductData:getProductData,
        getCustomerInfo:getCustomerInfo,
        checkRafEligibility:checkRafEligibility,
        enrollCustomer:enrollCustomer,
        moving:moving,
        sendRafEmail:sendRafEmail,
        dsmEnroll:dsmEnroll,
        setProductData:setProductData,
        rafUpdateCustomerInfo:rafUpdateCustomerInfo,
        wcRequest:wcRequest,
        logout:logout,
        getPromoCodeGroupInfo:getPromoCodeGroupInfo
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


