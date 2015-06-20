<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<html>
	<body>
		<h2>Hello World! teste</h2>
		<form action="JetSkyServlet" method="post">
		    <input type="text" name="username">
		    <input type="password" name="password">
		    <input type="submit" value="login">
		    <span class="error">${error}</span>
		</form>
	</body>
</html>