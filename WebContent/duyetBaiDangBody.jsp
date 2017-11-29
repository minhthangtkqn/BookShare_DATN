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
				<b>DETAILS</b>
			</h2>

			<h3 style="color: red; text-align: center;">
				<b><bean:write name="chiTietBaiDang" property="tenSach" /></b>
			</h3>

			<p>Author: <bean:write name="chiTietBaiDang" property="tacGia" /></p>
			<p>Category: <bean:write name="chiTietBaiDang" property="tenDanhMuc" /></p>
			<p>Publisher: <bean:write name="chiTietBaiDang" property="nxb" /></p>
			<p>Publish year: <bean:write name="chiTietBaiDang" property="namxb" /></p>
			<p>Posted date: <bean:write name="chiTietBaiDang" property="ngayBan" /></p>
			<p>Region:	<bean:write name="chiTietBaiDang" property="tenTinhBan" /></p>

			<p style="color: red; font-size: 20px">
				<b>Price: <bean:write name="chiTietBaiDang" property="gia" /></b>
			</p>
			
			<html:form action="duyet-bai-dang.do" method="post" styleClass="col-lg-6 features_button">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="APPROVE" class="w3-btn w3-ripple w3-red col-lg-12"></input>
			</html:form>
			
			<html:form action="khong-duyet-bai-dang.do" method="post" styleClass="col-lg-6 features_button">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="DISAPPROVE" class="w3-btn w3-ripple w3-red col-lg-12"></input>
			</html:form>
			
			<html:form action="khoa-bai-dang.do" method="post" styleClass="col-lg-6 features_button">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="text" name="maNguoiRaoBan" value="${maNguoiRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="LOCK" class="w3-btn w3-ripple w3-green col-lg-12"></input>
			</html:form>
			
			<html:form action="mo-khoa-bai-dang.do" method="post" styleClass="col-lg-6 features_button">
				<input type="text" name="maRaoBan" value="${maRaoBan}" style="display: none;">
				<input type="text" name="maNguoiRaoBan" value="${maNguoiRaoBan}" style="display: none;">
				<input type="submit" name="submit" value="UNLOCK" class="w3-btn w3-ripple w3-green col-lg-12"></input>
			</html:form>
		</div>

		<div class="thongtin_nguoiban">
			<h2 class="info-title">
				<b>SELLER INFORMATION</b>
			</h2>
			<div class="anh_nguoiban">
				<a href="chi-tiet-nguoi-dung.do?maNguoiDung=${maNguoiRaoBan}">
					<img style="height: 100%; width: 100%;" src="${anhNguoiBan}">
				</a>
			</div>
			<div class="text_info">
				<p>
					Account:
					<bean:write name="chiTietBaiDang" property="taiKhoanNguoiBan" />
				</p>

				<p>
					Name:
					<bean:write name="chiTietBaiDang" property="hoTenNguoiBan" />
				</p>

				<p>
					Gender:
					<bean:write name="chiTietBaiDang" property="gioiTinh" />
				</p>
				<p>
					Birth year:
					<bean:write name="chiTietBaiDang" property="namSinhNguoiBan" />
				</p>
			</div>
			
			<a href="lich-su-danh-gia.do?maNguoiBan=${maNguoiRaoBan}" class="w3-btn w3-ripple w3-light-green btn-hoi-mua features_button">
				See all reviews
			</a>
			
		</div>
		<br>

	</div>

</div>
<!-- END BODY -->
