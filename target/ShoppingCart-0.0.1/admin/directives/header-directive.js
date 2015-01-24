angular.module('shopApp').directive('header', 
	['$rootScope',
	function($rootScope){	
		return {
	        templateUrl: themeBasePath+"/header.html",
	        link : function($scope,element) {
	        	
	        	$scope.leftmenu = {
	        		0 : {
	        			"name" : "Dashboard",
	        			"sref" : "dashboard"
	        		},1 : {
	        			"name" : "Categories",
	        			"sref" : "categories"
	        		},2 : {
	        			"name" : "Brands",
	        			"sref" : "brands"
	        		},3 : {
	        			"name" : "Units",
	        			"sref" : "units"
	        		},4 : {
	        			"name" : "Weights",
	        			"sref" : "weights"
	        		},5 : {
	        			"name" : "Discounts",
	        			"sref" : "discounts"
	        		},6 : {
	        			"name" : "Products",
	        			"sref" : "products"
	        		},7 : {
	        			"name" : "Users",
	        			"sref" : "users"
	        		},8 : {
	        			"name" : "User Roles",
	        			"sref" : "usersRoles"
	        		}
	        	};

	        	var pathArray = window.location.hash.split( '/' );
				$scope.currentPageName = pathArray[1];
				$rootScope.$on('$stateChangeStart', function(event, toState, toParams){
					$scope.currentPageName = toState.data.action;
				});

	        }
		}
	}
]);