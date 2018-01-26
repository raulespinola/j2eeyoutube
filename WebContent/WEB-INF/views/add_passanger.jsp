<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>Welcome to World Airlines</h2>
   
   <div class="container">
	   <form action="AddPassanger" method="post">
	     <div class="inputField">
	   		<label for="first_name" class="inputlabel">First Name</label> 
	   		<input name="first_name" type=text></input>
	     </div>
	   	<div class="inputField">
	   		<label for="last_name" class="inputlabel">Last Name</label> 
	   		<input name="last_name" type=text></input>
	     </div>
	   	<div class="inputField">
	   		<label for="birth_date" class="inputlabel">Birth Date New</label> 
	   		<input name="birth_date" type=text></input>
	     </div>
	     <select name="gender">
	     	<option value="Male">Male</option>
	     	<option value="Female">Female</option>
	     </select>
	     
	     <div class="inputField">
	     	<input id="submitBtn" type="submit" value="Add Passanger">
	     </div>
	   	
	   		
	   </form>
   </div>
</body>
</html>