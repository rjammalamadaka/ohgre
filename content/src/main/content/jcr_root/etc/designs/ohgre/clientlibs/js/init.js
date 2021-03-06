ohgrePortal.run(['$rootScope', '$compile', '$http', 'PrimeService', "OhGreService", function($rootScope, $compile, $http, PrimeService, OhGreService) {

    var activeStates = ["ENROLLMENT ACTIVE", "ENROLLMENT PENDING", "ENROLLMENT REJECTED", "ENROLLMENT SENT WAITING FOR RESPONSE", "ENROLLMENT WAITING TO BE SENT"];

    var restrictedProductCodes=['COE','COF','DOE','DOF','VEE','VEF'];

    var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

    $rootScope.currentMonth = months[new Date().getMonth()];
    $rootScope.currentYear = new Date().getFullYear();
    $rootScope.currentDate = new Date().getDate();


    setTimeout(function() {
        $('#portalbody').show();
    }, 500);

    var portalname = $('#primary-header').data('portalname');
    $rootScope.portalname = portalname;

    if($rootScope.portalname !="oh" && $rootScope.portalname !="gre"){
        var hostname=location.hostname;
        if(hostname.indexOf("onlyong")!= -1){
            $rootScope.portalname="oh";
            portalname="oh";
        } else if(hostname.indexOf("grandrapidsenergy")!= -1){
            $rootScope.portalname="gre";
            portalname="gre";
        }else{
            $rootScope.portalname="oh";
            portalname="oh";
        }
    }
    $rootScope.homeUrl = null;
    if (portalname == "oh") {
        $rootScope.homeUrl = "/content/onlyong";
    } else {
        $rootScope.homeUrl = "/content/gre";
    }

    $rootScope.hashParams = {};

    var hashUrl = window.location.hash;
    hashUrl = decodeURIComponent(hashUrl);
    hashUrl=decodeURIComponent(hashUrl);
    hashUrl=decodeURIComponent(hashUrl);
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
    queryurl=decodeURIComponent(queryurl);
    queryurl=decodeURIComponent(queryurl);

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
      if(portalname !== "oh"){
        url=url.replace("onlyong","gre");
        }
      window.open(url), '_blank', 'height=100%,width=100%';

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

        if($rootScope.customerInfo && $rootScope.customerInfo.productCode){
            if(restrictedProductCodes.indexOf($rootScope.customerInfo.productCode)!= -1){
                // $scope.enrollReq.existingCustomerStatus="Inactive";
                //existingCustomerStatus="Inactive";
                return "Inactive";
            }
        }


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

    function calculate_time_zone() {
        var rightNow = new Date();
        var jan1 = new Date(rightNow.getFullYear(), 0, 1, 0, 0, 0, 0);
        var june1 = new Date(rightNow.getFullYear(), 6, 1, 0, 0, 0, 0);
        var temp = jan1.toGMTString();
        var jan2 = new Date(temp.substring(0, temp.lastIndexOf(" ")-1));
        temp = june1.toGMTString();
        var june2 = new Date(temp.substring(0, temp.lastIndexOf(" ")-1));
        var std_time_offset = (jan1 - jan2) / (1000 * 60 * 60);
        var daylight_time_offset = (june1 - june2) / (1000 * 60 * 60);
        var dst;
        if (std_time_offset == daylight_time_offset) {
            dst = "0";
        } else {
            var hemisphere = std_time_offset - daylight_time_offset;
            if (hemisphere >= 0)
                std_time_offset = daylight_time_offset;
            dst = "1";
        }
        var timeZone="T";
        if(std_time_offset=="-5")
            timeZone="ET";
        else if(std_time_offset=="-6")
            timeZone="CT";
        else if(std_time_offset=="-7")
            timeZone="MT";
        else if(std_time_offset=="-8")
            timeZone="PT";
        return timeZone;
    }

    $rootScope.getESTTimeFormat=function(){

        var d=new Date();
        var localOffset = d.getTimezoneOffset() * 60000;
        var localTime = d.getTime();
        var utc = localTime + localOffset;
        centralOffset=-6;
        utc=utc+(-6*3600000);
        // var utcTime=new Date(utc);

        //var date=new Date(utc),
        var date=new Date(),
            hour = date.getHours(),
            minute = date.getMinutes(),
            second = date.getSeconds(),
            hourFormatted = hour % 12 || 12,
            minuteFormatted = minute < 10 ? '0' + minute : minute,
            morning = hour < 12 ? " a.m." : " p.m.";
        currentmonth=months[date.getMonth()];
        currentdate=date.getDate();
        currentyear=date.getFullYear();

        return currentmonth+" "+currentdate +", "+currentyear+" / "+hourFormatted + ":" +minuteFormatted + morning+calculate_time_zone();
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

    $rootScope.getDisplayPromocode= function(promocode){
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

    $rootScope.resstdpromocode = $("#resstdpromocode-div").data("resstdpromocode");
    $rootScope.commstdpromocode = $("#commstdpromocode-div").data("commstdpromocode");

    if(!$rootScope.resstdpromocode || $rootScope.resstdpromocode.length==0){
        if(portalname =="oh")
         $rootScope.resstdpromocode=$("#stdpromocodes").data("ohstdrespromo");
         else if(portalname =="gre")
         $rootScope.resstdpromocode=$("#stdpromocodes").data("grestdrespromo");
    }
     if(!$rootScope.commstdpromocode || $rootScope.commstdpromocode.length==0){
        if(portalname =="oh")
         $rootScope.commstdpromocode=$("#stdpromocodes").data("ohstdcompromo");
         else if(portalname =="gre")
         $rootScope.commstdpromocode=$("#stdpromocodes").data("grestdcompromo");
    }


}]);



var getAccountNumber = function(ldc){

        if(ldc =="COH"){
          return $("#coh-accno").val();
        }
        if(ldc =="DEO"){
            return $("#deo-accno").val();
        }
        if(ldc =="DUK"){
           return $("#duk-accno").val();
        }
        if(ldc =="VED"){
          return $("#ved-accno").val();
        }
        if(ldc =="MCG"){
          return $("#mcg-accno").val();
        }
        if(ldc =="MIC"){
          return $("#mic-accno").val();
        }

    }



 var isAccountNumberValid = function(ldc){

        if(ldc =="COH"){
            if(!cohMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        if(ldc =="DEO"){
            if(!deoMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        if(ldc =="DUK"){
            if(!dueoMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        if(ldc =="VED"){
            if(!vedMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        if(ldc =="MCG"){
            if(!mcgMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        if(ldc =="MIC"){
            if(!micMask.masked.isComplete){
                $("#accountnumberinvalid").show();
                return false;
            }
        }
        return true;
    }