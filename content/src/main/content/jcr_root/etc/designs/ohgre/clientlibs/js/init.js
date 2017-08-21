ohgrePortal.run(['$rootScope', '$compile', '$http', function ($rootScope, $compile, $http){

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
        if(ldcbutton && ldcbutton.length>0){
			ldc=$(ldcbutton[0]).val();
        }
        if(ldc){
        	req.LDC=ldc;
            if(!req.LdcDesc){
					req.LdcDesc=$rootScope.ldcInfo.LDCDesc;
            }
        }else{
           var promoInfo=ohgre.store("promoCodeInfo");
            if(promoInfo && promoInfo.LDCList && promoInfo.LDCList.length>0){
				req.LDC=promoInfo.LDCList[0].LDCCode;
                req.LdcDesc=promoInfo.LDCList[0].LDCDesc;
            }else{

            }

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


}]); 
