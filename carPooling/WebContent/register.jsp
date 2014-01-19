<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
	<!--Meta Tags-->
	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
		
	<!--Title-->
	<title>Register</title>

	<!--Stylesheets-->
	<link rel="stylesheet" href="css/style3.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/superfish.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="all" />
	<link type="text/css" href="css/jqueryui/jquery.ui.datepicker.css" rel="stylesheet" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/colours/green.css" type="text/css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700' rel='stylesheet' type='text/css' />

	<!--Favicon-->
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

	<!--JavaScript-->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js'></script>
	<script type='text/javascript' src='js/jquery.prettyPhoto.js'></script>
	<script type="text/javascript" src="js/superfish.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript" src="js/selected.js"></script>

<!-- END head -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<!-- BEGIN body -->
<body>
	
	<!-- BEGIN .wrapper -->
	<div class="wrapper">
		
		<!-- BEGIN .topbar -->
		<div class="topbar clearfix">
			
			<!-- BEGIN .social-icons -->
			<ul class="social-icons">
				<li><a href="#"><span id="twitter_icon"></span></a></li>
				<li><a href="#"><span id="facebook_icon"></span></a></li>
				<li><a href="#"><span id="googleplus_icon"></span></a></li>
				<li><a href="#"><span id="skype_icon"></span></a></li>
				<li><a href="#"><span id="flickr_icon"></span></a></li>
				<li><a href="#"><span id="linkedin_icon"></span></a></li>
				<li><a href="#"><span id="vimeo_icon"></span></a></li>
				<li><a href="#"><span id="youtube_icon"></span></a></li>
				<li><a href="#"><span id="rss_icon"></span></a></li>
			<!-- END .social-icons -->
			</ul>
		<!-- 	
			BEGIN .topbar-right
			<div class="topbar-right clearfix">
				
				<ul class="clearfix">
					<li class="checkout-icon"><a href="register.html">New Customer</a></li>
					<li class="myaccount-icon"><a href="my-account.html">My Account</a></li>
				</ul>

			  END .topbar-right
			</div>
		 -->
		<!-- END .topbar -->
		</div>
		
		<!-- BEGIN #site-title -->
		<div id="site-title">
			<a href="index.jsp">
				<h1>Register<span></span></h1>
			</a>
		<!-- END #site-title -->
		</div>
		
		<!-- BEGIN .main-menu-wrapper -->
		
        <div id="main-menu-wrapper" class="clearfix">
			
			<ul id="main-menu" class="fl">
				<li><a href="index.jsp">Home</a></li>
			</ul>	
				
			<form method="post" action="" id="menu-search" class="fr">
				<input type="text" name="s" />
			</form>
		
		<!-- END .main-menu-wrapper -->	
		
		</div>
		
		<div id="page-header">
			<img src="images/page-header1.jpg" alt="" />
		</div>
		
		<!-- BEGIN .section -->
		<div class="section">
			
			<ul class="columns-content page-content clearfix">
				
				<!-- BEGIN .col-main -->
				<li class="col-main">
					
					<!-- BEGIN .blog-title-single -->
					<div class="blog-title-single clearfix">
						
					</div>
					<!-- END .blog-title-single -->
					
					<!-- BEGIN .blog-content -->
					<div class="blog-content clearfix">
						<div class="block-img1"></div>
						
						
					<!-- END .blog-content -->
					</div>
					
						<!-- BEGIN #respond -->
	<!-- <div id="respond" class="clearfix"> -->
		<h3 id="reply-title">Register Information</h3>
       <s:form action="register_userregistration" method="post"> 
								<table border="0" align="center" >
								
				<tr>
			
					<td>
						<s:textfield name="name" label="Name(*)"></s:textfield>
					</td>
					
				</tr>			
				 <tr>
					<td>
						<s:textfield name="email" label="Email(*)"></s:textfield>
                                               
					</td>
				</tr>	
	             			
				<tr>
					<td>Sex(*): </td>
					<td>
						<select name="sex">
                                                <option value="male">Male</option>
                                                <option value="female">Female</option>
                                                </select>
					</td>
				</tr>	
				
				<tr>
					<td>
						<s:textfield name="dob" label="Date of Birth(*)" id="date-input"></s:textfield>
                                               
					</td>
				</tr>
				
					<tr>
                      <td>
						<s:textfield name="driverlicense" label="Driver License" ></s:textfield>
					</td>         
				</tr>	
				
				
				<tr>
                      <td>
						<s:password name="password" label="Password(*)" showPassword="false"></s:password>
					</td>         
				</tr>	
                    
                   <tr>
                      <td>
						<s:password  name="confirmpassword" label="Confirm Password(*)" showPassword="false" ></s:password>
					</td>         
				</tr>	
			    
			 <tr>
					<td>
                                        <s:submit value="Submit"></s:submit>
					</td>
                                        <td>
                                        <s:submit value="Cancel" action="register_cancel"></s:submit>
					</td>
				</tr>										
		  </table>	
								</s:form>

							<!-- END #respond -->
					<!-- 		</div> -->
				
				<!-- END .col-main -->
				</li>
				
				<!-- BEGIN .col-sidebar -->
				<li class="col-sidebar"><!-- END .col-sidebar -->
				</li>
				
			</ul>
			
		<!-- END .section -->
		</div>

		<!-- BEGIN #footer -->
		<div id="footer">
			
			<ul class="columns-4 clearfix">
				<li class="col4">
					
					<!-- BEGIN .widget -->
					<div class="widget">
						<div class="widget-title clearfix">
							<h6>Customer Services</h6>
						</div>
						
						<ul>
							<li class="contact-phone">(412)427-2652</li>
							<li class="contact-mail">kimiyu01@gmail.com</li>
						</ul>

					<!-- END .widget -->
					</div>
					
				</li>
			</ul>
		
		<!-- END #footer -->
		</div>
		
		<div id="footer-bottom" class="clearfix">
			
			<div class="fl">
				
				<ul>
					<li><a href="index.html">Home</a></li>
					
					<li></li>
				</ul>
				
				<p>&copy; Copyright 2013</p>
				
			</div>
		</div>
			
	<!-- END .wrapper -->
	</div>
	
<!-- END body -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>