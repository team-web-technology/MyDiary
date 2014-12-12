<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:insertDefinition name="home">
	<tiles:putAttribute name="content">

		<h1>Hello world!</h1>
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
						<tr>
							<td>${user.id }</td>
							<td>${user.username }</td>
							<td>${user.email}</td>
							<td>${user.role.role}</td>
							<td>${user.enabled }</td>
							<td>${user.acountNonLocked}</td>
							<td>${user.acountNonExpired}</td>
						</tr>
					</c:forEach>
				</table>

			</div>
		</c:if>

	</tiles:putAttribute>

</tiles:insertDefinition>