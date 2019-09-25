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
	<form action="searchfriends">
		<input type="text" name="searchquery" class="text-field"
			placeholder="Eneter email" />
		<button type="submit" value="SEARCH" class="button">SEARCH</button>
	</form>
	<ul>

		<c:if test="${not empty searchedUser}">
			<c:forEach var="friends1" items="${searchedUser}">
			<form action = "addasfriend" method="post">
						Name : <span>${friends1.firstname}</span>
				</br>
						DOB : <span>${friends1.dob}</span>
				</br>
						Gender : <span>${friends1.gender}</span>
				</br>
						Email : <span>${friends1.email}</span>
				</br>
				<button type="submit" name="receiverId" value="${friends1.sl}" class="button">Add Friend</button>
				
				</form>


			</c:forEach>
		</c:if>

	</ul>
<c:if test="${not empty requestStatus}"> ${requestStatus} </c:if> <br>
<c:if test="${empty friends1}"> No Results Found </c:if>


</body>
</html>