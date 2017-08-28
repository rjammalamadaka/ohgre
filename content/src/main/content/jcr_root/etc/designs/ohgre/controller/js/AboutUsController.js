ohgrePortal.controller('AboutUsController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {
 var portalname=$rootScope.portalname;

    var promocode=$("#promocode").data("promocode");

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

     var bindClickEvent =function(){
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

    }


     $scope.viewplans = function(){

        var ldcCode=$('#fixed-plans-button').val();
            getPromoGroups(promocode);
 			var url="/bin/getPromoCodeInfo?portalName="+portalname+"&promotionCode="+promocode;
             $http.get(url).success(function(data, status, headers, config){

				var redirectUrl="";
                 if($scope.promoInfo && $scope.promoInfo.url){
					redirectUrl=$scope.promoInfo.url;
                 }else{
					redirectUrl="";
                 }

                 if(data && data.responseStatus =="0"){

                     if(data.LDCList && data.LDCList.length >0 && redirectUrl){
                          ohgre.store("promoCodeInfo",data);
							location.href=redirectUrl+".html#fromabout=true&ldc="+ldcCode;
                       }

                 }else if(data && data.responseStatus =="1"){
						$scope.serverError=data.responsemessage;

                 }

             }).error(function (data,status, headers, config){

                 console.log("error");
             });

      // location.href="/content/onlyong/promo_landing.html";
    }


      var getPromoGroups= function(promotionCode){
			var url='/content/onlyong/promotions.infinity.json';

        $http.get(url).success(function(data, status, headers, config){
            for (var property in data) {
    			if (data.hasOwnProperty(property) && property != "jcr:primaryType") {
                    var childNode=data[property];
                    for(var childproperty in childNode){
                        if(childNode.hasOwnProperty(childproperty) && childproperty != "jcr:primaryType"){
                            var url=childNode[childproperty];

                            if(childproperty == promotionCode){
							var promoinfo={};
							promoinfo.code=childproperty;
                            promoinfo.url=url;
                            $scope.promoInfo=promoinfo;
                                break;
                            }
                        }
                    }
    			}
			}

        }).error(function (data,status, headers, config){

                 console.log("error");
         });


    }

}]);

