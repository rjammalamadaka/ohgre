ohgrePortal.run(['$rootScope', '$compile', '$http','PrimeService',"OhGreService", function ($rootScope, $compile, $http,PrimeService,OhGreService){ 
    setTimeout(function(){ 
        $('#portalbody').show();
    }, 500);

     var portalname=$('#primary-header').data('portalname');
    $rootScope.portalname=portalname;
	$rootScope.homeUrl=null;
    if(portalname == "oh"){
		$rootScope.homeUrl="/content/onlyong";
    }else{
		$rootScope.homeUrl="/content/gre";
    }

     $rootScope.hashParams = {};

    var hashUrl=window.location.hash;
    hashUrl=decodeURIComponent(hashUrl);
    var hashParams = hashUrl && hashUrl.split("#")[1] && hashUrl.split("#")[1].split('&');
    for(var i=0;i<hashParams.length;i++){
        var param = hashParams[i].split("=")
		$rootScope.hashParams[param[0]]=param[1];
    }

    function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

     $rootScope.queryParams = {};
    var queryParams = window.location.search && window.location.search.split("?")[1] && window.location.search.split("?")[1].split('&');
    for(var i=0;i<queryParams.length;i++){
        var param = queryParams[i].split("=")
        $rootScope.queryParams[param[0]]=param[1];
    }
    if($rootScope.queryParams && !isEmpty($rootScope.queryParams)){
		$rootScope.hashParams=$rootScope.queryParams;
    }

    $rootScope.cardpromobuttonclick =function(url){
		location.href=url+'.html'
    }
    $rootScope.navigationclick =function(url){
			location.href=$rootScope.homeUrl+"/"+url;
    }

     $rootScope.getNumber =function(QuoteDescription){

         if(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }
         }

    } 



     $rootScope.bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            $rootScope.ldcDesc= obj.context.innerText;
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});



    }

     $rootScope.maintext="from angular";


     var config = {
        responsetype : 'json',
        headers : {
            'Content-Type' :'application/json'
        }
    }

    $rootScope.planSelect =function(product){

        var url='/bin/setProductData';
        var req={};
        req.QuoteDescription=product.QuoteDescription;
		req.ProductDescription=product.ProductDescription;
        req.ProductCode=product.ProductCode;
        req.LdcDesc=$rootScope.ldcDesc;
		req.FixedPricePerTherm=product.FixedPricePerTherm;

		var ldc=null;
        var ldcbutton=$('#fixed-plans-button');
        var promoInfo=ohgre.store("promoCodeInfo");
        if(ldcbutton && ldcbutton.length>0){
			ldc=$(ldcbutton[0]).val();
        }

        if($rootScope.hashParams && $rootScope.hashParams.ldc){
			req.LDC=$rootScope.hashParams.ldc;
        }
        if(ldc){
        	req.LDC=ldc;
            if(!req.LdcDesc){
					req.LdcDesc=$rootScope.ldcInfo.LDCDesc;
            }
        }else{

            if(!req.LDC){
                if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0){
                    req.LDC=promoInfo.LDCList[0].LDCCode;
                    req.LdcDesc=promoInfo.LDCList[0].LDCDesc;
                }
            }else if(req.LDC && promoInfo && promoInfo.LDCList){
                for(var i=0;i<promoInfo.LDCList.length;i++){
					if(req.LDC ==promoInfo.LDCList[i].LDCCode)
                      req.LdcDesc= promoInfo.LDCList[i].LDCDesc;
                }

            }


        }

        if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0 && promoInfo.LDCList[0].promotion && promoInfo.LDCList[0].promotion.length>0){

               for(var i=0;i<promoInfo.LDCList.length;i++){
                   if(req.LDC ==promoInfo.LDCList[i].LDCCode){
                      //req.LdcDesc= promoInfo.LDCList[i].LDCDesc;
                       req.CustomerTypeCode=promoInfo.LDCList[i].promotion[0].CustomerTypeCode;
                   }
                }

            if(promoInfo.LDCList[0].promotion[0].RateClassCode.length>0){
			req.RateClassCode=promoInfo.LDCList[0].promotion[0].RateClassCode;	
            }else{
				req.RateClassCode="01";
            }
        }else{

  			if($rootScope.hashParams && $rootScope.hashParams.lctype){
                if($rootScope.hashParams.lctype =="residential"){
					req.RateClassCode ="01";
                }else if($rootScope.hashParams.lctype =="commercial"){
					req.RateClassCode ="04";
                }
            }
            if($rootScope.hashParams && $rootScope.hashParams.ldc){
               var ldcType=$("input[name='location_type']:checked"). val(); 
                if(ldcType=="residential"){
					req.RateClassCode ="01";
                }else if(ldcType =="commercial"){
					req.RateClassCode ="04";
                }

            }
            req.CustomerTypeCode="";

        }

        if($rootScope.hashParams && $rootScope.hashParams.referralcode){
			req.referralcode=$rootScope.hashParams.referralcode;
        }

         $http.post(url, req ,config).success(function(data, status, headers, config){

				location.href=$rootScope.homeUrl+"/customer_lookup.html"; 

         }).error(function (data,status, headers, config){

             console.log("error");
         });

    }

    $rootScope.footernavigation= function(url){
        if(portalname == "oh"){
            location.href=url;
        }else{
			url=url.replace("onlyong","gre");
            location.href=url;
        }
    }

    $rootScope.bindAccordian =function(){

        $('.accord-trigger').on('click',function(event){
            event.preventDefault();
            var obj = $(this);
            obj.toggleClass('accord-expanded');
        });
    }


$rootScope.currentYear=new Date().getFullYear();

    $rootScope.giftcardvalue="ddd";


    $rootScope.getNumberWithoutStar =function(QuoteDescription){

         if(QuoteDescription){

             if(QuoteDescription.indexOf("CCF")>0){
                 return("CCF");
             }else if(QuoteDescription.indexOf("MCF")>0){
                 return("MCF");
             }
         }

     }

    $rootScope.getOnlyDate =function(value){
        if(value){
        var date=new Date(value);
        var dd = date.getDate();
        var mm = date.getMonth()+1; //January is 0!
        var yyyy = date.getFullYear();
        if(dd<10){
            dd='0'+dd;
        } 
        if(mm<10){
            mm='0'+mm;
        } 
        return mm+'/'+dd+'/'+yyyy;
        }else{
		return "";
        }
    }

   /* var getLdcInfo=function(){
        PrimeService.getLdcInfo().success(function(data, status, headers, config){
            if(data && data.responseStatus =="0"){
                console.log(data.LDCList);
                $rootScope.ldcinfo=data.LDCList;
                setTimeout(function(){ $rootScope.loginPopupBindClickEvent(); }, 10);
            }


        }).error(function(data, status, headers, config){

        });
    }
*/
   /* $rootScope.myAccountCheck=function(url,name){

		console.log(name);
        if(name.indexOf('Account') != -1){
            getLdcInfo();
            jQuery("#login-popup-wrapper").addClass("show-popup");

        }else{

            location.href=url+".html";
        }
    }
*/

}]); 

/*

(function (global) {

    if(window.location.pathname.indexOf('customer_lookup.html') !=-1){

    if(typeof (global) === "undefined") {
        throw new Error("window is undefined");
    }

    var _hash = "!";
    var noBackPlease = function () {
        global.location.href += "#";

        // making sure we have the fruit available for juice (^__^)
        global.setTimeout(function () {
            global.location.href += "!";
        }, 50);
    };

    global.onhashchange = function () {
        if (global.location.hash !== _hash) {
            global.location.hash = _hash;
        }
    };

    global.onload = function () {            
        noBackPlease();

        // disables backspace on page except on input fields and textarea..
        document.body.onkeydown = function (e) {
            var elm = e.target.nodeName.toLowerCase();
            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea')) {
                e.preventDefault();
            }
            // stopping event bubbling up the DOM tree..
            e.stopPropagation();
        };          
    }

    }

})(window);


*/
