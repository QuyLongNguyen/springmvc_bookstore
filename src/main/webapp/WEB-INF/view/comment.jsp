<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<div class="container mt-5 mb-5">
	<div class="d-flex justify-content-center row">
		<div class="d-flex flex-column col-md-10">

			<div class="coment-bottom bg-white p-2 px-4">
				<div class="d-flex flex-row add-comment-section mt-4 mb-4">
					<img class="img-fluid img-responsive rounded-circle mr-2"
						src="https://i.imgur.com/qdiP4DB.jpg" width="68">
					<form action="${book.bookId}/comment"  method="post">

						<div class="form-group">
							<input type="text" class="form-control mr-3"
								placeholder="Add comment" name="content" />
						</div>
						
						
						
						<div class="form-group">
							<input class="btn btn-primary" type="submit" value="Comment">
						</div>
					</form>
				</div>
				<c:forEach var="comment" items="${comments}">
					<div class="commented-section mt-2">
						<div class="d-flex flex-row align-items-center commented-user">
							<h5 class="mr-2">${comment.user.userName}</h5>
							<c:set var="cmtTime" value="${comment.createdTimestamp}"></c:set>
							<%
								Date cmtTime = (Date)pageContext.findAttribute("cmtTime");
								long diff = System.currentTimeMillis() - cmtTime.getTime();
								long seconds = diff / 1000;
								String time = (seconds % 60) + "s ago";
								long minutes = seconds / 60;
								if(minutes > 0){
									time = (minutes % 60) + "m " + time;
								}
								long hours = minutes / 60;
								if(hours > 0){
									time = (hours % 24) +"h " + time;
								}
								long days = hours / 24;
								if(days > 0){
									time = days +"d " + time;
								}	
							%>
							<span class="dot mb-1"></span> <span class="mb-1 ml-2"><%=time%></span>
						</div>
						<div class="comment-text-sm">
							<span>${comment.content}</span>
						</div>
						<div class="reply-section">
							<div class="d-flex flex-row align-items-center voting-icons">
								<i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i
									class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span
									class="ml-2">Like number</span><span class="dot ml-2"></span>
								<h6 class="ml-2 mt-1">Reply</h6>
							</div>
						</div>
					</div>
				</c:forEach>


			</div>
		</div>
	</div>
</div>
