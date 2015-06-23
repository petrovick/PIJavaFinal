<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<link rel="stylesheet" href="jquery-ui.min.css" />
<script type="text/javascript" src="jquery-ui.min.js" ></script>
<script type="text/javascript" src="jquery-1.11.3.js" ></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


<html>
	<head>
		<style type="text/css" ></style>
	</head>
	<body>
		<div id="mensagem" name="mensagem">${mensagem }</div>
		<div id="formulario">
			<form action="JetSkiServlet" method="post">
				<input class="form-control"  type="hidden" name="_id" id="_id" value="${_id}"/>
				<div class="input-group">
					<input class="form-control" type="text" name="descricao" id="descricao" value="${descricao}" aria-describedby="basic-addon2"/>
					<span class="input-group-addon" id="basic-addon2">Descrição</span>
				</div>
				
				<div class="input-group">
					<input class="form-control" type="text" name="hp" id="hp" value="${hp}" aria-describedby="basic-addon2"/>
					<span class="input-group-addon" id="basic-addon2">HP</span>
				</div>
				
				<div class="input-group">
					<input class="form-control" type="text" name="peso" id="peso" value="${peso}" aria-describedby="basic-addon2"/>
					<span class="input-group-addon" id="basic-addon2">Peso</span>
				</div>
				
				<input class="btn btn-success" type="submit" id="buscar" value="Salvar" />
			</form>
		</div>
	
	<div id="lista">
		<div class="panel panel-default">
			<div class="panel-heading">Jetskies</div>
				<table class="table">
					<tr>
						<th>Codigo</th>
						<th>Descricao</th>
						<th>Peso</th>
						<th>HP</th>
					</tr>
					<c:forEach items="${jetskies}" var="j">
					    <tr>      
					        <td>${j._id}</td>
					        <td>${j.descricao}</td>
					        <td>${j.peso}</td>
					        <td>${j.hp}</td>  
					    </tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>