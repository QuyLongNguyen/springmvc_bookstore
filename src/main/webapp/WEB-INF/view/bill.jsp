<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Bill | Hogwarts Bookstore</title>
    
  </head>
  <body class="bg-light">
    <jsp:include page="header.jsp"></jsp:include>
    <div><br></div>
    <div class="container ">
     
      <div class="container bg-white p-3 border rounded">
      
      <div class="row">
          <div class="col-xl-3 h4"><a class="text-success " 
        href="${pageContext.request.contextPath}/bills"> &larr;Back</a> </div>
        </div>
        
        
        <div class="row">
          <div class="col-xl-3 h3">Bill ID: ${bill.billId} </div>
        </div>
        
        <div class="row">
          <div class="col-xl-9 h4">Date created: ${bill.dateCreated}</div>
        </div>
        
        <div class="row">
          <div class="col-xl-3 h4">Status: ${bill.status.statusType}</div>
         
        </div>
           <div> <hr> </div> 
        
        <c:set var="total" value="${0}"></c:set>
        <c:forEach items="${billItems}" var="item">
        
        <div class="row">
          <div class="col-xl-6">
            <div class="h4 mb-2"> ${item.book.title}</div>
            <div class="h5 mb-2"> Quantity: ${item.quantity}</div>
            <div class="h5 mb-2"> Price:<span class="text-danger"> $${item.price} </span></div>
            <div class="h5 mb-2"> Subtotal:<span class="text-danger"> $${item.quantity * item.price} </span></div>
            <c:set var="total" value="${total + (item.quantity * item.price)}"></c:set>
   			<div><hr></div>
          </div>
          
        </div>
        </c:forEach>   
        
         <div class="row">
        <div class="col-xl-3 h3 mb-2">Total: <span class="text-danger">$${total} </span></div>
         </div>
         <div><hr></div>
        <div class="row">
          <div class="col-xl-3 h4"><a class="text-success " 
        href="${pageContext.request.contextPath}/bills"> &larr;Back</a> </div>
        </div>
        </div>
        <div><br></div>
       
      
      </div>
      
    </body>
  </html>