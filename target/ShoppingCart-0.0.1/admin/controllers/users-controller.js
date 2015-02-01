angular.module("shopApp").controller("usersController",
	["$scope","usersService","userRolesService",
	function($scope,usersService,userRolesService){

		$scope.usersFormShowFlag = false;
		$scope.usersFormEditFlag = false;
		$scope.userList = [];
		$scope.userRolesList = [];

		userRolesService.getUserRoles().then(function(result){
			$scope.userRolesList = result;
		});

		usersService.getUsers().then(function(result){
			if(result.length<0) {
				$scope.usersFormShowFlag = true;				
			}
			$scope.userList = result;
		});
		
		$scope.usersFormData = {};
		
		$scope.createUser = function() {
			usersService.createUsers($scope.usersFormData).then(function(result){
				
			});
		}

	}
]);