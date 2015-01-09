angular.module("shopApp").controller("userRolesController",
	["$scope","userRolesService",
	function($scope,userRolesService){

		$scope.usersFormShowFlag = false;
		$scope.userList = [];

		usersService.getUsers().then(function(result){
			if(result.length<0) {
				$scope.usersFormShowFlag = true;				
			}
			$scope.userList = result;
		});

	}
]);