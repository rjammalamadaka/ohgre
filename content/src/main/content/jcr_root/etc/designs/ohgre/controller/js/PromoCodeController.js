ohgrePortal.controller('PromoCodeController', ['$scope', '$rootScope', '$http','$window','PrimeService','OhGreService',function ($scope, $rootScope,$http,$window,PrimeService,OhGreService) {

    ohgre.removeStore("promoCodeInfo");
    ohgre.removeStore("promocode");

    $scope.placeholder = "Enter Promo Code";


    $scope.promoCodeSubmit = function(){
		$scope.promoform.submited = true;
        if($scope.promoform.$valid){
document.cookie="promocode="+$scope.promotioncode;

        var promotionCode=$scope.promotioncode;
            if(promotionCode){
                getPromoGroups(promotionCode);
                PrimeService.getPromoCodeInfo(promotionCode).success(function(data, status, headers, config) {
                    var redirectUrl=null;
                     if($scope.promoInfo && $scope.promoInfo.url){
                         redirectUrl=$scope.promoInfo.url;
                         if($rootScope.portalname =="gre"){
                            redirectUrl=redirectUrl.replace("onlyong","gre");
                         }
                     }
                     if(data && data.responseStatus =="0"){
                         if(data.LDCList && data.LDCList.length >0){
							//$window.sessionStorage.setItem('promoLDC',angular.toJson(data.LDCList));
                            var ldclist= data.LDCList[0];
                             var promotion=ldclist.promotion[0];
                             ohgre.store("promoCodeInfo",data);
                             if(promotion.PromotionExpired =="Y"){
                                    location.href=$rootScope.homeUrl+"/backuppromo.html";
                             }else if(data.LDCList && redirectUrl){
                                    location.href=redirectUrl+".html";
                            }else if(data.LDCList && data.LDCList.length!=0 && !redirectUrl){
                                if(data.LDCList.length ==1){
                                    location.href=$rootScope.homeUrl+"/promo-general.html";
                                }else{
                                    location.href=$rootScope.homeUrl+"/generic-promo.html";
                                }
                            }else{
                                location.href=$rootScope.homeUrl+"/promo-general.html";
                            }
                         }

                     }else if(data && data.responseStatus =="1"){
                            //ohgre.store("promoCodeInfo",null);
                            location.href=$rootScope.homeUrl+"/promotion-error.html";
                     }

                }).error(function(data, status, headers, config) {});
            }

        }else{
            $scope.placeholder = "";
            return;
        }

    }
    var getPromoGroups= function(promotionCode){
        OhGreService.getPromoGroups().success(function(data, status, headers, config){
            for (var property in data) {
    			if (data.hasOwnProperty(property) && property != "jcr:primaryType") {
                    var childNode=data[property];
                    for(var childproperty in childNode){
                        if(childNode.hasOwnProperty(childproperty) && childproperty != "jcr:primaryType"){
                            var url=childNode[childproperty];

                            if(childproperty == promotionCode){
							var promoinfo={};
							promoinfo.code=childproperty;
                            promoinfo.url=url;
                            $scope.promoInfo=promoinfo;
                                break;
                            }
                        }
                    }
    			}
			}
        }).error(function (data,status, headers, config){ });
    }

	var promoCodeEl = angular.element( document.querySelector('#promotioncode')),
        errorMsgWrapper = angular.element(document.querySelector('.error-message-wrapper'));

    $scope.$watch('promotioncode', function (newValue, oldValue, scope) {
       if(newValue){
		$scope.promotioncode = newValue.toUpperCase();

       }
	}, true);

    $scope.promoCodeFocused = function() {
		errorMsgWrapper.addClass('error-hidden');
        //$scope.placeholder = "";
    }
    $scope.promoCodeBlur = function() {
		errorMsgWrapper.removeClass('error-hidden');
        //$scope.placeholder = "";
    }

    $scope.errorClicked = function() {
		console.log('errorClicked');
        errorMsgWrapper.addClass('error-hidden');
		promoCodeEl.focus();
        //errorMsgWrapper.hide();
    }



}]);
