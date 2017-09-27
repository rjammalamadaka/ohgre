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
        if(ldc){
        	req.LDC=ldc;
            if(!req.LdcDesc){
					req.LdcDesc=$rootScope.ldcInfo.LDCDesc;
            }
        }else{

            if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0){
				req.LDC=promoInfo.LDCList[0].LDCCode;
                req.LdcDesc=promoInfo.LDCList[0].LDCDesc;
            }else{

            }

        }

        if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0 && promoInfo.LDCList[0].promotion && promoInfo.LDCList[0].promotion.length>0){
			req.CustomerTypeCode=promoInfo.LDCList[0].promotion[0].CustomerTypeCode;
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

    }


}]); 

