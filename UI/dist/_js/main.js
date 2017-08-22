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
			var formel = obj.parent().find('.form');
			var formId = formel.attr('id');
			$('#'+formId).submit();
		});
		// DROP DOWN VALIDATION
		$('.someclick-handler').on('click',function(){
			var dropdownVal = $('.dropdown-trigger .value').html();
			if(dropdownVal == 'Select Your Gas Utility' || dropdownVal == ''){
				$('.dropdown-container').addClass('has-error');
			}
		});
		$('input').on('blur',function(){
			var obj = $(this);
			if(obj.parent().filter('data-size')){
				if($(this).val() != ''){
					$(this).removeClass('has-error');
				}
			}
		});
		$('input').on('keyup',function(){
		/*	var obj = $(this);
			if(obj.parent().filter('data-size')){
				var lengthval = obj.parent().data('size');
				var inputlength = obj.val().length;

				if(lengthval == inputlength){
					console.log('next input');
					var currentIndex = $(this).parent().index();
					console.log(currentIndex);
					if(currentIndex == 0){
						currentIndex = 1;
					}
					var nextElement = currentIndex + 1;
					console.log(nextElement);
					$('.form-area.multiple-input .input-container:nth-child('+nextElement+') input').focus();
				}
			} */
		});
		$('#promo-code-enter').on('submit',function(event){
			event.preventDefault();
			if($('#promo-code-value').val() == ''){
				$(this).addClass('has-error');
			}else{
				$(this).removeClass('has-error');
			}
		});
		/*
		$('form').on('submit',function(event){
			event.preventDefault();
			var errors = false;
			console.log('submit called');
			var requiredElement = $(this).find('[data-required="true"]');
			$.each(requiredElement,function(index,value){
				if($(this).val() == ''){
					errors = true;
					$(this).parent().addClass('has-error');
				}
			});
			if(!errors){
				console.log('no errors');
				var nextBtn = $('.next-button').data('next');
				ohio_ng.showNextContent(nextBtn);
			}else{
				console.log('found errors');
			}
		});*/
	},
	showNextContent : function(next_section){
		$('.active-form').removeClass('active-form');
		$('#step-through >div:nth-child('+next_section+')').addClass('active-form');
		if(next_section > 3){
			next_section = next_section - 1;
			$('.active-step').removeClass('active-step');
			$('.steps-container > div:nth-child('+next_section+')').addClass('active-step');
		}
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
