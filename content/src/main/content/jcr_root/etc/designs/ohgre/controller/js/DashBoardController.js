ohgrePortal.controller('DashBoardController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

    ohgre.removeStore("promoCodeInfo");
jQuery('#popup-spinner-wrap').show();

    function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

    var getCustomerInfo=function(req){


         if(req.LDC=="DUK"){
                req.AccountNumber=req.AccountNumber.substring(0,req.AccountNumber.length-1);
            }
            if(req.LDC=="VED"){
               req.AccountNumber= req.AccountNumber.substring(2,req.AccountNumber.length-1);
            }



        PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){


            $scope.customerInfo=JSON.parse(data.CustomerInfoResult);

            jQuery('#popup-spinner-wrap').hide();

        }).error(function(data, status, headers, config){
            jQuery('#popup-spinner-wrap').hide();

        });

    }

     PrimeService.getProductData().success(function(data, status, headers, config){


         if(!isEmpty(data)){
             $scope.productData=data;
             var req={};
             req.AccountNumber=data.AccountNumber; 
             req.LDC=data.LDC;
             if(!data.AccountNumber || !data.LDC){
				location.href=$rootScope.homeUrl+".html";
             }else{
 				getCustomerInfo(req);
             }

         }else{
			location.href=$rootScope.homeUrl+".html";

         }
     }).error(function(data, status, headers, config){

         jQuery('#popup-spinner-wrap').hide();

     });

    $scope.logout=function(){
        jQuery('#logout-popup').show();
    }
    $scope.confirmlogout =function(){
		$rootScope.commonLogout();
    }

    $scope.cancellogout=function(){
		jQuery('#logout-popup').hide();
    }
    $scope.changeMyRenewal =function(){
		location.href=$rootScope.homeUrl+'/select-plan.html';
    }

    $scope.cancelMyContract =function(){
		location.href=$rootScope.homeUrl+'/cancel-contract.html';
    }
    $scope.getFormatedAccountnumber =function(accountNumber){

        var formattedNumber="";
        if(accountNumber){
		var ldc=$scope.productData.LDC;
   if(ldc == "COH"){
       //8331
            formattedNumber=accountNumber.substring(0,8)+'-'+accountNumber.substring(8,11)+'-000-'+accountNumber.substring(14,15);

        }else if(ldc == "DUK"){
            //4421
            formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,8)+'-'+accountNumber.substring(8,10)+'-'+$scope.productData.dukNumber;

        }else if(ldc == "DEO"){
			//1444
            formattedNumber=accountNumber.substring(0,1)+'-'+accountNumber.substring(1,5)+'-'+accountNumber.substring(5,9)+'-'+accountNumber.substring(9,13);

        }else if(ldc == "VED"){
            //2971
			formattedNumber="03-"+accountNumber.substring(0,9)+"-"+accountNumber.substring(9,16)+"-0";

        }else if(ldc == "MCG"){
			//4341
            formattedNumber=accountNumber.substring(0,4)+'-'+accountNumber.substring(4,7)+'-'+accountNumber.substring(7,11)+'-'+accountNumber.substring(11,12);

        }else if(ldc == "MIC"){
            formattedNumber=accountNumber;
        }
        return formattedNumber;

        }else{
			return "";
        }


    }


}]);

