angular.module("shopApp").controller("userRolesController",
	["$scope","userRolesService",
	function($scope,userRolesService){

		$scope.userRoleFormRoleName = "";

		$scope.usersRolesFormShowFlag = false;
		$scope.usersRolesFormEditFlag = false;
		$scope.userRolesList = [];
		
		$scope.resetUserRolesFormData = function() {
			$scope.userRolesFormData = {
				roleId : "",
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
		}
		
		$scope.resetUserRolesFormData();

		$scope.submitUserRolesForm = function() {
			userRolesService.insertUserRoles($scope.userRolesFormData,$scope.userRoleFormRoleName).then(function(result){
				alert("Role created successfully");
				$scope.resetUserRolesFormData();
				
			});
		};

		$scope.getUserRolesList = function() {
			userRolesService.getUserRoles().then(function(result){
				$scope.userRolesList = result;
				$scope.usersRolesFormEditFlag = false;
				$scope.usersRolesFormShowFlag = false;
			});
		}
		$scope.getUserRolesList();

		$scope.editUserRoles = function(index) {
			var tempUser = _.where($scope.userRolesList,function(rw){
				return rw.id == index;
			});
			$scope.userRoleFormRoleName = tempUser[0].name;
			
			$scope.userRolesFormData = tempUser[0].roledata;			
			
			console.debug($scope.userRolesFormData.categories_view);

			$scope.usersRolesFormEditFlag = true;
			$scope.usersRolesFormShowFlag = true;
		}
		
		$scope.updateUserRolesForm = function(){
			console.debug($scope.userRolesFormData);
			userRolesService.updateUserRoles($scope.userRolesFormData,$scope.userRoleFormRoleName).then(function(result){
				alert("Role updated successfully");
				$scope.usersRolesFormEditFlag = false;
				$scope.usersRolesFormShowFlag = false;
				$scope.resetUserRolesFormData();
			});			
		};
		
	}
]);