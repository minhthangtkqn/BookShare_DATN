<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!-- BODY -->
<div id="page-body" class="container">
	<br>
	<br>
	<br>
	<bean:define id="chiTietBaiDang" name="chiTietBaiDangForm"
		property="chiTiet"></bean:define>

		<bean:define id="maRaoBan" name="chiTietBaiDang" property="maRaoBan"></bean:define>
		<bean:define id="anhNguoiBan" name="chiTietBaiDang"	property="anhNguoiBan"></bean:define>
		<bean:define id="maNguoiRaoBan" name="chiTietBaiDang" property="maNguoiRaoBan"></bean:define>

	<div class="body-row">
		<div class="w3-content product-img-slides">
			<bean:define id="linkAnh1" name="chiTietBaiDang" property="linkAnh1"></bean:define>
			<bean:define id="linkAnh2" name="chiTietBaiDang" property="linkAnh2"></bean:define>
			<bean:define id="linkAnh3" name="chiTietBaiDang" property="linkAnh3"></bean:define>
			<bean:define id="linkAnh4" name="chiTietBaiDang" property="linkAnh4"></bean:define>
			<bean:define id="linkAnh5" name="chiTietBaiDang" property="linkAnh5"></bean:define>

			<img class="mySlides" src="${linkAnh1}" style="width: 100%"> 
			<img class="mySlides" src="${linkAnh2}" style="width: 100%"> 
			<img class="mySlides" src="${linkAnh3}" style="width: 100%"> 
			<img class="mySlides" src="${linkAnh4}" style="width: 100%"> 
			<img class="mySlides" src="${linkAnh5}" style="width: 100%">

			<div class="w3-row-padding w3-section">
				<div class="tiny-img">
					<img class="w3-opacity w3-hover-opacity-off"
						src="${linkAnh1}" onclick="currentDiv(1)">
				</div>
				<div class="tiny-img">
					<img class="w3-opacity w3-hover-opacity-off"
						src="${linkAnh2}" onclick="currentDiv(2)">
				</div>
				<div class="tiny-img">
					<img class="w3-opacity w3-hover-opacity-off"
						src="${linkAnh3}" onclick="currentDiv(3)">
				</div>
				<div class="tiny-img">
					<img class="w3-opacity w3-hover-opacity-off"
						src="${linkAnh4}" onclick="currentDiv(4)">
				</div>
				<div class="tiny-img">
					<img class="w3-opacity w3-hover-opacity-off"
						src="${linkAnh5}" onclick="currentDiv(5)">
				</div>
			</div>
		</div>

		<div class="product-info">
			<h2 class="info-title">
				<b>THÔNG TIN SÁCH</b>
			</h2>

			<h3 style="color: red; text-align: center;">
				<b><bean:write name="chiTietBaiDang" property="tenSach" /></b>
			</h3>

			<p>Tác giả: <bean:write name="chiTietBaiDang" property="tacGia" /></p>
			<p>Danh mục: <bean:write name="chiTietBaiDang" property="tenDanhMuc" /></p>
			<p>Nhà xuất bản: <bean:write name="chiTietBaiDang" property="nxb" /></p>
			<p>Năm xuất bản: <bean:write name="chiTietBaiDang" property="namxb" /></p>
			<p>Ngày đăng: <bean:write name="chiTietBaiDang" property="ngayBan" /></p>
			<p>Khu vực:	<bean:write name="chiTietBaiDang" property="tenTinhBan" /></p>

			<p style="color: red; font-size: 20px">
				<b>Giá: <bean:write name="chiTietBaiDang" property="gia" /></b>
			</p>
			
			<logic:equal value="0" name="chiTietBaiDang" property="trangThaiRaoBan">
				<html:form action="duyet-bai-dang.do" method="post" styleClass="col-lg-12 features_button">
					<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
					<input type="submit" name="submit" value="DUYỆT" class="w3-btn w3-ripple w3-red col-lg-12"></input>
				</html:form>
			</logic:equal>
			
			<logic:equal value="1" name="chiTietBaiDang" property="trangThaiRaoBan">
				<html:form action="khong-duyet-bai-dang.do" method="post" styleClass="col-lg-12 features_button">
					<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
					<input type="submit" name="submit" value="BỎ DUYỆT" class="w3-btn w3-ripple w3-red col-lg-12"></input>
				</html:form>
			</logic:equal>
			
<%-- 			<html:form action="xoa-bai-dang.do" method="post" styleClass="col-lg-12 features_button"> --%>
<%-- 				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;"> --%>
<!-- 				<input type="submit" name="submit" value="XÓA" class="w3-btn w3-ripple w3-green col-lg-12"></input> -->
<%-- 			</html:form> --%>
			
			<form id="xoa_bai_dang_${maRaoBan}" action="xoa-bai-dang.do" 
					method="post" onsubmit="return confirm('Bạn có thực sự muốn XÓA bài đăng này?');"
					class="col-lg-12 features_button">
				<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<a style="width: 100%; height: 100%;" class="w3-btn w3-ripple w3-green col-lg-12"
					onclick="if(document.getElementById('xoa_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('xoa_bai_dang_${maRaoBan}').submit()};"
					href="javascript:{}">XÓA</a>
			</form>
			
		</div>

		<div class="thongtin_nguoiban">
			<h2 class="info-title">
				<b>THÔNG TIN NGƯỜI BÁN</b>
			</h2>
			<div class="anh_nguoiban">
				<a href="chi-tiet-nguoi-dung.do?maNguoiDung=${maNguoiRaoBan}">
					<img style="height: 100%; width: 100%;" src="${anhNguoiBan}">
				</a>
			</div>
			<div class="text_info">
				<p>
					Tài khoản:
					<bean:write name="chiTietBaiDang" property="taiKhoanNguoiBan" />
				</p>

				<p>
					Tên:
					<bean:write name="chiTietBaiDang" property="hoTenNguoiBan" />
				</p>

				<p>
					Giới tính:
					<bean:write name="chiTietBaiDang" property="gioiTinh" />
				</p>
				<p>
					Năm sinh:
					<bean:write name="chiTietBaiDang" property="namSinhNguoiBan" />
				</p>
			</div>
			
			<a href="lich-su-danh-gia.do?maNguoiBan=${maNguoiRaoBan}" class="w3-btn w3-ripple w3-light-green btn-hoi-mua features_button">
				Xem đánh giá về người bán
			</a>
			
		</div>
		<br>

	</div>

</div>
<!-- END BODY -->
