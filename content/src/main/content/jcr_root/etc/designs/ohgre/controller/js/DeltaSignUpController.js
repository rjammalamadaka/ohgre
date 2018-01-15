ohgrePortal.controller('DeltaSignUpController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {

    	$scope.deltaconfirmation=false;


    $scope.setLdcInfo =function(mainValue,description){
        $scope.ldc=mainValue;
        $scope.ldcDesc=description;
        $scope.an1=null;
        $scope.an2=null;
        $scope.an3=null;
        $scope.an4=null;

           $scope.an1required=true;
        $scope.an2required=true;
        $scope.an3required=true;
        $scope.an4required=true;

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
			$scope.an1minl="4";
		    $scope.an2minl="3";
            $scope.an3minl="4";
            $scope.an4minl="1";

        }else if(mainValue == "MIC"){
            $scope.an1minl="0";
            $scope.an2minl="0";
            $scope.an3minl="0";
            $scope.an4minl="13";
             $scope.an1required=false;
        $scope.an2required=false;
        $scope.an3required=false;
        }

        $scope.$apply();
    }


    $scope.bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
          var description=$(this).find('span').text();
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $scope.setLdcInfo(mainValue,description);
             $('#fixed-plans-button').val(mainValue);

		});

    }


$scope.dsmEnrollSubmit =function(){

		$scope.invaliddeltaskymilesaccountnumber=false;
 		var checkNumber=-1;


    $scope.deltasignupinfo.submited = true;
    if($scope.deltasignupinfo.$valid && !$scope.flag){

        checkNumber=validateDeltaSkyMilesNumber($scope.dsmAccountNumber);
             if(checkNumber ==3){
				$scope.invaliddeltaskymilesaccountnumber=true;
             }else if(checkNumber==0){

                $scope.dsmEnrollReq={};
                 $scope.dsmEnrollReq.firstName=$scope.firstName;
                 $scope.dsmEnrollReq.lastName=$scope.lastName;
                 $scope.dsmEnrollReq.dsmEmail=$scope.emailaddress;
                 $scope.dsmEnrollReq.dsmfirstName=$scope.dsmFirsName;
                 $scope.dsmEnrollReq.dsmlastName=$scope.dsmLastName;
                 $scope.dsmEnrollReq.dsmPhone=$scope.phoneNumber;
                 $scope.dsmEnrollReq.dsmAccountNumber=$scope.dsmAccountNumber;
                                  if($scope.ldc =="MIC"){
                 	$scope.dsmEnrollReq.LDCAccountNumber=$scope.an4;
                 }else{
					$scope.dsmEnrollReq.LDCAccountNumber=$scope.an1+$scope.an2+$scope.an3+$scope.an4;
                 }
                $scope.LDCAccountNumber= $scope.dsmEnrollReq.LDCAccountNumber;
                 $scope.dsmEnrollReq.LDCName=$scope.ldc;

                PrimeService.dsmEnroll($scope.dsmEnrollReq).success(function(data, status, headers, config){ 
                    $scope.flag=false;
                    if(data.message =="Success"){
                        $scope.deltaconfirmation=true;
                    }
                }).error(function(data, status, headers, config){
                    $scope.flag=false;
                });
             }

    }
}
    
    PrimeService.getLdcInfo().success(function(data, status, headers, config){
        if(data && data.responseStatus =="0"){

            //$rootScope.deltaconfirmation=true;
			$scope.ldcinfo=data.LDCList;
            setTimeout(function(){ $scope.bindClickEvent(); }, 10);
        }
        
    }).error(function (data,status, headers, config){
        
    });


     $scope.phoneformatchange =function(number){

        var phonenumber=$("#phonenumber").val();
        phonenumber=phonenumber.replace("(","").replace(")","").replace(" ","").replace("-","");
        if(phonenumber && phonenumber.indexOf('-') ==-1 && phonenumber.length>3){
           var formatedNumber="("+phonenumber.substring(0,3)+") "+phonenumber.substring(3,6)+"-"+phonenumber.substring(6);
            $("#phonenumber").val(formatedNumber); 
            $scope.phoneNumber=formatedNumber;
        }
    }

     var validateDeltaSkyMilesNumber=function (sknum) {
       var smn = sknum;
       var integerCheck = 0,
           smnStatus = 4,
           smn01;
       
       var getSingleDigit = function(x) {
           if (x > 9) {
               var a,
                   b;
               
               a = x.toString();
               b = parseInt(a.substring(0, 1)) + parseInt(a.substring(1, 2));
               
               return b;
           }
           
           else
               return parseInt(x);
       };
       
       var regex=/^[0-9]+$/;
       if (sknum.match(regex)) {
           integerCheck = 1;
       }

       if(integerCheck > 0) {
           if(smn.length < 10) {
               smnStatus = 2;
           }
           else {
               smn01 = smn.substring(0, 1) * 2;
               smn02 = parseInt(smn.substring(1, 2));
               smn03 = smn.substring(2, 3) * 2;
               smn04 = parseInt(smn.substring(3, 4));
               smn05 = smn.substring(4, 5) * 2;
               smn06 = parseInt(smn.substring(5, 6));
               smn07 = smn.substring(6, 7) * 2;
               smn08 = parseInt(smn.substring(7, 8));
               smn09 = smn.substring(8, 9) * 2;
               chkDigit = parseInt(smn.substring(9, 10));
               
               smn01 = getSingleDigit(smn01);
               smn03 = getSingleDigit(smn03);
               smn05 = getSingleDigit(smn05); 
               smn07 = getSingleDigit(smn07);
               smn09 = getSingleDigit(smn09);
               
               intOdds = smn01 + smn03 + smn05 + smn07 + smn09;
               intEvens = smn02 + smn04 + smn06 + smn08;
               
               intRemainder = (intOdds + intEvens) % 10;
               
               if ((intRemainder == 0) && (chkDigit == 0)) { smnStatus = 0; }
               else if ((10 - intRemainder) == chkDigit) { smnStatus = 0; }
               else { smnStatus = 3; }
           }
           
       }
       
       else {
           smnStatus = 4;
       }
       
       return smnStatus;
   }


   $scope.$watch('dsmAccountNumber', function (newValue, oldValue, scope) {
       if(newValue && newValue.length>0){
		$scope.invaliddeltaskymilesaccountnumber=false;
       }
	}, true);

    $scope.backtohome =function(){

		location.href=$rootScope.homeUrl+".html";
    }


    $scope.viewPlansDeltaSignup =function(promotionCode,promotionpath){
		var promoCode="DELTA25";
        var promoPath=$rootScope.homeUrl+"/promo_landing.html";
        if(promotionCode){
			promoCode=promotionCode;
        }
        if(promotionpath){
			promoPath=promotionpath;
        }

    PrimeService.getPromoCodeInfo(promoCode).success(function(data, status, headers, config){
        if(data && data.responseStatus =="0"){                    
            if(data.LDCList && data.LDCList.length >0){
                var ldclist= data.LDCList[0];
                var promotion=ldclist.promotion[0];
                ohgre.store("promoCodeInfo",data);
                if(promoPath){
                    location.href=promoPath+".html";
                }
            }
        }
        
    }).error(function (data,status, headers, config){
        ohgre.store("promoCodeInfo",null);
    });
    }



}]);