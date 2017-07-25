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
			$('.expanded-dropdown.opened').removeClass('opened');
			obj.parent().parent().parent().parent().find('.dropdown-trigger .value').html(val);
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