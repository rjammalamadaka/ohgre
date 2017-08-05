ohgrePortal.controller('PromoCodeController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {


 var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }

 var portalname=$("#primary-header").data("portalname");

    var portalRootUrl=null;
    if(portalname =="oh"){
		portalRootUrl ="/content/onlyong/";
    }else if(portalname =="gre"){
		portalRootUrl ="/content/gre/";
    }

    $scope.promoCodeSubmit = function(){


        var promotionCode=$scope.promotionCode;
        var url=null;
        if(promotionCode){
			 url="/bin/getPromoCodeInfo?portalname="+portalname+"&promotionCode="+promotionCode;
             $http.get(url).success(function(data, status, headers, config){

                 if(data.promotype =="APPLE"){
                    window.location=portalRootUrl+"promo-landing-apples.html";

                 }else if(data.promotype =="RAF"){

                      window.location=portalRootUrl+"raf-promotion.html";

                 }else if(data.promotype =="DELTA"){

                      window.location=portalRootUrl+"promo_landing.html";

                 }else if(data.promotype =="INVALID"){


                 }
             }).error(function (data,status, headers, config){

                 console.log("error");
             });

             }

    }

    $scope.signup=function(product){

        var url='/bin/setProductData';
        var req={};
        req.QuoteDescription=product.QuoteDescription;
		req.ProductDescription=product.ProductDescription;
        req.ProductCode=product.ProductCode;
        if($scope.Customer && $scope.Customer.length>0){
        req.LDC=$scope.Customer[0].LDC;
        }
       // var req=JSON.stringify(product);
         $http.post(url, req ,config).success(function(data, status, headers, config){



        		var ldc=$scope.Customer[0].LDC;
				location.href="/content/ohgre/customerenroll.html#pcode="+product.ProductCode+"&ldc="+ldc;


             console.log("success");

         }).error(function (data,status, headers, config){

             console.log("error");
         });


    }

}]);

