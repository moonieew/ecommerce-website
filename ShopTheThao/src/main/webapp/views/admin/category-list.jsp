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
					<form method="post" action="category">
						<h6 class="heading-small text-muted mb-4">Danh Mục</h6>
						<div class="pl-lg-4">
							<div class="row">
								<div class="col-lg-4">
									<div class="form-group">
										<label class="form-control-label" for="input-city">Tên
											danh mục</label> <input type="text" name="name" id="input-city"
											class="form-control" placeholder="Ví dụ: Áo thể thao"
											required />
									</div>
								</div>
								<hr class="my-4" />
								<div class="col-lg-2">
									<input type="submit" class="btn btn-primary"
										value="Tạo danh mục" />
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
					<h3 class="mb-0">Danh mục sản phẩm</h3>
				</div>
				<!-- Light table -->
				<div class="table-responsive">
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col" class="sort" data-sort="id">Mã danh mục</th>
								<th scope="col" class="sort" data-sort="name">Tên danh mục</th>
								<th scope="col" class="sort" data-sort="action">Hành Động</th>
							</tr>
						</thead>
						<tbody class="list">
							<c:forEach items="${ categoryList}" var="p">
								<tr>
									<td class="budget">${p.id }</td>
									<td class="budget">${p.name }</td>
									<td class="text-right"><a class="btn btn-danger"
										href="${pageContext.request.contextPath }/admin/deletecategory?id=${p.id}"
										onclick="return confirm('Xoá danh mục này ?')">Xoá</a></td>
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