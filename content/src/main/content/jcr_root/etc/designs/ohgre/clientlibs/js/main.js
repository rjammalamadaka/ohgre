var buttonClick = false;
var ohio_ng = {
	init : function(){
		this.listeners();
	},
	listeners : function(){

        $('.trigger-popup').on('click',function(event){
			event.preventDefault();
         $('.popup-wrapper').addClass('show-popup');
      });

   /*   $('.popup-wrapper,#close-window').on('click',function(event){
			event.preventDefault();
         $('.popup-wrapper').removeClass('show-popup');
      });
      */

         $('.close-window').on('click',function(event){
			event.preventDefault();
         $('.popup-wrapper').removeClass('show-popup');
      });

        
		$('.dropdown-trigger').on('click',function(event){
			/*event.preventDefault();
			var obj = $(this);
			obj.parent().find('.expanded-dropdown').toggleClass('opened');

*/

            event.preventDefault();
			var obj = $(this);
			obj.parent().toggleClass('dropdown-showing').find('.expanded-dropdown').toggleClass('opened');
			setTimeout(function(){
				buttonClick = buttonClick ? false : true;
			},500);


		});
		$('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            console.log(val);
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
            //console.log(mainValue);
            // $(this).attr("value",mainValue);

			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});
		$('.accord-trigger').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			obj.toggleClass('accord-expanded');
		});
		$('#mobile-menu').on('click',function(event){
			event.preventDefault();
			$(this).toggleClass('menu-open');
			$('#primary-navigation').toggleClass('expaned-menu');
		});
        $('.toggle-button').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var toggleDirection = obj.data('toggle');
			console.log(toggleDirection);
			$('.active-link').removeClass('active-link');
			obj.addClass('active-link');
			if(toggleDirection == 'show-all'){
				$('.accord-trigger').addClass('accord-expanded');
			}else{
				$('.accord-trigger').removeClass('accord-expanded');
			}
		});

        $('body').on('click',function(event){
			if(buttonClick){
				if($('.dropdown-container').hasClass('dropdown-showing')){
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


	}
}
$(document).ready(function(){
	ohio_ng.init();
});

$(window).scroll(function(){
	var sTop = $(window).scrollTop();
	var menu_bar = $('#primary-header');

		if(sTop >= 20){
			menu_bar.addClass('sticky');
		}else{
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