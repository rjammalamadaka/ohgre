ohgrePortal.controller('ReferAFriendController', ['$scope', '$rootScope', '$http', 'PrimeService', 'OhGreService', function($scope, $rootScope, $http, PrimeService, OhGreService) {

  $scope.step2 = false;

  var updateCustomerInfoReq = {};
  var bindClickEvent = function() {
    $('.select-option').on('click', function(event) {
      event.preventDefault();
      var obj = $(this);
      var val = obj.html();
      $('.expanded-dropdown.opened').removeClass('opened');
      var dropdownButton = obj.parent().parent().parent().parent();
      var mainValue = $(this).find('span').attr('class');
      var description = $(this).find('span').text();
      $(dropdownButton).find('.dropdown-trigger .value').html(val);
      $scope.setLdcInfo(mainValue, description);
      $('#fixed-plans-button').val(mainValue);

      $scope.errorInfo = null;
      $scope.$apply();

    });
      /*
	$('#COH').focus(function(e) {
        if($scope.ldc == 'COH') {
			var cgoMask = new IMask(document.getElementById('COH'), {
                mask: '000000000-000-{\\0\\0\\0}-0',
           lazy: false,
           //placeholderChar: 'X'
           }).on('accept', function() {
           document.getElementById('COH').classList.remove('complete');
           }).on('complete', function() {
                document.getElementById('COH').classList.add('complete');
           });

        }
    });
      $('#DEO').focus(function(e) {
        if($scope.ldc == 'DEO') {
			   var deoMask = new IMask(document.getElementById('DEO'), {
               mask: '0-0000-0000-0000',
               lazy: false,
               //placeholderChar: 'X'
               }).on('accept', function() {
               document.getElementById('DEO').classList.remove('complete');
               }).on('complete', function() {
               document.getElementById('DEO').classList.add('complete');
          });
            //$('#abcd').inputmask("999999999-999-{000}-0");
        }
    });
      $('#VED').focus(function(e) {
        if($scope.ldc == 'COH') {
			var cgoMask = new IMask(document.getElementById('VED'), {
                mask: '{\\0\\3}-000000000-0000000-\\0',
           lazy: false,
           //placeholderChar: 'X'
           }).on('accept', function() {
           document.getElementById('VED').classList.remove('complete');
           }).on('complete', function() {
                document.getElementById('VED').classList.add('complete');
           });

        }
    });
      $('#DUK').focus(function(e) {
        if($scope.ldc == 'DUK') {
			var cgoMask = new IMask(document.getElementById('DUK'), {
                mask: '0-0000-0000-0000',
           lazy: false,
           //placeholderChar: 'X'
           }).on('accept', function() {
           document.getElementById('DUK').classList.remove('complete');
           }).on('complete', function() {
                document.getElementById('DUK').classList.add('complete');
           });

        }
    });
    */
  }


  var togglePopup = function(p) {
    var popupObj = $(p);
    if(popupObj.hasClass('show-popup')) {
      UTILS.allowBodyScroll();
    }
    else {
      UTILS.preventBodyScroll();
    }
    popupObj.toggleClass('show-popup')
  }

  jQuery('.terms-test').click(function() {
    togglePopup('#raf-terms-popup');
  });

  $rootScope.termsupdate = false;
  $rootScope.redirecttohome = function() {
    //location.href=$rootScope.homeUrl+".html";
    //jQuery("#raf-terms-popup").removeClass("show-popup");
    togglePopup('#raf-terms-popup');
    jQuery("#login-inactive-popup").addClass("show-popup");
  }

  $rootScope.closeDeclinePopup = function() {

    jQuery("#login-inactive-popup").removeClass("show-popup");
  }
  $scope.setLdcInfo = function(ldc, description) {
    $scope.ldc = ldc;
    $scope.ldcdesc = description;
    $scope.an1 = null;
    $scope.an2 = null;
    $scope.an3 = null;
    $scope.an4 = null;

    $scope.an1r = false;
    $scope.an3r = false;
    $scope.an4r = false;

    $scope.an1required = true;
    $scope.an2required = true;
    $scope.an3required = true;
    $scope.an4required = true;


    if (ldc == "COH") {
      $scope.an1minl = "8";
      $scope.an2minl = "3";
      $scope.an3minl = "3";
      $scope.an4minl = "1";
      $scope.an3 = "000";
      $scope.an3r = true;


    } else if (ldc == "DUK") {
      $scope.an1minl = "4";
      $scope.an2minl = "4";
      $scope.an3minl = "2";
      $scope.an4minl = "1";

    } else if (ldc == "DEO") {
      $scope.an1minl = "1";
      $scope.an2minl = "4";
      $scope.an3minl = "4";
      $scope.an4minl = "4";

    } else if (ldc == "VED") {
      $scope.an1minl = "2";
      $scope.an2minl = "9";
      $scope.an3minl = "7";
      $scope.an4minl = "1";
      $scope.an1 = "03";
      $scope.an4 = "0";
      $scope.an1r = true;
      $scope.an4r = true;

    } else if (ldc == "MCG") {
      $scope.an1minl = "4";
      $scope.an2minl = "3";
      $scope.an3minl = "4";
      $scope.an4minl = "1";

    } else if (ldc == "MIC") {
      $scope.an1minl = "0";
      $scope.an2minl = "0";
      $scope.an3minl = "0";
      $scope.an4minl = "13";

      $scope.an1required = false;
      $scope.an2required = false;
      $scope.an3required = false;
    }

    $scope.raf.submited = false;
    $scope.raf.lastname.$visited = false;
    $scope.lastname = null;
    // $scope.raf.$setUntouched();
    $scope.raf.$setPristine();
    $scope.$apply();
  }

  PrimeService.getLdcInfo().success(function(data, status, headers, config) {
    if (data && data.responseStatus == "0") {
      $scope.ldcinfo = data.LDCList;
      setTimeout(function() {
        bindClickEvent();
      }, 10);
    }

  }).error(function(data, status, headers, config) {


  });

  $scope.referafriendsubmit = function() {
//$(".accountnumber").val("");
  var ldc = jQuery('#fixed-plans-button').val();
       $('.accountnumber').hide();
    if (ldc) {

        if(ldc=="COH"){
			$('#coh-accno').show();
        }

        if(ldc=="DEO"){
			$('#deo-accno').show();
        }

        if(ldc=="DUK"){
			$('#duk-accno').show();
        }

        if(ldc=="VED"){
			$('#ved-accno').show();
        }
        if(ldc=="MCG"){
			$('#mcg-accno').show();
        }

        if(ldc=="MIC"){
			$('#mic-accno').show();
        }
    }

      $scope.step2 = true;

  }

  $scope.referafriendcancel = function() {

      $("#raf-account-number").val("");
       $("#accountnumberinvalid").hide();
    $scope.errorInfo = null;
    $scope.step2 = false;

  }
     var req = {};




  $scope.referafriendstep2submit = function() {
 $("#accountnumberinvalid").hide();
    $scope.raf.submited = true;
    $scope.errorInfo = null;
    if (isAccountNumberValid($scope.ldc) && $scope.raf.$valid) {
	var accno=getAccountNumber($scope.ldc);;

      /*if ($scope.ldc == "DUK") {
        req.AccountNumber = $scope.an1 + $scope.an2 + $scope.an3;
      } else if ($scope.ldc == "VED") { 
        req.AccountNumber = $scope.an2 + $scope.an3;
      } else if ($scope.ldc == "MIC") {
        req.AccountNumber = $scope.an4;
      } else {
        req.AccountNumber = $scope.an1 + $scope.an2 + $scope.an3 + $scope.an4;
      }*/
      var accountNumberForBE= accno.replace(/\-/g, "");

        if($scope.ldc=="DUK"){
        	accountNumberForBE=accountNumberForBE.substring(0,accountNumberForBE.length-1);
        }
        if($scope.ldc=="VED"){
        	accountNumberForBE=accountNumberForBE.substring(2,accountNumberForBE.length-1);
        }

      req.AccountNumber= accountNumberForBE;
      req.LDC = $scope.ldc;

      PrimeService.getCustomerInfo(req).success(function(data, status, headers, config) {
        if (data && data.CustomerInfoResult) {
          var customerInfo = JSON.parse(data.CustomerInfoResult);
          if (customerInfo.responseStatus == 1) {
            $scope.step2 = false;
            $scope.errorInfo = "We were unable to find your account. Please try again or call " + $scope.mobilenumber + " for assistance";

          } else if (customerInfo.responseStatus == 0) {
            var regex = /[^a-zA-Z]/g;
            var businessName = customerInfo.businessName;
            businessName = businessName.replace(regex, "");
            var lastName = $scope.lastname.replace(regex, "");
            businessName = businessName.substring(0, 5);
            lastName = lastName.substring(0, 5);

            if ((customerInfo.rateClass == "01" && $scope.lastname.toUpperCase() == customerInfo.lastName.toUpperCase()) || (customerInfo.rateClass == "04" && lastName.toUpperCase() == businessName.toUpperCase())) {

              if (customerInfo.raftermsCondAcknowledgedInd != "Y") {

                if (customerInfo.raftermsCondAcknowledgedInd == "N") {
                  $rootScope.termsupdate = false;
                } else if (customerInfo.raftermsCondAcknowledgedInd == "R") {
                  $rootScope.termsupdate = true;

                }
                //jQuery('#raf-terms-popup').addClass('show-popup');
                togglePopup('#raf-terms-popup');
                updateCustomerInfoReq.custID = customerInfo.custID;
                updateCustomerInfoReq.account = customerInfo.account;
                updateCustomerInfoReq.ldc = customerInfo.ldc;
              } else if (customerInfo.raftermsCondAcknowledgedInd == "Y") {
                setProductData();
              }
            } else {
              $scope.errorInfo = "We found an account that matches the account number but not the last name. For further inquiries, please call " + $scope.mobilenumber + ".";

            }
          }
        }

      }).error(function(data, status, headers, config) {


      });

    }
  }

  var setProductData = function() {
    PrimeService.setProductData(req).success(function(data, status, headers, config) {

      location.href = $rootScope.homeUrl + '/raf-authenticated.html';

    }).error(function(data, status, headers, config) {


    });

  }

  $rootScope.acceptrafterms = function() {
    updateCustomerInfoReq.RAFTermsCondAcknowledgedInd = "Y";
    jQuery('#popup-spinner-wrap').show();
    PrimeService.rafUpdateCustomerInfo(updateCustomerInfoReq).success(function(data, status, headers, config) {

      jQuery('#popup-spinner-wrap').hide();
      if (data.ResponseStatus == 0) {
        setProductData();
      }
    }).error(function(data, status, headers, config) {
      jQuery('#popup-spinner-wrap').hide();

    });
  }
  $rootScope.closeacceptrafterms = function() {
    //jQuery('#raf-terms-popup').removeClass('show-popup');
    togglePopup('#raf-terms-popup');
  }
  jQuery('#close-window').click(function() {
    // jQuery('#raf-terms-popup').removeClass('show-popup');
    togglePopup('#raf-terms-popup');
  });


  if ($rootScope.hashParams && $rootScope.hashParams.refferalcode) {
    jQuery('#popup-spinner-wrap').show();

    var req = {};
    req.custId = $rootScope.hashParams.refferalcode;

    PrimeService.getCustomerInfo(req).success(function(data, status, headers, config) {
      if (data && data.CustomerInfoResult) {
        var customerInfo = JSON.parse(data.CustomerInfoResult);

        if (customerInfo.responseStatus == 1) {
          $scope.errorInfo = "We were unable to find your account. Please try again or call " + $scope.mobilenumber + " for assistance";
          jQuery('#popup-spinner-wrap').hide();
        } else if (customerInfo.responseStatus == 0) {
          //var req={};

          req.LDC = customerInfo.ldc;
          req.LdcDesc = customerInfo.ldcdesc;
          req.AccountNumber = customerInfo.account;
          req.referralcode = customerInfo.custID;
          req.ProductDescription = customerInfo.productDesc;
          req.ProductCode = customerInfo.productCode;

          if (customerInfo.raftermsCondAcknowledgedInd != 'Y') {
            jQuery('#popup-spinner-wrap').hide();
            updateCustomerInfoReq.custID = customerInfo.custID;
            updateCustomerInfoReq.account = customerInfo.account;
            updateCustomerInfoReq.ldc = customerInfo.ldc;

            //jQuery('#raf-terms-popup').addClass('show-popup');
            togglePopup('#raf-terms-popup');
          } else {

            PrimeService.setProductData(req).success(function(data, status, headers, config) {

              location.href = $rootScope.homeUrl + '/raf-authenticated.html';

            }).error(function(data, status, headers, config) {


            });
          }
        }
      } else {
        jQuery('#popup-spinner-wrap').show();
      }

    }).error(function(data, status, headers, config) {
      jQuery('#popup-spinner-wrap').hide();

    });

  }





}]);



if(document.getElementById('coh-accno')){
//setTimeout(function(){
var cohMask = new IMask(document.getElementById('coh-accno'), {
      mask: '00000000-000-{\\0\\0\\0}-0',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('coh-accno').classList.remove('complete');
}).on('complete', function() {
    document.getElementById('coh-accno').classList.add('complete');
     $("#accountnumberinvalid").hide();
});

var deoMask = new IMask(document.getElementById('deo-accno'), {
      mask: '0-0000-0000-0000',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('deo-accno').classList.remove('complete');
}).on('complete', function() {
     $("#accountnumberinvalid").hide();
    document.getElementById('deo-accno').classList.add('complete');
});

var dueoMask = new IMask(document.getElementById('duk-accno'), {
      mask: '0000-0000-00-0',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('duk-accno').classList.remove('complete');
}).on('complete', function() {
     $("#accountnumberinvalid").hide();
    document.getElementById('duk-accno').classList.add('complete');
});

var vedMask = new IMask(document.getElementById('ved-accno'), {
      mask: '{\\0\\3}-000000000-0000000-\\0',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('ved-accno').classList.remove('complete');
}).on('complete', function() {
     $("#accountnumberinvalid").hide();
    document.getElementById('ved-accno').classList.add('complete');
});

var mcgMask = new IMask(document.getElementById('mcg-accno'), {
      mask: '0000-000-0000-0',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('mcg-accno').classList.remove('complete');
}).on('complete', function() {
     $("#accountnumberinvalid").hide();
    document.getElementById('mcg-accno').classList.add('complete');
});

var micMask = new IMask(document.getElementById('mic-accno'), {
      mask: '0000000000000',
      lazy: false,
      placeholderChar: 'X'
}).on('accept', function() {
    document.getElementById('mic-accno').classList.remove('complete');
}).on('complete', function() {
     $("#accountnumberinvalid").hide();
    document.getElementById('mic-accno').classList.add('complete');
});

}

//}, 3000);