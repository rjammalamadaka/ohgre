ohgrePortal.controller('RafAuthenticatedController', ['$scope', '$rootScope', '$http' ,'PrimeService','OhGreService',function ($scope, $rootScope,$http,PrimeService,OhGreService) {



     var date=new Date();
     var currentYear=date.getFullYear();
    var previouserYear=currentYear-1;
    $scope.years=[previouserYear,currentYear];
    $scope.giftCardByYear={};
	$scope.sclectedYear=currentYear;

    $scope.rafemailmessage="I'm very happy with service from Ohio Natural Gas, and I think you will be too. If you sign up with them using the promotion codes below, we can both get $50 credit towards our bill. Not bad, huh?"

    PrimeService.getProductData().success(function(data, status, headers, config){

        if(data){
            var req={};
             req.LDC= data.LDC;
              req.AccountNumber= data.AccountNumber;

            PrimeService.getCustomerInfo(req).success(function(data, status, headers, config){
                console.log(data);
                if(data && data.CustomerInfoResult){
                    var customerInfo=JSON.parse(data.CustomerInfoResult);
                    if(customerInfo.responseStatus ==1){


                    }else if(customerInfo.responseStatus ==0){
							$scope.customerInfo=customerInfo;
                           console.log($scope.customerInfo);
                        var giftCard= $scope.customerInfo.giftCard;
						var currentYearGf=[];
                        var previouserYearGf=[];
                        giftCard.forEach(function(entry) {
                            var date=new Date(entry.giftCardCreateDate);
                            var year= date.getFullYear();
                           // if($scope.years.indexOf(year) != -1){
								//$scope.giftCardByYear[year]=entry;
                                if(year ==currentYear){
									currentYearGf.push(entry);
									//$scope.giftCardByYear[currentYear]=entry;
                                }else if(year ==previouserYear){
                                    previouserYearGf.push(entry);
									//$scope.giftCardByYear[previouserYear]=entry;
                                }
                           // }
                        });

						$scope.giftCardByYear[currentYear]=currentYearGf;
                        $scope.giftCardByYear[previouserYear]=previouserYearGf;

                        console.log($scope.giftCardByYear);
                        $scope.bindClickEvent();

                        $scope.setProductData(currentYear);
                    }
                }else{
					location.href=$rootScope.homeUrl+"/refer-a-friend.html";
                }

            }).error(function (data,status, headers, config){

                console.log("error");
            });

        }

    }).error(function(data, status, headers, config){

        console.log(data);

    });

    //$scope.giftcardinfo=$scope.giftCardByYear[$scope.sclectedYear];

    $scope.setProductData =function(year){

        console.log("product data set");

	    var dropdosnValue=$('#raf-dropdown').find('span')[0];
        $(dropdosnValue).text(year);

        $scope.giftcardinfo=$scope.giftCardByYear[$scope.sclectedYear];

        $scope.awardedTotal=0;
        $scope.pendingTotal=0;
        $scope.awarded=[];
        $scope.pending=[];
        $scope.ineligible=[];

        for(var i=0;i<$scope.giftcardinfo.length;i++){
            if($scope.giftcardinfo[i].giftCardStatusCode =="020"){
                $scope.awarded.push($scope.giftcardinfo[i]);
                $scope.awardedTotal=$scope.awardedTotal+parseInt($scope.giftcardinfo[i].giftCardAmount);
                $scope.giftCardTypeCode=$scope.giftcardinfo[i].giftCardTypeCode;

            }else if($scope.giftcardinfo[i].giftCardStatusCode =="005"){
                 $scope.pending.push($scope.giftcardinfo[i]);
                 $scope.pendingTotal=$scope.pendingTotal+parseInt($scope.giftcardinfo[i].giftCardAmount);

            }else if($scope.giftcardinfo[i].giftCardStatusCode =="040"){
                 $scope.ineligible.push($scope.giftcardinfo[i]);
                var text=$scope.giftcardinfo[i].noteText;
                $scope.noteText="Reason : "+text.split("-")[1] ;
            }

        }

        console.log($scope.giftcardinfo);
    }

    $scope.bindClickEvent =function(){

      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').text();
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
            // $('#fixed-plans-button').val(mainValue);
          $scope.sclectedYear=mainValue;
 			$scope.setProductData(mainValue);
          $scope.$apply();

		});

    }

    $scope.convertToDate =function(date){
        var temp=date.split(" ");
		return temp[0];
    }

    $scope.rafauthenticated =function(){
		jQuery('#raf-terms-popup').addClass('show-popup');
    }

    $scope.refertomyfrineds =function(){

        $scope.rafMailSerrverMsg=null;
        $scope.rafemailform.submited = true;
        if($scope.rafemailform.$valid){
    
            var requestInfo={};
            requestInfo.tomailId=$scope.customerInfo.emailAddress;
            requestInfo.firstName=$scope.customerInfo.firstName;
            requestInfo.lastName=$scope.customerInfo.lastName;
           requestInfo.emailAddress=$scope.toemailaddress;
            requestInfo.rafBody=$scope.rafemailmessage;
            requestInfo.custID=$scope.customerInfo.custID;
    
            PrimeService.wcRequest(requestInfo).success(function(data, status, headers, config){
                console.log("success");
                console.log(data);
				if(data && data.success){
                    jQuery('#raf-terms-popup').removeClass('show-popup');
 					jQuery('#raf-confirm').addClass('show-popup');
                }else{

					$scope.rafMailSerrverMsg="Problem with mail server, Please try later";
                }
    
            }).error(function(data, status, headers, config){
                console.log(data);
                console.log("error");
                $scope.rafMailSerrverMsg="Problem with mail server, Please try later";
    
            });
        }
    }

    $scope.redirectToPrivacy=function(){
		location.href=$rootScope.homeUrl+"/privacy-policy.html";
    }

    $scope.redirectToHome =function(){
		location.href=$rootScope.homeUrl+'.html'
    }

    var outBoundTracking =function(o) {
        "function" == typeof ga ? (console.log("tracking"), ga("send", "event", {
                                   eventCategory: "RAF_Share",
                                   eventAction: o,
                                   eventLabel: 'RAFMicrosite'
                                   })) : console.log("not tracking")
    }


    $scope.fbIconClick =function(){

        var code = "RAF25";
        //var base_url = window.location.protocol + "/" + window.location.host + "/RAF25/";
		var base_url = window.location.origin+$rootScope.homeUrl+"/promo-raf.html";
         var o = base_url + "?promocode=" + code+"&referralcode="+$scope.customerInfo.custID;
		    return window.open("https://www.facebook.com/sharer/sharer.php?u=" + o, "pop", "width=600, height=400, scrollbars=no"), outBoundTracking("Facebook"), !1


    }
    $scope.twIconClick =function(){
  		var code = "RAF25";
       // var base_url = window.location.protocol + "/" + window.location.host + "/RAF25/";
		var base_url = window.location.origin+$rootScope.homeUrl+"/promo-raf.html";
		//var base_url = window.location.origin+$rootScope.homeUrl+"/promo-raf.html";
       /* var o = "$25 for you %26 $25 for me. Enroll with Ohio Natural Gas on their lowest available rates! Terms apply. %23ad",
		        t = "url=" + base_url + "?promocode=" + code + "&referralcode="+$scope.customerInfo.custID+"&r=1&text=" + o;
         t=encodeURIComponent(t);
		    return window.open("https://twitter.com/intent/tweet?" + t, "pop", "width=600, height=400, scrollbars=no"), outBoundTracking("Twitter"), !1
*/
         var o = "$25 for you %26 $25 for me. Enroll with Ohio Natural Gas on their lowest available rates! Terms apply. %23ad",
		        t = "url=" + base_url + "?promocode=" + code + "&referralcode="+$scope.customerInfo.custID+"&r=1&text=" + o;
		    return window.open("https://twitter.com/intent/tweet?" + t, "pop", "width=600, height=400, scrollbars=no"), outBoundTracking("Twitter"), !1

    }

}]);
