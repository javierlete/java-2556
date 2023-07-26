<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">

	<div class="col-auto">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover" href="#">Active</a></li>
			<li class="nav-item"><a class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover" href="#">Link</a></li>
			<li class="nav-item"><a class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover" href="#">Link</a>
				<ul class="ps-3 nav flex-column">
					<li class="nav-item"><a class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover" href="#">Link2</a></li>
					<li class="nav-item"><a class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover" href="#">Link2</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="col">
		<div
			class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-0">
			<c:forEach begin="1" end="10" var="id">
				<div class="col border">
					<div class="position-absolute">
						<span class="bg-warning">#${id}</span> <span class="numero">
						</span>
					</div>
					<div class="p-3 h-100">
						<p class="my-1">
							<a href="#?${id}"><img
								src="https://picsum.photos/300/200?${id}" class="img-fluid"
								alt="..."></a>
						</p>
						<p class="my-1 opciones-claras">
							<a
								class="link-underline-warning link-underline-opacity-0 link-underline-opacity-100-hover"
								href="#?${id}">Artículo bla bla bla</a>
						</p>
						<p class="my-1 opciones-claras">
							<a class="link-underline link-underline-opacity-0" href="#">
								<span class="text-warning"><i class="bi bi-star-fill"></i>
									<i class="bi bi-star-fill"></i> <i class="bi bi-star-half"></i>
									<i class="bi bi-star"></i> <i class="bi bi-star"></i></span> 123.456
							</a>
						</p>
						<p class="my-1">
							<a class="link-danger link-underline-opacity-0" href="#?${id}">12,34€</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>