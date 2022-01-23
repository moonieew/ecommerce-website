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
						<h1 class="text-white">Create an account</h1>
						<p class="text-lead text-white">Use these awesome forms to
							login or create new account in your project for free.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page content -->
	<div class="container mt--8 pb-5">
		<!-- Table -->
		<div class="row justify-content-center">
			<div class="col-lg-6 col-md-8">
				<div class="card bg-secondary border-0">
					<div class="card-body px-lg-5 py-lg-5">
						<form action="register" method="post" role="form">
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<input name="username" class="form-control"
										placeholder="Tên tài khoản" type="text" required>
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
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-lock-circle-open"></i></span>
									</div>
									<input name="repassword" class="form-control"
										placeholder="Nhập lại mật khẩu" type="password" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<input name="fname" class="form-control" placeholder="Tên"
										type="text" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<input name="lname" class="form-control" placeholder="Họ"
										type="text" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<select name="gender" id="gender" class="form-control" required>
										<option value="0">Nam</option>
										<option value="1">Nữ</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<select name="roleId" id="gender" class="form-control" required>
										<option value="2">Người bán</option>
										<option value="3">Khách</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<input name="phone" class="form-control" placeholder="Số điện thoại"
										type="text" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-email-83"></i></span>
									</div>
									<input name="email" class="form-control" placeholder="Email"
										type="email" required>
								</div>
							</div>
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"><i class="ni ni-hat-3"></i></span>
									</div>
									<input name="address" class="form-control" placeholder="Địa chỉ"
										type="text" required>
								</div>
							</div>
							<div class="row my-4">
								<div class="col-12">
									<div
										class="form-group custom-control custom-control-alternative custom-checkbox">
										<input class="custom-control-input" id="customCheckRegister"
											type="checkbox"  required> <label class="custom-control-label"
											for="customCheckRegister"> <span
											class="text-muted">Tôi đồng ý với điều khoản </span>
										</label>
									</div>
								</div>
							</div>
							<div class="text-center">
								<input type="submit" class="btn btn-primary my-4"
									value="Đăng kí">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>