<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>
<div class="container-fluid mt--6">
	<div class="row">
		<div class="col">
			<div class="card">
				<!-- Card header -->
				<div class="card-header border-0">
					<h3 class="mb-0">Danh sách tài khoản</h3>
				</div>
				<!-- Light table -->
				<div class="table-responsive">
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col" class="sort" data-sort="mads">Tên đăng nhập</th>
								<th scope="col" class="sort" data-sort="hoten">Mật khẩu</th>
								<th scope="col" class="sort" data-sort="hoten">Họ tên</th>
								<th scope="col" class="sort" data-sort="gioitinh">Giới Tính</th>
								<th scope="col" class="sort" data-sort="sdt">SĐT</th>
								<th scope="col" class="sort" data-sort="namsinh">Email</th>
								<th scope="col" class="sort" data-sort="diachi">Địa Chỉ</th>
								<th scope="col" class="sort" data-sort="diachi">Quyền</th>
							</tr>
						</thead>
						<tbody class="list">
							<c:forEach items="${ getUserByPagging}" var="p">
								<tr>
									<td class="budget">${p.username }</td>
									<td class="budget">${p.password }</td>
									<td class="budget">${p.fname } ${p.lname }</td>
									<c:choose>
										<c:when test="${p.gender == 1 }">
											<td class="budget">Nam</td>
										</c:when>
										<c:otherwise>
											<td class="budget">Nữ</td>
										</c:otherwise>
									</c:choose>
									<td class="budget">${p.phone }</td>
									<td class="budget">${p.email }</td>
									<td class="budget">${p.address }</td>
									<c:choose>
										<c:when test="${p.roleId == 1 }">
											<td class="budget">Admin</td>
										</c:when>
										<c:when test="${p.roleId == 2 }">
											<td class="budget">Người bán</td>
										</c:when>
										<c:otherwise>
											<td class="budget">Khách</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- Card footer -->
				<c:if test="${getUserByPagging != null }">
					<div class="card-footer py-4">
						<nav aria-label="static.">
							<ul class="pagination justify-content-end mb-0">
								<li class="page-item ${tag <= 1 ? "disabled":" " }""><a
									class="page-link" href="userlist?index=${tag-1 }"> <i
										class="fas fa-angle-left"></i> <span class="sr-only">Previous</span>
								</a></li>
								<c:forEach begin="1" end="${countPageUser}" var="p">
									<li class="page-item ${tag == p ? "active":"" }" ><a
										class="page-link" href="userlist?index=${p}">${p}</a></li>
								</c:forEach>
								<li class="page-item ${tag >= countPageUser ? "disabled":" " }"">
									<a class="page-link" href="userlist?index=${tag+1 }"> <i
										class="fas fa-angle-right"></i> <span class="sr-only">Next</span>
								</a>
								</li>
							</ul>
						</nav>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- Dark table -->
</div>