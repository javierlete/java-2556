<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<article class="col-9 border-bottom border-2">
		<div class="row">
			<div class="col">
				<img src="https://picsum.photos/300/400" class="img-fluid" alt="">
			</div>
			<div class="col-8">
				<header class="border-bottom border-2">
					<h2>${articulo.descripcion}</h2>
					<p class="my-1 opciones-claras">
						<a class="link-underline link-underline-opacity-0" href="#"> <span
							class="text-warning"> <c:forEach begin="1" end="5" var="n">
									<c:choose>
										<c:when test="${n <= articulo.estrellas / 2}">
											<i class="bi bi-star-fill"></i>
										</c:when>
										<c:when test="${n == Math.round(articulo.estrellas / 2)}">
											<i class="bi bi-star-half"></i>
										</c:when>
										<c:otherwise>
											<i class="bi bi-star"></i>
										</c:otherwise>
									</c:choose>
								</c:forEach>
						</span> ${articulo.estrellas}
						</a>
					</p>
				</header>
				<p class="fs-3">
					<fmt:formatNumber type="currency" value="${articulo.precio}"></fmt:formatNumber>
				</p>
			</div>
		</div>
	</article>

	<div class="col">
		<div class="card mb-3">
			<form class="card-body" action="cesta" method="post">
				<p class="fs-3">
					<fmt:formatNumber type="currency" value="${articulo.precio}"></fmt:formatNumber>
				</p>
				<p class="card-text d-flex align-items-baseline">
					<input type="hidden" name="id" value="${articulo.id}">
					<label for="cantidad">Cantidad:</label>
					<select id="cantidad" name="cantidad" class="form-select" style="width: 4rem">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select>
				</p>
				<p>
					<button class="w-100 btn btn-warning rounded-pill">Añadir a la cesta</button>
				</p>
				<p>
					<a href="#" class="w-100 btn btn-warning rounded-pill">Comprar ya</a>
				</p>
			</form>
		</div>
		<div class="card">
			<div class="card-header text-center">Compara precios en Amazonia</div>
			<div class="card-body d-flex justify-content-between">
				<p class="card-text text-danger fs-4">
					12,34 €
				</p>
				<p>
					<a href="#" class="btn btn-sm btn-warning rounded-pill">Añadir a la cesta</a>
				</p>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>