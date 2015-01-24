angular.module("shopApp").service("userRolesService",
	function($http,$q,serviceCallBaseUrl){

		this.insertUserRoles = function(request){
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"roletoScreens/insert",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

	}
);