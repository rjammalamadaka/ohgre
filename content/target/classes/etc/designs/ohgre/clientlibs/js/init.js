ohgrePortal.run(['$rootScope', '$compile', '$http', function ($rootScope, $compile, $http){
//initialization logic

     var portalname=$('#primary-header').data('portalname');
    $rootScope.portalname=portalname;

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

        if(portalname =='oh'){
			location.href="/content/onlyong/"+url;
        }else{
			location.href="/content/gre/"+url;
        }
    }

     $rootScope.getNumber =function(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }

    } 


     $rootScope.bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            console.log(val);
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
            //console.log(mainValue);
            // $(this).attr("value",mainValue);

			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});

    }

}]); 
