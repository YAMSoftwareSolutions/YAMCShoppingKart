angular.module("shopApp").controller("cartController",
	["$scope","homeService",
	function($scope,homeService){
		
		var tempProducts = getCookie("shopAppCartProducts");
		if(tempProducts!="")
		$scope.cartProducts = JSON.parse(tempProducts);
		else
		$scope.cartProducts = [];
		
		homeService.getProducts().then(function(products){
			console.debug(products);
			for(index in $scope.cartProducts) {
				console.debug($scope.cartProducts[index].id);
				var tepProduct = _.find(products,function(rw){
					rw.id == $scope.cartProducts[index].id
				});
				console.debug(tepProduct);
				$scope.cartProducts[index].productImage = tepProduct.productImage;
			}					

		});
		
		

	}
]);