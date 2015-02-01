var themeBasePath = 'themes/default';

angular.module("shopApp",
    ['ui.router','ui.tree']).
    value("serviceCallBaseUrl","../rest/").
    config(["$stateProvider","$urlRouterProvider",
        function($stateProvider,$urlRouterProvider){    

    	
    	
        $stateProvider.state('dashboard', {
            url: "/dashboard",
            templateUrl: themeBasePath+'/home.html',
            data : {
                action : "dashboard",
            }
        })
        .state('categories', {
            url: '/categories',
            templateUrl: themeBasePath+'/categories.html',
            controller : "categoriesController",
            data:{
                action : "categories",
            }
        })
        .state('brands', {
            url: '/brands',
            templateUrl: themeBasePath+'/brands.html',
            controller : "brandsController",
            data:{
                action : "brands",
            }
        }).state('units', {
            url: '/units',
            templateUrl: themeBasePath+'/units.html',
            controller: "unitsController",
            data:{
                action : "units",
            }
        }).state('weights', {
            url: '/weights',
            templateUrl: themeBasePath+'/weights.html',
            controller: "weightsController",
            data:{
                action : "weights",
            }
        }).state('products', {
            url: '/products',
            templateUrl: themeBasePath+'/products.html',
            controller : "productsController",
            data:{
                action : "products",
            }
        }).state('discounts', {
            url: '/discounts',
            templateUrl: themeBasePath+'/discounts.html',
            controller : "discountsController",
            data:{
                action : "discounts",
            }
        }).state('users', {
            url: '/users',
            templateUrl: themeBasePath+'/users.html',
            controller : "usersController",
            data:{
                action : "users",
            }
        }).state('usersRoles', {
            url: '/userRoles',
            templateUrl: themeBasePath+'/userRoles.html',
            controller : "userRolesController",
            data:{
                action : "userRoles",
            }
        })

        $urlRouterProvider.otherwise("dashboard");

    }
]).run(["$rootScope",
        function($rootScope){
	
	$rootScope.globalConfig =  GLOBALCONFIG;
	
	}
]);

angular.module("starterapp",
    ['ui.router','ui.tree']).
    value("serviceCallBaseUrl","../rest/").
    run(["$http",
        function($http){    
    	var tempUserRequest = {id:GLOBALCONFIG.userID};
    	$http.post("../rest/userService/search",tempUserRequest)
		.success(function(data, status, headers, config) {
			var tempRequest = {roleId:data.role};
			$http.post("../rest/roletoScreens/search",tempRequest)
			.success(function(data, status, headers, config) {				
				GLOBALCONFIG.rolesPermissions = data;
				angular.bootstrap(document.getElementById("appdiv"), ['shopApp']); 
			}).
			error(function(data, status, headers, config) {
			
			});
		}).
		error(function(data, status, headers, config) {
		
		});		    	
	}
]);

angular.element(document).ready(function() {
    angular.bootstrap(document.getElementById("starterdiv"), ['starterapp']);   
});