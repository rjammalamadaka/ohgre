ohgrePortal.controller('CustomerEnrollController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

    $scope.customerEnrollSubmit = function(){

         var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }

         var url='/bin/enrollCustomer';

        var req={};
        req.accountNumber=$scope.accountNumber;
        req.accountNameLast=$scope.accountNameLast;
        req.accountNameFirst=$scope.accountNameFirst;
        req.accountPhone=$scope.accountPhone;
        req.howtohearus=$scope.howtohearus;
        req.raf=$scope.raf;
        req.serviceAddress1=$scope.serviceAddress1;
        req.serviceAddress2=$scope.serviceAddress2;
        req.serviceCity=$scope.serviceCity;
        req.serviceState=$scope.serviceState;
        req.serviceZip=$scope.serviceZip;
        req.billingAddress1=$scope.billingAddress1;
        req.billingAddress2=$scope.billingAddress2;
        req.billingCity=$scope.billingCity;
        req.billingState=$scope.billingState;
        req.billingZip=$scope.billingZip;

		if($rootScope.hashParams && $rootScope.hashParams.pcode)
        req.productCode=$rootScope.hashParams.pcode;

        if($rootScope.hashParams && $rootScope.hashParams.ldc)
        req.ldc=$rootScope.hashParams.ldc

         $http.post(url, req ,config).success(function(data, status, headers, config){

             if(data && data.responseMessage){
				$scope.message=data.responseMessage;
             }

         }).error(function (data,status, headers, config){
             
             console.log("error");
         });


    }

        var url="/bin/getProductData";

         $http.get(url).success(function(data, status, headers, config){

                console.log(data);
             
         }).error(function (data,status, headers, config){
             
             console.log("error");
         })


 $scope.productQuoteDescription= ohgre.store("productQuoteDescription");
    $scope.productProductDescription= ohgre.store("productProductDescription");
    console.log($rootScope.hashParams);
    
}]);

