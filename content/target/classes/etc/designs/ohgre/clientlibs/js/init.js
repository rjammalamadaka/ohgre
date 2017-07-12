ohgrePortal.run(['$rootScope', '$compile', '$http', function ($rootScope, $compile, $http){
//initialization logic


     $rootScope.hashParams = {};
    var hashParams = window.location.hash && window.location.hash.split("#")[1] && window.location.hash.split("#")[1].split('&');
    for(var i=0;i<hashParams.length;i++){
        var param = hashParams[i].split("=")
		$rootScope.hashParams[param[0]]=param[1];
    }

}]); 
