ohgrePortal.directive('ngFocus', [function() {
  var FOCUS_CLASS = "ng-focused";
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function(scope, element, attrs, ctrl) {
      ctrl.$focused = false;
      element.bind('focus', function(evt) {
        element.addClass(FOCUS_CLASS);
        scope.$apply(function() {
          ctrl.$focused = true;
        });
      }).bind('blur', function(evt) {
        element.removeClass(FOCUS_CLASS);
        scope.$apply(function() {
          ctrl.$focused = false;
        });
      });
    }
  }
}]);


ohgrePortal.directive('ngVisited', [function() {
  var VISITED_CLASS = "ng-visited";
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function(scope, element, attrs, ctrl) {
      ctrl.$focused = false;
      element.bind('focus', function(evt) {
        element.addClass(VISITED_CLASS);
        scope.$apply(function() {
          ctrl.$visited = true;
        });
      });
    }
  }
}]);
ohgrePortal.directive('restrictTo', function() {
  return {
    restrict: 'A',
    link: function(scope, element, attrs) {
      var re = RegExp(attrs.restrictTo);
      var exclude = [8, 13, 9, 46, 38, 40, 37, 39];
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
ohgrePortal.directive('multipleEmails', function() {
  return {
    require: 'ngModel',
    restrict: 'A',
    link: function(scope, element, attrs, ctrl) {

      ctrl.$parsers.unshift(function(viewValue) {
        // console.log('multipleEmails');
        // console.log('viewValue', viewValue);

        var emails = viewValue.split(',');
        // loop that checks every email, returns undefined if one of them fails.
        //var re = /\S+@\S+\.\S+/;
        var re = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))){2,6}$/i;


        // angular.foreach(emails, function() {
        var validityArr = emails.map(function(str) {
          return re.test(str.trim());
        }); // sample return is [true, true, true, false, false, false]
        var atLeastOneInvalid = false;
        angular.forEach(validityArr, function(value) {
          if (value === false)
            atLeastOneInvalid = true;
        });
        if (!atLeastOneInvalid) {
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
ohgrePortal.directive('lettersOnly', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attrs, modelCtrl) {
      modelCtrl.$parsers.push(function(inputValue) {
        // this next if is necessary for when using ng-required on your input.
        // In such cases, when a letter is typed first, this parser will be called
        // again, and the 2nd time, the value will be undefined
        if (inputValue == undefined) return ''
        console.log('inputValue', inputValue);
        var transformedInput = inputValue.replace(/^[a-zA-Z ]+$/, '');
        if (transformedInput != inputValue) {
          modelCtrl.$setViewValue(transformedInput);
          modelCtrl.$render();
        }

        return transformedInput;
      });

      // element[0].addEventListener('input', function(event) {
      //   var reg = /^\d+$/;
      //
      //   var userInput;
      //
      //   if (event.data) {
      //     userInput = event.data.length;
      //     if (!reg.test(event.data)) {
      //
      //       var isnum = /^\d+$/.test(event.data);
      //
      //       if (!isnum) {}
      //
      //       $(element[0]).val(
      //         function(index, value) {
      //           return value.substr(0, value.length - 1);
      //         })
      //
      //     }
      //   }
      //
      // });


    }
  };
});
ohgrePortal.directive('noSpecials', function() {
  return {
      restrict: 'A',
      require: 'ngModel',
      link: function(scope, elem, attrs, ngModel) {
          ngModel.$parsers.push(function(viewValue) {
            var reg = /^[^`~!@#$%\^&*()_+={}|[\]\\:;"<>?,/1-9]*$/;
            // if view values matches regexp, update model value
            if (viewValue.match(reg)) {
              return viewValue;
            }
            // keep the model value as it is
            var transformedValue = ngModel.$modelValue;
            ngModel.$setViewValue(transformedValue);
            ngModel.$render();
            return transformedValue;
          });
      }
  };
});

ohgrePortal.directive('numbersOnly', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attrs, modelCtrl) {
      modelCtrl.$parsers.push(function(inputValue) {
        // this next if is necessary for when using ng-required on your input.
        // In such cases, when a letter is typed first, this parser will be called
        // again, and the 2nd time, the value will be undefined
        if (inputValue == undefined) return ''
        var transformedInput = inputValue.replace(/[^0-9]/g, '');
        if (transformedInput != inputValue) {
          modelCtrl.$setViewValue(transformedInput);
          modelCtrl.$render();
        }

        return transformedInput;
      });

      element[0].addEventListener('input', function(event) {
        var reg = /^\d+$/;

        var userInput;


        if (event.data) {
          userInput = event.data.length;
          console.log('data length', userInput);
          if (!reg.test(event.data)) {

            var isnum = /^\d+$/.test(event.data);

            if (!isnum) {}

            $(element[0]).val(
              function(index, value) {
                return value.substr(0, value.length - 1);
              })

          }
        }


      });

    }
  };
});
ohgrePortal.directive('noNumbers', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attrs, modelCtrl) {
      modelCtrl.$parsers.push(function(inputValue) {
        /*
        // this next if is necessary for when using ng-required on your input.
        // In such cases, when a letter is typed first, this parser will be called
        // again, and the 2nd time, the value will be undefined
        //console.log('inputValue', inputValue);
        if (inputValue == undefined) return ''
        var transformedInput = inputValue.replace(/[^0-9]/g, '');
        if (transformedInput != inputValue) {
          modelCtrl.$setViewValue(transformedInput);
          modelCtrl.$render();
        }

        return transformedInput;
        */
      });

      element[0].addEventListener('input', function(event) {
        var reg = /^\d+$/;

        var userInput;

        if (event.data) {
          console.log('event.data', event.data);
          userInput = event.data.length;
          console.log('data length', userInput);
          if (reg.test(event.data)) {
            console.log('we got a number...');

            var isnum = /^\d+$/.test(event.data);

            if (!isnum) {}

            $(element[0]).val(
              function(index, value) {
                return value.substr(0, value.length - 1);
              })
          }
        }
      });
    }
  };
});

ohgrePortal.directive('moveFocus', function() {
  function getCaretPosition(elem) {
    // Internet Explorer Caret Position
    if (document.selection && document.selection.createRange) {
      var range = document.selection.createRange();
      var bookmark = range.getBookmark();
      return bookmark.charCodeAt(2) - 2;
    }

    // Firefox Caret Position
    return elem.setSelectionRange && elem.selectionStart;
  }

  return {
    restrict: 'A',
    link: function(scope, elem, attr) {
      var tabindex = parseInt(attr.tabindex);
      var maxlength = parseInt(attr.maxlength);
      console.log(attr);

      elem.on('input, keydown', function(e) {
        maxlength = parseInt(attr.maxlength);
        tabindex = parseInt(attr.tabindex);

        var val = elem.val(),
          cp,
          code = e.which || e.keyCode;

        console.log('val.length', val.length);
        console.log('maxlength', maxlength);
        console.log('tabindex', tabindex);

        if (val.length === maxlength && [8, 37, 38, 39, 40, 46].indexOf(code) === -1) {

          var next = document.querySelectorAll('#input' + (tabindex + 1));
          next.length && next[0].focus();
          return;
        }

        cp = getCaretPosition(this);
        if ((cp === 0 && code === 46) || (cp === 1 && code === 8)) {
          var prev = document.querySelectorAll('#input' + (tabindex - 1));
          e.preventDefault();
          elem.val(val.substring(1));
          prev.length && prev[0].focus();
          return;
        }
      });
    }
  };
});

ohgrePortal.directive('autoNext', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attr, form) {
            var tabindex = parseInt(attr.tabindex);
            var maxLength = parseInt(attr.maxlength);
            //keypress
            element.on('keyup', function(e) {
                //if (element.val().length > maxLength-1) {
                if (element.val().length == element.attr('maxlength')) {
                    console.log('equal');
                    var next = angular.element(document.body).find('[tabindex=' + (tabindex+1) + ']');

                    console.log('next.disabled', next);

                    if (next.length > 0) {
                        next.focus();
                        return next.triggerHandler('keyup', { which: e.which});
                    }
                    else  {
                        return false;
                    }
                }
                return true;
            });

        }
    }
});
