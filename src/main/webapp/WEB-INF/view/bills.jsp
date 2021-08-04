<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Cart | Hogwarts Bookstore</title>
    
  </head>
  <body class="bg-light">
    <jsp:include page="header.jsp"></jsp:include>
   <div><br></div>
  <c:forEach items="${bills}" var="bill">
  		<div>${bill.billId}</div>
  		<div>${bill.dateCreated}</div>
  		<div>${bill.status.statusType}</div>
  </c:forEach>
</body>
</html>