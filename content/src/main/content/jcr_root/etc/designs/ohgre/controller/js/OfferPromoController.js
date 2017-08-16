ohgrePortal.controller('OfferPromoController', ['$scope', '$rootScope', '$http',function ($scope, $rootScope,$http) {

    var portalname=$("#primary-header").data("portalname");

	$scope.displayPlans =false;


     var processPromotionInfo=function(promoInfo){
 	//var promoInfo=ohgre.store("promoCodeInfo");

    if(promoInfo.LDCList.length>0){
        var ldc=promoInfo.LDCList[0];
        //console.log(ldc.promotion[0]);
        $scope.promotion=ldc.promotion[0];
        console.log($scope.promotion);
        $scope.giftCardValue=$scope.promotion.GiftCardValue;

    }

     }


    $rootScope.$watch('promotionInfo', function (newValue, oldValue, scope) {
        // console.log(newValue);
        if(newValue){

			var promoInfo=ohgre.store("promoCodeInfo");
     		processPromotionInfo(promoInfo);
        }
    });


    $scope.viewPlans =function(){

		var ldcCode=$('#fixed-plans-button').val();
        if(ldcCode){
            var url="/bin/getQuotes?portalName="+portalname+"&ldcCode="+ldcCode+"&promotionCode="+$scope.promotion.PromotionCode;
             $http.get(url).success(function(data, status, headers, config){
                 $scope.Quotes=data;
                 if($scope.Quotes && $scope.Quotes.Customer && $scope.Quotes.Customer.length>0){
                      $scope.displayPlans = true;
                     $scope.Customer=$scope.Quotes.Customer;
                     $scope.products=$scope.Customer[0].Product;

                 }else{


                 }

             }).error(function (data,status, headers, config){
    
                 console.log("error");
             });
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
            //console.log(mainValue);
            // $(this).attr("value",mainValue);

			 $(dropdownButton).find('.dropdown-trigger .value').html(val);
             $('#fixed-plans-button').val(mainValue);

		});

    }


     $scope.getNumber =function(QuoteDescription){

        if(QuoteDescription.indexOf("CCF")>0){
			return("Ccf**");
        }else if(QuoteDescription.indexOf("MCF")>0){
			return("Mcf**");
        }

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

