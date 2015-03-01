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
		
		$scope.resetUsersFormData = function(){
			$scope.usersFormData = {
				userName : "",
				password : "",
				mobile : "",
				emailId : "",
				role : "",
				houseNumber : "",
				street : "",
				area : "",
				landmark : "",
				city : "",
				pincode : "",
			};
		};
		$scope.resetUsersFormData();
		
		$scope.createUser = function() {
			usersService.createUsers($scope.usersFormData).then(function(result){
				alert("User created successfully");
				$scope.usersFormShowFlag = false;
				$scope.resetUsersFormData();
			});
		}

		$scope.editUser = function(userId) {
			var tempUser = _.where($scope.userList,function(rw){
				return rw.id == userId;
			});
			$scope.usersFormData = tempUser[0];

			$scope.usersFormEditFlag = true;
			$scope.usersFormShowFlag = true;
		}

		$scope.updateUser = function() {
			usersService.updateUsers($scope.usersFormData).then(function(result){
				alert("User updated successfully");
			});
		}

		$scope.deleteUser = function(userId){
			if(confirm("Are you sure want delete the user?"))
			{
				usersService.deleteUsers(userId).then(function(result){

				});
			}
		}

	}
]);