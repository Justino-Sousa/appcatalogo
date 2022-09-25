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
	
	<br />
	<div class="container">
		<h3>Cadastramento de Catálogos</h3>
		<form method="post" action="/catalogo/incluir">
			
			<div class="mb-3">
				<label class="form-label">Nome</label> 
				<input type="text" class="form-control" name="nome" required="required">
			</div>
			
			<div class="mb-3">
				<label class="form-label">Descrição</label> 
				<input type="text" class="form-control" name="descricao" required="required">
			</div>

			<div class="mb-3">
				<label class="form-label">Assinatura</label> 
				<select class="form-control" name="tipoAssinatura" required="required">
					<option disabled="disabled" selected="selected">Selecione o tipo da assinatura</option>
					<c:forEach var="a" items="${listagem}">
						<option>${a.nome}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="mb-3">
				<c:forEach var="p" items="${jogos}">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""> 
						<label class="form-check-label" >${p.nome}</label>
					</div>
				</c:forEach>
			</div>
			

			<button type="submit" class="btn btn-primary">cadastrar</button>
		</form>

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