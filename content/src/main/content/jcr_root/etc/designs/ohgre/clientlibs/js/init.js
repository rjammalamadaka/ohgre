ohgrePortal.run(['$rootScope', '$compile', '$http', function ($rootScope, $compile, $http){
//initialization logic

     var portalname=$('#primary-header').data('portalname');
    $rootScope.portalname=portalname;

  if(portalname && (portalname =='oh')){
    	$rootScope.ldcList=[{name:'COH',value:'Columbia Ohio'},{name:'DUK',value:'Duke Energy Ohio'},{name:'DEO',value:'Dominion East Ohio'},{name:'VED',value:'Vectren Energy Delivery of Ohio'}];

    }else{
		$rootScope.ldcList=[{name:'MCG',value:'DTE Gas Company'},{name:'MIC',value:'Consumers Energy'}]
    }

     $rootScope.hashParams = {};
    var hashParams = window.location.hash && window.location.hash.split("#")[1] && window.location.hash.split("#")[1].split('&');
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

}]); 
