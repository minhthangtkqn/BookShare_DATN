<%@page import="common.StringProcess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<bean:define id="maNguoiBan" name="danhGiaNguoiBanForm" property="maNguoiBan"></bean:define>
	<bean:define id="nguoiBan" name="danhGiaNguoiBanForm" property="nguoiBan"></bean:define>

	<div class="body-row">
		<div class="col-lg-8">
		
			<logic:notEmpty name="danhGiaNguoiBanForm" property="listDanhGia">
				<logic:iterate id="danhGia" name="danhGiaNguoiBanForm" property="listDanhGia">
					
					<bean:define id="diemDanhGia" name="danhGia" property="diemDanhGia"></bean:define>
					<bean:define id="maDanhGia" name="danhGia" property="maDanhGia"></bean:define>
					
					<div class="col-lg-12" style="margin-bottom: 50px;">
					
						<div class="col-lg-12">
							<input class="rating-seller" value="${diemDanhGia}">
						</div>
						
						<div class="col-lg-12">
							<bean:write name="danhGia" property="taiKhoanNguoiDanhGia"></bean:write>
						</div>
						
						<div class="col-lg-12">
							<textarea id="${maDanhGia}" class="form-control" disabled>
	<bean:write name="danhGia" property="binhLuan"></bean:write>
							</textarea>
						</div>
						
					</div>
				</logic:iterate>
			</logic:notEmpty>
			
			<logic:empty name="danhGiaNguoiBanForm" property="listDanhGia">
				No one has rated this seller.
			</logic:empty>
		</div>
		
		<div class="col-lg-4">
			<h2 class="info-title">
				<b>SELLER INFORMATION</b>
			</h2>
			<div class="anh_nguoiban">
				<bean:define id="anh" name="nguoiBan" property="anh"></bean:define>
				<img style="height: 200px; width: 200px;" src="${anh}">
			</div>
			<div class="text_info">
				<p>
					Account:
					<bean:write name="nguoiBan" property="taiKhoan" />
				</p>

				<p>
					Name:
					<bean:write name="nguoiBan" property="hoTen" />
				</p>

				<p>
					Birth year:
					<bean:write name="nguoiBan" property="namSinh" />
				</p>

				<p>
					Email:
					<bean:write name="nguoiBan" property="email" />
				</p>

				<p>
					Phone number:
					<bean:write name="nguoiBan" property="dienThoai" />
				</p>
			</div>
			
			<% if(!StringProcess.notVaild((String)session.getAttribute("userID"))){ %>
				<% if((Integer)session.getAttribute("type") == 1){ %>
			<a href="danh-gia-nguoi-ban.do?maNguoiBan=${maNguoiBan}" class="w3-btn w3-ripple w3-red btn-hoi-mua">
				Rate this seller
			</a>
			
			<% 		} 
				}%>
			
		</div>
	</div>

</div>
<!-- END BODY -->
