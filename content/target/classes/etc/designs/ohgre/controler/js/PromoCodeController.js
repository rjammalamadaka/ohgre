ohgrePortal.controller('PromoCodeController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {


 var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }

    $scope.promoCodeSubmit = function(){





         var promotionCode=$scope.promotionCode;
        var url=null;
        if(promotionCode){
			 url='/bin/getQuotes?promotionCode='+promotionCode;
        }else{
			 url='/bin/getQuotes';
        }

         $http.get(url).success(function(data, status, headers, config){

             $scope.Quotes=data;
             if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
					$scope.Customer=$scope.Quotes.Customer;
                   $scope.products=$scope.Customer[0].Product;
             }


             console.log(data);

         }).error(function (data,status, headers, config){

             console.log("error");
         })

    }

    $scope.signup=function(product){

        var url='/bin/setProductData';
        var req={};
        req.QuoteDescription=product.QuoteDescription;
req.ProductDescription=product.ProductDescription;
       // var req=JSON.stringify(product);
         $http.post(url, req ,config).success(function(data, status, headers, config){

             	ohgre.store("productQuoteDescription",product.QuoteDescription);
        		ohgre.store("productProductDescription",product.ProductDescription);
        		var ldc=$scope.Customer[0].LDC;
				location.href="/content/ohgre/customerenroll.html#pcode="+product.productCode+"&ldc="+ldc;


             console.log("success");

         }).error(function (data,status, headers, config){

             console.log("error");
         });


    }

}]);

