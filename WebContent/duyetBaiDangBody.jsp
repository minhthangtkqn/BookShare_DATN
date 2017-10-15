<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
	<!---content main-->
<div id="content_detail">

	<bean:define id="chiTietBaiDang" name="chiTietBaiDangForm" property="chiTiet"></bean:define>

	<div id="content_detail_product">
		<!--example-->
		<div class="anh_product">
			<!--Ảnh chính được hiển thị-->
			<div class="pic">
				<div class="w3-display-container mySlides">
					<bean:define id="linkAnh1" name="chiTietBaiDang"
						property="linkAnh1"></bean:define>
					<img src="${linkAnh1}">
					<div class="w3-display-bottomleft w3-container w3-black"></div>
				</div>

				<div class="w3-display-container mySlides">
					<bean:define id="linkAnh2" name="chiTietBaiDang"
						property="linkAnh2"></bean:define>
					<img src="${linkAnh2}">
					<div class="w3-display-bottomleft w3-container w3-black"></div>
				</div>

				<div class="w3-display-container mySlides">
					<bean:define id="linkAnh3" name="chiTietBaiDang"
						property="linkAnh3"></bean:define>
					<img src="${linkAnh3}">
					<div class="w3-display-bottomleft w3-container w3-black"></div>
				</div>

				<div class="w3-display-container mySlides">
					<bean:define id="linkAnh4" name="chiTietBaiDang"
						property="linkAnh4"></bean:define>
					<img src="${linkAnh4}">
					<div class="w3-display-bottomleft w3-container w3-black"></div>
				</div>

				<div class="w3-display-container mySlides">
					<bean:define id="linkAnh5" name="chiTietBaiDang"
						property="linkAnh5"></bean:define>
					<img src="${linkAnh5}">
					<div class="w3-display-bottomleft w3-container w3-black"></div>
				</div>
			</div>
			<!--/Ảnh chính được hiển thị-->

			<!--Ảnh nhỏ để zoom lớn-->
			<div class="zoom_pic">

				<div class="pics">
					<img class="demo w3-opacity w3-hover-opacity-off" src="${linkAnh1}"
						style="cursor: pointer;" onclick="currentDiv(1)" title="">
				</div>
				<div class="pics">
					<img class="demo w3-opacity w3-hover-opacity-off" src="${linkAnh2}"
						style="cursor: pointer;" onclick="currentDiv(2)" title="">
				</div>
				<div class="pics">
					<img class="demo w3-opacity w3-hover-opacity-off" src="${linkAnh3}"
						style="cursor: pointer;" onclick="currentDiv(3)" title="">
				</div>
				<div class="pics">
					<img class="demo w3-opacity w3-hover-opacity-off" src="${linkAnh4}"
						style="cursor: pointer;" onclick="currentDiv(4)" title="">
				</div>
				<div class="pics">
					<img class="demo w3-opacity w3-hover-opacity-off" src="${linkAnh5}"
						style="cursor: pointer;" onclick="currentDiv(5)" title="">
				</div>

			</div>
			<!--/Ảnh nhỏ để zoom lớn-->

		</div>

		<div class="des_product">
			<h2
				style="display: block; height: 50px; width: 100%; background-color: #189eff; line-height: 50px; color: white; text-align: center; font-size: 20px; margin: 0px; margin-bottom: 20px;">
				<b>THÔNG TIN SÁCH</b>
			</h2>
			<h3 style="color: red">
				<b><bean:write name="chiTietBaiDang" property="tenSach" /></b>
			</h3>
			<p>Tác giả:  <bean:write name="chiTietBaiDang" property="tacGia" />	</p>
			<p>Danh mục:	<bean:write name="chiTietBaiDang" property="tenDanhMuc" /></p>
			<p>Nhà xuất bản: <bean:write name="chiTietBaiDang" property="nxb" /></p>
			<p>Năm xuất bản: <bean:write name="chiTietBaiDang" property="namxb" /></p>
			<p>Ngày đăng bán: <bean:write name="chiTietBaiDang" property="ngayBan" /></p>
			<p>Tỉnh thành:	<bean:write name="chiTietBaiDang" property="tenTinhBan" /></p>
			
			<h5 style="color: red; font-size: 20px">
				<b>Giá: <bean:write name="chiTietBaiDang" property="gia" /></b>
			</h5>

		</div>

		<div class="thongtin_nguoiban">
			<p style="font-size: 17px; color: red; font-style: italic;">
				<b>Được đăng bởi</b>
			</p>
			<div class="anh_nguoiban">
				<bean:define id="anhNguoiBan" name="chiTietBaiDang" property="anhNguoiBan"></bean:define>
				<img style="height: 200px; width: 200px;" src="${anhNguoiBan}">
			</div>
			<div class="text_info">
				<p>Tài khoản: <bean:write name="chiTietBaiDang" property="taiKhoanNguoiBan" /></p>
				
				<p>
					Tên người bán:
					<bean:write name="chiTietBaiDang" property="hoTenNguoiBan" />
				</p>
				
				<p>Giới tính: <bean:write name="chiTietBaiDang" property="gioiTinh" /></p>
				<p>Năm sinh: <bean:write name="chiTietBaiDang" property="namSinhNguoiBan" /></p>
			</div>
			<!---gfsd-->
<!--			<button class="w3-btn w3-ripple w3-red" data-toggle="modal"-->
<!--				data-target="#myModal">Try Buy</button>-->
		
			<bean:define id="maRaoBan" name="chiTietBaiDang" property="maRaoBan"></bean:define>
			<bean:define id="maNguoiRaoBan" name="chiTietBaiDang" property="maNguoiRaoBan"></bean:define>
			
			<html:form action="duyet-bai-dang.do" method="post">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="DUYỆT" class="w3-btn w3-ripple w3-red"></input>
			</html:form>
			
			<html:form style="display: inline-block;" action="khoa-bai-dang.do" method="post">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="text" name="maNguoiRaoBan" value="${maNguoiRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="KHÓA" class="w3-btn w3-ripple w3-green"></input>
			</html:form>
			
			<html:form style="display: inline-block;" action="mo-khoa-bai-dang.do" method="post">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="text" name="maNguoiRaoBan" value="${maNguoiRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="MỞ KHÓA" class="w3-btn w3-ripple w3-green"></input>
			</html:form>
			
			<!-- login -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h6 style="color: red">
								<i>Đăng nhập để xem thông tin liên lạc !!</i>
							</h6>
							<h4>
								<b>Đăng nhập</b>
							</h4>
						</div>
						<div class="modal-body">
							<form role="form">
								<div class="form-group">
									<label for="tendangnhap">Tên đăng nhập </label> <input
										type="text" class="form-control" id="user"
										placeholder="Tên đăng nhập">
								</div>
								<div class="form-group">
									<label for="matkhau">Mật khẩu </label> <input type="password"
										class="form-control" id="pass" placeholder="Nhập mật khẩu">
								</div>
								<button type="submit" class="btn btn-block">Đăng nhập</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--    <button  onclick="myFunction()" class="w3-btn w3-ripple w3-red" style="width: 100%;">Mua</button>-->

		<script>
			function myFunction() {
				alert("Vui lòng đăng nhập để xem thông tin liên lạc của người đăng!!!");
			}
		</script>
	</div>
</div>
<!--    END BODY    -->