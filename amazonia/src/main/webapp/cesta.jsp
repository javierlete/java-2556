<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">
	<div class="col-9">
		<h2 class="border-bottom">Cesta</h2>
		<c:forEach begin="1" end="3" var="id">
			<article class="border-bottom p-3">
				<div class="row">
					<div class="col">
						<img src="https://picsum.photos/300/400?${id}" class="img-fluid"
							alt="">
					</div>
					<div class="col-10">
						<h2>Descripción ${id}</h2>
						<p class="fs-4 fw-bold">
							<fmt:formatNumber type="currency" value="${id}"></fmt:formatNumber>
						</p>
						<div style="--bs-breadcrumb-divider: '|';">
							<ol class="breadcrumb d-flex align-items-baseline">
								<li class="breadcrumb-item"><select id="cantidad"
									name="cantidad" class="form-select bg-secondary-subtle"
									style="width: 7rem">
										<option>Cant: 1</option>
										<option>1</option>
										<option>2</option>
										<option>3</option>
								</select></li>
								<li class="breadcrumb-item"><a href="#">Eliminar</a></li>
							</ol>
						</div>
					</div>
				</div>
			</article>
		</c:forEach>
		<footer class="fs-5 text-end">
			Subtotal (4 productos): <span class="fw-bold">40,01 €</span>
		</footer>
	</div>

	<div class="col">
		<div class="card mb-3">
			<form class="card-body">
				<p class="fs-6">
					Subtotal (4 productos): <span class="fw-bold">40,01 €</span>
				</p>
				<p>
					<a href="#" class="w-100 btn btn-warning">Tramitar pedido</a>
				</p>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>