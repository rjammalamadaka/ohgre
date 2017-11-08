ohgrePortal.controller('CancelContractController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

// $scope.formButton="Apply Promo Code";

      function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }


    var flag=false;


    var getQuotes=function(req){
		var PromoCode=null;
        var ResPromoCode=$("#cancel-plan-wrapper").data("respromocode");
        var ComPromoCode=$("#cancel-plan-wrapper").data("compromocode");
        if(req.rateClassCode =="01"){
			PromoCode=ResPromoCode;
        }else if(req.rateClassCode =="04"){
			PromoCode=ComPromoCode;
        }
       /* if(req.PromoCode){            
            PromoCode=req.PromoCode;
        }*/
        
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


        $scope.planSelectRenewal =function(product){

		console.log(product);
        $scope.selectedProduct=product;

        console.log($scope.selectedProduct.ProductDescription);

		console.log($scope.customerInfo);
		console.log($scope.productData);

        if($scope.customerInfo.existingCustomerInd=="Y" && $scope.customerInfo.renewalContractExistsInd=="Y"){
             $('#popupwithrenewal').addClass('show-popup');
        }else{
            var earlyTermChargeAmt= Number($scope.customerInfo.earlyTermChargeAmt);
            if(earlyTermChargeAmt>0){
                $rootScope.showearlyterminationfee=true;
                $('#popupetc').addClass('show-popup');                
            }else{
                 $scope.continueenroll();
				//location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 
            }
        }

    }

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


    $scope.continueenroll =function(){
         var req={};

        req.QuoteDescription=$scope.selectedProduct.QuoteDescription;
		req.ProductDescription=$scope.selectedProduct.ProductDescription;
        req.ProductCode=$scope.selectedProduct.ProductCode;
        req.LdcDesc= $scope.productData.ldcDesc;
        req.LDC= $scope.productData.LDC;
		req.FixedPricePerTherm=$scope.selectedProduct.FixedPricePerTherm;
        req.AccountNumber=$scope.productData.AccountNumber;
        req.RateClassCode=$scope.productData.rateClassCode;

         PrimeService.setProductData(req).success(function(data, status, headers, config){  

             location.href=$rootScope.homeUrl+"/customer_lookup.html#fromRenewal=true"; 

         }).error(function (data,status, headers, config){ 

         });


    }

    $scope.redirecttodashboard =function(){
        location.href=$rootScope.homeUrl+"/myaccount.html";

    }

      $scope.getFormatedAccountnumber =function(accountNumber){
        var formattedNumber="";
        if(accountNumber){
            var ldc="";
            if($scope.productData && $scope.productData.LDC){
		    ldc=$scope.productData.LDC;
            }
			if(ldc == "COH"){       
			formattedNumber=accountNumber.substring(0,8)+'-'+accountNumber.substring(8,11)+'-000-'+accountNumber.substring(14,15);
			}else if(ldc == "DUK"){
			formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,8)+'-'+accountNumber.substring(8,10)+'-'+accountNumber.substring(10,11);
			}else if(ldc == "DEO"){
			formattedNumber=accountNumber.substring(0,1)+'-'+accountNumber.substring(1,5)+'-'+accountNumber.substring(5,9)+'-'+accountNumber.substring(9,13);
			}else if(ldc == "VED"){
			formattedNumber="03-"+accountNumber.substring(2,11)+"-"+accountNumber.substring(11,18)+"-0";
			}else if(ldc == "MCG"){
			formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,7)+'-'+accountNumber.substring(7,11)+'-'+accountNumber.substring(11,12);
			}else if(ldc == "MIC"){
			formattedNumber=accountNumber;
			}
			return formattedNumber;
        }else{return "";}
      }

}]);

