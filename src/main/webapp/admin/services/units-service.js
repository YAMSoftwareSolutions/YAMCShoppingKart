angular.module('shopApp').service('unitsService',
	function($http,$q,$rootScope,serviceCallBaseUrl) {

		var unitsList = [];

		this.getUnits = function() {
			var deferred = $q.defer();
			if(unitsList.length>0) {				
				deferred.resolve(unitsList);
			}
			else {
				$http.post(serviceCallBaseUrl+"unitService/getAll")
				.success(function(data, status, headers, config) {				
					deferred.resolve(data);
				}).
	  			error(function(data, status, headers, config) {
					deferred.reject(data);
	  			});
	  		}
  			return deferred.promise;
		};

		this.postUnits = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"unitService/insert",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
			return deferred.promise;
		};

		this.putUnits = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"unitService/update",request)
			.success(function(data,status,headers,config) {
				deferred.resolve(data);
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
			return deferred.promise;
		};

		this.deleteUnits = function(request) {
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"unitService/delete",request)
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