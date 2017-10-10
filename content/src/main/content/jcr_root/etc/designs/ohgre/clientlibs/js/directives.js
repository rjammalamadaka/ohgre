
ohgrePortal.directive('ngFocus', [function() {
  var FOCUS_CLASS = "ng-focused";
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function(scope, element, attrs, ctrl) {
      ctrl.$focused = false;
      element.bind('focus', function(evt) {
        element.addClass(FOCUS_CLASS);
        scope.$apply(function() {ctrl.$focused = true;});
      }).bind('blur', function(evt) {
        element.removeClass(FOCUS_CLASS);
        scope.$apply(function() {ctrl.$focused = false;});
      });
    }
  }
}]);


ohgrePortal.directive('ngVisited', [function() {
  var VISITED_CLASS ="ng-visited";
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function(scope, element, attrs, ctrl) {
      ctrl.$focused = false;
      element.bind('focus', function(evt) {
        element.addClass(VISITED_CLASS);
        scope.$apply(function() {ctrl.$visited = true;});
      });
    }
  }
}]);
ohgrePortal.directive('restrictTo', function() {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var re = RegExp(attrs.restrictTo);
            var exclude = [8,13,9,46,38,40,37,39];
            element[0].addEventListener('keydown', function(event) {

                if (!(event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {
                    if(exclude.indexOf(event.keyCode) < 0) {
						event.preventDefault();
                    }
                }

            });


        }
    }
});