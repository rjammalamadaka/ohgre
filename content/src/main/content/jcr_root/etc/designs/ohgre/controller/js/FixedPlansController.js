ohgrePortal.controller('FixedPlansController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

 var portalname=$rootScope.portalname;

    $scope.viewplans = function(){
        var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){
		console.log(ldcCode);
            if(portalname =="oh"){
         	location.href="/content/onlyong/rate-plans.html#ldc="+ldcCode;
            }else{
                location.href="/content/gre/rate-plans.html#ldc="+ldcCode;
            }
        }
    }

    var bindClickEvent =function(){
      $('.select-option').on('click',function(event){
			event.preventDefault();
			var obj = $(this);
			var val = obj.html();
            console.log(val);
			$('.expanded-dropdown.opened').removeClass('opened');
            var dropdownButton=obj.parent().parent().parent().parent();
            var mainValue=$(this).find('span').attr('class');
			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});

    }




var url="/bin/getLDCInfoServlet?portalName="+portalname;
     $http.get(url).success(function(data, status, headers, config){
         if(data && data.responseStatus =="0"){
               console.log(data.LDCList);
             $scope.ldcinfo=data.LDCList;
             setTimeout(function(){ bindClickEvent(); }, 10);
         }

         }).error(function (data,status, headers, config){

             console.log("error");
         });

}]);

