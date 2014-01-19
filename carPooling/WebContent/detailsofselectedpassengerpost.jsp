<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Details Of Selected Passengers' Posts</title>

	<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <link rel="stylesheet" href="/resources/demos/style.css" />
	
</head>

<body>
   

<form action="" method="post">  
     <table border="4" align="center">		
   <s:iterator value="detaillist" status="stuts"> 
        <tr align="center"><td>Post ID:</td><td><s:property value="postID" /></td> </tr>
         <tr align="center"><td>Passenger's Name:</td><td><s:property value="name" /></td> </tr>
        <tr align="center"><td>Departure:</td><td><s:property value="departure" /></td> </tr>
        <tr align="center"><td>Destination:</td><td><s:property value="destination" /></td> </tr>
         <tr align="center"><td>Departure Date:</td><td><s:property value="departuredate" /></td> </tr>
           <tr align="center"><td>Estimated Leaving Time:</td><td><s:property value="estimatedleavingtime" /></td> </tr>
             <tr align="center"><td>Need Seats:</td><td><s:property value="needseats" /></td> </tr>
               <tr align="center"><td>Expected Car Type:</td><td><s:property value="expectedcartype" /></td> </tr>
                 <tr align="center"><td>Estimated Cost:</td><td><s:property value="expectedcost" /></td> </tr>
                <tr align="center"><td>Phone:</td><td><s:property value="phone" /></td> </tr>
                  <tr align="center"><td>Sex:</td><td><s:property value="sex" /></td> </tr> 
                   <tr align="center"><td>Date of Birth:</td><td><s:property value="dob" /></td> </tr>
                   <tr align="center"><td>Email:</td><td><s:property value="email" /></td> </tr>
                     <tr align="center"><td>Memo:</td><td><s:property value="memo" /></td> </tr>
                     <tr align="center"><td>Number of Applied Drivers:</td><td><s:property value="numberofapplieddrivers" /></td> </tr>
    </s:iterator> 	
				</table>		
					</form>		
				
</body>
</html>