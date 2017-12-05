
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
           /*
            element[0].addEventListener('keydown', function(event) {

                if (!(event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {
                    if(exclude.indexOf(event.keyCode) < 0) {
						event.preventDefault();
                    }
                }

            });
            */
			element[0].addEventListener('input', function(event) {
                var reg = /^\d+$/;
                 /*
                var userInput = event.data.length;

				console.log('data length', userInput);


                if(!reg.test(event.data)){

                    var isnum = /^\d+$/.test(event.data);

                    if(!isnum) {
                    }

					$(element[0]).val(
                        function(index, value){
                            return value.substr(0, value.length - 1);
                    })

                }
                */
            });


        }
    }
});
ohgrePortal.directive('multipleEmails', function () {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function(scope, element, attrs, ctrl) {

            ctrl.$parsers.unshift(function(viewValue) {
                console.log('multipleEmails');
                console.log('viewValue', viewValue);

                var emails = viewValue.split(',');
                // loop that checks every email, returns undefined if one of them fails.
                //var re = /\S+@\S+\.\S+/;
                var re = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))){2,6}$/i;


                // angular.foreach(emails, function() {
                var validityArr = emails.map(function(str){
                    return re.test(str.trim());
                }); // sample return is [true, true, true, false, false, false]
                var atLeastOneInvalid = false;
                angular.forEach(validityArr, function(value) {
                    if(value === false)
                        atLeastOneInvalid = true;
                });
                if(!atLeastOneInvalid) {
                    // ^ all I need is to call the angular email checker here, I think.
                    ctrl.$setValidity('multipleEmails', true);
                    return viewValue;
                } else {
                    ctrl.$setValidity('multipleEmails', false);
                    return undefined;
                }

                // })
            });

			/*
            ctrl.$parsers.unshift(checkEmails);
      		ctrl.$formatters.unshift(checkEmails);

            function checkEmails(viewValue){
                if(viewValue){
                     var emails = viewValue.split(',');
                    // loop that checks every email, returns undefined if one of them fails.
                    var re = /\S+@\S+\.\S+/;
    
                    // angular.foreach(emails, function() {
                    var validityArr = emails.map(function(str){
                        return re.test(str.trim());
                    }); // sample return is [true, true, true, false, false, false]
                    var atLeastOneInvalid = false;
                    angular.forEach(validityArr, function(value) {
                        if(value === false)
                            atLeastOneInvalid = true;
                    });
                    if(!atLeastOneInvalid) {
                        // ^ all I need is to call the angular email checker here, I think.
                        ctrl.$setValidity('multipleEmails', true);
                        return viewValue;
                    } else {
                        ctrl.$setValidity('multipleEmails', false);
                        return undefined;
                    }
                }
                console.log('checkEmails');
            }
            */
        }
    };
})
ohgrePortal.directive('numbersOnly', function(){
   return {
     require: 'ngModel',
     link: function(scope, element, attrs, modelCtrl) {
       modelCtrl.$parsers.push(function (inputValue) {
           // this next if is necessary for when using ng-required on your input. 
           // In such cases, when a letter is typed first, this parser will be called
           // again, and the 2nd time, the value will be undefined
           if (inputValue == undefined) return '' 
           var transformedInput = inputValue.replace(/[^0-9]/g, ''); 
           if (transformedInput!=inputValue) {
              modelCtrl.$setViewValue(transformedInput);
              modelCtrl.$render();
           }         

           return transformedInput;         
       });
     }
   };
});