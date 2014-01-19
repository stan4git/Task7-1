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
	<title>Manage My Post As Passenger</title>

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
		
		<h3 id="reply-title">Information Of Potential Drivers</h3>
       <s:form action="" method="post"> 
 <table border="0" align="center" >
	<tr>
     <td><div align="center">Email</div></td>
     <td><div align="center">Name</div></td>  
     <td><div align="center">Sex</div></td>  
     <td><div align="center">Date of Birth</div></td>  
     <td><div align="center">Driver License</div></td>  
     
  </tr> 
     <s:iterator value="ulist" status="stuts"> 
        <tr align="center"> 
         <td><s:property value="email" /></td> 
            <td><s:property value="name" /></td> 
             <td><s:property value="sex" /></td> 
              <td><s:property value="dob" /></td> 
               <td><s:property value="driverlicense" /></td>
        </tr> 
    </s:iterator> 	
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
					<li><a href="index.jsp">Home</a></li>
					<li><a href="contact.jsp">Contact Us</a></li>
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