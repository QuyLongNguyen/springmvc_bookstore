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
						<span class="h3 text-white"> Email sender </span>
					</div>
				</div>

				<form:form action="${pageContext.request.contextPath}/login/sendEmail"
					method="POST">
					
					<!-- Check for login error -->
					<c:if test="${error != null }">
						<i class="failed"> ${error}</i>
					</c:if>

					<div class="form-group row">
						<label class="col-form-label col-xl-3">Email: </label>
						<div class="col-xl-7">
							<input type="text" class="form-control"  name="email" 
							placeholder="We will send an authorization code to your email" />
						</div>
					</div>


					<div class="form-group row justify-content-around">
						<div class="col-xl-3">
							<input type="submit" class="form-control btn-primary"
								value="Send" />
						</div>
					</div>
				</form:form>
				
				<c:if test="${message != null }">
						<i class="text-success"> ${message}</i>
					</c:if>
				
				<div class="mb-3">
					<a href="${pageContext.request.contextPath}/">Homepage</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>