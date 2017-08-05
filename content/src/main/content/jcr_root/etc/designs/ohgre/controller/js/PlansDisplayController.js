ohgrePortal.controller('PlansDisplayController', ['$scope', '$rootScope', '$http','$window',function ($scope, $rootScope,$http,$window) {


 		var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }
        $scope.displayPlans = true;

 	var portalname=$("#primary-header").data("portalname");

    $("input[name=location_type][value='residential']").prop("checked",true);

    var getQuotes = function(ldcCode){
        var locationType=$("input[name='location_type']:checked"). val();   
        $window.sessionStorage.setItem('lcType', locationType);

        var promotionCode=$scope.promotionCode;
        var url="/bin/getQuotes?portalName="+portalname;
        if(ldcCode){
			 url=url+"&ldcCode="+ldcCode;
        }
        if(promotionCode){
			url=url+"&promotionCode="+promotionCode;
        }
        if(locationType){
			url=url+"&locationType="+locationType;
        }
         $http.get(url).success(function(data, status, headers, config){
			//goToByScroll();	
             $scope.Quotes=data;
             if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
					$scope.Customer=$scope.Quotes.Customer;
                   $scope.products=$scope.Customer[0].Product;
                 $window.sessionStorage.setItem('products', angular.toJson($scope.products));
                 $scope.displayPlans = true;
             }
             console.log(data);

         }).error(function (data,status, headers, config){

             console.log("error");
         })

    }



        if($rootScope.hashParams.ldc){
       		 $scope.ldc=$rootScope.hashParams.ldc;
			$('#fixed-plans-button').val($scope.ldc);
		///$window.sessionStorage.setItem('ldcType', $scope.ldc);
        }

        if($rootScope.hashParams.lctype){
			$scope.lctype=$rootScope.hashParams.lctype;
        	if($scope.lctype =="commercial"){
			 	$("input[name=location_type][value='commercial']").prop("checked",true);
        	}
        	//$window.sessionStorage.setItem('lcType', $scope.lctype);
        }
        else{
			$scope.lctype= "residential";

			 	$("input[name=location_type][value='residential']").prop("checked",true);
        	//$window.sessionStorage.setItem('lcType', $scope.lctype);
        }



        if($scope.ldc){
            getQuotes($scope.ldc);
        }

    for (i = 0; i < $rootScope.ldcList.length; i++) { 
		var test=$rootScope.ldcList[i];
        if(test.name == $scope.ldc){
            var ldctext="<span>"+test.value+"</span>";
			$('#fixed-plans-button .value').html(ldctext);
            break;
        }
    }


    $scope.getNumber =function(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }

    }


    $scope.getPlans =function(){

		$scope.displayPlans = false;
 		var ldcCode=$('#fixed-plans-button').val();

        //$window.sessionStorage.setItem('ldcType', ldcCode);
        if(ldcCode){

			var currentHash=location.hash;
            var currentLdc=$rootScope.hashParams.ldc;
            var locationType=$("input[name='location_type']:checked"). val(); 
            var currentLocationType=$rootScope.hashParams.lctype;
            currentHash= currentHash.replace(currentLdc,ldcCode);
			currentHash= currentHash.replace(currentLocationType,locationType);
$rootScope.hashParams.lctype=locationType;
$rootScope.hashParams.ldc=ldcCode;
            console.log(currentHash);
			location.hash=currentHash;

            getQuotes(ldcCode);
        }
    }

    $scope.displayGuranteedAccord = false;
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
       else 
       {
           $scope.displayGuranteedAccord = $scope.displayGuranteedAccord ? false : true;
       }

       // alert(product.displayAccordian);
    //    $scope.displayAdditionalInfo = $scope.displayAdditionalInfo ? false : true;

    }

    var goToByScroll =function(){

        $('html,body').animate({
            scrollTop: $('.plan-detail').offset().top},
                               'slow');
    	}


}]);


