<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!--Meta Tags-->
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	
		
	<!--Title-->
	<title>CarPooling</title>

	<!--Stylesheets-->
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
				<li><a href="Myfirst.xml"><image src="images/RSS_LOGO.png"/></a></li>

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
			
			<!-- BEGIN .topbar-right -->
			<div class="topbar-right clearfix">
				
				<ul class="clearfix">
					<li class="checkout-icon"><a href="register.jsp">New Customer</a></li>
					<li class="myaccount-icon"><a href="login_testLogin">My Account</a></li>
				</ul>

			  <!-- END .topbar-right -->
			</div>
		
		<!-- END .topbar -->
		</div>
		
		<!-- BEGIN #site-title -->
		<div id="site-title">
			<a href="index.jsp">
		<h1>Car Pooling<span></span></h1> 
			</a>
		<!-- END #site-title -->
		</div>
		
		<!-- BEGIN .main-menu-wrapper -->
		<div id="main-menu-wrapper" class="clearfix">
			
			<ul id="main-menu" class="fl">
				<li><a href="index.jsp">Home</a></li>
								
				
				<li><a href="findDriver_find">Find Driver</a>
				<li><a href="findPassenger_find">Find Passenger</a>
				
				
				</li>
				
			</ul>
			
			<%-- <s:form method="get"  id="menu-search" class="fr" >
				<input type="text" name="s" />
			</s:form> --%>
		
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
					
					<h2 class="page-title">Service Group</h2>
					
					<!-- BEGIN .blog-title -->
					<div class="blog-title clearfix">
						<div class="fl">
							<h3><a>Group Member</a><span>
							
							</span></h3>
						</div>
					  <!-- END .blog-title -->
					</div>

					<!-- BEGIN .blog-content -->
					<div class="blog-content clearfix">
						<div class="block-img1"></div>
						<p>
						<table width="100%" class="account-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td data-title="ID">1</td>
						<td data-title="Name">Yaping Chen</td>
						<td data-title="Email">yac32@pitt.edu</td>
					</tr>
					<tr>
						<td data-title="ID">2</td>
						<td data-title="Name">Yue Wang</td>
						<td data-title="Email">yuw57@pitt.edu</td>
					</tr>
					<tr>
						<td data-title="ID">3</td>
						<td data-title="Name">Michael Kozenko</td>
						<td data-title="Email">mek135@pitt.edu</td>
					</tr>
					<tr>
						<td data-title="ID">4</td>
						<td data-title="Name">Shimiao Ren</td>
						<td data-title="Email">shr48@pitt.edu</td>
					</tr>
				</tbody>
			</table>
						</p>
						
					<!-- END .blog-content -->
					</div>
					
					
				<!-- BEGIN .col-sidebar -->
				<li class="col-sidebar">
				  <div class="widget">
				    <div class="widget-title clearfix"><h4 class="tag-title">Recent News</h4></div>
						
						<ul class="latest-posts-list clearfix">
							
							<li class="clearfix">
								<div class="lpl-img">
									<a href="blog-single.html" rel="bookmark">
										<img width="66" height="66" src="images/blog-thumb1.jpg" alt="" />
									</a>
								</div>
								<div class="lpl-content">
									<h6><a href="" rel="bookmark">The Price of Carpooling </a> <span> Posted Jun 13, 2013 By user</span>
									<span>
									Carpooling is an efficient solution to improve the mobility of millions of Europeans while reducing carbon emissions and traffic.

With carpooling, people can travel cheap in a safe and friendly way. </span></h6>
								</div>
							</li>
							
							
						</ul>
					
					</div>
					
				<!-- END .col-sidebar -->
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
					<li><a href="index.jsp">Home</a></li>
					
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