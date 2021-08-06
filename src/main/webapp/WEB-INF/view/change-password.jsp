<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="security"%>

<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<title>Change password | Hogwarts bookstore</title>
	</head>
	<body class="bg-light">
		<jsp:include page="header.jsp"></jsp:include>
		<div> <br> </div>
		<div class="container" >
				<div class="row justify-content-around  ">
				
				<div class="col-xl-5 border bg-white rounded">
				<div class="row">
					<div class="col-xl-12 p-2 text-center mb-4 bg-primary rounded-top ">
						<span class="h3 text-white"> Change password </span>
					</div>
				</div>
					
				<form:form action="${pageContext.request.contextPath}/user/changePassword" 
				modelAttribute="user" method="post" >
				
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Current password: </label>
						<div class="col-xl-7">
							<form:input type="password" class="form-control" path="oldPassword" placeholder="current password"/>
							<form:errors cssClass="failed" path="oldPassword"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">New password: </label>
						<div class="col-xl-7">
							<form:input type="password" class="form-control" path="password" placeholder="new password"/>
							<form:errors cssClass="failed" path="password"> </form:errors>
						</div>
					</div>
					
					<div class="form-group row">
						<label class="col-form-label col-xl-3">Confirm new password: </label>
						<div class="col-xl-7">
							<form:input type="password" class="form-control" path="matchingPassword" placeholder="Confirm new password"/>
							<form:errors cssClass="failed" path="matchingPassword"> </form:errors>
						</div>
					</div>
					
					
					
					<div class="form-group row justify-content-around">
						<div class="col-xl-3">
							<input type="submit" class="form-control btn-primary" value="Update"/>
						</div>
					</div>			
				</form:form>
					<c:if test="${param.change == true}">
					<div class="row justify-content-around">
						<div class="col-xl-10 alert alert-success" role="alert">Change password successfully!
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