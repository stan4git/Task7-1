<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<!--Meta Tags-->
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	
		
	<!--Title-->
	<title>My Account</title>

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
			
			<!-- BEGIN .topbar-right -->
			<div class="topbar-right clearfix">
				
				<ul class="clearfix">
						<li class="myaccount-icon">${sessionScope.email}</li>
					<li class="myaccount-icon"><a href="logout_out">Log Out</a></li>
				</ul>

			  <!-- END .topbar-right -->
			</div>
		
		<!-- END .topbar -->
		</div>
		
		<!-- BEGIN #site-title -->
		<div id="site-title">
			<a href="index.jsp">
				<h1>My Account Center<span></span></h1>
			</a>
		<!-- END #site-title -->
		</div>
		
		<!-- BEGIN .main-menu-wrapper -->
		<div id="main-menu-wrapper" class="clearfix">
			
			<ul id="main-menu" class="fl">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="">Post</a>
					<ul>
						<li><a href="Dpost.jsp">Post As Driver</a></li>
						<li><a href="Ppost.jsp">Post As Passenger</a></li>
				</ul>
				
			
				<li><a href="my-account.jsp">Manage Posts</a>
					<ul>
						<li><a href="managepost_asDriver">Manage My Post As Driver</a></li>
						<li><a href="managepost_asPassenger">Manage My Post As Passenger</a></li>
					</ul>
				</li>
				
				<li><a href="my-account.jsp">Manage Participated Post</a>
					<ul>
						<li><a href="manageparticipatedpost_asDriver">My Selected Passengers</a></li>
						<li><a href="manageparticipatedpost_asPassenger">My Selected Drivers</a></li>
					</ul>
				</li>
				
				<li><a href="my-account.jsp">Manage Account</a>
				<ul>
						<li><a href="changepassword.jsp">Change Password</a></li>
						<li><a href="reviseprofile_getInfo">Revise Profile</a></li>
					</ul>
				</li>
			</ul>
			
		
		
		<!-- END .main-menu-wrapper -->	
		
		</div>
		
		<div id="page-header">
			<img src="images/page-header1.jpg" alt="" />
		</div>
		
		<!-- BEGIN .section -->
		<div class="section page-content clearfix">
	
			<h2 class="page-title">My Account</h2>

			<p> Welcome to your account area.</p>
				
			<div class="tag-title-wrap clearfix">
				<h4 class="tag-title">Tips</h4>
			</div>
					<div class="lpl-content">
									<h6><a href="" rel="bookmark">The Price of Carpooling </a> <br/><br/>
									<span> Posted Jun 13, 2013 By user</span><br/><br/>
			
									
									Carpooling is an efficient solution to improve the mobility of millions of Europeans while reducing carbon emissions and traffic.

With carpooling, people can travel cheap in a safe and friendly way. </h6><br/>
								</div>
			
			<p>&nbsp;</p>
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