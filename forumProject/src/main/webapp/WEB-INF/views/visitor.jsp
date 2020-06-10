<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Forum Application</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
<!--         <p>
        	<a style=text-decoration:none href="addPost">1. Add Post</a><br><br>
        	<a style=text-decoration:none href="viewPosts">2. View Posts</a><br><br>
        	<a style=text-decoration:none href="addComments">3. Add Comments</a><br><br>
        	<a style=text-decoration:none href="viewDiscussion">4. View Discussion</a>
        </p>
 -->
        <div class="container">
			<br>
				<!-- <p class="bg-danger text-white text-center form-rounded"><b>Online Forum Application</b></p><br> -->
<!-- 			<div class="card bg-danger text-white text-center form-rounded" style="width: 70rem; height: 4rem">
    			<div class="card-body">
    				<h1><b>Online Forum Application</b></h1>
    			</div>
  			</div><br><br> -->
  			
   			<div style="height: 100px;">
				<div class="bg-danger h-50 d-inline-block text-white text-center form-rounded" style="width: 1120px;"><h2><b>Online Forum Application</b><h2></div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<a href="addPost" 		 class="btn btn-info btn-md btn-block" role="button"><b>Add Post</b></a><br>
					<a href="viewPosts" 	 class="btn btn-info btn-md btn-block" role="button"><b>View Posts</b></a><br>
					<a href="addComments" 	 class="btn btn-info btn-md btn-block" role="button"><b>Add Comments</b></a><br>
					<a href="viewDiscussion" class="btn btn-info btn-md btn-block" role="button"><b>View Discussion</b></a><br><br>
				</div>
			</div>
			<h1><p class="bg-primary text-white text-right">IIHT</p></h1><br>
		</div>        
        
    </body>
</html>