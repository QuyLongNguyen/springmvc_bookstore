<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>${book.title}| ${book.category.categoryName} | Hogwarts
	Bookstore</title>

<!-- reference our style sheet 

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /> -->

</head>

<body class="bg-light">
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<br>
	</div>
	<div class="container">
		<nav aria-label="breadcrumb bg-white ">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/">Home</a></li>

				<c:url var="categoryDir" value="/books">
					<c:param name="categoryName" value="${book.category.categoryName}"></c:param>
					<c:param name="page" value="${0}"></c:param>
				</c:url>

				<li class="breadcrumb-item"><a href="${categoryDir}">${book.category.categoryName}
				</a></li>

				<li class="breadcrumb-item active">${book.title}</li>

			</ol>
		</nav>
	</div>
	<div class="container bg-white rounded">
		<div class="row">
			<div class="col-xl-12">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-xl-1"></div>
			<div class="col-xl-4  text-center ">
				<img alt="image" width="70%" height="90%"
					src="${pageContext.request.contextPath}/resources/images/${book.cover}">
			</div>

			<div class="col-xl-1"></div>

			<div class="col-xl-6 ">
				<div class="h3">${book.title}</div>
				<div class="h6">Author: ${book.author}</div>
				<div class="h6">Publish year: ${book.publishYear}</div>

				<div class="text-danger h4 mb-3 mt-3">$${book.price}</div>
				<div>
					<form:form action="addToCart" modelAttribute="item" method="POST">
						<form:hidden path="itemId" />
						<form:hidden path="bookId" value="${book.bookId}" />

						<div class="row form-group mt-2 ml-1">
							<c:if test="${book.quantity <= 10}">
								<form:input class="form-control col-xl-2" type="number"
									value="1" min="1" max="${book.quantity}" path="quantity" />
							</c:if>

							<c:if test="${book.quantity > 10}">
								<form:input class="form-control col-xl-2" type="number"
									value="1" min="1" max="10" path="quantity" />
							</c:if>

							<small id="emailHelp" class="form-text text-muted w-100">Max
								quantity is 10, contact us to buy more.</small>
						</div>
						<div class="col-xl-8 mb-3 mr-3"></div>

						<input class="btn btn-danger mr-3" type="submit"
							value="Add to cart">
						<span> <svg xmlns="http://www.w3.org/2000/svg" width="30"
								height="30" fill="#d9534f" class="bi bi-heart-fill"
								viewBox="0 0 16 16">
  <path fill-rule="evenodd"
									d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z" />
</svg>
						</span>

					</form:form>
				</div>
				<c:if test="${param.buy == true}">
					<div class="row mt-2 ml-1">
						<div class="col-xl-6 alert alert-success " role="alert">
							Add to cart successfully!
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</div>

				</c:if>
			</div>

		</div>
	</div>
	<div>
		<br>
	</div>
	<div class="container bg-white rounded p-3">
		<div class="row">
			<div class="col-xl-12 h3 lead">Description</div>
		</div>
		<div>
			<hr>
		</div>
		<div class="row">
			<div class="col-xl-12">${book.description}</div>
		</div>
	</div>

	
	<jsp:include page="comment.jsp"></jsp:include>

	<div>
		<br>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>


