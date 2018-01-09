ohgrePortal.controller('OfferPromoController', ['$scope', '$rootScope', '$http','$window', 'PrimeService',function ($scope, $rootScope,$http,$window,PrimeService) {

	$scope.displayPlans =false;
     var processPromotionInfo=function(promoInfo){
         if(promoInfo.LDCList.length>0){
              $scope.ldcinfo=promoInfo.LDCList;
             setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
             var ldc=promoInfo.LDCList[0];
             $scope.promotion=ldc.promotion[0];
             $scope.giftCardValue=$scope.promotion.GiftCardValue; 
             $scope.GIFTCARDVALUE=Number($scope.giftCardValue);
             var date = new Date($scope.promotion.PromotionExpiratonDate),
                     locale = "en-us",
                     month = date.toLocaleString(locale, { month: "long" });
         $scope.EXPIRATIONDATE=  month+" "+date.getDate()+", "+date.getFullYear();


         }
     }


    $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
        if(newValue){
			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });

    var getQuotesForViewPlans =function(){

        var ldcCode=$('#fixed-plans-button').val();

          if( $scope.promotion &&  $scope.promotion.RateClassCode){
                $scope.rateClassCode=$scope.promotion.RateClassCode;
            }

            if(!$scope.rateClassCode){
                $scope.rateClassCode = "01";
            }

            PrimeService.getQuotes(ldcCode,$scope.promotion.PromotionCode,$scope.rateClassCode).success(function(data, status, headers, config){
                $scope.Quotes=data;
                if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                    $scope.displayPlans = true;
                    $scope.Customer=$scope.Quotes.Customer;
                    var customer=$scope.Customer[0];

                    console.log( $rootScope.prmoProduct);
                    var getQuotesProductsList=[];

                    for(var i=0;i<customer.Product.length;i++){
                        if($rootScope.prmoProduct.indexOf(customer.Product[i].ProductCode) !=-1){
                            getQuotesProductsList.push(customer.Product[i]);

                        }

                    };
                    $scope.products=getQuotesProductsList;//$scope.Customer[0].Product;

                    updateProductFinePrint();
                    setTimeout(function(){ $rootScope.bindAccordian(); }, 10);


                }else{
                }

            }).error(function (data,status, headers, config){    
                console.log("error");
            });

    }

    $scope.viewPlans =function(){
        var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){
             $rootScope.getPromoCodeInfoForEnroll(ldcCode);

        }

    }


      $rootScope.$watch('prmoProduct', function (newValue, oldValue, scope) {

        if(newValue && newValue.length>0){
            getQuotesForViewPlans();
			//var promoInfo=ohgre.store("promoCodeInfo");
     		//processPromotionInfo(promoInfo,newValue);
        }
    });

    var updateProductFinePrint = function() {

         angular.forEach($scope.products, function(value, key) {
 				var ProductFinePrintText = value.ProductFinePrintText.split(".");
     			 var lastword = ProductFinePrintText[ProductFinePrintText.length - 1];
      				if (!(lastword.length > 1))
        		ProductFinePrintText.pop();
      		$scope.products[key].ProductFinePrintText = ProductFinePrintText;
         });

     }

    var promoLDC = angular.fromJson($window.sessionStorage.getItem('promoLDC'));

    if(promoLDC !== undefined && promoLDC !== ""){
		$scope.ldcinfo=promoLDC;
        setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
    }
    else{

        PrimeService.getLdcInfo().success(function(data, status, headers, config){
                 if(data && data.responseStatus =="0"){
                     $scope.ldcinfo=data.LDCList;
                     setTimeout(function(){  $rootScope.bindClickEvent(); }, 10);
                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });
    }

    //"Additional Info" toggle
    $scope.displayAddlInfo = function(product) {
        console.log("Inside Function");
        if (product != undefined) {

          if (product.displayAccordian == undefined) {
            product.displayAccordian = true;
          } else if (product.displayAccordian) {
            product.displayAccordian = false;
          } else if (!product.displayAccordian) {
            product.displayAccordian = true;
          }
        } else {
          $scope.displayGuranteedAccord = $scope.displayGuranteedAccord ? false : true;
        }

        // alert(product.displayAccordian);
        //    $scope.displayAdditionalInfo = $scope.displayAdditionalInfo ? false : true;

  	}


}]);

