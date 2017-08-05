var ohio_ng = {
	init : function(){
		this.listeners();
	},
	listeners : function(){
		$('.dropdown-trigger').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			obj.parent().find('.expanded-dropdown').toggleClass('opened');
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