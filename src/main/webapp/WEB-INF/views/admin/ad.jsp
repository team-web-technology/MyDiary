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
	<c:if test="${not empty users }">
		<div id="userlist">
			<table>
				<tr>
					<th>ID</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Permission</th>
					<th>Enabled</th>
					<th>Locked</th>
					<th>Expired</th>
				</tr>

				<c:forEach var="user" items="${users }">
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.email}</td>
					<td>${user.email}</td>
					<td>${user.enabled }</td>
					<td>${user.acountNonLocked}</td>
					<td>${user.acountNonExpired}</td>
				</c:forEach>
			</table>

		</div>
	</c:if>
</body>
</html>