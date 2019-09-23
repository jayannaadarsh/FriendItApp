<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
	<head>
	<script type='text/javascript'>
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}
</script>
		<meta charset="utf-8">
		<title> Registration</title>
		<link href="./resources/css/stylee.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<h1>Registration form</h1>
		<s:form class="form1" action="saveuser" modelAttribute="user">
			<fieldset class="fieldset1">
			<div>
			<h3>Account Information</h3>
			<label for="Email"> Email: </label>  <s:errors path = "email" ></s:errors>
			<s:input type="text" path="email"/><br><br>
			
			<label for="Password"> Password: </label>
   			<s:input path="password" type="password" /><br><br>
   			<label for="Confirm Password"> Confirm Password: </label>
  		    <s:input path="confirm_password" type="password" /><br><br>
		
			<h3>Personal Information</h3>
			<label for="First Name">First Name:</label>
			<s:input type="text" path="firstname" /><br><br>
			<label for="Last Name">Last Name:</label>
			<s:input type="text" path="lastname"/><br><br>
			<label for="City">City:</label>
			<s:input type="text" path="city" /><br><br>
			<label for="Date Of Birth">Date Of Birth:</label>
			<s:input type="date" path="dob"/> <br><br>
			<label>You Are:</label>
			<div class="Radio">           
            <s:radiobutton  value="M" path="gender" />He<br>
            <s:radiobutton value="F" path="gender" />She<br>
            
            
          
 
        	</div>
			
			<br><br>
			<h3>Profile Information</h3>
			<label for="More About Me">More About Me:</label>
			<input type="text" name="More About Me"><br><br>
			<label for="Upload Profie pic">Upload Profie pic:</label>
			<input type="file" name="image" accept="image/*" onchange="preview_image(event)"><br><br>
			<label for="Captcha Image">Captcha Image:</label>
		
			<img name="Captcha" id="output_image"  style="width:300px;height:300px;border-radius:50%;float: right;
    padding: 5px;"><br><br> 
			
			
			<input class="btn2" type="submit" value="Register">
			<input class="btn3" type="button"  value="Cancel">
		</fieldset>
		
			</div>
			
			<br><br>
		</s:form>
	</body>
</html>
