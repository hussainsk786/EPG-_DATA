<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Channel Details</title>
</head>
<body>
	<h1>Channel Details</h1>
	<c:choose>

		<c:when test="${!empty listDTO }">

			<table border="1">
				<tr>
					<th>SNO</th>
					<th>Channel Name</th>
					<th>Channel Logo</th>
					<th>Genre</th>
					<th>Language</th>
				</tr>
				<c:forEach items="${listDTO }" var="dto" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${dto.channelName}</td>
						<td><img src="${dto.channelLogo}" width="50" height="50"></td>
						<td>${dto.genre}</td>
						<td>${dto.language}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red">Records not found</h1>
		</c:otherwise>
	</c:choose>


	<h1>
		<a href="/loadForm">Home</a>
	</h1>
</body>
</html>