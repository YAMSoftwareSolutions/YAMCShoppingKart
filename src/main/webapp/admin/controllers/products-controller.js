angular.module("shopApp").controller("productsController",
	["$scope","categoriesService","unitsService","weightsService","brandsService","discountsService",
	function($scope,categoriesService,unitsService,weightsService,brandsService,discountsService){

		$scope.productFormData = {
			"units" : [],
			"units" : [],
		};	

		$scope.initializeCategories = function() {
			var finalCategoriesList = [];
			categoriesService.getCategories().then(function(categoriesList){			
				var categoriesCounter = 1;
				$scope.originalCategoriesList = categoriesList;
				if(categoriesList.length==0) {
					$scope.showCategoryFormFlag = true;
				}

				var rootCateogies  = _.where(categoriesList, function(rw){
					return rw.id == rw.parentCategory;
				});

				for(var rootIndex in rootCateogies) {
					finalCategoriesList[rootIndex] = {};
					finalCategoriesList[rootIndex].id = rootCateogies[rootIndex].id;
					finalCategoriesList[rootIndex].name = rootCateogies[rootIndex].categoryNameEng;
					finalCategoriesList[rootIndex].nodes = $scope.buildRecursiveTree(rootCateogies[rootIndex].id,categoriesList);
				}			
				$scope.categoriesList = finalCategoriesList;
			});
		};

		$scope.initializeCategories();

		$scope.buildRecursiveTree = function(parentCategory,categoriesList) {

			var rootCateogies  = _.where(categoriesList, function(rw){
				return rw.parentCategory == parentCategory && rw.id!=parentCategory;
			});

			if(rootCateogies.length>0)
			{
				var tempCategoriesList = [];
				for(var rootIndex in rootCateogies) {
					tempCategoriesList[rootIndex] = {};
					tempCategoriesList[rootIndex].id = rootCateogies[rootIndex].id;
					tempCategoriesList[rootIndex].name = rootCateogies[rootIndex].categoryNameEng;
					tempCategoriesList[rootIndex].nodes = $scope.buildRecursiveTree(rootCateogies[rootIndex].id,categoriesList);
				}
				return tempCategoriesList;
			}
			else
			{
				return [];
			}

		};
		
		unitsService.getUnits().then(function(result){
			$scope.unitsList = result;
		});

		weightsService.getWeights().then(function(result){
			$scope.weightsList = result;
		});

		brandsService.getBrands().then(function(result){
			$scope.brandsList = result;
		});

		discountsService.getDiscounts().then(function(result){
			$scope.discountsList = result;
		});
		
		$scope.unitsRows = [];

		$scope.unitsRows[$scope.unitsRows.length] = {
			"name" : "Abc"
		};

		$scope.addUnitsRows = function(){			
			$scope.unitsRows[$scope.unitsRows.length] = {
				"name" : "Xyz"
			};
		};

		$scope.removeUnitRow = function(id) {
			$scope.unitsRows.splice(id,1);		
		}

		$scope.createProduct = function() {



		};

	}
]);