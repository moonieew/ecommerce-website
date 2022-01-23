<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<!-- Navbar -->
<nav id="navbar-main"
	class="navbar navbar-horizontal navbar-transparent navbar-main navbar-expand-lg navbar-light">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath }/home"> <img
			src="${url}/img/brand/white.png">
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar-collapse" aria-controls="navbar-collapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="navbar-collapse navbar-custom-collapse collapse"
			id="navbar-collapse">
			<div class="navbar-collapse-header">
				<div class="row">
					<div class="col-6 collapse-brand">
						<a href="dashboard.html"> <img
							src="${url}/img/brand/blue.png">
						</a>
					</div>
					<div class="col-6 collapse-close">
						<button type="button" class="navbar-toggler"
							data-toggle="collapse" data-target="#navbar-collapse"
							aria-controls="navbar-collapse" aria-expanded="false"
							aria-label="Toggle navigation">
							<span></span> <span></span>
						</button>
					</div>
				</div>
			</div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a href="${pageContext.request.contextPath }/account/login" class="nav-link">
						<span class="nav-link-inner--text">Đăng nhập</span>
				</a></li>
				<li class="nav-item"><a href="${pageContext.request.contextPath }/account/register" class="nav-link">
						<span class="nav-link-inner--text">Đăng Kí</span>
				</a></li>
			</ul>
			<hr class="d-lg-none" />
		</div>
	</div>
</nav>