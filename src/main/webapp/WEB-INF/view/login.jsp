<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login | Hogwarts bookstore</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>

</head>
<body class="bg-light">
	<div class="container" style="margin-top: 10%">
		<div class="row justify-content-around  ">

			<div class="col-xl-5 border bg-white rounded">
				<div class="row ">
					<div class="col-xl-12 p-2 text-center mb-4 bg-primary rounded-top ">
						<span class="h3 text-white"> Login </span>
					</div>
				</div>

				<form:form action="${pageContext.request.contextPath}/authenticate"
					method="POST">
					<!-- Check for login error -->
					<c:if test="${param.error != null }">
						<i class="failed">Sorry! You entered invalid </i>
					</c:if>

					<div class="form-group row">
						<label class="col-form-label col-xl-3">Username: </label>
						<div class="col-xl-7">
							<input type="text" class="form-control" name="username" />
						</div>
					</div>

					<div class="form-group row">
						<label class="col-form-label col-xl-3">Password: </label>
						<div class="col-xl-7">
							<input type="password" class="form-control" name="password" />
						</div>
					</div>

					<div class="form-group row mt-2">
						<div class="col-xl-3" ></div>
						<div class="form-check col-xl-7 ml-3">
							<input class="form-check-input" type="checkbox" id="gridCheck" name="remember-me">
							<label class="form-check-label" for="gridCheck"> Remember me </label>
						</div>
						
					</div>

					<div class="form-group row justify-content-around">
						<div class="col-xl-3">
							<input type="submit" class="form-control btn-primary"
								value="Login" />
						</div>
					</div>
				</form:form>
				<div class="mb-3">
					<a href="${pageContext.request.contextPath}/register">Register New User</a>
				</div>
				
				<div class="mb-3">
					<a href="${pageContext.request.contextPath}/login/forgetPassword">Forget password</a>
				</div>
				
				<div class="mb-3">
					<a href="https://accounts.google.com/o/oauth2/auth?
					scope=email
					&redirect_uri=http://localhost:8080/hogwarts-bookstore/login/google
					&response_type=code
  					&client_id=620331720388-sgff3utkvvg2hl52r8j8eultsqeff6a2.apps.googleusercontent.com
  					">Login With Google</a>
				</div>
				<div class="mb-3">
					<a href="${pageContext.request.contextPath}/">Homepage</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>