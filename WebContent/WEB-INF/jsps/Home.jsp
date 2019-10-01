<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


HOME PAGE
<div>


<a href="logout">Click to logout</a><br>
<a href="friends">friends</a><br>
<a href="FriendsRequest">friend Request</a>
<form action="wallpost">
<input type="text" name="content"/>
<input type="submit">Post</input>
</form>
</div>
<div>
<c:if test="${requststatus=='True'}">
			<c:forEach var="requests" items="${friendrequests}">
			
			</c:forEach>
			</c:if>
</div></br>
<br>

<div>
<br>
<br>
<h1>Posts</h1>
<ul>
			<c:forEach var="wallcontent" items="${wallcontents}">
			<li>
			${wallcontent.wallid.firstname}<br>
			${wallcontent.content}<br>
			Like : ${wallcontent.likes} <form action="likes"><button type="submit" name="sl" value="${wallcontent.sl}">Like</button></form><br>
			Dislike : ${wallcontent.dislike} <form action="dislikes"><button type="submit" name="sl" value="${wallcontent.sl}">DisLike</button></form><br>
			${wallcontent.createdDate}<br>
			
			<br>
			</li>
			
			</c:forEach>
			</ul>
			
</div>




</body>
</html>