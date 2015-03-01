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
		
		this.updateUserRoles = function(request,roleName){
			var roleRequest = {
				"id" : request.roleId,
				"roleName" : roleName
			};
			var deferred = $q.defer();
			$http.post(serviceCallBaseUrl+"roleService/update",roleRequest)
			.success(function(data,status,headers,config) {
				
				request.roleId = data.id;
				$http.post(serviceCallBaseUrl+"roletoScreens/update",request)
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
				console.debug(data);
				$http.post(serviceCallBaseUrl+"roletoScreens/getAll")
				.success(function(rolesdata, status, headers, config) {
					console.debug(data);
					var tempdata = [];
					for(index in rolesdata)
					{
						console.debug(index+"::"+rolesdata[index].id);
						tempdata[index] = {};
						tempdata[index].id = data[index].id;
						tempdata[index].name = data[index].roleName;
						tempdata[index].roledata = {};
						tempdata[index].roledata.roleId = data[index].id;
						tempdata[index].roledata.id = rolesdata[index].id;
						tempdata[index].roledata.categories_view = (rolesdata[index].categories_view=="true")?true:false;
						tempdata[index].roledata.categories_create = (rolesdata[index].categories_create=="true")?true:false;
						tempdata[index].roledata.categories_delete = (rolesdata[index].categories_delete=="true")?true:false;
						tempdata[index].roledata.categories_update = (rolesdata[index].categories_update=="true")?true:false;
						
						tempdata[index].roledata.brands_view = (rolesdata[index].brands_view=="true")?true:false;
						tempdata[index].roledata.brands_create = (rolesdata[index].brands_create=="true")?true:false;
						tempdata[index].roledata.brands_delete = (rolesdata[index].brands_delete=="true")?true:false;
						tempdata[index].roledata.brands_update = (rolesdata[index].brands_update=="true")?true:false;
						
						tempdata[index].roledata.units_view = (rolesdata[index].units_view=="true")?true:false;
						tempdata[index].roledata.units_create = (rolesdata[index].units_create=="true")?true:false;
						tempdata[index].roledata.units_delete = (rolesdata[index].units_delete=="true")?true:false;
						tempdata[index].roledata.units_update = (rolesdata[index].units_update=="true")?true:false;
						
						tempdata[index].roledata.weight_view = (rolesdata[index].weight_view=="true")?true:false;
						tempdata[index].roledata.weight_create = (rolesdata[index].weight_create=="true")?true:false;
						tempdata[index].roledata.weight_delete = (rolesdata[index].weight_delete=="true")?true:false;
						tempdata[index].roledata.weight_update = (rolesdata[index].weight_update=="true")?true:false;
						
						tempdata[index].roledata.discounts_view = (rolesdata[index].discounts_view=="true")?true:false;
						tempdata[index].roledata.discounts_create = (rolesdata[index].discounts_create=="true")?true:false;
						tempdata[index].roledata.discounts_delete = (rolesdata[index].discounts_delete=="true")?true:false;
						tempdata[index].roledata.discounts_update = (rolesdata[index].discounts_update=="true")?true:false;
						
						tempdata[index].roledata.product_view = (rolesdata[index].product_view=="true")?true:false;
						tempdata[index].roledata.product_create = (rolesdata[index].product_create=="true")?true:false;
						tempdata[index].roledata.product_delete = (rolesdata[index].product_delete=="true")?true:false;
						tempdata[index].roledata.product_update = (rolesdata[index].product_update=="true")?true:false;
						
						tempdata[index].roledata.users_view = (rolesdata[index].users_view=="true")?true:false;
						tempdata[index].roledata.users_create = (rolesdata[index].users_create=="true")?true:false;
						tempdata[index].roledata.users_delete = (rolesdata[index].users_delete=="true")?true:false;
						tempdata[index].roledata.users_update = (rolesdata[index].users_update=="true")?true:false;
						
						
					}
					
					deferred.resolve(tempdata);
				}).
	  			error(function(data, status, headers, config) {
					deferred.reject(data);
	  			});
			}).
  			error(function(data, status, headers, config) {
				deferred.reject(data);
  			});
  			return deferred.promise;
		};

	}
);