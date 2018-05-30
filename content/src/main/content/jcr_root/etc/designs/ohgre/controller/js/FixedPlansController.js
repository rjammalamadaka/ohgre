ohgrePortal.controller('FixedPlansController', ['$scope', '$rootScope', '$http','PrimeService',function ($scope, $rootScope,$http,PrimeService) {

 var portalname=$rootScope.portalname;
    ohgre.removeStore("promoCodeInfo");
    ohgre.removeStore("promocode");
    var standardpromocode=null;
    $scope.viewplans = function(){


            if( $rootScope.resstdpromocode){
               standardpromocode=$rootScope.resstdpromocode;
            }
       

        if(standardpromocode && standardpromocode.length>0){
             PrimeService.getPromoCodeInfo(standardpromocode).success(function(data, status, headers, config) {
                 data.standardpromocode=true;
                 ohgre.store("promoCodeInfo",data);
                 var ldcCode=$('#fixed-plans-button').val();
                 if(ldcCode){
                     if(portalname =="oh"){
                         location.href="/content/onlyong/rate-plans.html#ldc="+ldcCode;
                     }else{
                         location.href="/content/gre/rate-plans.html#ldc="+ldcCode;
                     }
                 }
            }).error(function (data,status, headers, config){
                
            });
        }else{
              var ldcCode=$('#fixed-plans-button').val();
                 if(ldcCode){
                     if(portalname =="oh"){
                         location.href="/content/onlyong/rate-plans.html#ldc="+ldcCode;
                     }else{
                         location.href="/content/gre/rate-plans.html#ldc="+ldcCode;
                     }
                 }
        }
    }

    var bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});

    }

    PrimeService.getLdcInfo().success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
              $scope.ldcinfo=data.LDCList;
             setTimeout(function(){ bindClickEvent(); }, 10);
         }else{
    		location.href=$rootScope.homeUrl+'/errors/500.html';
         }

         }).error(function (data,status, headers, config){

            if(status == 404){
                location.href=$rootScope.homeUrl+"/errors/404.html";
            }else{
                location.href=$rootScope.homeUrl+"/errors/500.html";
            }

         });

}]);

