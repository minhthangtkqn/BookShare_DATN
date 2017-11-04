<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CÁC BÀI ĐĂNG ĐÃ XEM</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="bootstraps/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/user.css">
</head>
<body>
	<div id="page">
		<!--    HEADER       -->
		<jsp:include page="/unloggedHeader.jsp"></jsp:include>
		<!--    END HEADER   -->

		<!-- 	BODY -->
		<div id="page-body" class="container">
			<div class="body-row">
				<div class="books">
					<h3>
						<b>CÁC BÀI ĐĂNG ĐÃ XEM</b>
					</h3>
					<table id="cac-bai-dang-da-xem"
						class="table table-striped table-bordered" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th>Ảnh</th>
								<th>Tên sách</th>
								<th>Tác giả</th>
								<th>Nhà xuất bản</th>
								<th>Năm xuất bản</th>
								<th>Danh mục</th>
								<th>Nơi lấy sách</th>
								<th>Giá</th>
								<th>Ngày bán</th>
								<th>Xem chi tiết</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Ảnh</th>
								<th>Tên sách</th>
								<th>Tác giả</th>
								<th>Nhà xuất bản</th>
								<th>Năm xuất bản</th>
								<th>Danh mục</th>
								<th>Nơi lấy sách</th>
								<th>Giá</th>
								<th>Ngày bán</th>
								<th>Xem chi tiết</th>
							</tr>
						</tfoot>
						<!-- ++++++++++++++++++  -->
						<tbody>
							<logic:iterate name="lichSuXemBaiDangForm"
								property="listBaiDangDaXem" id="sp">
								<tr>
									<bean:define id="anh" name="sp" property="linkAnh1"></bean:define>
									<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>

									<td><img src="${anh}" style="width: 80px; height: 100px;"></td>
									<td><bean:write name="sp" property="tenSach" /></td>
									<td><bean:write name="sp" property="tacGia" /></td>
									<td><bean:write name="sp" property="nxb" /></td>
									<td><bean:write name="sp" property="namxb" /></td>
									<td><bean:write name="sp" property="tenDanhMuc" /></td>
									<td><bean:write name="sp" property="tenTinhBan"></bean:write></td>
									<td><bean:write name="sp" property="gia"></bean:write></td>
									<td><bean:write name="sp" property="ngayBan"></bean:write></td>
									
									<td>
										<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}">
											<i class="glyphicon glyphicon-folder-open"></i>
										</a>
									</td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>

				</div>
			</div>

			<div class="body-row">
		
				<div class="books">
					<h3 style="color: red;">
						<b>HOT TRONG THÁNG VỪA QUA</b>
					</h3>

					<div class="owl-carousel owl-theme">

						<logic:iterate id="book" property="dsHot" name="lichSuXemBaiDangForm">
							<div class="sp">
								<bean:define id="anh" name="book" property="linkAnh1"></bean:define>
								<bean:define id="maRaoBan" name="book" property="maRaoBan"></bean:define>

								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"> <img
									src="${anh}" class="w3-hover-opacity">
								</a>
								<h4 class="ten-sach">
									<b><bean:write name="book" property="tenSach" /></b>
								</h4>
								<p class="tac-gia">
									<bean:write name="book" property="tacGia" />
								</p>
								<h4 class="gia-tien">
									<b><bean:write name="book" property="gia" /></b>
								</h4>
							</div>
						</logic:iterate>

					</div>
				</div>
			</div>
		</div>
		<!-- 	END BODY -->

		<!--    FOOTER      -->
		<jsp:include page="/footer.jsp"></jsp:include>
		<!--    END FOOTER  -->

		<!-- SCRIPT TABLE PAGINATION -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="bootstraps/js/dataTables.bootstrap.min.js"></script>

		<script>
			$(document).ready(function() {
				$('#cac-bai-dang-da-xem').DataTable();
			});
		</script>
		<!-- END SCRIPT TABLE PAGINATION -->
	</div>
</body>
</html>