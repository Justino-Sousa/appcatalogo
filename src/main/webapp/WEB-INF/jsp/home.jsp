<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<h3>Classe: Catalogo</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>codigo</td>
					<td>Integer</td>
					<td>código do catálogo de jogos</td>
				</tr>
				<tr>
					<td>nome</td>
					<td>String</td>
					<td>nome do catálogo de jogos</td>
				</tr>
				<tr>
					<td>descrição</td>
					<td>String</td>
					<td>descrição do catálogo de jogos</td>
				</tr>
			</tbody>
		</table>

		<h3>Classe: Assinatura</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>tipoAssinatura</td>
					<td>char</td>
					<td>Tipo da assinatura</td>
				</tr>
				<tr>
					<td>catalogo</td>
					<td>Catalogo</td>
					<td>Catalogo da assinatura</td>
				</tr>
				<tr>
					<td>preco</td>
					<td>Bigdecimal</td>
					<td>Preço da assinatura</td>
				</tr>
			</tbody>
		</table>

		<h3>Classe: Jogo</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>codigo</td>
					<td>Integer</td>
					<td>código do jogo</td>
				</tr>
				<tr>
					<td>nome</td>
					<td>String</td>
					<td>nome do jogo</td>
				</tr>
				<tr>
					<td>tipoAssinatura</td>
					<td>char</td>
					<td>tipo da assinatura para esse jogo</td>
				</tr>
			</tbody>
		</table>

		<h3>Classe: JogoBasic</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>valor</td>
					<td>BigDecimal</td>
					<td>preço do jogo</td>
				</tr>
				<tr>
					<td>descricao</td>
					<td>String</td>
					<td>descrição do jogo</td>
				</tr>
				<tr>
					<td>genero</td>
					<td>String</td>
					<td>genero do jogo</td>
				</tr>
			</tbody>
		</table>

		<h3>Classe: JogoPremium</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>valor</td>
					<td>BigDecimal</td>
					<td>preço do jogo</td>
				</tr>
				<tr>
					<td>descricao</td>
					<td>String</td>
					<td>descrição do jogo</td>
				</tr>
				<tr>
					<td>genero</td>
					<td>String</td>
					<td>genero do jogo</td>
				</tr>
			</tbody>
		</table>

		<h3>Classe: JogoDeluxe</h3>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>valor</td>
					<td>BigDecimal</td>
					<td>preço do jogo</td>
				</tr>
				<tr>
					<td>descricao</td>
					<td>String</td>
					<td>descrição do jogo</td>
				</tr>
				<tr>
					<td>genero</td>
					<td>String</td>
					<td>genero do jogo</td>
				</tr>
			</tbody>
		</table>

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