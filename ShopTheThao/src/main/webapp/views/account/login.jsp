<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<!-- Main content -->
<div class="main-content">
	<!-- Header -->
	<div class="header bg-gradient-primary py-7 py-lg-8 pt-lg-9">
		<div class="container">
			<div class="header-body text-center mb-7">
				<div class="row justify-content-center">
					<div class="col-xl-5 col-lg-6 col-md-8 px-5">
						<h1 class="text-white">Welcome!</h1>
						<p class="text-lead text-white">Use these awesome forms to
							login or create new account in your project for free.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page content -->
	<div class="container mt--8 pb-5">
		<div class="row justify-content-center">
			<div class="col-lg-5 col-md-7">
				<div class="card bg-secondary border-0 mb-0">
					<div class="card-body px-lg-5 py-lg-5">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							${mess }
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
						<form action="login" method="post" role="form">
							<div class="form-group mb-3">
								<div
									class="input-group input-group-merge input-group-alternative">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-email-83"></i></span>
									</div>
									<input name="username" class="form-control"
										placeholder="Tài khoản" type="text" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-lock-circle-open"></i></span>
									</div>
									<input name="password" class="form-control"
										placeholder="Mật khẩu" type="password" required>
								</div>
							</div>
							<div
								class="custom-control custom-control-alternative custom-checkbox">
								<input class="custom-control-input" id=" customCheckLogin"
									type="checkbox"> <label class="custom-control-label"
									for=" customCheckLogin"> <span class="text-muted">Remember
										me</span>
								</label>
							</div>
							<div class="text-center">
								<input type="submit" class="btn btn-primary my-4"
									value="Đăng nhập">
							</div>
						</form>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-6 text-right">
						<a href="${pageContext.request.contextPath }/account/register"
							class="text-light"><small>Create new account</small></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>