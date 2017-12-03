<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<div class="body-row">
		<div class="col-lg-6">
			<h3>SỬA THÔNG TIN TÀI KHOẢN</h3>
			<br>
			<html:form action="/sua-nguoi-dung" method="post">
				
				<div class="row form-group">
					<label class="col-lg-4">Họ tên</label>
					<div class="col-lg-7">
						<html:text property="hoTen" styleClass="form-control"></html:text>
					</div>
				</div>
				<div class="row form-group">
					<label class="col-lg-4">Số điện thoại</label>
					<div class="col-lg-7">
						<html:text property="dienThoai" styleClass="form-control"></html:text>
					</div>
				</div>
				<div class="row form-group">
					<label class="col-lg-4">Email</label>
					<div class="col-lg-7">
						<html:text property="email" styleClass="form-control"></html:text>
					</div>
				</div>
				<div class="row form-group">
					<label class="col-lg-4">Giới tính</label>
					<div class="col-lg-7">
						<html:radio property="gioiTinh" value="1"
							style="margin-right: 10px;">Nam</html:radio>
						<html:radio property="gioiTinh" value="0"
							style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
					</div>
				</div>
				<div class="row form-group">
					<label class="col-lg-4">Khu vực</label>
					<div class="col-lg-7">
						<html:select property="maTinh" styleClass="form-control">
							<html:optionsCollection name="nguoiDungForm" property="dsTinh"
								label="tenTinh" value="maTinh" />
						</html:select>
					</div>
				</div>
				<input name="action" value="suaThongTin" style="display: none;">
				<div class="row form-group">
					<div class="col-lg-11">
						<html:submit styleClass="btn btn-primary form-control" property="submit"
							value="submit">Lưu</html:submit>
	<!-- 					<button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button> -->
					</div>
				</div>
			</html:form>
		</div>

		<div class="col-lg-6">
			<h3>SỬA MẬT KHẨU</h3>
			<html:form action="/sua-nguoi-dung" method="post">
				<div class="row form-group">
					<label class="col-lg-4">Mật khẩu mới</label>
					<div class="col-lg-7">
						<html:password property="matKhau" styleClass="form-control"></html:password>
					</div>
				</div>
				<input name="action" value="suaMatKhau" style="display: none;">
				<div class="row form-group">
					<div class="col-lg-11">
						<html:submit styleClass="btn btn-primary form-control" property="submit"
							value="submit">Lưu</html:submit>
	<!-- 					<button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button> -->
					</div>
				</div>
			</html:form>
		</div>
	</div>
</div>
<!-- END BODY -->
