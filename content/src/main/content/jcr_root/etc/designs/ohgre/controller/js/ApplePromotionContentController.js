ohgrePortal.controller('ApplePromotionContentController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

    //   
    var portalname=$rootScope.portalname;

  var processPromotionInfo=function(promoInfo){


      console.log("calling processPromotionInfo");

              if(promoInfo && promoInfo.LDCList.length>0){
                  var ldc=promoInfo.LDCList[0];
                  var ldcCode=ldc.LDCCode;
                  var promotion=ldc.promotion[0];
                  var url="/bin/getQuotes?portalName="+portalname;
                  if(ldcCode){
                      url=url+"&ldcCode="+ldcCode;
                  }
                  if(promotion && promotion.PromotionCode){
                      if(promotion.PromotionExpired =="Y"){
                          url=url+"&promotionCode="+promotion.BackupPromotionCode;
                      }else{
                          url=url+"&promotionCode="+promotion.PromotionCode;
                          
                      }
                  }
                  
                  $http.get(url).success(function(data, status, headers, config){
                      console.log(data);
                      if(data && data.responseStatus =="0"){
                          var customer=data.Customer[0];
                          $scope.productList= customer.Product;
                          //  console.log(product);
                          setTimeout(function(){ $rootScope.bindAccordian(); }, 10);

                      }
                      
                  }).error(function (data,status, headers, config){

                      console.log("error");
                  });

              }

    }

    $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
         console.log(newValue);
        if(newValue){

			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });


 if(!$rootScope.hashParams.promocode){

	//var promoInfo=ohgre.store("promoCodeInfo");
   //  processPromotionInfo(promoInfo);


 }



    $scope.getNumber =function(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }

    } 

    

}]);

