angular.module("shopApp").controller("orderconformationController",
	["$scope","homeService",
	function($scope,homeService){
		
		var tempProducts = getCookie("shopAppCartProducts");
		if(tempProducts!="")
		$scope.cartProducts = JSON.parse(tempProducts);
		else
		$scope.cartProducts = [];
		console.debug("products::",$scope.cartProducts);
		/*
	private double totalPrice;
	private int discountType;
	private double discountValue;
	private double priceAfterDiscount;
	private int productCount; 
	private TransactionOrderAddressTo address;
	private Collection<TransactionOrderProductListTo> productList = new ArrayList<TransactionOrderProductListTo>();
	
	private int id;
	private int unit;
	private int discountType;
	private double discountValue;
	private double quantity;
	private double price;
	private int weight;
	private int product;
	private int transactionOrder;
		 */
		
		$scope.confirmOrder = function(){
			var confirmOrderObject = {
					totalPrice : 0,					
					priceAfterDiscount : 1,
					productCount : 0,
					address : {						
					},
					productList : []					
			}
			for(var tempIndex in $scope.cartProducts)
			{
				console.debug(tempIndex+":::");
				console.debug($scope.cartProducts[tempIndex]);
				confirmOrderObject.totalPrice += ($scope.cartProducts[tempIndex].price*$scope.cartProducts[tempIndex].inCartQuantity);
				confirmOrderObject.productCount += $scope.cartProducts[tempIndex].inCartQuantity;
				confirmOrderObject.discountType = $scope.cartProducts[tempIndex].discountType;
				var tempProduct = {
						product : $scope.cartProducts[tempIndex].id,
						unit : $scope.cartProducts[tempIndex].inCartUnit,
						discountType : $scope.cartProducts[tempIndex].discountType,
						discountValue : "0.0",
						quantity : $scope.cartProducts[tempIndex].inCartQuantity,
						price : "0.0",
						weight : $scope.cartProducts[tempIndex].weight						
				}
				confirmOrderObject.productList.push(tempProduct);
			}
			homeService.confirmOrder(confirmOrderObject);
		};
		
		
	}
]);