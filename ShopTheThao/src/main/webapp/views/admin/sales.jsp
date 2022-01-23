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
					<h3 class="mb-0">Báo cáo doanh thu</h3>
				</div>
				<form action="#" method="post">
					<div class="row">
						<div class="col-2"></div>
						<div class="col">
							<label for="start">Ngày đầu:</label> <input type="date"
								id="start" name="ngaydau" value="2018-01-01" min="2018-01-01"
								max="2022-12-31">
						</div>
						<div class="col">
							<label for="end">Ngày cuối:</label> <input type="date" id="end"
								name="ngaycuoi" value="2022-12-31" min="2018-01-01"
								max="2022-12-31">
						</div>
						<div class="col">
							<input type="submit" class="btn btn-dark btn-sm" value="Tìm kiếm">
						</div>
					</div>
				</form>
				<!-- Light table -->
				<div class="table-responsive">
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col" class="sort" data-sort="mads">Ngày Bán</th>
								<th scope="col" class="sort" data-sort="ngaykham">Số Bệnh
									Nhân</th>
								<th scope="col" class="sort" data-sort="hoten">Doanh Thu</th>
							</tr>
						</thead>
						<tbody class="list">

							<tr>
								<td class="budget">222</td>
								<td class="budget">222</td>
								<td class="budget">222</td>
							</tr>

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