<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<div class="container-fluid mt--6">
	<div class="row">
		<div class="col-xl-2 order-xl-2"></div>
		<div class="col-xl-12 order-xl-1">
			<div class="card">
				<div class="card-header">
					<c:if test="${mess != null }">
						<div class="alert alert-info alert-dismissible fade show"
							role="alert">
							<strong>${mess }</strong>
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
					<div class="row align-items-center">

						<div class="col-8">
							<h3 class="mb-0">Sửa đơn vị vận chuyển</h3>
						</div>
					</div>
				</div>
				<div class="card-body">
					<form method="post" action="editship">
						<h6 class="heading-small text-muted mb-4">Vận chuyển</h6>
						<div class="pl-lg-4">
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Mã
											vận chuyển</label> <input type="text" name="id" id="input-city"
											class="form-control" value="${idValue}" readonly="readonly"
											placeholder="Ví dụ: Viettel Post" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Tên
											loại vận chuyển</label> <input type="text" name="cachship"
											id="input-city" class="form-control" value="${shipValue}"
											placeholder="Ví dụ: Viettel Post" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Giá
											tiền</label> <input type="number" name="price" id="input-city"
											class="form-control" value="${priceValue}" min="20000"
											required />
									</div>
								</div>
							</div>
							<hr class="my-4" />
							<div class="col-lg-2">
								<input type="submit" class="btn btn-info" value="Sửa" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Dark table -->