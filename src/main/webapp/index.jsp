<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<script src="http://code.jquery.com/jquery-1.11.3.js" type="text/javascript"></script>
<html>
	<body>
		<h2>Hello World! teste</h2>
		<div id="formulario">
			<form action="JetSkyServlet" name="form" method="post">
				<input type="hidden" name="_id" id="_id" value="${_id}"/>
				<label>Descrição</label>
				<input type="text" name="descricao" id="descricao" value="${descricao}"/>
				<label>HP</label>
				<input type="text" name="hp" id="hp" value="${hp}" />
				<label>Peso</label>
				<input type="text" name="peso" id="peso" value="${peso}" />
				<input type="button" id="buscar" value="Salvar" />
			</form>
		</div>
		
		<div id="lista">
			<c:import url="lista"></c:import>
		</div>
		
		<script>
			$('#form').on("click", function()
			{
				$.ajax({
					url: $('#form').attr("action"),
					type: "POST",
					success:function(data)
					{
						
					}
				});
			});
		</script>
	</body>
</html>