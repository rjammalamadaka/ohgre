ohgrePortal.controller('SignupController', ['$scope', '$rootScope', '$http', 'PrimeService', 'OhGreService', function($scope, $rootScope, $http, PrimeService, OhGreService) {


  $scope.signupsubmit = function() {

    $scope.signup.submited = true;
    if ($scope.signup.$valid) {
      document.getElementById("movingform").reset();
      $rootScope.email = $scope.email;

      jQuery('#popup1').addClass("show-popup");
      $('html').addClass('fixed-body');
    }

  }

  $('#close-window, .close-window-button').on('click', function(event) {
    event.preventDefault();
    jQuery('#popup1').removeClass("show-popup");
    $('html').removeClass('fixed-body');

  });

}]);

ohgrePortal.controller('SignupPopupController', ['$scope', '$rootScope', '$http', 'PrimeService', 'OhGreService', function($scope, $rootScope, $http, PrimeService, OhGreService) {

  $scope.signupfornewsletter = function() {


    $scope.movingform.submited = true;
    if ($scope.movingform.$valid) {



      var req = {};

      req.firstname = $scope.firstname;
      req.lastname = $scope.lastname;
      req.email = $scope.email;
      // req.phone="";
      //	req.contactpermission="";
      req.addressone = $scope.addressone;
      req.addresstwo = $scope.addresstwo;
      req.addresscity = $scope.addresscity;
      req.addressstate = $scope.addressstate;
      req.addresszip = $scope.addresszip;
      req.sendemails = true;

      // req.hearaboutus= "";
      req.fromsignup = true;
      if ($rootScope.portalname == 'oh') {
        req.partner = "ONG";
      } else {
        req.partner = "GRE";
      }

      PrimeService.moving(req).success(function(data, status, headers, config) {

        $scope.flag = false;
        if (data.resultCode == "0") {
          jQuery('#popup1').removeClass("show-popup");
          jQuery('#popup2').addClass("show-popup");
        }

      }).error(function(data, status, headers, config) {

        $scope.flag = false;
      });

    }
  }


  $('#close-window, .close-window-button').on('click', function(event) {
    event.preventDefault();
    jQuery('#popup2').removeClass("show-popup");
    location.href = $rootScope.homeUrl + ".html";
  });

}]);
