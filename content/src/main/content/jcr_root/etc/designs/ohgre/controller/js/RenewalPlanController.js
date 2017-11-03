ohgrePortal.controller('RenewalPlanController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {



    $scope.formButton="Apply Promo Code";

      function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }


    var flag=false;


    var getQuotes=function(req){

        var PromoCode=$("#renew-plan-select").data("promocode");
        if(req.PromoCode){
            
            PromoCode=req.PromoCode;
        }
        
        PrimeService.getQuotes(req.LDC,PromoCode,req.rateClassCode).success(function(data, status, headers, config){
            
            //console.log(data);
            if(data && data.responseStatus=="0"){
                $scope.products={};
                if(data.Customer && data.Customer.length>0){
                    if(!flag){
						flag=true;
                        $scope.defaultProducts=data.Customer[0].Product;

                    }
                    $scope.products=data.Customer[0].Product;
                    updateProductFinePrint();
                    console.log($scope.products);
                }
            }
            
        }).error(function (data,status, headers, config){
            
            console.log("error");
        });


    }


       var getCustomerInfo=function(req){


        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){

            console.log(data);

            $scope.customerInfo=JSON.parse(data.CustomerInfoResult);

            console.log($scope.customerInfo);


        }).error(function(data, status, headers, config){

        });

    }

           var updateProductFinePrint = function(){

        angular.forEach($scope.products, function(value, key){


            if($scope.products[key].ProductCode =="COJ"  || $scope.products[key].ProductCode =="COK"){

                $scope.guaranteeProduct=$scope.products[key];

                console.log("$scope.guaranteeProduct");
                console.log($scope.guaranteeProduct);

            }

            var ProductFinePrintText = value.ProductFinePrintText.split(".");
            var lastword=ProductFinePrintText[ProductFinePrintText.length-1];
            if(!(lastword.length>1))
            ProductFinePrintText.pop();
			$scope.products[key].ProductFinePrintText = ProductFinePrintText;

        });

    }


     PrimeService.getProductData().success(function(data, status, headers, config){

         console.log();

         if(!isEmpty(data)){
             $scope.productData=data;
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             getCustomerInfo(req);
             getQuotes(data);

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




/*var promocode="RAF25";
     PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config){


                 if(data && data.responseStatus =="0"){

                     console.log(data);

                 }else if(data && data.responseStatus =="1"){
						$scope.serverError=data.responsemessage;

                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });

*/

     //Code for controlling Accordian display

     $scope.displayAddlInfo = function(product){
        console.log("Inside Function");
        if(product != undefined){

        	if(product.displayAccordian == undefined)
        	{
				product.displayAccordian = true;
        	}
       		else if(product.displayAccordian){
				product.displayAccordian = false;
        	}
        	else if(!product.displayAccordian){
				product.displayAccordian = true;
        	}
      }


    }

    $scope.showMobileAccord = function(product){
		console.log("showMobileAccord");

		if(product != undefined){

        if(product.displayMobAccord == undefined)
        {
			product.displayMobAccord = true;
        }
        else if(product.displayMobAccord){
			product.displayMobAccord = false;
        }
        else if(!product.displayMobAccord){
			product.displayMobAccord = true;
        }
      }

    }

    $scope.submitPromoCode =function(){
		$scope.serverError=null;
		$scope.renewalPlanPromo.submited = true;

        if($scope.formButton=="CLEAR"){

            $scope.products=$scope.defaultProducts;
            $scope.formButton="Apply Promo Code";
            $('#submit-promo-code').removeClass("inactive");
       }else if($scope.renewalPlanPromo.$valid){
           $('#submit-promo-code').addClass("inactive");
            PrimeService.getPromoCodeInfo($scope.promocode).success(function(data, status, headers, config){
                //$('#submit-promo-code').removeClass("inactive");
                $scope.formButton="CLEAR";
                if(data && data.responseStatus =="0"){                    
                    console.log(data);
                    if(data.LDCList.length>0 && data.LDCList[0].promotion[0].PromotionExpired=="Y"){
						console.log("code expired");

                        if(data.LDCList[0].promotion[0].BackupPromotionCode){
                            var req={};
                            $scope.serverError="Unfortunately this promotion has expired but we have some great plans below"; 
                            req.AccountNumber=$scope.productData.AccountNumber; 
                            req.LDC=$scope.productData.LDC;
                            req.PromoCode=data.LDCList[0].promotion[0].BackupPromotionCode;
                            req.rateClassCode=$scope.productData.rateClassCode;
                            getQuotes(req);

                        }else{
							$scope.serverError="Sorry the promotion code has been expired"; 
                        }
                    }else{
                        var req={};
						req.AccountNumber=$scope.productData.AccountNumber; 
						req.LDC=$scope.productData.LDC;
						req.PromoCode=$scope.promocode;
                        req.rateClassCode=$scope.productData.rateClassCode;
						getQuotes(req);
                    }

                }else if(data && data.responseStatus =="1"){
                    $scope.serverError="Please enter a valid Promo code";                    
                }
                
            }).error(function (data,status, headers, config){  
               // $('#submit-promo-code').removeClass("inactive");
                $scope.formButton="CLEAR";
                console.log("error");
            });
        }
    }


}]);

