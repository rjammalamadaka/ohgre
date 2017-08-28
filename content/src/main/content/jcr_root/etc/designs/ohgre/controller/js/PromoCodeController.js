ohgrePortal.controller('PromoCodeController', ['$scope', '$rootScope', '$http','$window',function ($scope, $rootScope,$http,$window) {


 var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }

    var portalname=$rootScope.portalname;

    var portalRootUrl=null;
    if(portalname =="oh"){
		portalRootUrl ="/content/onlyong/";
    }else if(portalname =="gre"){
		portalRootUrl ="/content/gre/";
    }

    $scope.promoCodeSubmit = function(){

		$scope.promoform.submited = true;
        if($scope.promoform.$valid){

        var promotionCode=$scope.promotioncode;
        var url=null;
        if(promotionCode){
            getPromoGroups(promotionCode);
			 url="/bin/getPromoCodeInfo?portalName="+portalname+"&promotionCode="+promotionCode;
             $http.get(url).success(function(data, status, headers, config){


                 console.log($scope.promoInfo);
				var redirectUrl=null;

                 if($scope.promoInfo && $scope.promoInfo.url){
					 redirectUrl=$scope.promoInfo.url;
                     if($rootScope.portalname =="gre"){
						redirectUrl=redirectUrl.replace("onlyong","gre");
                     }
                 }

                 if(data && data.responseStatus =="0"){

                     if(data.LDCList && data.LDCList.length >0){
                         $window.sessionStorage.setItem('promoLDC',angular.toJson(data.LDCList));
                        var ldclist= data.LDCList[0];
                         var promotion=ldclist.promotion[0];
                         ohgre.store("promoCodeInfo",data);
                         if(promotion.PromotionExpired =="Y"){
                             	location.href=$rootScope.homeUrl+"/backuppromo.html";

                         }else if(data.LDCList && redirectUrl){
								location.href=redirectUrl+".html"; //Configured page in content node

                            /* if(data.LDCList.length ==1){}*/


                     	}else if(data.LDCList && data.LDCList.length!=0 && !redirectUrl){


							if(data.LDCList.length ==1){
                                location.href=$rootScope.homeUrl+"/promo-general.html";

                            }else{
								location.href=$rootScope.homeUrl+"/generic-promo.html";

                            }
                           /* if(redirectUrl){
								location.href=redirectUrl+".html";
                            }else{location.href=$rootScope.homeUrl+"/generic-promo.html";}*/

                        }else{
							location.href=$rootScope.homeUrl+"/promo-general.html";
                        }

                     }

                 }else if(data && data.responseStatus =="1"){
                        ohgre.store("promoCodeInfo",null);
                    location.href=$rootScope.homeUrl+"/promotion-error.html";


                 }

             }).error(function (data,status, headers, config){
                  ohgre.store("promoCodeInfo",data);
                 console.log("error");
             });

             }

        }else{
			return;

        }

    }
    var getPromoGroups= function(promotionCode){

        var url='';

        if(portalname =="oh"){
			url='/content/onlyong/promotions/oh.infinity.json';
    	}else if(portalname =="gre"){
			url='/content/onlyong/promotions/gre.infinity.json';
    	}



        $http.get(url).success(function(data, status, headers, config){
            for (var property in data) {
    			if (data.hasOwnProperty(property) && property != "jcr:primaryType") {
                    var childNode=data[property];
                    for(var childproperty in childNode){
                        if(childNode.hasOwnProperty(childproperty) && childproperty != "jcr:primaryType"){
                            var url=childNode[childproperty];

                            if(childproperty == promotionCode){
							var promoinfo={};
							promoinfo.code=childproperty;
                            promoinfo.url=url;
                            $scope.promoInfo=promoinfo;
                                break;
                            }
                        }
                    }
    			}
			}

        }).error(function (data,status, headers, config){

                 console.log("error");
         });


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
				location.href=$rootScope.homeUrl+"/customerenroll.html#pcode="+product.ProductCode+"&ldc="+ldc;


             console.log("success");

         }).error(function (data,status, headers, config){

             console.log("error");
         });


    }

  /*  $scope.toupper =function(promocode){
        if(promocode)
		$scope.promotionCode = promocode.toUpperCase();

    }*/

   $scope.$watch('promotioncode', function (newValue, oldValue, scope) {
    		//console.log(newValue);
       if(newValue){
		$scope.promotioncode = newValue.toUpperCase();
       }

	}, true);


}]);

