<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div class=container>
			<div class="container-fluid">
				<div class="collapse navbar-collapse" id="navbarText">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/">Home</a></li>
						<c:if test="${not empty user}">
							<li class="nav-item"><a class="nav-link"
								href="/usuario/list">Usuário</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/jogoBasic/list">Jogos Basic</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/jogoPremium/list">Jogos Premium</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/jogoDeluxe/list">Jogos Deluxe</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/catalogo/list">Catálogo</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/assinatura/list">Assinatura</a></li>
						</c:if>
					</ul>

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<c:if test="${empty user}">
							<li class="nav-item"><a class="nav-link" href="/usuario/cadastro">Signup</a></li>
							<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
						</c:if>

						<c:if test="${not empty user}">
							<li class="nav-item"><a class="nav-link" href="/login">Logout
									${user}</a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</div>
	</nav>
