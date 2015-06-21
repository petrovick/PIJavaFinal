<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
	<body>
	<p>${jetskies}</p>
		<table>
			<c:forEach items="${jetskies}" var="jetski">
				<tr>
					<td>${jetski.descricao}</td>
					<td>${jetski.hp}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>