<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- 
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
 onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload=""
	 -->
<head>
<meta charset="utf-8">
<title>FriendIt</title>
<link href="./resources/css/stylee.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="section1">
		<!-- <h1>FriendIt.COM</h1> -->
		<br> <img src="./resources/images/flower.jpg">
		<s:form action="login" method="get" modelAttribute="user">
			<fieldset class="fieldset">
				<h3 style="text-align: center;">SIGN IN</h3>
				<label for="Email">Email </label>
				<s:input type="text" path="email" />
				<br>
				<s:errors path="email"></s:errors>
				<br> <label for="Password">Password </label>
				<s:input type="Password" path="password" />
				<br>
				<s:errors path="password"></s:errors>
				<br>
				<p>
					<a href="ForgotPassword">Forgot Password</a>
				</p>
				<input class="btn1" type="submit" value="Login" />
			</fieldset>
		</s:form>
	</div>
	<div class="reg">
		<h2>Come Join Us!</h2>
		<form action="register">
			<input class="btn" name="Submit" type="submit" value="Register">
		</form>
	</div>
	<br>
	<br>
</body>
</html>


