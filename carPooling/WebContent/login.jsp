<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>LogIn</title>

	<!--- CSS --->
 	
<!-- <link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />  -->

 
 	<style type="text/css">
<!--


#container{
	margin: auto;
	margin-top: 180px;
	width: 524px;
	height: 262px;
	text-align: left;
	font-family: Verdana, Arial;
	font-weight: normal;
	font-size:30px;
	color: #ffffff;
	background:#eeeeee url(images/form-bg.png) top left repeat;

}
-->
</style>
	<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->
	</head>

	<body>
		<div id="container">
			<s:form action="login_userlogin">
				<table border="0" align="center" >
						<tr>
					<td>	
							<div class="login">LOGIN</div>
						</td>
					</tr>	
							
				<tr>
					<td>
						<s:textfield name="email" label="Email" ></s:textfield>
					</td>
				</tr>	
						
				 <tr>
					<td>
						<s:password name="password" label="Password" showPassword="false"></s:password>                        
					</td>
				</tr>
				
				 <tr>
					<td>
					<s:submit value="GO"></s:submit>
					</td>
				</tr>
				
				
		</table>	
			
			</s:form>
            
		</div>
	</body>
</html>