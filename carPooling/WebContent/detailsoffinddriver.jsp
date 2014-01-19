<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Details Find Drivers</title>

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
     <table border="0" align="center">		
   <s:iterator value="detaillist" status="stuts"> 
        <tr align="center"><td>Post ID:</td><td><s:property value="postID" /></td> </tr>
         <tr align="center"><td>Driver's Name:</td><td><s:property value="name" /></td> </tr>
          <tr align="center"><td>Sex:</td><td><s:property value="sex" /></td> </tr>
        <tr align="center"><td>Date Of Birth:</td><td><s:property value="dob" /></td> </tr>
         <tr align="center"><td>Driver License:</td><td><s:property value="driverlicense" /></td> </tr>
        <tr align="center"><td>Departure:</td><td><s:property value="departure" /></td> </tr>
        <tr align="center"><td>Destination:</td><td><s:property value="destination" /></td> </tr>
         <tr align="center"><td>Departure Date:</td><td><s:property value="departuredate" /></td> </tr>
           <tr align="center"><td>Estimated Leaving Time:</td><td><s:property value="estimatedleavingtime" /></td> </tr>
             <tr align="center"><td>Available Seats:</td><td><s:property value="availableseats" /></td> </tr>
               <tr align="center"><td>Car Type:</td><td><s:property value="cartype" /></td> </tr>
                 <tr align="center"><td>Estimated Total Cost:</td><td><s:property value="estimatedtotalcost" /></td> </tr>
                   <tr align="center"><td>Estimated Cost per Passenger:</td><td><s:property value="estimatedcostperpassenger" /></td> </tr>
                   <tr align="center"><td>Phone:</td><td><s:property value="phone" /></td> </tr>
                   <tr align="center"><td>Email:</td><td><s:property value="email" /></td> </tr>
                     <tr align="center"><td>Memo:</td><td><s:property value="memo" /></td> </tr>
                      <tr align="center"><td>Number of Applied person:</td><td><s:property value="numberofappliedpassengers" /></td> </tr>
                 <tr><s:submit value="Apply Participation" action="passengerApplyParticipation_apply"></s:submit></tr>
    </s:iterator> 	
				</table>		
					</form>			
</body>
</html>