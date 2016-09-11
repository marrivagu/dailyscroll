<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--  -->
<!-- Bootstrap CDN Start -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- Bootstrap CDN End -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Scribe Well</title>
</head>
<body>
	<!-- Nav start -->
	<nav class="navbar nav-tabs navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Daily Scroll</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="LoginController?username=${username}">My Posts <span
						class="sr-only">(current)</span></a></li>
				<li><a href="AllPostsController?username=${username}">All Posts</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				
				<li><a href="#">Welcome ${username} </a></li>
				<!-- <li><a href="/SimpleBlog/login.jsp" class="btn btn-primary" role="button">   Logout  </a></li> -->
				<li><a href="/SimpleBlog/login.jsp">Logout</a></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- Nav End -->

	<!-- Post Display Start -->
	
	<div class="row">
	<c:forEach var="post" items="${postList}">
  <div class="col-sm-6 col-md-4">
    
    
    
    <div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title text-uppercase font-weight-bold">${post.posttitle}</h3>
  </div>
  <div class="panel-body">
    <p>${post.posttext}</p>
    
    <div class="well well-sm">
	<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	${post.username}
	<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
	${post.createddate}
	</div>
    
  </div>
</div>
      
      
        
       
      
      
      
    
  </div>
  </c:forEach>
</div>
	


	<!-- Post Display End -->

<!-- Post Message start -->
	<div class="panel panel-success col-md-offset-2 col-md-8">
		<div class="panel-heading">
			<h3 class="panel-title">New Post</h3>
		</div>
		<div class="panel-body">

			<form class="form-horizontal" action="PostController" method="post">
			
			<div class="form-group">
					<label for="Title" class="col-sm-2 control-label">Title</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="posttitle" id="posttitle" placeholder="">
					</div>
				</div>
			
				<div class="form-group">
					<label for="message" class="col-sm-2 control-label">Message</label> 
					<div class="col-sm-10">
						<textarea class="form-control" rows="8" name="posttext" id="posttext"></textarea>
						<input type="hidden" name="username" value="${username}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary btn-lg active">Post</button>
					</div>
				</div>
			</form>

		</div>
	</div>
<!-- Post Message End -->

</body>
</html>