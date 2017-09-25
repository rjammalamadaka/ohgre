ohgrePortal.controller('MovingController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {


    if($rootScope.portalname =="oh"){
		$scope.addressstate="OH";
    }else if($rootScope.portalname =="gre"){
        $scope.addressstate="GRE";
    }


    $scope.submitMoving =function(){

        $scope.movingform.submited = true;

        if($scope.movingform.$valid && !$scope.flag){

		$scope.flag=true;
        var req={};

        req.firstname=$scope.firstname;
		req.lastname=$scope.lastname;
        req.email=$scope.email;
        req.phone=$scope.phone;
		req.contactpermission=$scope.contactpermission;
        req.addressone=$scope.addressone;
		req.addresstwo=$scope.addresstwo;
        req.addresscity=$scope.addresscity;
        req.addressstate=$scope.addressstate;
        req.addresszip=$scope.addresszip;
        req.sendemails=$scope.sendemails;

            var hearaboutus=$('#hearaboutus .value').find('span').html();
            if(!hearaboutus){
              hearaboutus= $('#hearaboutus .value').html();
            }
         req.hearaboutus= hearaboutus;


            var expectedmovedate= $('#expectedmovedate .value').find('span').html();
            if(!expectedmovedate){
                expectedmovedate=$('#expectedmovedate .value').html();
            }
         req.expectedmovedate=expectedmovedate;


        PrimeService.moving(req).success(function(data, status, headers, config){
			console.log(data);
             $scope.flag=false;
            if(data.resultCode =="0"){

            }

        }).error(function(data, status, headers, config){

			$scope.flag=false;
        })

        }
    }


       $scope.phoneformatchange =function(number){

        var phonenumber=$("#phonenumber").val();
        phonenumber=phonenumber.replace("(","").replace(")","").replace(" ","").replace("-","");
        if(phonenumber && phonenumber.indexOf('-') ==-1 && phonenumber.length>3){
           var formatedNumber="("+phonenumber.substring(0,3)+") "+phonenumber.substring(3,6)+"-"+phonenumber.substring(6);
            $("#phonenumber").val(formatedNumber); 
            $scope.phone=formatedNumber;
        }
    }


}]);

