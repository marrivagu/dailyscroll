<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

<nav class="navbar nav-tabs navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      
      <a class="navbar-brand" href="/SimpleBlog/login.jsp">Daily Scroll</a>
    </div>

    
    
  </div><!-- /.container-fluid -->
</nav>

<div class="jumbotron">
<div class="col-md-3"></div>
  <form class="form-inline" action="register" method="post">
  <div class="form-group">
    <label for="exampleInputName2">Name</label>
    <input type="text" class="form-control" name="userName" id="userName" placeholder="Jane Doe">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">Password</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="********">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">Email</label>
    <input type="text" class="form-control" name="email" id="email" placeholder="jane.doe@example.com">
  </div>
  <button type="submit" class="btn btn-primary btn-lg">Submit</button>
</form>
<div class="pull-sm-right">Have registered already? <a href="/SimpleBlog/login.jsp">click here to login</a></div>
</div>


<!--  
    <form action="register" method="post">
        Name:<input type="text" name="userName"/><br/>
        Password:<input type="password" name="password"/><br/>
        Email Id:<input type="text" name="email" /><br/>
        <input type="submit" value="Submit"/>
    </form>
    -->
</body>
</html>
