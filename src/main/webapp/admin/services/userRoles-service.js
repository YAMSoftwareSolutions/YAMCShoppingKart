angular.module("shopApp").service("userRolesService",
	function($http,$q,serviceCallBaseUrl){

		this.insertUserRoles = function(request,roleName){
			var roleRequest = {
				"roleName" : roleName
			};
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"roleService/insert",roleRequest)
			.success(function(data,status,headers,config) {
				
				request.roleId = data.id;
				$http.post(serviceCallBaseUrl+"roletoScreens/insert",request)
				.success(function(data,status,headers,config) {
					deferred.resolve(data);
				}).
	  			error(function(data, status, headers, config) {
					deferred.reject(data);
	  			});
			});
  			return deferred.promise;
		};

		this.getUserRoles = function() {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"roleService/getAll")
			.success(function(data, status, headers, config) {				
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

	}
);