<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>

         <s:form action="changepassword_change">
				<table border="0" align="center" >
				<tr>
					<td>
						<s:password name="originalpassword" label="Original Password" showPassword="false"></s:password>
					</td>
				</tr>	
						
				 <tr>
					<td>
						<s:password name="password" label="New password" showPassword="false"></s:password>                        
					</td>
				</tr>
				
				 <tr>
					<td>
						<s:password name="confirmpassword" label="Confirm password" showPassword="false"></s:password>                        
					</td>
				</tr>
				
				 <tr>
					<td>
					<s:submit value="Submit" ></s:submit>
					</td>
					<td>
					<s:submit value="Cancel" action="changepassword_cancel"></s:submit>
					</td>
				</tr>
				
				
		</table>	
			
			</s:form>
            
</body>
</html>