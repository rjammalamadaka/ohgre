ohgrePortal.controller('TermsLandingController', ['$scope', '$rootScope', '$http', '$window',function ($scope, $rootScope,$http,$window) {

     $scope.showfaq=true;


    $scope.goBack = function(){
        //$window.history.back();

        if(document.referrer) {window.open(document.referrer,'_self');} else {history.go(-1);} return false;
    }
    if(location.pathname.indexOf('faq')>0){

        $scope.showfaq=false;

    }

}]);

