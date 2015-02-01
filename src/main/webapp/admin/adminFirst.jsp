<%@page import="com.shopping.daofactory.ShoppingCartFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopping.to.UsersTo"%>
<%@page import="java.util.Collection"%>
<%@page import="com.shopping.action.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="shopApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
		<link rel="stylesheet" type="text/css" href="../assets/public/css/bootstrap.css">
		
	    <link rel="stylesheet" type="text/css" href="../assets/public/css/font-awesome.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="../assets/public/css/ng-tags-input.css">
		<link rel="stylesheet" type="text/css" href="../assets/public/css/angular-ui-tree.min.css">		
		
</head>
<body>

	<%@ page session="false" %>
	<%
	
		try {
			HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute("userId") == null){				 
				Collection<UsersTo> usersTo = new ArrayList<UsersTo>();
				usersTo = ShoppingCartFactory.getUserDao().getAll();
				if(!usersTo.isEmpty())
				{
					response.sendRedirect("index.jsp");
				}		   
			}
			//return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			//return Response.status(403).entity(error).build();
		}		
	%>
	
	<h3>Users</h3>	    
<div class="row" ng-controller="adminController">
	<div class="col-md-12">		
		<form role="form" method="post" action="http://localhost:8080/Shopping/rest/accessService/login" id="adminFirstForm">
	        <div class="form-group">	            
	            <input class="form-control" placeholder="User name" ng-model="usersFormData.userName" name="username">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Password" ng-model="usersFormData.password" name="password">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Mobile" ng-model="usersFormData.mobile">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="EmailId" ng-model="usersFormData.emailId">
	        </div>
	      <!--   <div class="form-group">	            
	            <select ng-model="usersFormData.role" class="form-group">
	            	<option ng-repeat="userRole in userRolesList" value="{{userRole.id}}">{{userRole.roleName}}</option>
	            </select>
	        </div> -->
	        <div class="form-group">	            
	            <input class="form-control" placeholder="HouseNo" ng-model="usersFormData.houseNumber">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Street" ng-model="usersFormData.street">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Area" ng-model="usersFormData.area">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Landmark" ng-model="usersFormData.landmark">
	        </div>
	        <div class="form-group">
	            <input class="form-control" placeholder="City" ng-model="usersFormData.city">
	        </div>
	        <div class="form-group">	            
	            <input class="form-control" placeholder="Pincode" ng-model="usersFormData.pincode">
	        </div>
	        
	        <button type="button" class="btn btn-primary" ng-click="createUser()">Submit</button>
	        <button type="reset" class="btn btn-default">Reset</button>
	    </form>
	</div>
</div>

			<!--vendor files -->
		<script type="text/javascript" src="../assets/public/js/angular.js"></script>
		<script type="text/javascript" src="../assets/public/js/angular-ui-router.js"></script>
		<script type="text/javascript" src="../assets/public/js/restangular.js"></script>
		<script type="text/javascript" src="../assets/public/js/lodash.compat.js"></script>
		<script type="text/javascript" src="../assets/public/js/angular-sanitize.js"></script>
		<script type="text/javascript" src="../assets/public/js/angular-animate.js"></script>
		<script type="text/javascript" src="../assets/public/js/angular-ui-tree.js"></script>
		<script type="text/javascript" src="../assets/public/js/ui-bootstrap-tpls-0.11.1.js"></script>
		<script type="text/javascript" src="../assets/public/js/ng-tags-input.js"></script>
		<script type="text/javascript" src="../bower_components/jquery/dist/jquery.js"></script>

		<!--vendor files end -->
		
		<script>
			angular.module("shopApp",[])
			.controller("adminController",
				["$scope","$http","$q",
			    	function($scope,$http,$q){
						$scope.usersFormData = {};
						$scope.createUser = function(){
							
							$http.post("../rest/roleService/getAll")
							.success(function(data, status, headers, config) {
								if(data.length==0) {
									var tempRoleRequest = {
										categories_view : true,
										categories_create : true,
										categories_update : true,
										categories_delete : true,
										brands_view : true,
										brands_create : true,
										brands_update : true,
										brands_delete : true,
										units_view : true,
										units_create : true,
										units_update : true,
										units_delete : true,
										weight_view : true,
										weight_create : true,
										weight_update : true,
										weight_delete : true,
										discounts_view : true,
										discounts_create : true,
										discounts_update : true,
										discounts_delete : true,
										product_view : true,
										product_create : true,
										product_update : true,
										product_delete : true,
										users_view : true,
										users_create : true,
										users_update : true,
										users_delete : true
									};
									var tempRoleNameRequest = {
										roleName : "admin"
									};
									$http.post("../rest/roleService/insert",tempRoleNameRequest)
									.success(function(data, status, headers, config) {
										tempRoleRequest.roleId = data.id;
										$http.post("../rest/roletoScreens/insert",tempRoleRequest)
										.success(function(data, status, headers, config) {
										
											$scope.usersFormData.role = tempRoleRequest.roleId;
											$http.post("../rest/userService/insert",$scope.usersFormData)
											.success(function(data, status, headers, config) {				
												document.getElementById("adminFirstForm").submit();										
											}).
								  			error(function(data, status, headers, config) {
												
								  			});
											
										}).
							  			error(function(data, status, headers, config) {
											
							  			});
										
									}).
						  			error(function(data, status, headers, config) {
										
						  			});
								}
								else {
									$scope.usersFormData.role = data[0].id;
									$http.post("../rest/userService/insert",$scope.usersFormData)
									.success(function(data, status, headers, config) {
										document.getElementById("adminFirstForm").submit();
									}).
						  			error(function(data, status, headers, config) {
										
						  			});
								}
							}).
				  			error(function(data, status, headers, config) {
								
				  			});
						};
					}
				]
			);
			    
		</script>

</body>
</html>