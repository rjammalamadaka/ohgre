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
		$('.next-button').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var next_section = obj.data('next');
			$('.active-form').removeClass('active-form');
			$('.active-step').removeClass('active-step');
			$('#step-through >div:nth-child('+next_section+')').addClass('active-form');
			$('.steps-container > div:nth-child('+next_section+')').addClass('active-step');
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
