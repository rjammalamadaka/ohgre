ohgrePortal.controller('TermsLandingController', ['$scope', '$rootScope', '$http', '$window',function ($scope, $rootScope,$http,$window) {


    $scope.goBack = function(){

        //$window.history.back();

        if(document.referrer) {window.open(document.referrer,'_self');} else {history.go(-1);} return false;
    }
   

}]);

