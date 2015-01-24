angular.module("shopApp").controller("usersController",
	["$scope","usersService",
	function($scope,usersService){

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