<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="security"%>

<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<title>Profile | Hogwarts bookstore</title>
	</head>
	<body class="bg-light">
		<jsp:include page="header.jsp"></jsp:include>
		<div> <br> </div>
		<div class="container" >
				<div class="row justify-content-around  ">
				
				<div class="col-xl-5 border bg-white rounded">
				<div class="row">
					<div class="col-xl-12 p-2 text-center mb-4 bg-primary rounded-top ">
						<span class="h3 text-white"> Profile </span>
					</div>
				</div>
					
				<form:form action="${pageContext.request.contextPath}/user/updateProfile" 
				modelAttribute="user" method="post" >
					<form:hidden path="id"/>
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Firstname: </label>
						<div class="col-xl-7">
							<form:input class="form-control" path="firstName" placeholder="firstname"/>
							<form:errors cssClass="failed" path="firstName"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Lastname: </label>
						<div class="col-xl-7">
							<form:input class="form-control" path="lastName" placeholder="lastname"/>
							<form:errors cssClass="failed" path="lastName"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Email: </label>
						<div class="col-xl-7">
							<form:input class="form-control" path="email" placeholder="email"/>
							<form:errors cssClass="failed" path="email"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Phone number: </label>
						<div class="col-xl-7">
							<form:input class="form-control" path="phoneNumber" placeholder="phone number"/>
							<form:errors cssClass="failed" path="phoneNumber"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Address: </label>
						<div class="col-xl-7">
							<form:textarea class="form-control" path="address" placeholder="address"/>
							<form:errors cssClass="failed" path="address"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row justify-content-around">
						<div class="col-xl-3">
							<input type="submit" class="form-control btn-primary" value="Update"/>
						</div>
					</div>			
				</form:form>
					<c:if test="${param.update == true}">
					<div class="row justify-content-around">
						<div class="col-xl-9 alert alert-success" role="alert">Update profile successfully!
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    					<span aria-hidden="true">&times;</span>
  						</button>
						</div>
					</div>
					</c:if>
				</div>
				
			</div>
			</div>
		<div><br></div>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>