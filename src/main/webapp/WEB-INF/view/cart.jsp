<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Cart | Hogwarts Bookstore</title>
    
  </head>
  <body class="bg-light">
    <jsp:include page="header.jsp"></jsp:include>
    <div> <br> </div>
    
    <c:set var="total" value="${0}"></c:set>
    <c:forEach items="${items}" var="item">
    
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-xl-8 border border-info">
          <div class="row p-3 bg-white ">
            <div class="col-xl-3 border-right border-info">
              <img alt="image" class="img-fluid " src="${pageContext.request.contextPath}/resources/images/${item.book.cover}">
            </div>
            
            <div class="col-xl-9 align-bottom " style="vertical-align: text-bottom">
              <form action="cart/updateItem" method="get">
                <div class="h3 mb-2"> ${item.book.title}</div>
                <div class="h5 mb-2" > Price:<span class="text-danger"> $${item.book.price} </span></div>
                
                <div class=" row form-group mt-2 ml-1 ">
                  <input type="hidden" name="itemId" value="${item.itemId}">
                  <c:if test="${item.book.quantity <= 10}">
                  <input class="form-control col-xl-2" type="number" name="quantity" value ="${item.quantity}" min="1" max= "${book.quantity}"/>
                  </c:if>
                  
                  <c:if test="${item.book.quantity > 10}">
                  <input class="form-control col-xl-2" type="number" name="quantity" value ="${item.quantity}" min="1" max= "10"/>
                  </c:if>
                </div>
                <div><hr></div>
                <div class="h4 mb-3"> Subtotal:<span class="text-danger" id="subtotal"> $${item.quantity * item.book.price}</span></div>
                <c:set var="total" value="${total + (item.quantity * item.book.price) }"></c:set>
                <div class="row">
                  <div class="col-xl-2">
                    <div><input class="btn btn-primary mb-2" type="submit" value="Update">  </div>
                  </div>
                  
                  <c:url var="deleteItem" value="cart/deleteItem">
                  <c:param name="itemId" value="${item.itemId}"></c:param>
                  </c:url>
                  <div class="col-xl-2">
                    <div><a class="btn btn-danger" href="${deleteItem}" role="button">Delete</a>  </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
          
        </div>
      </div>
    </div>
    <div><br></div>
    </c:forEach>
  
  <div class="container">
      <div class="row justify-content-center">
        <div class="col-xl-8 border border-success">
          <div class="row p-3 bg-white">
          <c:if test="${param.buy == true}">
          		<div class="col-xl-5 border-right border-success">
          			<span class="h2">Buy successfully! </span>
          		</div>
          		<div class=" col-xl-3 ">
          			<form:form action="cart/buy" method="post">
          			<div><a class="btn btn-success w-100 h3" href="${pageContext.request.contextPath}/bills" >View your bill</a></div>
          			</form:form>
          		</div>
          	</c:if>
          	<c:if test="${cartCount != 0}">
          		<div class="col-xl-4 border-right border-success">
          			<span class="h2">Total: </span><span class="h2 text-danger">&nbsp $${total} </span>
          		</div>
          		<div class=" col-xl-3 ">
          			<form:form action="cart/buy" method="post">
          			<div><input type="submit" class="btn btn-success w-100 h3" role="button" value="Buy"></div>
          			</form:form>
          		</div>
          	</c:if>
          	<c:if test="${cartCount == 0 && param.buy == false}">
          		<div class="col-xl-4 border-right border-success">
          			<span class="h2">Cart is empty! </span>
          		</div>
          		<div class=" col-xl-3 ">
          			
          			<div><a href="${pageContext.request.contextPath}/" 
          			class="btn btn-success w-100 h3" role="button"> Go to homepage </a></div>
          			
          		</div>
          	</c:if>
          </div>
         </div>
        </div>
    </div>
    
    <c:if test="${cartCount == 0}">
     	<div><br><br><br><br><br><br><br><br><br></div>
    </c:if>
  <div><br><br><br><br><br></div>
  <jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>