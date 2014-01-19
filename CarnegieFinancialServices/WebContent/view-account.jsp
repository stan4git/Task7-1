<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
    
    <link href="./css/pages/dashboard.css" rel="stylesheet" /> 
    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

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
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							John Doe <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="./account.html"><i class="icon-user"></i> View Account  </a>
							</li>
							
							<li>
								<a href="./change_password.html"><i class="icon-lock"></i> Change Password</a>
							</li>
							
							<li class="divider"></li>
							
							<li>
								<a href="./"><i class="icon-off"></i> Logout</a>
							</li>
						</ul>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			
			<div class="span3">
				
				<div class="account-container">
				
					<div class="account-avatar">
						<img src="./img/headshot.png" alt="" class="thumbnail" />
					</div> <!-- /account-avatar -->
				
					<div class="account-details">
					
						<span class="account-name">John Doe</span>
						
						<span class="account-role">Balance:10,000.00</span>
						
						<span class="account-actions">
							<a href="javascript:;">Profile</a> |
							
							<a href="javascript:;">Edit Settings</a>
						</span>
					
					</div> <!-- /account-details -->
				
				</div> <!-- /account-container -->
				
				<hr />
				
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					
					<li class="active">
						<a href="./">
							<i class="icon-home"></i>
							My Account 		
						</a>
					</li>
					
					<li>
						<a href="./faq.html">
							<i class="icon-gift"></i>
							Buy Fund	
						</a>
					</li>
					
					<li>
						<a href="./plans.html">
							<i class="icon-time"></i>
							Sell Fund		
						</a>
					</li>
					
					<li>
						<a href="./grid.html">
							<i class="icon-lock"></i>
							Request Check	
						</a>
					</li>
					
					<li>
						<a href="./charts.html">
							<i class="icon-check"></i>
							Transaction History	
						</a>
					</li>
					
					<li>
						<a href="./account.html">
							<i class="icon-signal"></i>
							Research Fund							
						</a>
					</li>
					
				</ul>	
				
				<hr />
				
				<div class="sidebar-extra">
					<p>Contact Us: 1-80-CARNEGIE</p>
				</div> <!-- .sidebar-extra -->
				
				<br />
		
			</div> <!-- /span3 -->
			
			
			
			<div class="span9">
				
				<h1 class="page-title">
					<i class="icon-home"></i>
					My Account					
				</h1>
				<div class="widget">
				<div class="widget-header">
					<i class="icon-user"></i>
					<h3>Basic Information</h3>
				</div> <!-- /widget-header -->

				
				<div class="widget-content">
								
								
								
					<div class="tabbable">
						
						<br />
						
							<div class="tab-content">
								<form id="edit-profile" class="form-horizontal" />
									<fieldset>
						
										<div class="control-group">											
											<label class="control-label" for="firstname">First Name</label>
											<div class="controls">
												<input type="text" class="input-medium disabled" id="firstname" value="John" disabled=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="lastname">Last Name</label>
											<div class="controls">
												<input type="text" class="input-medium disabled" id="lastname" value="Doe" disabled=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="email">Currnt Address</label>
											<div class="controls">
												<input type="text" class="input-large disabled" id="address" value="5000 Forbes Ave" disabled=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										<div class="control-group">											
											<label class="control-label" for="password1">Last Trading Day</label>
											<div class="controls">
												<input type="text" class="input-medium disabled" id="tradingday" value="01/16/14" disabled=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
										<div class="control-group">											
											<label class="control-label" for="password2">Cash Balance</label>
											<div class="controls">
												<input type="text" class="input-medium disabled" id="balance" value="10,000.00" disabled=""/>
											</div> <!-- /controls -->				
										</div> <!-- /control-group -->
										
										
											
									
									</fieldset>
								</form>
								
								
								
								
						</div>
					</div>
								
								
								
								
								
								
								
								
							</div> <!-- /widget-content -->
							</div> <!-- /widget -->




				<div class="widget widget-table">
										
					<div class="widget-header">
						<i class="icon-th-list"></i>
						<h3>Funds</h3>
					</div> <!-- /widget-header -->
					
					<div class="widget-content">
					
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>FUND NAME</th>
									<th>TICKER</th>
									<th>SHARE</th>
									<th>VALUE</th>
									<th>OPERATION</th>
								</tr>
							</thead>
							
							<tbody>
								<tr>
									<td>1</td>
									<td>Rydex Dynamic NASDAQ-100 2X Strategy A</td>
									<td>RYVLX</td>
									<td>100.00</td>
									<td>27,233.00</td>
									<td class="action-td">
										<a href="javascript:;" class="btn btn-small btn-warning">
											Buy								
										</a>&nbsp;&nbsp;&nbsp;					
										<a href="javascript:;" class="btn btn-small">
											Sell					
										</a>
									</td>
								</tr>
							</tbody>
						</table>
					
					</div> <!-- /widget-content -->
					
				</div> <!-- /widget -->
				
			</div> <!-- /span9 -->
			
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->
					
	
<div id="footer">
	
	<div class="container">				
		<hr />
		<p>&copy; 2014 Seagull Consulting.</p>
	</div> <!-- /container -->
	
</div> <!-- /footer -->


    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery-1.7.2.min.js"></script>
<script src="./js/excanvas.min.js"></script>
<script src="./js/jquery.flot.js"></script>
<script src="./js/jquery.flot.pie.js"></script>
<script src="./js/jquery.flot.orderBars.js"></script>
<script src="./js/jquery.flot.resize.js"></script>


<script src="./js/bootstrap.js"></script>
<script src="./js/charts/bar.js"></script>

  </body>
</html>