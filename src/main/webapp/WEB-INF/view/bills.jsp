<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Bills | Hogwarts Bookstore</title>
    
  </head>
  <body class="bg-light">
    <jsp:include page="header.jsp"></jsp:include>
    
    <div><br></div>
    <div class="container ">
      <c:forEach items="${bills}" var="bill" varStatus="loop">
      <div class="container bg-white p-3 border rounded">
        <div class="row">
          <div class="col-xl-3 h3">Bill ID: ${bill.billId} </div>
        </div>
        
        <div class="row">
          <div class="col-xl-9 h4">Date created: <i>${bill.dateCreated}</i></div>
        </div>
        
        <div class="row">
          <div class="col-xl-3 h4">Status: ${bill.status.statusType}</div>
          
        </div>
        <div> <hr> </div>
        <div class="row">
          <c:forEach items="${totals}" begin="${loop.index}" end="${loop.index}" var="temp">
          <c:set var="total" value="${temp}"></c:set>
          </c:forEach>
          <div class="col-xl-3 h4 text-danger">Total: $${total}</div>
          
        </div>
        
        <div><hr></div>
        <div class="row">
          <div class="col-xl-2"><a class="btn btn-success "
          href="${pageContext.request.contextPath}/bills/${bill.billId}" role="button">View detail</a></div>
          
          
          <c:url var="deleteBill" value="bills/deleteBill">
          <c:param name="billId" value="${bill.billId}"></c:param>
          </c:url>
          
          <c:if test="${bill.status.statusId == 1 }">
          <div class="col-xl-2"><a class="btn btn-danger"
          href="${deleteBill}" role="button">Delete bill</a></div>
          </c:if>
          <c:if test="${bill.status.statusId != 1 }">
          <div class="col-xl-2"><button class="btn btn-danger" type="button" disabled>Delete bill</button> </div>
          </c:if>
        </div>
        
      </div>
      <div><br></div>
      </c:forEach>
      
    </div>
    <div><br></div>
    <jsp:include page="footer.jsp"></jsp:include>
    <c:if test="${param.delete == true }">
    <script type="text/javascript"> alert("Delete bill successfully") </script>
    </c:if>
  </body>
</html>