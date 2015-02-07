<%@page import="com.shopping.daofactory.ShoppingCartFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.shopping.to.UsersTo"%>
<%@page import="java.util.Collection"%>
<%@page import="com.shopping.action.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../assets/public/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../assets/public/css/sb-admin.css">
    <link rel="stylesheet" type="text/css" href="../assets/public/css/font-awesome.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="../assets/public/css/ng-tags-input.css">
	<link rel="stylesheet" type="text/css" href="../assets/public/css/angular-ui-tree.min.css">
	<link rel="stylesheet" type="text/css" href="../assets/private/css/admin.css">
</head>
<body>

	<%@ page session="false" %>
	<%
	
		try {
			HttpSession session = request.getSession(false);
			System.out.println("userId:::::::::::::::::::::::::::");
			
			if(session == null || session.getAttribute("userId") == null){
					 
				Collection<UsersTo> usersTo = new ArrayList<UsersTo>();
				usersTo = ShoppingCartFactory.getUserDao().getAll();
				System.out.println(usersTo.size());
				if(usersTo.isEmpty())
				{
					response.sendRedirect("adminFirst.jsp");
				}
				else {
				   response.sendRedirect("login.html");
				}
				%>
				<script type="text/javascript">
				var GLOBALCONFIG = { userID : 0 };
				</script>
				<%
			}
			else {
				System.out.println(session.getAttribute("userId"));
				%>
				<script type="text/javascript">
				var GLOBALCONFIG = {userID : <%=session.getAttribute("userId")%>};
				</script>
				<%				
			}
			//return Response.status(201).entity(usersTo).build();
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Unable to Find Records";
			//return Response.status(403).entity(error).build();
		}
		
	%>
	<div id="starterdiv"></div>
	<div id="appdiv">
	
		<div class="container-fluid spinner_block" ng-class="{true: 'spinerActive', false: 'spinerInactive'}[spinerisActive]">
			<div class="spinner">
				<div class="spinner-container container1">
					<div class="circle1"></div>
					<div class="circle2"></div>
					<div class="circle3"></div>
					<div class="circle4"></div>
				</div>
				<div class="spinner-container container2">
					<div class="circle1"></div>
					<div class="circle2"></div>
					<div class="circle3"></div>
					<div class="circle4"></div>
				</div>
				<div class="spinner-container container3">
					<div class="circle1"></div>
					<div class="circle2"></div>
					<div class="circle3"></div>
					<div class="circle4"></div>
				</div>
			</div>
		</div>

		<div id="wrapper">
			<div header></div>
			<div id="page-wrapper">
            	<div class="container-fluid workarea">
					<div ui-view></div>
				</div>
			</div>
		</div>		
	</div>
		<!-- data:image/jpeg;base64 - image -->
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

		<script type="text/javascript" src="app.js"></script>

		<!-- controllers -->
		<script type="text/javascript" src="controllers/categories-controller.js"></script>
		<script type="text/javascript" src="controllers/brands-controller.js"></script>
		<script type="text/javascript" src="controllers/units-controller.js"></script>
		<script type="text/javascript" src="controllers/weights-controller.js"></script>
		<script type="text/javascript" src="controllers/discounts-controller.js"></script>
		<script type="text/javascript" src="controllers/products-controller.js"></script>
		<script type="text/javascript" src="controllers/userRoles-controller.js"></script>
		<script type="text/javascript" src="controllers/users-controller.js"></script>

		<!-- directives -->
		<script type="text/javascript" src="directives/header-directive.js"></script>

		<!-- services -->
		<script type="text/javascript" src="services/categories-services.js"></script>
		<script type="text/javascript" src="services/brands-service.js"></script>
		<script type="text/javascript" src="services/units-service.js"></script>
		<script type="text/javascript" src="services/weights-service.js"></script>
		<script type="text/javascript" src="services/discounts-service.js"></script>
		<script type="text/javascript" src="services/products-service.js"></script>
		<script type="text/javascript" src="services/users-service.js"></script>
		<script type="text/javascript" src="services/userRoles-service.js"></script>

</body>
</html>