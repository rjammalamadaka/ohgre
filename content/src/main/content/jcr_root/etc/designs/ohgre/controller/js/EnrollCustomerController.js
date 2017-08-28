ohgrePortal.controller('EnrollCustomerController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

    var config = {
		        responsetype : 'json',
        		headers : {
            		'Content-Type' :'application/json'
        		}
   		 }
    $http.get("/bin/getProductData.json").success(function(data, status, headers, config){

        $scope.product=data;
$scope.an1r=false;
$scope.an3r=false;
$scope.an4r=false;        
        if(data.LDC == "COH"){
			$scope.an1minl="8";
		    $scope.an2minl="3";
            $scope.an3minl="3";
            $scope.an4minl="1";
            $scope.an3="000";
            $scope.an3r=true;

        }else if(data.LDC == "DUK"){
			$scope.an1minl="4";
		    $scope.an2minl="4";
            $scope.an3minl="2";
            $scope.an4minl="1";

        }else if(data.LDC == "DEO"){
			$scope.an1minl="1";
		    $scope.an2minl="4";
            $scope.an3minl="4";
            $scope.an4minl="4";

        }else if(data.LDC == "VED"){
			$scope.an1minl="2";
		    $scope.an2minl="9";
            $scope.an3minl="7";
            $scope.an4minl="1";
            $scope.an1="03";
            $scope.an4="0";
            $scope.an1r=true;
            $scope.an4r=true;

        }else if(data.LDC == "MCG"){
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(data.LDC == "MIC"){

			$scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";

        }

    }).error(function (data,status, headers, config){

        console.log("error");
    });


    $scope.enrollCustomer =function(step){


			$scope.formone.submited = true;
        if($scope.formone.$valid){
            console.log($scope.formone.$valid);

            	$('.active-form').removeClass('active-form');
			$('.active-step').removeClass('active-step');
			$('#step-through >div:nth-child('+step+')').addClass('active-form');
			$('.steps-container > div:nth-child('+step+')').addClass('active-step');



        }else{

		return;
        }


        /*

			$('.active-form').removeClass('active-form');
			$('.active-step').removeClass('active-step');
			$('#step-through >div:nth-child('+step+')').addClass('active-form');
			$('.steps-container > div:nth-child('+step+')').addClass('active-step');

            */
    }

}]);

