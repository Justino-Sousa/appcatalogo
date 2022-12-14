<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppCatálogo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp" />
	
	<div class="container">
		
		<h2>AppCatalogo</h2>
		<p>Projeto de gestão de catálogo de jogos online</p>
		<hr>
		<h3>Classe: JogoPremium</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Desenvolvedor</th>
					<th>Genero</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="jp" items="${listagem}">
					<tr>
						<td>${jp.codigo}</td>
						<td>${jp.nome}</td>
						<td>${jp.descricao}</td>
						<td>${jp.valor}</td>	
						<td>${jp.desenvolvedor}</td>
						<td>${jp.genero}</td>
						<td><a href="/jogoPremium/${jp.codigo}/delete">excluir</a></td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
		<a href="/jogoPremium/cadastro">
			<button type="button" class="btn btn-outline-dark">Cadastrar</button>
		</a>
	</div>


	<!-- importações de scripts -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
		integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
		crossorigin="anonymous"></script>

</body>
</html>