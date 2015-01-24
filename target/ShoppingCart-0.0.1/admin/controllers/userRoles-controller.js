angular.module("shopApp").controller("userRolesController",
	["$scope","userRolesService",
	function($scope,userRolesService){

		$scope.userRolesFormData = {
			categories_view : false,
			categories_create : false,
			categories_update : false,
			categories_delete : false,
			brands_view : false,
			brands_create : false,
			brands_update : false,
			brands_delete : false,
			units_view : false,
			units_create : false,
			units_update : false,
			units_delete : false,
			weight_view : false,
			weight_create : false,
			weight_update : false,
			weight_delete : false,
			discounts_view : false,
			discounts_create : false,
			discounts_update : false,
			discounts_delete : false,
			product_view : false,
			product_create : false,
			product_update : false,
			product_delete : false,
			users_view : false,
			users_create : false,
			users_update : false,
			users_delete : false
		};

		$scope.submitUserRolesForm = function() {
			userRolesService.insertUserRoles($scope.userRolesFormData).then(function(result){
				
			});
		};
		
	}
]);