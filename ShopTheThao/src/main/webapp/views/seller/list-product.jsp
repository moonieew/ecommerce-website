<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!-- Page content -->
<div class="container-fluid mt--6">

	<div class="row">
		<div class="col-xl-12">
			<div class="card">
				<div class="card-header border-0">
					<div class="row align-items-center">
						<div class="col">
							<h3 class="mb-0">Danh sách sản phẩm</h3>
						</div>
						<div class="col text-right">
							<a href="" class="btn btn-sm btn-primary">See all</a>
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<!-- Projects table -->
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col">Hình ảnh</th>
								<th scope="col" class="text-center">Tên sản phẩm</th>
								<th scope="col" class="text-center">Giá tiền</th>
								<th scope="col" class="text-center">Giá khuyến mãi (%)</th>
								<th scope="col" class="text-center">Số lượng</th>
								<th scope="col" class="text-center">Trạng thái</th>
								<th scope="col" class="text-center">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listAllProduct}" var="p">
								<tr>
									<th scope="col"><img src="${p.image }" width="100" height="100"></th>
									<th scope="col" class="text-center">${p.name }</th>
									<th scope="col" class="text-center">${p.price }</th>
									<th scope="col" class="text-center">${p.salePrice }%</th>
									<th scope="col" class="text-center">${p.quantity }</th>
									<th scope="col" class="text-center">
										<c:choose>
											<c:when test="${p.status == 1 }"><a class="text-success">Mở</a>
											</c:when>
											<c:otherwise> <a class="text-danger">Khóa</a> </c:otherwise>
										</c:choose>					
									</th>
									<th scope="col" class="text-center">
										<div class="col">
											<a href="detail?pid=${p.id }" class="btn btn-sm btn-primary">Chi tiết</a>
											<c:choose>
												<c:when test="${p.status == 1 }">
													<a href="status?pid=${p.id }&status=1" class="btn btn-sm btn-danger">Ẩn</a>
												</c:when>
												<c:otherwise>
													<a href="status?pid=${p.id }&status=0" class="btn btn-sm btn-success">Hiện</a>
												</c:otherwise>
											</c:choose>
										</div> 
									</th>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center" >
						<c:if test="${index > 1}">
							<li class="page-item "><a class="page-link"
								href="list?index=${index-1 }">Trước</a></li>
						</c:if>
						<c:forEach begin="1" end="${endP }" var="i">
							<li class="page-item  ${index==i ? "active" : "" }"><a
								class="page-link" href="list?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${index < endP}">
							<li class="page-item "><a class="page-link"
								href="list?index=${index+1 }">Sau</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>



