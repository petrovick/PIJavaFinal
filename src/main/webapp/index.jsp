<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<html>
	<body>
		<h2>Hello World! teste</h2>
		<div id="formulario">
			<form action="JetSkyServlet" method="post">
				<input type="hidden" name="_id" id="_id" value="${_id}"/>
				<label>Nome</label>
				<input type="text" name="descricao" id="descricao" value="${descricao}"/>
				<label>Login</label>
				<input type="text" name="hp" id="hp" value="${hp}" />
				<label>Senha</label>
				<input type="text" name="peso" id="peso" value="${peso}" />
				<input type="submit" id="buscar" value="Salvar" />
			</form>
		</div>

	</body>
</html>