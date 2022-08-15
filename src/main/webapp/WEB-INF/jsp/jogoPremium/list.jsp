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
	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  
	<div class=container>
  		<div class="container-fluid">
    		<div class="collapse navbar-collapse" id="navbarText">
      			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="/">Home</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/jogoBasic/list">Jogos Basic</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/jogoPremium/list">Jogos Premium</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/jogoDeluxe/list">Jogos Deluxe</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/catalogo/list">Catálogo</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="/assinatura/list">Assinatura</a>
			        </li>
      			</ul>
    		</div>
		</div>
	</div>
</nav>
	
	<div class="container">
		
		<h2>AppCatalogo</h2>
		<p>Projeto de gestão de catálogo de jogos online</p>
		<hr>
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