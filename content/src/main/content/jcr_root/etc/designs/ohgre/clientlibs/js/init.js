ohgrePortal.run(['$rootScope', '$compile', '$http', 'PrimeService', "OhGreService", function($rootScope, $compile, $http, PrimeService, OhGreService) {

  var activeStates = ["ENROLLMENT ACTIVE", "ENROLLMENT PENDING", "ENROLLMENT REJECTED", "ENROLLMENT SENT WAITING FOR RESPONSE", "ENROLLMENT WAITING TO BE SENT"];


  var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

  $rootScope.currentMonth = months[new Date().getMonth()];
  $rootScope.currentYear = new Date().getFullYear();
  $rootScope.currentDate = new Date().getDate();


  setTimeout(function() {
    $('#portalbody').show();
  }, 500);

  var portalname = $('#primary-header').data('portalname');
  $rootScope.portalname = portalname;
  $rootScope.homeUrl = null;
  if (portalname == "oh") {
    $rootScope.homeUrl = "/content/onlyong";
  } else {
    $rootScope.homeUrl = "/content/gre";
  }

  $rootScope.hashParams = {};

  var hashUrl = window.location.hash;
  hashUrl = decodeURIComponent(hashUrl);
  var hashParams = hashUrl && hashUrl.split("#")[1] && hashUrl.split("#")[1].split('&');
  for (var i = 0; i < hashParams.length; i++) {
    var param = hashParams[i].split("=")
    $rootScope.hashParams[param[0]] = param[1];
  }

  function isEmpty(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key))
        return false;
    }
    return true;
  }

  $rootScope.queryParams = {};

  var queryurl = decodeURIComponent(window.location.search);
  queryurl = decodeURIComponent(queryurl);

  var queryParams = queryurl && queryurl.split("?")[1] && queryurl.split("?")[1].split('&');
  for (var i = 0; i < queryParams.length; i++) {
    var param = queryParams[i].split("=")
    $rootScope.queryParams[param[0]] = param[1];
  }
  if ($rootScope.queryParams && !isEmpty($rootScope.queryParams)) {
    $rootScope.hashParams = $rootScope.queryParams;
  }

  $rootScope.cardpromobuttonclick = function(url) {
    location.href = url + '.html'
  }
  $rootScope.navigationclick = function(url) {
    location.href = $rootScope.homeUrl + "/" + url;
  }

  $rootScope.getNumber = function(QuoteDescription) {

    if (QuoteDescription) {

      if (QuoteDescription.indexOf("CCF") > 0) {
        return ("Ccf");
      } else if (QuoteDescription.indexOf("MCF") > 0) {
        return ("Mcf");
      }
    }

  }



  $rootScope.bindClickEvent = function() {
    $('.select-option').on('click', function(event) {
      event.preventDefault();
      var obj = $(this);
      var val = obj.html();
      $rootScope.ldcDesc = obj.context.innerText;
      $('.expanded-dropdown.opened').removeClass('opened');
      var dropdownButton = obj.parent().parent().parent().parent();
      var mainValue = $(this).find('span').attr('class');
      $(dropdownButton).find('.dropdown-trigger .value').html(val);
      $('#fixed-plans-button').val(mainValue);

    });



  }

  $rootScope.maintext = "from angular";


  var config = {
    responsetype: 'json',
    headers: {
      'Content-Type': 'application/json'
    }
  }

  $rootScope.planSelect = function(product) {

    var url = '/bin/setProductData';
    var req = {};
    req.QuoteDescription = product.QuoteDescription;
    req.ProductDescription = product.ProductDescription;
    req.ProductDescriptionFriendly = product.ProductDescFriendly;
    req.ProductCode = product.ProductCode;
    req.LdcDesc = $rootScope.ldcDesc;
    req.FixedPricePerTherm = product.FixedPricePerTherm;
    req.PriceChangeFrequency = product.PriceChangeFrequency;

    var ldc = null;
    var ldcbutton = $('#fixed-plans-button');
    var promoInfo = ohgre.store("promoCodeInfo");
    if (ldcbutton && ldcbutton.length > 0) {
      ldc = $(ldcbutton[0]).val();
    }

    if ($rootScope.hashParams && $rootScope.hashParams.ldc) {
      req.LDC = $rootScope.hashParams.ldc;
    }
    if (ldc) {
      req.LDC = ldc;
      if (!req.LdcDesc) {
        req.LdcDesc = $rootScope.ldcInfo.LDCDesc;
      }
    } else {

      if (!req.LDC) {
        if (promoInfo && promoInfo.LDCList && promoInfo.LDCList.length > 0) {

          for (var i = 0; i < promoInfo.LDCList.length; i++) {
            ldc = promoInfo.LDCList[i];
            var promotion = ldc.promotion[0];
            if (promotion.PromotionExpired == "Y" && promotion.BackupPromotionCode.length > 0) {
              req.LDC = promoInfo.LDCList[i].LDCCode;
              req.LdcDesc = promoInfo.LDCList[i].LDCDesc;

              break;
            }
            if (promotion.PromotionExpired == "N") {
              req.LDC = promoInfo.LDCList[i].LDCCode;
              req.LdcDesc = promoInfo.LDCList[i].LDCDesc;

              break;
            }

          }


        }
      } else if (req.LDC && promoInfo && promoInfo.LDCList) {
        for (var i = 0; i < promoInfo.LDCList.length; i++) {
          if (req.LDC == promoInfo.LDCList[i].LDCCode)
            req.LdcDesc = promoInfo.LDCList[i].LDCDesc;
        }

      }


    }

    if (promoInfo && promoInfo.LDCList && promoInfo.LDCList.length > 0 && promoInfo.LDCList[0].promotion && promoInfo.LDCList[0].promotion.length > 0) {

      for (var i = 0; i < promoInfo.LDCList.length; i++) {
        if (req.LDC == promoInfo.LDCList[i].LDCCode) {
          //req.LdcDesc= promoInfo.LDCList[i].LDCDesc;
          req.CustomerTypeCode = promoInfo.LDCList[i].promotion[0].CustomerTypeCode;
        }
      }

      if (promoInfo.LDCList[0].promotion[0].RateClassCode.length > 0) {
        req.RateClassCode = promoInfo.LDCList[0].promotion[0].RateClassCode;
      } else {
        req.RateClassCode = "01";
      }
    } else {

      if ($rootScope.hashParams && $rootScope.hashParams.lctype) {
        if ($rootScope.hashParams.lctype == "residential") {
          req.RateClassCode = "01";
        } else if ($rootScope.hashParams.lctype == "commercial") {
          req.RateClassCode = "04";
        }
      }
      if ($rootScope.hashParams && $rootScope.hashParams.ldc) {
        var ldcType = $("input[name='location_type']:checked").val();
        if (ldcType == "residential") {
          req.RateClassCode = "01";
        } else if (ldcType == "commercial") {
          req.RateClassCode = "04";
        }

      }
      req.CustomerTypeCode = "";

    }



    var locationType = $("input[name='location_type']:checked").val();
    if (locationType) {
      if (locationType == "residential") {
        req.RateClassCode = "01";
      } else if (locationType == "commercial") {
        req.RateClassCode = "04";

      }
    }



    if ($rootScope.hashParams && $rootScope.hashParams.referralcode) {
      req.referralcode = $rootScope.hashParams.referralcode;
    }

    $http.post(url, req, config).success(function(data, status, headers, config) {

      location.href = $rootScope.homeUrl + "/customer_lookup.html";

    }).error(function(data, status, headers, config) {

    });

  }

  $rootScope.footernavigation = function(url) {
    if (portalname == "oh") {
      location.href = url;
    } else {
      url = url.replace("onlyong", "gre");
      location.href = url;
    }
  }

  $rootScope.bindAccordian = function() {

    $('.accord-trigger.trigger-arrow').off().on('click', function(event) {
      console.log('triggered');
      event.preventDefault();
      var obj = $(this);
      obj.toggleClass('accord-expanded');
      event.stopPropagation();
    });
  }


  $rootScope.currentYear = new Date().getFullYear();




  $rootScope.giftcardvalue = "ddd";


  $rootScope.getNumberWithoutStar = function(QuoteDescription) {

    if (QuoteDescription) {

      if (QuoteDescription.indexOf("CCF") > 0) {
        return ("CCF");
      } else if (QuoteDescription.indexOf("MCF") > 0) {
        return ("MCF");
      }
    }

  }

  $rootScope.getOnlyDate = function(value) {
    if (value) {
      var date = new Date(value);
      var dd = date.getDate();
      var mm = date.getMonth() + 1; //January is 0!
      var yyyy = date.getFullYear();
      if (dd < 10) {
        dd = '0' + dd;
      }
      if (mm < 10) {
        mm = '0' + mm;
      }
      return mm + '/' + dd + '/' + yyyy;
    } else {
      return "";
    }
  }

  $rootScope.getNextDayDate = function(value) {
    if (value) {
      var date = new Date(value);
      var dd = date.getDate() + 1;
      var mm = date.getMonth() + 1; //January is 0!
      var yyyy = date.getFullYear();
      if (dd < 10) {
        dd = '0' + dd;
      }
      if (mm < 10) {
        mm = '0' + mm;
      }
      return mm + '/' + dd + '/' + yyyy;
    } else {
      return "";
    }
  }

  $rootScope.getCustomerStatus = function(status) {

    if (activeStates.indexOf(status) != -1) {
        $rootScope.customerStatus="Active";
      return "Active";
    } else {
         $rootScope.customerStatus="Inactive";
      return "Inactive";
    }

  }

  $rootScope.commonLogout = function() {

    PrimeService.logout().success(function(data, status, headers, config) {
      location.href = $rootScope.homeUrl + ".html";
    }).error(function(data, status, headers, config) {

    });
  }


  $rootScope.isEmpty = function(obj) {
    for (var key in obj) {
      if (obj.hasOwnProperty(key))
        return false;
    }
    return true;
  }


  var metaList = document.getElementsByTagName("meta");
  for (var i = 0; i < metaList.length; i++) {
    if (metaList[i].getAttribute("property") == "og:url") {
      var url = metaList[i].getAttribute("content");
      metaList[i].content = location.origin + url;
    }
    if (metaList[i].getAttribute("property") == "og:image") {
      var image = metaList[i].getAttribute("content");
      metaList[i].content = location.origin + image;
    }
  }


  $rootScope.mobilenumber = $("#mobilenumber-div").data("mobilenumber");


  if ($rootScope.hashParams && $rootScope.hashParams.rateClassCode) {
    if ($rootScope.hashParams.rateClassCode.length > 0)
      $rootScope.rateClassCode = $rootScope.hashParams.rateClassCode;
  }

  $rootScope.IsIE = function() {
    if (navigator.userAgent.indexOf('MSIE') !== -1 || navigator.appVersion.indexOf('Trident/') > 0) {
      return true;
    } else {
      return false;
    }

  }

  if ($rootScope.IsIE()) {
    $http.get(location.href, {
      headers: {
        'Cache-Control': 'no-cache'
      }
    });
    //alert(navigator.userAgent);
  }

    $rootScope.getESTTimeFormat=function(){

        var d=new Date();
        var localOffset = d.getTimezoneOffset() * 60000;
        var localTime = d.getTime();
        var utc = localTime + localOffset;
        centralOffset=-6;
        utc=utc+(-6*3600000);
       // var utcTime=new Date(utc);

        var date=new Date(utc),
        hour = date.getHours(),
        minute = date.getMinutes(),
        second = date.getSeconds(),
        hourFormatted = hour % 12 || 12, 
        minuteFormatted = minute < 10 ? '0' + minute : minute,
        morning = hour < 12 ? " a.m." : " p.m.";
        currentmonth=months[date.getMonth()];
        currentdate=date.getDate();
        currentyear=date.getFullYear();

        return currentmonth+" "+currentdate +", "+currentyear+" / "+hourFormatted + ":" +minuteFormatted + morning+" CT";
    }

    var getDateFormat=function(date){
        var month=date.getMonth()+1;
        var day=date.getDate();
        var year=date.getFullYear();
        if(month<10){month='0'+month};
        if(day<10){day='0'+day};
        return month+'/'+day+'/'+year;
    }
    var date = new Date();
    var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
    var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0); 
    $rootScope.currentMonthFirstDay=getDateFormat(firstDay);
    $rootScope.currentMonthLastDay=getDateFormat(lastDay); 


}]);
