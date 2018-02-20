ohgrePortal.controller('PromoCodeController', ['$scope', '$rootScope', '$http','$window','PrimeService','OhGreService',function ($scope, $rootScope,$http,$window,PrimeService,OhGreService) {

          var onlinePromoCodes=["SCORE1C","COMPARE1C","SWITCH", "SCORE1V", "COMPARE1V", "SCORE1DT", "LOWEST1DT", "SCORE1CO", "LOWEST1CO", "10MONTHFIX2018", "10FIX2018", "SCORE3C", "MOVER3C", "SCORE3V", "COMPARE3V", "MOVER3V", "MOVER3V", "DELTA15K", "SCORECO", "SCOREDT", "LOWESTCO", "LOWESTDT"];

    ohgre.removeStore("promoCodeInfo");
    ohgre.removeStore("promocode");

    $scope.placeholder = "Enter Promo Code";

    $scope.backUpPromoApplied=false;


    $scope.promoCodeSubmit = function(){
		$scope.promoform.submited = true;
        if($scope.promoform.$valid){
        //document.cookie="promocode="+$scope.promotioncode;


        var promotionCode=$scope.promotioncode;

            if(promotionCode){
				if(onlinePromoCodes.indexOf(promotionCode)!=-1){
             		promotionCode= promotionCode.concat("ONLINE");
        					 }
                PrimeService.getPromoCodeGroupInfo(promotionCode).success(function(data, status, headers, config) {
                    if(data && data.success){
						var promoCodeinfo=data.promoCodeInfo;
                        var promoinfo={};
                        promoinfo.code=promoCodeinfo.promoCode;
                        promoinfo.url=promoCodeinfo.value;
                        $scope.promoInfo=promoinfo;
						getPromoCodeInfo(promotionCode);
                    }else{
                        getPromoCodeInfo(promotionCode);
						//$scope.errorInfo=data.errorMessage;
                      // location.href=$rootScope.homeUrl+"/promotion-error.html";
                    }
                }).error(function(data, status, headers, config) {

                });
               // getPromoGroups(promotionCode);


            }

        }else{
            $scope.placeholder = "";
            return;
        }

    }

    var getPromoCodeInfo=function(promotionCode){

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
                    var locationType=$("input[name='location_type']:checked"). val(); 
                    //$window.sessionStorage.setItem('promoLDC',angular.toJson(data.LDCList));

					var ldc=null,promotionCode=null;
                    var promotion=null;


                    for(var i=0;i<data.LDCList.length;i++){
                        ldc=data.LDCList[i];
                        var ldcCode=ldc.LDCCode;
                       promotion =ldc.promotion[0];

                        if(promotion && promotion.PromotionCode){
                            if( promotion &&  promotion.RateClassCode){
                                if(locationType=="residential" && promotion.RateClassCode=="01"){
									$scope.rateClassCode=promotion.RateClassCode;
                                }else if(locationType=="commercial" && promotion.RateClassCode=="04"){
									$scope.rateClassCode=promotion.RateClassCode;
                                }

                            }

                            if(!promotion.RateClassCode.length>0){
                                if(locationType=="residential"){
                            		data.LDCList[i].promotion[0].RateClassCode="01";
                                    $scope.rateClassCode="01";
                                } else{
                           			 data.LDCList[i].promotion[0].RateClassCode="04"; 
                                     $scope.rateClassCode="04";
                                }

                            }
                            if(promotion.PromotionExpired =="Y" && promotion.BackupPromotionCode.length>0){
							    // getPromoCodeInfo(promotion.BackupPromotionCode);
                                //data.LDCList[i].promotion[0].PromotionCode=promotion.BackupPromotionCode;

                                promotionCode= promotion.BackupPromotionCode; 
                                break;
                            }if(promotion.PromotionExpired =="N"){
                                promotionCode=promotion.PromotionCode; 
                                break;                              
                            }
                        }
                    }

                    //if(flag)
                   // getPromoCodeInfo(promotion.BackupPromotionCode);

                    if(!$scope.rateClassCode){
						location.href=$rootScope.homeUrl+"/invalid-promocode.html";
                        return false;
                    }

                  //  var ldclist= data.LDCList[0];
                   // var promotion=ldclist.promotion[0];
                    //data.locationType=locationType;
                  /*  if(!promotion.RateClassCode.length>0){
                        if(locationType=="residential")
                            data.LDCList[0].promotion[0].RateClassCode="01";
                        else
                            data.LDCList[0].promotion[0].RateClassCode="04"; 

                    }*/
                    ohgre.store("promoCodeInfo",data);
                    if($scope.backUpPromoApplied){

                        if(redirectUrl){
								window.location.href=redirectUrl+".html?isExpired=true";
                        }else{
								location.href=$rootScope.homeUrl+"/backuppromo.html";
                        }
                        		return;
                     }

                    if(promotion.PromotionExpired =="Y" && !redirectUrl){
                        if(promotion.BackupPromotionCode.length>0 && !$scope.backUpPromoApplied){
                            $scope.backUpPromoApplied=true;
							getPromoCodeInfo(promotion.BackupPromotionCode);
                            return;
                        	//location.href=$rootScope.homeUrl+"/backuppromo.html";

                        }else if(!$scope.backUpPromoApplied){
							location.href=$rootScope.homeUrl+"/promotion-error.html";
                        }


                    }else if(data.LDCList && redirectUrl){

                         if(promotion.BackupPromotionCode.length>0 && !$scope.backUpPromoApplied){
                            $scope.backUpPromoApplied=true;
							getPromoCodeInfo(promotion.BackupPromotionCode);
                            return;
                        	//location.href=$rootScope.homeUrl+"/backuppromo.html";

                        }

                        if(promotion.PromotionExpired =="Y"){


                            if(promotion.BackupPromotionCode){


                                if($rootScope.IsIE()){

							     setTimeout(function(){ window.location.href=redirectUrl+".html?isExpired=true";});
                                }else{
									setTimeout(function(){ window.location.href=redirectUrl+".html#isExpired=true";});

                                }


                              }else{
									location.href=$rootScope.homeUrl+"/promotion-error.html";
                                                             }


                        }else{
                            location.href=redirectUrl+".html";
                        }


                    }else if(data.LDCList && data.LDCList.length!=0 && !redirectUrl){
                       // if(data.LDCList.length ==1){
                        //    location.href=$rootScope.homeUrl+"/promo-general.html";
                        //}else{
                            ohgre.removeStore("promoCodeInfo");
                            ohgre.removeStore("promocode");
                            location.href=$rootScope.homeUrl+"/invalid-promocode.html";
                        //}
                    }else{
                        location.href=$rootScope.homeUrl+"/promo-general.html";
                    }
                }

            }else if(data && data.responseStatus =="1"){
                //ohgre.store("promoCodeInfo",null);
                location.href=$rootScope.homeUrl+"/invalid-promocode.html";
            }

        }).error(function(data, status, headers, config) {

        });


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
        errorMsgWrapper.addClass('error-hidden');
		promoCodeEl.focus();
        //errorMsgWrapper.hide();
    }



}]);
