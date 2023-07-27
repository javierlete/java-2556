<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<div class="col-9">
		<h2 class="border-bottom">Cesta</h2>
		<c:forEach items="${cesta.articulos}" var="a">
			<article class="border-bottom p-3">
				<div class="row">
					<div class="col">
						<img src="https://picsum.photos/300/400?${a.id}" class="img-fluid"
							alt="">
					</div>
					<div class="col-10">
						<h2>${a.descripcion}</h2>
						<p class="fs-4 fw-bold">
							<fmt:formatNumber type="currency" value="${a.precio}"></fmt:formatNumber>
						</p>
						<div style="--bs-breadcrumb-divider: '|';">
							<ol class="breadcrumb d-flex align-items-baseline">
								<li class="breadcrumb-item"><select id="cantidad"
									name="cantidad" class="form-select bg-secondary-subtle"
									style="width: 7rem">
										<option value="${a.cantidad}">Cant: ${a.cantidad}</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
								</select></li>
								<li class="breadcrumb-item"><a href="eliminar?id=${a.id}">Eliminar</a></li>
							</ol>
						</div>
					</div>
				</div>
			</article>
		</c:forEach>
		<footer class="fs-5 text-end">
			Subtotal (${cesta.cantidadArticulos} productos): <span class="fw-bold"><fmt:formatNumber type="currency" value="${cesta.total}"></fmt:formatNumber></span>
		</footer>
	</div>

	<div class="col">
		<div class="card mb-3">
			<form class="card-body">
				<p class="fs-6">
					Subtotal (${cesta.cantidadArticulos} productos): <span class="fw-bold"><span class="fw-bold"><fmt:formatNumber type="currency" value="${cesta.total}"></fmt:formatNumber></span></span>
				</p>
				<p>
					<a href="#" class="w-100 btn btn-warning">Tramitar pedido</a>
				</p>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>