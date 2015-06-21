<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<script src="jquery-1.11.3.js" type="text/javascript"></script>
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
				<input type="submit" id="buscar" value="Salvar" />
			</form>
		</div>
		
		<div id="lista">
			<table>
				<c:forEach items="${jetskies}" var="jetski">
					<tr>
						<td>${jetski.descricao}</td>
						<td>${jetski.hp}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
<!-- 		<script> -->
// 			$('#buscar').click(function()
// 			{
// 				alert('clicou');
// 				$.ajax({
// 					url: $('#form').attr("action"),
// 					type: "POST",
// 					success:function(data)
// 					{
// 						$('#lista').empty();
// 						$('#lista').html(data);
// 					}
// 				});
// 			});
<!-- 		</script> -->
	</body>
</html>