<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>Carnegie Financial Services</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" />
    <link href="./css/font-awesome.css" rel="stylesheet" />
    
    <link href="./css/adminia.css" rel="stylesheet" /> 
    <link href="./css/adminia-responsive.css" rel="stylesheet" /> 
    
    <link href="./css/pages/login.css" rel="stylesheet" /> 

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="./">Carnegie Financial Services</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->

<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>Login</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	
	<form action="login_userlogin" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" name="username" class="" id="username" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" name="password" class="" id="password" />
						</div>
					</div>
				</fieldset>
				
				<div id="remember-me" class="pull-left">
					<input type="checkbox" name="remember" id="remember" />
					<label id="remember-label" for="remember">Remember Me</label>
				</div>
				
				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
						Login
					</button>
				</div>
			</form>
			
			
		</div> <!-- /login-content -->
		
		
		
	
</div> <!-- /login-wrapper -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery-1.7.2.min.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/login.js" type="text/javascript"></script> 
<script>

		jQuery(document).ready(function() {     
		  Login.init();

		});

	</script>


 


	<%-- <div id="container">
		<s:form action="login_userlogin">
			<table border="0" align="center">
				<tr>
					<td>
						<div class="login">LOGIN</div>
					</td>
				</tr>

				<tr>
					<td><s:textfield name="username" label="Username"></s:textfield></td>
				</tr>

				<tr>
					<td><s:password name="password" label="Password" showPassword="false"></s:password></td>
				</tr>

				<tr>
					<td><s:submit value="GO"></s:submit></td>
				</tr>


			</table>

		</s:form>
	</div>
		<div id="footer">
			Seagull Consulting
		</div> --%>
</body>
</html>