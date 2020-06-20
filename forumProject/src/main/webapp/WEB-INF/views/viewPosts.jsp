<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View GlobalTech Forum Posts</title>
		<link type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet"/>
		<style>
			table {
			  border-collapse: collapse;
			  border-spacing: 0;
			  width: 100%;
			  border: 1px solid #ddd;
			}
			
			th, td {
			  text-align: left;
			  padding: 16px;
			}
			
			tr:nth-child(even) {
			  background-color: #f2f2f2;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<p class="bg-primary text-danger text-center"><h1>Post Details</h1><br>
		</div>
		<div class="container-fluid">
		 <div class="row-fluid">
		  <div class="span12">
		    <fieldset>
				<table class="table table-hover table-striped-rows table-bordered table-condensed">
				    <tr class="text-danger">
				        <th>Post ID</th>
				        <th>Title</th>
				        <th>Tags</th>
				        <th>Post Description</th>
				        <th>Post Comment | Like</th>
				    </tr>
		           	<c:forEach var="listValue" items="${plist}">
			            <tr>
			                <td>
			                    <c:out value="${listValue.postId}" /> 
			                </td>
			                <td>
			                    <c:out value="${listValue.title}" /> 
			                </td>
			                <td>
			                    <c:out value="${listValue.tags}" /> 
			                </td>
			                <td>
			                    <c:out value="${listValue.postDescription}" /> 
			                </td>
			                <td>
			                    <!-- <a href="addComments">Post Comment</a> -->

			                    <a href="addComments?id=${listValue.postId}" style='text-decoration: none;'>Comment</a> | <a href="updateLike" style='text-decoration: none;'>Like</a>
			                    
				  				<%-- <button class="btn btn-info" onclick="location.href='addComments/id=${listValue.postId}'">Post Comment</button> --%>

			                    <%-- <a href="addComments"><img src="${pageContext.request.contextPath}/resources/images/comment.jpg" class="img-rounded"></img></a> --%>
			                </td>
			            </tr>
		           	</c:forEach>
		        </table>
		    </fieldset>
	   </div>
	  </div>
	 </div>  
	</body>
</html>