<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style type="text/css">
.failed {
	color: red;
}
</style>
</head>

<body>

	<h3>Login page</h3>
	<form:form action="${pageContext.request.contextPath}/register/processRegistration" 
		modelAttribute="userDto" method="POST">

		<c:if test="${registrationError != null}">
			<div class=".failed"> ${registrationError}</div>
		</c:if>
		
		<label>Username: </label>
		<form:input path="username" placeholder="username"/>
		<form:errors cssClass="failed" path="username"> </form:errors>
		<br>
		
		<label>Password: </label>
		<form:input path="password" placeholder="password"/>
		<form:errors cssClass="failed" path="password"> </form:errors>
		<br>
		
		<label>Confirm Password: </label>
		<form:input path="matchingPassword" placeholder="password"/>
		<form:errors cssClass="failed" path="matchingPassword"> </form:errors>
		<br>
		
		<label>Firstname:</label>
		<form:input path="firstName" placeholder="firstname"/>
		<form:errors cssClass="failed" path="firstName"> </form:errors>
		<br>
		
		<label>Lastname:</label>
		<form:input path="lastName" placeholder="lastname"/>
		<form:errors cssClass="failed" path="lastName"> </form:errors>
		<br>
		
		<label>Email:</label>
		<form:input path="email" placeholder="email"/>
		<form:errors cssClass="failed" path="email"> </form:errors>
		<br>
		
		<button type="submit">Register</button>
		
	</form:form>
</body>
</html>
