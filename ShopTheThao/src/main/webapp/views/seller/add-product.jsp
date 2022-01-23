<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!-- Page content -->
<div class="container-fluid mt--6">
	<div class="row">
		<div class="col-xl-12">
			<div class="card">

				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="card-header border-0">
						<div class="row align-items-center">
							<div class="col">
								<h2 class="mb-2 text-center text-success">THÊM SẢN PHẨM MỚI</h2>
							</div>
						</div>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" action="add" method="post">
								
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label"> Tên sản phẩm</label>
										<div class="col-sm-8 ">
											<input class="form-control " placeholder="Nhập tên sản phẩm" name="name" />
										</div>
									</div>
									
									<div class="form-group row justify-content-center">									
										<label class="col-sm-2 col-form-label"></label>
										<label class="col-sm-1 col-form-label">Danh mục</label>
										<div class="form-group col-md-3">											
											<select name="category" class="form-control">
												<option selected>Chọn danh mục...</option>
												<c:forEach items="${listCategory}" var="c">
													<option value="${c.id}">${c.name}</option>
												</c:forEach> 
											</select>
										</div>
										<label class="col-sm-1 col-form-label text-center">Nhãn hiệu</label>
										<div class="form-group col-md-3">											
											<input class="form-control " placeholder="Nhập tên nhãn hiệu" name="brand" />
										</div>										
									</div>
									
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label"> Giá tiền</label>
										<div class="col-sm-8 ">
											<input class="form-control" type="number"
												placeholder="Nhập giá tiền sản phẩm" name="price" min="5000"
												step="1000" />
										</div>
									</div>
									
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label"> Giá khuyến mãi</label>
										<div class="col-sm-8 ">
											<input class="form-control" type="number"
												placeholder="Nhập tỉ lệ khuyến mãi (0% - 99%)" name="saleprice"
												min="0" max="99" value="0" />
										</div>
									</div>


									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label">Mô tả sản phẩm </label>
										<div class="col-sm-8 ">
											<textarea  rows="4" cols="105" name="description" id="editer"></textarea>
										</div>
									</div>
									
									<div class="form-group row justify-content-center">									
										<label class="col-sm-2 col-form-label"> Kích cỡ - Số lượng</label>
										<label class="col-sm-1 col-form-label text-center">S</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho size S" name="sizeS" min="0"
												step="1" value="0"/>
										</div>
										<label class="col-sm-1 col-form-label text-center">M</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho size M" name="sizeM" min="0"
												step="1" value="0"/>
										</div>
									</div>
									
									<div class="form-group row justify-content-center">									
										<label class="col-sm-2 col-form-label"></label>									
										<label class="col-sm-1 col-form-label text-center">L</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho size L" name="sizeL" min="0"
												step="1" value="0"/>
										</div>
										<label class="col-sm-1 col-form-label text-center">XL</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho size XL" name="sizeXL" min="0"
												step="1" value="0"/>
										</div>
									</div>
									
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label">Hình ảnh</label>
										<div class="col-sm-8 ">
											<input type="text" name="image" />
										</div>
									</div>
																										
									<div class="col mb-2">
										<div class="row">
											<div class="col-sm-12  col-md-6">
												<button type="submit" class="btn btn-success btn-block text-uppercase">Thêm sản phẩm</button>
											</div>
											<div class="col-sm-12  col-md-6">
												<button type="reset" class="btn btn-danger btn-block text-uppercase">Hủy bỏ</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
	</div>
</div>

