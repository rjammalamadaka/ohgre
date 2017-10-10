ohgrePortal.controller('DeltaSignUpController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

	$scope.ldc='MIC';
    $scope.setLdcInfo =function(mainValue){
		console.log(mainValue);
        $scope.ldc=mainValue;
        if(mainValue == "COH"){
			$scope.an1minl="8";
		    $scope.an2minl="3";
            $scope.an3minl="3";
            $scope.an4minl="1";
            $scope.an3="000";
            $scope.an3r=true;

        }else if(mainValue == "DUK"){
			$scope.an1minl="4";
		    $scope.an2minl="4";
            $scope.an3minl="2";
            $scope.an4minl="1";

        }else if(mainValue == "DEO"){
			$scope.an1minl="1";
		    $scope.an2minl="4";
            $scope.an3minl="4";
            $scope.an4minl="4";

        }else if(mainValue == "VED"){
			$scope.an1minl="2";
		    $scope.an2minl="9";
            $scope.an3minl="7";
            $scope.an4minl="1";
            $scope.an1="03";
            $scope.an4="0";
            $scope.an1r=true;
            $scope.an4r=true;

        }else if(mainValue == "MCG"){
            console.log("MCG values set");
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(mainValue == "MIC"){
             console.log("MIC values set");
            $scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";
        }

    }


    $scope.bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            ///console.log(val);
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $scope.setLdcInfo(mainValue);
             $('#fixed-plans-button').val(mainValue);

		});

    }

    
    PrimeService.getLdcInfo().success(function(data, status, headers, config){
        if(data && data.responseStatus =="0"){
            $scope.ldcinfo=data.LDCList;
            setTimeout(function(){ $scope.bindClickEvent(); }, 10);
        }
        
    }).error(function (data,status, headers, config){
        
        console.log("error");
    });

    /*



        */

}]);