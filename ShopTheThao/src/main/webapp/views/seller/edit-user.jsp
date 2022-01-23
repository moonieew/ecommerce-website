<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>

<div class="row">
	<div class="col-xl-2 order-xl-2"></div>
	<div class="col-xl-12 order-xl-1">
		<div class="card">
			<div class="card-header">
				<c:if test="${mess != null }">
				<div class="alert alert-info alert-dismissible fade show text-center"
					role="alert">
					<strong>${mess }</strong>
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				</c:if>
				<div class="row align-items-center">

					<div class="col-12">
						<h3 class="mb-0 text-center text-success">CHỈNH SỬA TÀI KHOẢN</h3>
					</div>
				</div>
			</div>
			<div class="card-body">
				<form method="post" action="information">
					<h6 class="heading-small text-muted mb-4">Thông tin tài khoản</h6>
					<div class="pl-lg-4">						
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label class="form-control-label" for="input-username">Tên</label>
									<input type="text" name="fname" id="input-username"
										class="form-control" placeholder="Nhập tên" required value="${user.fname }"/>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label class="form-control-label" for="input-username">Họ</label>
									<input type="text" name="lname" id="input-username"
										class="form-control" placeholder="Nhập họ" required value="${user.lname }"/>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label class="form-control-label" for="input-last-name">Email</label>
									<input type="email" name="email" id="input-last-name"
										class="form-control" placeholder="Nhập email" required value="${user.email }"/>
								</div>
							</div>						
							<div class="col-lg-3">
								<div class="form-group">
									<label class="form-control-label" for="input-email">Giới
										Tính</label> <select name="gender" id="gender" class="custom-select"
										required>
										<c:choose>
											<c:when test="${user.gender == 1 }">
												<option value="1" selected>Nam</option>
												<option value="0">Nữ</option>
											</c:when>
											<c:otherwise>
												<option value="1">Nam</option>
												<option value="0" selected>Nữ</option>
											</c:otherwise>
										</c:choose>								
									</select>
								</div>
							</div>
							
							
						</div>
					</div>
					<hr class="my-4" />
					<!-- Address -->
					<h6 class="heading-small text-muted mb-4">Thông tin liên lạc</h6>
					<div class="pl-lg-4">
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label class="form-control-label" for="input-address">Địa
										chỉ</label> <input id="input-address" name="address"
										class="form-control"
										placeholder="1 Võ Văn Ngân, Linh Chiểu, Thủ Đức, TPHCM"
										type="text" required  value="${user.address }"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label class="form-control-label" for="input-city">Số
										điện thoại</label> <input type="text" name="phone" id="input-city"
										class="form-control" placeholder="0914282920" required value="${user.phone }"/>
								</div>
							</div>
							<hr class="my-4" />
							<div class="col-lg-2">
								<input type="submit" class="btn btn-primary"
									value="Chỉnh sửa" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>