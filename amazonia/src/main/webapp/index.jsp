<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<div class="row">

	<div class="col-auto">
		<ul class="nav flex-column">
			<li class="nav-item"><a
				class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover"
				href="#">Active</a></li>
			<li class="nav-item"><a
				class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover"
				href="#">Link</a></li>
			<li class="nav-item"><a
				class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover"
				href="#">Link</a>
				<ul class="ps-3 nav flex-column">
					<li class="nav-item"><a
						class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover"
						href="#">Link2</a></li>
					<li class="nav-item"><a
						class="link-dark link-underline link-underline-opacity-0 link-underline-opacity-100-hover"
						href="#">Link2</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="col">
		<div
			class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-0">
			<c:forEach items="${articulos}" var="a">
				<div class="col border">
					<div class="position-absolute">
						<span class="bg-warning">#${a.id}</span> <span class="numero">
						</span>
					</div>
					<div class="p-3 h-100">
						<p class="my-1">
							<a href="#?${a.id}"><img
								src="https://picsum.photos/300/200?${a.id}" class="img-fluid"
								alt=""></a>
						</p>
						<p class="my-1 opciones-claras">
							<a
								class="link-underline-warning link-underline-opacity-0 link-underline-opacity-100-hover"
								href="#?${a.id}">${a.descripcion}</a>
						</p>
						<p class="my-1 opciones-claras">
							<a class="link-underline link-underline-opacity-0" href="#">
								<span class="text-warning"> <c:forEach begin="1" end="5"
										var="n">
										<c:choose>
											<c:when test="${n <= a.estrellas / 2}">
												<i class="bi bi-star-fill"></i>
											</c:when>
											<c:when test="${n == Math.round(a.estrellas / 2)}">
												<i class="bi bi-star-half"></i>
											</c:when>
											<c:otherwise>
												<i class="bi bi-star"></i>
											</c:otherwise>
										</c:choose>
									</c:forEach>
							</span> ${a.estrellas}
							</a>
						</p>
						<p class="my-1">
							<a class="link-danger link-underline-opacity-0" href="#?${a.id}">
								<fmt:formatNumber type="currency" value="${a.precio}"></fmt:formatNumber>
							</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>