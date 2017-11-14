<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<br><br>
	<bean:define id="nd" name="nguoiDungForm" property="nguoiDung"></bean:define>
	
	<bean:define id="anh" name="nd" property="anh"></bean:define>
	<bean:define id="taiKhoan" name="nd" property="taiKhoan"></bean:define>
	<bean:define id="hoTen" name="nd" property="hoTen"></bean:define>
	<bean:define id="gioiTinh" name="nd" property="gioiTinh"></bean:define>
	<bean:define id="namSinh" name="nd" property="namSinh"></bean:define>
	<bean:define id="dienThoai" name="nd" property="dienThoai"></bean:define>
	<bean:define id="email" name="nd" property="email"></bean:define>
	<bean:define id="tenTinh" name="nd" property="tenTinh"></bean:define>
	<bean:define id="ghiChu" name="nd" property="ghiChu"></bean:define>
	<bean:define id="loaiNguoiDung" name="nd" property="loaiNguoiDung"></bean:define>
	

	<div class="body-row">

		<p class="info-title w3-red">
			<b>DETAILS</b>
		</p>
		<div class="img_user">
			<img style="height: 100%; width: 100%;" src="${anh}">
		</div>

		<div class="form-horizontal info_user_left">
			<div class="form-group">
				<label for="account" class="col-sm-4 control-label">Account</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="account"
						value="${taiKhoan}" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-4 control-label">Name</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="name"
						value="${hoTen}" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="gender" class="col-sm-4 control-label">Gender</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="gender" value="${gioiTinh }"
						disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="birthday" class="col-sm-4 control-label">Birthday</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="birthday" value="${namSinh }"
						disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="phone" class="col-sm-4 control-label">Phone
					number</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="${dienThoai }"
						value="0123456789" disabled>
				</div>
			</div>


		</div>

		<div class="form-horizontal info_user_right">
			<div class="form-group">
				<label for="email" class="col-sm-4 control-label">Email</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="${email }"
						value="abcxyz@123.com" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="region" class="col-sm-4 control-label">Region</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="region" value="${tenTinh }"
						disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="note" class="col-sm-4 control-label">Note</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="note" value="${ghiChu }" disabled>
				</div>
			</div>

			<div class="form-group">
				<label for="status" class="col-sm-4 control-label">Status</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="status" value="${loaiNguoiDung }"
						disabled>
				</div>
			</div>
		</div>
		
		<bean:define id="maNguoiDung" name="nguoiDungForm"
			property="maNguoiDung"></bean:define>
			
		<div class="col-sm-6">
			<div class="form-group">
				<form action="mo-khoa-nguoi-dung.do" method="post">
					<input type="text" name="maNguoiDung" value="${maNguoiDung}"
						style="display: none;">
					<div class="col-sm-12">
						<input class="form-control" type="text" name="ghiChu"  placeholder="Note ...">
						<input type="submit" name="submit" value="UNLOCK"
							class="w3-btn w3-ripple w3-red form-control">
					</div>
				</form>
			</div>
		</div>

		<div class="col-sm-6">
			<div class="form-group">
				<form action="khoa-nguoi-dung.do" method="post">
					<input type="text" name="maNguoiDung" value="${maNguoiDung}"
						style="display: none;">
					<div class="col-sm-12">
						<input class="form-control" type="text" name="ghiChu" placeholder="Note ...">
						<input class="w3-btn w3-ripple w3-red form-control" type="submit"
							name="submit" value="LOCK">
					</div>
				</form>
			</div>
		</div>
	</div>

	<br><br><br>

</div>
<!-- END BODY -->