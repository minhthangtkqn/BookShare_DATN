<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div id="content_detail">
	<h3>SỬA THÔNG TIN NGƯỜI DÙNG</h3>
    	<bean:write name="nguoiDungForm" property="taiKhoan" />
    <br>
	<html:form action="/sua-nguoi-dung" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <html:text property="hoTen" styleClass="form-control"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Điện thoại</label>
            <div class="col-lg-3">
                <html:text property="dienThoai" styleClass="form-control"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Email</label>
            <div class="col-lg-3">
                <html:text property="email" styleClass="form-control"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Giới tính</label>
            <div class="col-lg-3">
            	<html:radio property="gioiTinh" value="1" style="margin-right: 10px;">Nam</html:radio>
            	<html:radio property="gioiTinh" value="0" style="margin: 0px 10px 0px 30px;">Nữ</html:radio>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Địa chỉ</label>
            <div class="col-lg-3">
            	<html:select property="maTinh" styleClass="form-control">
            		<html:optionsCollection name="nguoiDungForm" property="dsTinh" label="tenTinh" value="maTinh"/>
            	</html:select>
            </div>
        </div>
        <input name="action" value="suaThongTin" style="display: none;">
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <html:submit styleClass="btn btn-primary" property="submit" value="submit">Lưu lại</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
            </div>
        </div>
    </html:form>
    
    <h3>ĐỔI MẬT KHẨU</h3>
    <html:form action="/sua-nguoi-dung" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mật khẩu mới</label>
            <div class="col-lg-3">
                <html:password property="matKhau" styleClass="form-control"></html:password>
            </div>
        </div>
        <input name="action" value="suaMatKhau" style="display: none;">
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <html:submit styleClass="btn btn-primary" property="submit" value="submit">Lưu lại</html:submit>
                <button class="btn btn-primary" onclick="history.go(-1);">Quay lại</button>
            </div>
        </div>
	</html:form>
</div>