ohgrePortal.controller('TermsLandingController', ['$scope', '$rootScope', '$http', '$window',function ($scope, $rootScope,$http,$window) {


    $scope.goBack = function(){

        $window.history.back();
    }
   

}]);

