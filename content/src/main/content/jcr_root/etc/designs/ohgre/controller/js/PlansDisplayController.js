ohgrePortal.controller('PlansDisplayController', ['$scope', '$rootScope', '$http', '$window', 'PrimeService', function($scope, $rootScope, $http, $window, PrimeService) {


  var config = {
    responsetype: 'json',
    headers: {
      'Content-Type': 'application/json'
    }
  }


  var isEmpty = function(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key))
        return false;
    }
    return true;
  }


  jQuery('#popup-spinner-wrap').show();

  $scope.displayPlans = true;

  $scope.guaranteeProductDisplay = false;

  var portalname = $rootScope.portalname;

  $("input[name=location_type][value='residential']").prop("checked", true);

  var getQuotes = function(ldcCode) {
    var locationType = $("input[name='location_type']:checked").val();
    //$window.sessionStorage.setItem('lcType', locationType);

    var promotionCode = $scope.promotionCode;
    var url = "/bin/getQuotes?portalName=" + portalname;
    if (ldcCode) {
      url = url + "&ldcCode=" + ldcCode;
    }
    if (promotionCode) {
      url = url + "&promotionCode=" + promotionCode;
    }
    if (locationType) {
      url = url + "&locationType=" + locationType;
    }

    $http.get(url).success(function(data, status, headers, config) {
      //goToByScroll();
      jQuery('#popup-spinner-wrap').hide();
      if (!isEmpty(data)) {

        $scope.Quotes = data;
        if ($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length > 0) {
          $scope.Customer = $scope.Quotes.Customer;
          $scope.products = $scope.Customer[0].Product;
          updateProductFinePrint();
          //$window.sessionStorage.setItem('products', angular.toJson($scope.products));
          $scope.displayPlans = true;
          setTimeout(function() {
            $rootScope.bindAccordian();
          }, 10);
        }

      } else {
        location.href = $rootScope.homeUrl + "/errors/500.html";
      }

    }).error(function(data, status, headers, config) {
      jQuery('#popup-spinner-wrap').hide();
      if (status == 404) {
        location.href = $rootScope.homeUrl + "/errors/404.html";
      } else {
        location.href = $rootScope.homeUrl + "/errors/500.html";
      }
    });

  }



  var updateProductFinePrint = function() {

    angular.forEach($scope.products, function(value, key) {


      if ($scope.products[key].ProductCode == "COJ" || $scope.products[key].ProductCode == "COK") {

        $scope.guaranteeProduct = $scope.products[key];


      }

      var ProductFinePrintText = value.ProductFinePrintText.split(".");
      var lastword = ProductFinePrintText[ProductFinePrintText.length - 1];
      if (!(lastword.length > 1))
        ProductFinePrintText.pop();
      $scope.products[key].ProductFinePrintText = ProductFinePrintText;

    });

  }

  var url = "/bin/getLDCInfoServlet?portalName=" + portalname;
  $http.get(url).success(function(data, status, headers, config) {
    if (data && data.responseStatus == "0") {
      $scope.ldcinfo = data.LDCList;
      if ($rootScope.hashParams && $rootScope.hashParams.ldc) {
        var currentLdc = $rootScope.hashParams.ldc;
        data.LDCList.forEach(function(entry) {
          if (currentLdc == entry.LDCCode) {
            $rootScope.ldcInfo = entry;
          }

        });

      }



      setTimeout(function() {


        $rootScope.bindClickEvent();
        //   $("#fixed-plans-button").html($scope.ldcInfo.LDCDesc);
        if ($scope.ldcInfo && $scope.ldcInfo.LDCDesc)
          $('.dropdown-trigger .value').html($scope.ldcInfo.LDCDesc);

      }, 10);


    }


  }).error(function(data, status, headers, config) {


  });



  if ($rootScope.hashParams.ldc) {
    $scope.ldc = $rootScope.hashParams.ldc;
    $('#fixed-plans-button').val($scope.ldc);
    // $('.dropdown-trigger .value').html($scope.ldc)
    ///$window.sessionStorage.setItem('ldcType', $scope.ldc);
  }

  if ($rootScope.hashParams.lctype) {
    $scope.lctype = $rootScope.hashParams.lctype;
    if ($scope.lctype == "commercial") {
      $("input[name=location_type][value='commercial']").prop("checked", true);
    }
    //$window.sessionStorage.setItem('lcType', $scope.lctype);
  } else {
    $scope.lctype = "residential";

    $("input[name=location_type][value='residential']").prop("checked", true);
    //$window.sessionStorage.setItem('lcType', $scope.lctype);
  }



  if ($scope.ldc) {

    if ($scope.ldc == "COH") {

      $scope.guaranteeProductDisplay = true;


    }
    getQuotes($scope.ldc);
  }

  /*  for (i = 0; i < $rootScope.ldcList.length; i++) {
		var test=$rootScope.ldcList[i];
        if(test.name == $scope.ldc){
            var ldctext="<span>"+test.value+"</span>";
			$('#fixed-plans-button .value').html(ldctext);
            break;
        }
    }*/


  $scope.getNumber = function(QuoteDescription) {

    if (QuoteDescription.indexOf("CCF") > 0) {
      return ("Ccf");
    } else if (QuoteDescription.indexOf("MCF") > 0) {
      return ("Mcf");
    }

  }


  $scope.getPlans = function() {


    $scope.displayPlans = false;
    var ldcCode = $('#fixed-plans-button').val();

    if (ldcCode == "COH") {
      $scope.guaranteeProductDisplay = true;
    } else {
      $scope.guaranteeProductDisplay = false;
    }

    //$window.sessionStorage.setItem('ldcType', ldcCode);
    if (ldcCode) {

      var currentHash = location.hash;
      var currentLdc = $rootScope.hashParams.ldc;
      var locationType = $("input[name='location_type']:checked").val();
      var currentLocationType = $rootScope.hashParams.lctype;
      currentHash = currentHash.replace(currentLdc, ldcCode);
      currentHash = currentHash.replace(currentLocationType, locationType);
      $rootScope.hashParams.lctype = locationType;
      $rootScope.hashParams.ldc = ldcCode;
      location.hash = currentHash;
      jQuery('#popup-spinner-wrap').show();

      getQuotes(ldcCode);
    }
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

  $scope.showMobileAccord = function(product) {


    if (product != undefined) {
      if (product.displayMobAccord == undefined) {
        product.displayMobAccord = true;
      } else if (product.displayMobAccord) {
        product.displayMobAccord = false;
      } else if (!product.displayMobAccord) {
        product.displayMobAccord = true;
      }
    }

  }

  $scope.showMobileAccordGuarantee = function() {
    if ($scope.displayGuranteedAccord) {
      $scope.displayGuranteedAccord = false;
    } else {
      $scope.displayGuranteedAccord = true;
    }

  }

  $scope.showDeskAccordGuarantee = function() {
    consoloe.log($scope.displayGuranteedAccord);

    if ($scope.displayGuranteedAccord) {
      $scope.displayGuranteedAccord = false;
    } else {
      $scope.displayGuranteedAccord = true;
    }

  }

  var goToByScroll = function() {

    $('html,body').animate({
        scrollTop: $('.plan-detail').offset().top
      },
      'slow');
  }


  var getProductInfo = function() {
    var url = "/content/onlyong/product-configuration/jcr:content/content/productcontentconfig.json";
    $http.get(url).success(function(data, status, headers, config) {
      if (data && data.iItems) {
        $scope.productsInfo = data.iItems;
      }
    }).error(function(data, status, headers, config) {

    });

  }
  getProductInfo();

  $scope.getProductDescription = function(productCode) {
    var smallDesc = null;
    if ($scope.productsInfo && $scope.productsInfo.length > 0) {
      for (var i = 0; i < $scope.productsInfo.length; i++) {

        var product = null;
        try {
          product = JSON.parse($scope.productsInfo[i]);
        } catch (e) {}
        if (product && product.productcode && product.productcode == productCode) {
          smallDesc = product.description;
          break;
        }
      }

    }
    return smallDesc;
  }

}]);
