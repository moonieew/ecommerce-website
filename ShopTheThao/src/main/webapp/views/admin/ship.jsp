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
							<h3 class="mb-0">Thêm Danh Mục</h3>
						</div>
					</div>
				</div>
				<div class="card-body">
					<form method="post" action="ship">
						<h6 class="heading-small text-muted mb-4">Vận chuyển</h6>
						<div class="pl-lg-4">
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Tên loại vận chuyển</label> <input type="text" name="cachship" id="input-city"
											class="form-control" placeholder="Ví dụ: Viettel Post"
											required />
									</div>
								</div>
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Giá
											tiền</label> <input type="number" name="price" id="input-city"
											class="form-control" min="20000" required />
									</div>
								</div>
								<hr class="my-4" />
								<div class="col-lg-2">
									<input type="submit" class="btn btn-primary"
										value="Thêm" />
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="card">
				<!-- Card header -->
				<div class="card-header border-0">
					<h3 class="mb-0">Danh sách vận chuyển</h3>
				</div>
				<!-- Light table -->
				<div class="table-responsive">
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col" class="sort" data-sort="id">Tên vận chuyển</th>
								<th scope="col" class="sort" data-sort="name">Tiền vận
									chuyển</th>
								<th scope="col" class="sort" data-sort="action">Hành Động</th>
							</tr>
						</thead>
						<tbody class="list">
							<c:forEach items="${ shipList}" var="p">
								<tr>
									<td class="budget">${p.cachShip }</td>
									<td class="budget">${p.price }</td>
									<td class="text-right">
										<div class="dropdown">
											<a class="btn btn-sm btn-icon-only text-light" href="#"
												role="button" data-toggle="dropdown" aria-haspopup="true"
												aria-expanded="false"> <i class="fas fa-ellipsis-v"></i>
											</a>
											<div
												class="
                        dropdown-menu dropdown-menu-right dropdown-menu-arrow
                      ">
												<a class="dropdown-item"
													href="${pageContext.request.contextPath }/admin/deleteship?id=${p.id}"
													onclick="return confirm('Xoá mục này ?')">Xoá</a> <a
													class="dropdown-item"
													href="${pageContext.request.contextPath }/admin/editship?id=${p.id}&cachship=${p.cachShip}&price=${p.price}"
													onclick="return confirm('Sửa mục này ?')">Sửa</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Card footer -->
			</div>
		</div>
	</div>
	<!-- Dark table -->
</div>