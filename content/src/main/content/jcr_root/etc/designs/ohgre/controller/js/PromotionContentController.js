ohgrePortal.controller('PromotionContentController', ['$scope', '$rootScope', '$http', 'PrimeService', function($scope, $rootScope, $http, PrimeService) {


  var portalname = $rootScope.portalname;
  $scope.displayPlans = false;


  if ($rootScope.hashParams && $rootScope.hashParams.rateClassCode) {

    if ($rootScope.hashParams.rateClassCode == "01") {

      $("input[name=location_type][value='residential']").prop("checked", true);

    } else if ($rootScope.hashParams.rateClassCode == "04") {

      $("input[name=location_type][value='commercial']").prop("checked", true);

    }
  }

  $scope.hasIntroImg = ($('#promo-intro-img').attr('src') === undefined) ? 0 : 1;

  var processPromotionInfo = function(promoInfo) {

    if (promoInfo.LDCList.length > 0) {
      $scope.ldcInfo = promoInfo;
      var ldc = promoInfo.LDCList[0];
      $scope.promotion = ldc.promotion[0];
      $scope.giftCardValue = $scope.promotion.GiftCardValue;
      $scope.DELTAMILES = $scope.promotion.DSMAwardMiles;
      var date = new Date($scope.promotion.PromotionExpiratonDate),
        locale = "en-us",
        month = date.toLocaleString(locale, {
          month: "long"
        });
      $scope.EXPIRATIONDATE = month + " " + date.getDate() + ", " + date.getFullYear();

        if (!($rootScope.hashParams && $rootScope.hashParams.rateClassCode)) {
           var rateClassCode= $scope.promotion.RateClassCode
            if(rateClassCode =="01")
 			$("input[name=location_type][value='residential']").prop("checked", true);
            else if(rateClassCode == "04")
              $("input[name=location_type][value='commercial']").prop("checked", true);
        }

    }

    if ($rootScope.hashParams.ldc && $rootScope.hashParams.fromabout) {
      $scope.displayPlans = true;

      if ($scope.promotion && $scope.promotion.RateClassCode) {
        $scope.rateClassCode = $scope.promotion.RateClassCode;
      }

      var promotionCode = null;
      if ($scope.promotion && $scope.promotion.PromotionCode) {
        if ($scope.promotion.PromotionExpired == "Y") {
          promotionCode = $scope.promotion.BackupPromotionCode;
        } else {
          promotionCode = $scope.promotion.PromotionCode;

        }
      }



      var url = "/bin/getQuotes?portalName=" + portalname + "&ldcCode=" + $rootScope.hashParams.ldc + "&promotionCode=" + promotionCode + "&rateClassCode=" + $scope.rateClassCode;
      $http.get(url).success(function(data, status, headers, config) {
        $scope.Quotes = data;
        if ($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length > 0) {
          $scope.displayPlans = true;
          $scope.Customer = $scope.Quotes.Customer;
          var customer = $scope.Customer[0];
          var getQuotesProductsList = [];
          for (var i = 0; i < customer.Product.length; i++) {
            if ($rootScope.prmoProduct.indexOf(customer.Product[i].ProductCode) != -1) {
              getQuotesProductsList.push(customer.Product[i]);

            }

          };
          $scope.products = getQuotesProductsList; //$scope.Customer[0].Product;

          setTimeout(function() {
            $rootScope.bindAccordian();
          }, 10);

        } else {


        }

      }).error(function(data, status, headers, config) {

      });


    }

  }

  var getBackupPromoCodeInfo = function(promocode) {


    PrimeService.getPromoCodeInfo(promocode).success(function(data, status, headers, config) {
      ohgre.store("promoCodeInfo", data);
      processPromotionInfo(data);

    }).error(function(data, status, headers, config) {

    });
  }
  $rootScope.$watch('promotionInfo', function(newValue, oldValue, scope) {
    if (newValue) {

      var promoInfo = ohgre.store("promoCodeInfo");

      if ($rootScope.hashParams.isExpired) {
        if (promoInfo.LDCList.length > 0) {
          var ldc = promoInfo.LDCList[0];
          var promotion = ldc.promotion[0];
          if (promotion.BackupPromotionCode) {
            getBackupPromoCodeInfo(promotion.BackupPromotionCode);
          } else {
            processPromotionInfo(promoInfo);
          }
        }

      } else {
        processPromotionInfo(promoInfo);
      }
    }
  });


  var getQuotesForViewPlans = function() {

    var ldcCode = $('#fixed-plans-button').val();

    /*  if( $scope.promotion &&  $scope.promotion.RateClassCode){
            $scope.rateClassCode=$scope.promotion.RateClassCode;
        }

        if(!$scope.rateClassCode){
            $scope.rateClassCode = "01";
        }*/

    PrimeService.getQuotes(ldcCode, $scope.promotion.PromotionCode, $scope.rateClassCode).success(function(data, status, headers, config) {
      $scope.Quotes = data;
      if ($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length > 0) {
        $scope.displayPlans = true;
        $scope.Customer = $scope.Quotes.Customer;
        var customer = $scope.Customer[0];


        var getQuotesProductsList = [];

        for (var i = 0; i < customer.Product.length; i++) {
          if ($rootScope.prmoProduct.indexOf(customer.Product[i].ProductCode) != -1) {
            getQuotesProductsList.push(customer.Product[i]);

          }

        };
        $scope.products = getQuotesProductsList; //$scope.Customer[0].Product;

        updateProductFinePrint();
        setTimeout(function() {
          $rootScope.bindAccordian();
        }, 10);


      } else {}

    }).error(function(data, status, headers, config) {

    });

  }

  $scope.displayGuranteedAccord = false;
  $scope.displayAddlInfo = function(product) {
    if (product != undefined) {

      if (product.displayAccordian == undefined) {
        product.displayAccordian = true;
      } else if (product.displayAccordian) {
        product.displayAccordian = false;
      } else if (!product.displayAccordian) {
        product.displayAccordian = true;
      }
    } else {
      $scope.displayGuranteedAccord = $scope.displayGuranteedAccord ? false : true;
    }

    // alert(product.displayAccordian);
    //    $scope.displayAdditionalInfo = $scope.displayAdditionalInfo ? false : true;

  }

  $rootScope.$watch('prmoProduct', function(newValue, oldValue, scope) {

    if (newValue && newValue.length > 0) {
      getQuotesForViewPlans();
    }
  });

  $scope.viewPlans = function() {

    var ldcCode = $('#fixed-plans-button').val();

    var locationType = $("input[name='location_type']:checked").val();
    if (locationType == "residential") {
      $scope.rateClassCode = "01";
    } else if (locationType == "commercial") {
      $scope.rateClassCode = "04";

    }

    if (ldcCode) {

      if ($scope.ldcInfo && $scope.ldcInfo.LDCList && $scope.ldcInfo.LDCList.length > 0) {

        /*  for(var i=0;i<$scope.ldcInfo.LDCList.length;i++){
                    if(ldcCode==$scope.ldcInfo.LDCList[i].LDCCode){

						$scope.rateClassCode=$scope.ldcInfo.LDCList[i].promotion[0].RateClassCode;
                        if($scope.ldcInfo.LDCList[i].promotion[0].RateClassCode.length==0){
                            var promoInfo=ohgre.store("promoCodeInfo");
                          var locationType=promoInfo.locationType;
                            if(locationType=="residential"){
								$scope.rateClassCode="01";
                            }else if(locationType=="commercial"){
								$scope.rateClassCode="04";
                            }
                        }
                        break;
                    }
                }*/


        //if($scope.rateClassCode.length ==0){

        // }

      }

      var promotionCode = null;
      if ($scope.promotion && $scope.promotion.PromotionCode) {
        if ($scope.promotion.PromotionExpired == "Y") {
          promotionCode = $scope.promotion.BackupPromotionCode;
        } else {
          promotionCode = $scope.promotion.PromotionCode;

        }
      }

      $rootScope.getPromoCodeInfoForEnroll(ldcCode);

      /*  if( $scope.promotion &&  $scope.promotion.RateClassCode){
				$scope.rateClassCode=$scope.promotion.RateClassCode;
            }
*/
      /*
			PrimeService.getQuotes(ldcCode,promotionCode,$scope.rateClassCode).success(function(data, status, headers, config){
                 $scope.Quotes=data;
                 if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                     $scope.displayPlans = true;
                     $scope.Customer=$scope.Quotes.Customer;

					var customer=$scope.Customer[0];
						var getQuotesProductsList=[];

                          for(var i=0;i<customer.Product.length;i++){
                              if($rootScope.prmoProduct.indexOf(customer.Product[i].ProductCode) !=-1){
								getQuotesProductsList.push(customer.Product[i]);

                              }

                          };
		            $scope.products=getQuotesProductsList;//$scope.Customer[0].Product;

                    // $scope.products=$scope.Customer[0].Product;
                     updateProductFinePrint();
                     setTimeout(function(){ $rootScope.bindAccordian(); }, 10);

                 }else{

                 }

             }).error(function (data,status, headers, config){

             });
             */
    }

  }

  var updateProductFinePrint = function() {

    angular.forEach($scope.products, function(value, key) {
      var ProductFinePrintText = value.ProductFinePrintText.split(".");
      var lastword = ProductFinePrintText[ProductFinePrintText.length - 1];
      if (!(lastword.length > 1))
        ProductFinePrintText.pop();
      $scope.products[key].ProductFinePrintText = ProductFinePrintText;
    });

  }




  PrimeService.getLdcInfo().success(function(data, status, headers, config) {
    if (data && data.responseStatus == "0") {
      $scope.ldcinfo = data.LDCList;
      setTimeout(function() {
        $rootScope.bindClickEvent();
      }, 10);
    }

  }).error(function(data, status, headers, config) {


  });

  if ($rootScope.hashParams.isExpired) {
    $rootScope.expired = true;
  }

  $rootScope.$watch('ldcForEnrollPromo', function(newValue, oldValue, scope) {
    if (newValue) {
      //$scope.promotioncode = newValue.toUpperCase();
      if ($rootScope.enrollLdc && $rootScope.enrollLdc.LDCCode) {
        $rootScope.getPromoCodeInfoForEnroll($rootScope.enrollLdc.LDCCode);
      }

    }
  }, true);

    $scope.getDisplayPromocode = function(promocode){
        if(promocode){
			var index=promocode.indexOf("ONLINE");
            if(index != -1){
			return promocode.substr(0,index);
            }else{
				return promocode;
            }
        }else{ return "";

        }


    }


}]);
