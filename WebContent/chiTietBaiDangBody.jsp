<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<bean:define id="chiTietBaiDang" name="chiTietBaiDangForm" property="chiTiet"></bean:define>
	<bean:define id="maNguoiRaoBan" name="chiTietBaiDang" property="maNguoiRaoBan"></bean:define>

	<div class="body-row note">
		<p>
			You should see the rating of the seller before deciding to buy.
			<br>
			If you know any problem with the sell account or the details of post,
			please report it. We appreciate that 
		</p>
	</div>

	<div class="body-row">
		<div class="w3-content product-img-slides">
			<bean:define id="linkAnh1" name="chiTietBaiDang" property="linkAnh1"></bean:define>
			<bean:define id="linkAnh2" name="chiTietBaiDang" property="linkAnh2"></bean:define>
			<bean:define id="linkAnh3" name="chiTietBaiDang" property="linkAnh3"></bean:define>
			<bean:define id="linkAnh4" name="chiTietBaiDang" property="linkAnh4"></bean:define>
			<bean:define id="linkAnh5" name="chiTietBaiDang" property="linkAnh5"></bean:define>
			<bean:define id="maRaoBanChiTiet" name="chiTietBaiDang" property="maRaoBan"></bean:define>

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

			<h3 style="text-align: center;">
				<a style="color: red;" href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBanChiTiet}">
					<p style="padding-left: 10px; padding-right: 10px;"><bean:write name="chiTietBaiDang" property="tenSach" /></p>
				</a>
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
		</div>

		<div class="thongtin_nguoiban">
			<h2 class="info-title">
				<b>SELLER INFORMATION</b>
			</h2>
			<div class="anh_nguoiban">
				<bean:define id="anhNguoiBan" name="chiTietBaiDang"
					property="anhNguoiBan"></bean:define>
				<img style="height: 200px; width: 200px;" src="${anhNguoiBan}">
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
			<a href="danh-gia-nguoi-ban.do?maNguoiBan=${maNguoiRaoBan}" class="w3-btn w3-ripple w3-red btn-hoi-mua">
				Rate this seller
			</a>
			<a href="lich-su-danh-gia.do?maNguoiBan=${maNguoiRaoBan}" class="w3-btn w3-ripple w3-red btn-hoi-mua">
				See all rating
			</a>
		</div>
	</div>
	
	<br><br>
	
	<div class="body-row col-lg-12">
		<div class="col-lg-offset-1 col-lg-11 comment-box">
			<div class="col-lg-5" style="padding-left: 45px; margin-bottom: -35px;">
				<h3>QUESTIONS</h3>
			</div>
			
			<logic:iterate id="dsBinhLuan" name="chiTietBaiDangForm" property="dsBinhLuan">
				<div class="col-lg-12">
					<%	int i = 1;	%>
					<br>
					<logic:iterate id="binhLuan" name="dsBinhLuan" property="nhomBinhLuan">
						<bean:define id="anh" name="binhLuan" property="linkAnh"></bean:define>
						<bean:define id="taiKhoan" name="binhLuan" property="taiKhoan"></bean:define>
						<bean:define id="thoiGian" name="binhLuan" property="thoiGian"></bean:define>
						<bean:define id="cmt" name="binhLuan" property="binhLuan"></bean:define>
						<bean:define id="maBinhLuan" name="binhLuan" property="maBinhLuan"></bean:define>
						
						
						<%	if (i == 1) {	%>
						<bean:define id="maBinhLuanDuocTraLoi" name="binhLuan" property="maBinhLuan"></bean:define>
						<div class="col-lg-12">
							<br>
							<div class="col-lg-1">
								<img src="${anh}" width="100%" class="img-circle">
							</div>
							
							<div class="col-lg-11">
								<div class="col-lg-12" style="height: 30px;">
									<div class="col-lg-4 no-padding username-cmt">
										<bean:write name="binhLuan" property="taiKhoan"></bean:write>
									</div>
									<div class="col-lg-offset-6 col-lg-2">
										<bean:write name="binhLuan" property="thoiGian"></bean:write>
									</div>
								</div>
								
								<div class="col-lg-12">
									<textarea id="${maBinhLuan}" class="form-control" 
										disabled>
<bean:write name="binhLuan" property="binhLuan"></bean:write>
									</textarea>
								</div>
							</div>
						</div>
						<%	} else { %>
						<div class="col-lg-offset-1 col-lg-11">
							<br>
							<div class="col-lg-1">
								<img src="${anh}" width="100%" class="img-circle">
							</div>
							
							<div class="col-lg-11">
								<div class="col-lg-12" style="height: 30px;">
									<div class="col-lg-4 no-padding username-cmt">
										<bean:write name="binhLuan" property="taiKhoan"></bean:write>
									</div>
									<div class="col-lg-offset-6 col-lg-2">
										<bean:write name="binhLuan" property="thoiGian"></bean:write>
									</div>
								</div>
								
								<div class="col-lg-12">
									<textarea id="${maBinhLuan}" class="form-control" 
										disabled>
<bean:write name="binhLuan" property="binhLuan"></bean:write>
									</textarea>
								</div>
							</div>
						</div>
						<%	} %>
						<% i++; %>
					</logic:iterate>

					<!-- tra loi cau hoi -->
					<div class="col-lg-offset-1 col-lg-11">
						<div class="col-lg-offset-1 col-lg-11">
							<div class="col-lg-12">
					
								<html:form action="/dang-binh-luan" method="post">
									<div class="form-group">
										<html:text property="maRaoBan" style="display: none;"
											value="${maRaoBanChiTiet}"></html:text>
										<html:text property="maBinhLuanDuocTraloi" style="display: none;"
											value="${maBinhLuanDuocTraLoi}"></html:text>
										<label for="">Add an answer</label>
										<html:textarea rows="3" property="binhLuan"
											styleClass="form-control"></html:textarea>
									</div>
		
									<div class="form-group">
										<div class="col-lg-12 no-padding">
											<button type="submit"
												class="w3-button w3-ripple w3-light-green col-lg-2">Answer this question</button>
										</div>
									</div>
								</html:form>
							</div>
						</div>
					</div>
				</div>
			</logic:iterate>
			
			<div class="col-lg-12" style="margin-top: 40px;">
				<html:form action="/dang-binh-luan" method="post">
					<div class="form-group">
						<html:text property="maRaoBan" style="display: none;" value="${maRaoBanChiTiet}"></html:text>
						<label for="">Your question</label>
						<html:textarea rows="6" property="binhLuan" styleClass="form-control"></html:textarea>
					</div>
					
					<div class="form-group">
						<div class="col-lg-12 no-padding">
							<button type="submit" class="w3-button w3-ripple w3-light-green col-lg-2">Post your question</button>
						</div>
					</div>
				</html:form>
			</div>
			
			<div class="col-lg-12" style="height: 50px;"></div>
		</div>
	</div>
	
	<br><br>
	
	<div class="body-row col-lg-12">
		<div class="books">
			<h3 style="color: red;">
				<b>FEATURED POSTS FROM LAST MONTH SO FAR</b>
			</h3>

			<div class="owl-carousel owl-theme">

				<logic:iterate id="book" property="dsGoiYMoiNguoiCungXem" name="chiTietBaiDangForm">
					<div class="sp">
						<bean:define id="anh" name="book" property="linkAnh1"></bean:define>
						<bean:define id="maRaoBan" name="book" property="maRaoBan"></bean:define>
						
						<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}">
							<img src="${anh}" class="w3-hover-opacity">
						</a>
						<h4 class="ten-sach">
							<b><bean:write name="book" property="tenSach"/></b>
						</h4>
						<p class="tac-gia"><bean:write name="book" property="tacGia"/></p>
						<h4 class="gia-tien">
							<b><bean:write name="book" property="gia"/></b>
						</h4>
					</div>
				</logic:iterate>

			</div>
		</div>
	</div>
</div>
<!-- END BODY -->
<script src="js/script.js"></script>
<script>
setHeight();
</script>