var buttonClick = false;

UTILS = {
    trim: function(str) {
        try {
            str = UTILS.ltrim( str );
            str = UTILS.rtrim( str );
            return str;
        } catch(ex) {
            console.log('UTIL.trim exception: ' + ex);
        }
    },
    rtrim: function( str ) {
        try {
            str = str.replace(/\s+$/g,'');
            return str;
        } catch(ex) {
            console.log('UTIL.rtrim exception: ' + ex);
        }
    },
    ltrim: function(str) {
        try {
            str = str.replace(/^\s+/g,'');
            return str;
        } catch(ex) {
            console.log('UTIL.ltrim exception: ' + ex);
        }
    },
    isMobileDevice: function() {
        var isMobileDevice = false;
        isMobileDevice = $(window).width() < 1024 ? true : false;
        return isMobileDevice;
    },
    preventBodyScroll: function() {
      $('body').addClass('fixed-body');
    },
    allowBodyScroll: function() {
      $('body').removeClass('fixed-body');
    },
};

var ohio_ng = {
  init: function() {
    this.listeners();
    this.socialButtons();
  },
  listeners: function() {

    $('.print-button').on('click', function(event) {
      event.preventDefault();
      window.print();
    });

    $('.trigger-popup').on('click', function(event) {
      event.preventDefault();
      $('.popup-wrapper').addClass('show-popup');
      $('body').addClass('fixed-body');

    });

    /*   $('.popup-wrapper,#close-window').on('click',function(event){
			event.preventDefault();
         $('.popup-wrapper').removeClass('show-popup');
      });
      */

    $('.close-window, .close-window-button').on('click', function(event) {
      event.preventDefault();
      $('.popup-wrapper').removeClass('show-popup');
      $('body').removeClass('fixed-body');
    });

    $('.tooltip-trigger').on('click', function(event) {
      event.preventDefault();
      $('.tooltip-text').toggleClass('tooltip-open');
    });
    $('.close-tooltip').on('click', function(event) {
      event.preventDefault();
      $('.tooltip-text').removeClass('tooltip-open');
      console.log('close tooltip');
    });

    $('.dropdown-trigger').on('click', function(event) {
      /*event.preventDefault();
			var obj = $(this);
			obj.parent().find('.expanded-dropdown').toggleClass('opened');

*/

      event.preventDefault();
      var obj = $(this);
      obj.parent().toggleClass('dropdown-showing').find('.expanded-dropdown').toggleClass('opened');
      setTimeout(function() {
        buttonClick = buttonClick ? false : true;
      }, 500);


    });
    $('.select-option').on('click', function(event) {
      event.preventDefault();
      var obj = $(this);
      var val = obj.html();
      console.log(val);
      $('.expanded-dropdown.opened').removeClass('opened');
      var dropdownButton = obj.parent().parent().parent().parent();
      var mainValue = $(this).find('span').attr('class');
      //console.log(mainValue);
      // $(this).attr("value",mainValue);

      $(dropdownButton).find('.dropdown-trigger .value').html(val).addClass('dropdown-updated');
      $('#fixed-plans-button').val(mainValue);

    });
    $('.accord-trigger').on('click', function(event) {
      event.preventDefault();
      var obj = $(this);
      obj.toggleClass('accord-expanded');
    });
    $('#mobile-menu').on('click', function(event) {
      event.preventDefault();
      $(this).toggleClass('menu-open');
      $('#primary-navigation').toggleClass('expaned-menu');
    });
    $('.toggle-button').on('click', function(event) {
      event.preventDefault();
      var obj = $(this);
      var toggleDirection = obj.data('toggle');
      console.log(toggleDirection);
      $('.active-link').removeClass('active-link');
      obj.addClass('active-link');
      if (toggleDirection == 'show-all') {
        $('.accord-trigger').addClass('accord-expanded');
      } else {
        $('.accord-trigger').removeClass('accord-expanded');
      }
    });

    $('body').on('click', function(event) {
      if (buttonClick) {
        if ($('.dropdown-container').hasClass('dropdown-showing')) {
          buttonClick = false;
          $('.expanded-dropdown').removeClass('opened');
          $('.dropdown-container').removeClass('dropdown-showing');
        }
      }
    });


    /*    $('#same-billing').on('change',function(event){
			var service_address = ['address-one','address-two','address-city','address-state','address-zip'];

			if ($(this).is(':checked')) {
            for(let m in service_address){
					var item = service_address[m];
					var inputVal = $('#'+item).val();
					$('#billing-'+item).val(inputVal);
				}
				$('.billing-address').addClass('show-less');
        }else{
			  for(let m in service_address){
				  var item = service_address[m];
				  $('#billing-'+item).val('');
			  }
			  $('.billing-address').removeClass('show-less');
		  }
		});*/


  },
  socialButtons: function() {
    /*function outBoundTracking(o) {
		    "function" == typeof ga ? (console.log("tracking"), ga("send", "event", {
		        eventCategory: "RAF_Share",
		        eventAction: o,
		        eventLabel: 'RAFMicrosite'
		    })) : console.log("not tracking")
		}

		var code = "RAF25", //$("#code").text(),
    base_url = window.location.protocol + "/" + window.location.host + "/RAF25/";
		base_url = "http://dev-ohio.macquarium.com:4503" + "/content/" + "/onlyong/" + "promo-raf.html";
		$(".fb-icon").click(function() {
		    var o = base_url + "?promocode=" + code;
		    return window.open("https://www.facebook.com/sharer/sharer.php?u=" + o, "pop", "width=600, height=400, scrollbars=no"), outBoundTracking("Facebook"), !1
		}), $(".tw-icon").click(function() {
		    var o = "$25 for you %26 $25 for me. Enroll with Ohio Natural Gas on their lowest available rates! Terms apply. %23ad",
		        t = "url=" + base_url + "?promocode=" + code + "&r=1&text=" + o;
		    return window.open("https://twitter.com/intent/tweet?" + t, "pop", "width=600, height=400, scrollbars=no"), outBoundTracking("Twitter"), !1
		});

          */
  }


}
$(document).ready(function() {
  ohio_ng.init();
});

$(window).scroll(function() {
  var sTop = $(window).scrollTop();
  var menu_bar = $('#primary-header');

  if (sTop >= 20) {
    menu_bar.addClass('sticky');
  } else {
    menu_bar.removeClass('sticky');
  }

});


//custmore lookup
/*

       $('.next-button').on('click',function(event){
         event.preventDefault();
         var obj = $(this);
         var next_section = obj.data('next');
         $('.active-form').removeClass('active-form');
         $('#step-through >div:nth-child('+next_section+')').addClass('active-form');
         if(next_section > 3){
            next_section = next_section - 1;
            $('.active-step').removeClass('active-step');
            $('.steps-container > div:nth-child('+next_section+')').addClass('active-step');
         }
      });
   },
   transform: function(obj) {
    var val = obj.value.replace( /\D/g, '' );
    if ( /^(\d{3})(\d{3})(\d{4})$/.test( val ) ) {
      obj.value = '('+RegExp.$1 + ')-' + RegExp.$2 + '-' + RegExp.$3;
    } else {
      //alert( 'Invalid input: ' + obj.value );
    }
  }
}
*/

//SignUp for emails pop-up

/*
$(document).ready(function(){
	initValidate();
});

function validateSignup() {
	showConfirmation();
}

function showConfirmation() {
	var validForm = 0;

	if(($('#first-name').val().trim() !== '') && ($('#last-name').val().trim() !== '')) {
		var emailAddress = $('#email').val().trim()

		if(emailAddress !== '') {
			if( /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/
.test(emailAddress)) {
				validForm = 1;
			}

		}

		else if($('#address-1').val().trim() !== '') {
			if($('#billing-address-city').val().trim() !== '' &&
				$('#billing-address-state').val().trim() !== '' &&
				$('#billing-address-zip').val().trim() !== '') {
					validForm = 1;
				}
		}

		if(validForm) {
			$('#popup1').empty().remove();
			$('#popup2').addClass('show-popup');
		}
	}

}

function initValidate() {
	$('.submit-button').on('click', function(e) {
		e.preventDefault();
		$('#offer-signup-form').submit();
	});

  $('#offer-signup-form').on('submit',function(e){
    e.preventDefault();
		validateSignup();
  });

}
*/
