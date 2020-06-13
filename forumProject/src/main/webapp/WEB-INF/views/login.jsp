
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- Material form login -->
		<div class="card">
		
		  <h5 class="card-header info-color white-text text-center py-4">
		    <strong>Sign in</strong>
		  </h5>
		
		  <!--Card content-->
		  <div class="card-body px-lg-5 pt-0">
		
		    <!-- Form -->
		    <form class="text-center" style="color: #757575;" action="#!">
		
		      <!-- Email -->
		      <div class="md-form">
		        <input type="email" id="materialLoginFormEmail" class="form-control">
		        <label for="materialLoginFormEmail">E-mail</label>
		      </div>
		
		      <!-- Password -->
		      <div class="md-form">
		        <input type="password" id="materialLoginFormPassword" class="form-control">
		        <label for="materialLoginFormPassword">Password</label>
		      </div>
		
		      <div class="d-flex justify-content-around">
		        <div>
		          <!-- Remember me -->
		          <div class="form-check">
		            <input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
		            <label class="form-check-label" for="materialLoginFormRemember">Remember me</label>
		          </div>
		        </div>
		        <div>
		          <!-- Forgot password -->
		          <a href="">Forgot password?</a>
		        </div>
		      </div>
		
		      <!-- Sign in button -->
		      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>
		
		      <!-- Register -->
		      <p>Not a member?
		        <a href="">Register</a>
		      </p>
		
		      <!-- Social login -->
		      <p>or sign in with:</p>
		      <a type="button" class="btn-floating btn-fb btn-sm">
		        <i class="fab fa-facebook-f"></i>
		      </a>
		      <a type="button" class="btn-floating btn-tw btn-sm">
		        <i class="fab fa-twitter"></i>
		      </a>
		      <a type="button" class="btn-floating btn-li btn-sm">
		        <i class="fab fa-linkedin-in"></i>
		      </a>
		      <a type="button" class="btn-floating btn-git btn-sm">
		        <i class="fab fa-github"></i>
		      </a>
		
		    </form>
		    <!-- Form -->
		
		  </div>
		
		</div>
		<!-- Material form login -->	
	</body>
</html>
 --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html lang="en">
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
    
<!DOCTYPE html>
 --><html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Template</title>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/login.css">
  <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
</head>
<body>
    <div class="container">
      <div class="row">
        <div class="col-sm-6 first-column px-0 d-none d-sm-block">
          <!-- <img src="E:/Corporate Training 2020/IIHT/From Praful/Yaksha Assignment/Assignment 1/Junior FSE/Forum.jpg" alt="login image" class="login-img" width=550 height=410> -->
          <img src="${pageContext.request.contextPath}/resources/images/Forum.jpg" alt="login image" class="login-img">

        </div>
        <div class="col-sm-6 second-column login-section-wrapper">
          <div class="brand-wrapper">
            <img src="${pageContext.request.contextPath}/resources/images/forumLogo.png" alt="logo" class="logo rounded-circle">
          </div>
          <div class="login-wrapper my-auto">
            <h1 class="login-title">Log in</h1>
            <form action="#!">
              <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" placeholder="email@example.com" name="email"/>
              </div>
              <div class="form-group mb-4">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control" placeholder="enter your passsword">
              </div>
              <input name="login" id="login" class="btn btn-block login-btn" type="button" value="Login">
            </form>
            <a href="#!" class="forgot-password-link">Forgot password?</a>
            <p class="login-wrapper-footer-text">Don't have an account? <a href="#!" class="text-reset">Register here</a></p>
          </div>
        </div>
      </div>
    </div>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>

<!--     
Default form login
<form class="text-center border border-light p-5" action="#!">

    <p class="h4 mb-4">Sign in</p>

    Email
    <input type="email" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="E-mail">

    Password
    <input type="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password">

    <div class="d-flex justify-content-around">
        <div>
            Remember me
            <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
            </div>
        </div>
        <div>
            Forgot password
            <a href="">Forgot password?</a>
        </div>
    </div>

    Sign in button
    <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>

    Register
    <p>Not a member?
        <a href="">Register</a>
    </p>

    Social login
    <p>or sign in with:</p>

    <a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
    <a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

</form>
Default form login    
    
 -->    
<!--     
		Material form login
		<div class="card">
		
		  <h5 class="card-header info-color white-text text-center py-4">
		    <strong>Sign in</strong>
		  </h5>
		
		  Card content
		  <div class="card-body px-lg-5 pt-0">
		
		    Form
		    <form class="text-center" style="color: #757575;" action="#!">
		
		      Email
		      <div class="md-form">
		        <input type="email" id="materialLoginFormEmail" class="form-control">
		        <label for="materialLoginFormEmail">E-mail</label>
		      </div>
		
		      Password
		      <div class="md-form">
		        <input type="password" id="materialLoginFormPassword" class="form-control">
		        <label for="materialLoginFormPassword">Password</label>
		      </div>
		
		      <div class="d-flex justify-content-around">
		        <div>
		          Remember me
		          <div class="form-check">
		            <input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
		            <label class="form-check-label" for="materialLoginFormRemember">Remember me</label>
		          </div>
		        </div>
		        <div>
		          Forgot password
		          <a href="">Forgot password?</a>
		        </div>
		      </div>
		
		      Sign in button
		      <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>
		
		      Register
		      <p>Not a member?
		        <a href="">Register</a>
		      </p>
		
		      Social login
		      <p>or sign in with:</p>
		      <a type="button" class="btn-floating btn-fb btn-sm">
		        <i class="fab fa-facebook-f"></i>
		      </a>
		      <a type="button" class="btn-floating btn-tw btn-sm">
		        <i class="fab fa-twitter"></i>
		      </a>
		      <a type="button" class="btn-floating btn-li btn-sm">
		        <i class="fab fa-linkedin-in"></i>
		      </a>
		      <a type="button" class="btn-floating btn-git btn-sm">
		        <i class="fab fa-github"></i>
		      </a>
		
		    </form>
		    Form
		
		  </div>
		
		</div>
		Material form login -->
	</body>
</html>