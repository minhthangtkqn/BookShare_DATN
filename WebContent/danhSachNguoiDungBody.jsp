<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div>
	<div class="container">

		<div class="books">
			<h3>
				<b>DANH SÁCH NGƯỜI DÙNG</b>
			</h3>
			<table border="1" class="books-table">
				<thead>
					<td></td>
					<td>Tên</td>
					<td>Tài khoản</td>
					<td>Địa chỉ</td>
					<td>Điện thoại</td>
					<td>Email</td>
					<td>Giới tính</td>
					<td>Năm sinh</td>
					<td>Ghi chú</td>
				</thead>
				<!-- ++++++++++++++++++  -->
				<logic:iterate name="danhSachNguoiDungForm" property="dsNguoiDung"
					id="sp">
					<tr>
						<bean:define id="anh" name="sp" property="anh"></bean:define>
						<td><img src="${anh}" style="width: 160px; height: 200px;"></td>
						<td><bean:write name="sp" property="hoTen" /></td>
						<td><bean:write name="sp" property="taiKhoan" /></td>
						<td><bean:write name="sp" property="tenTinh" /></td>
						<td><bean:write name="sp" property="dienThoai" /></td>
						<td><bean:write name="sp" property="email" /></td>
						<td><bean:write name="sp" property="gioiTinh"></bean:write></td>
						<td><bean:write name="sp" property="namSinh"></bean:write></td>
					</tr>
				</logic:iterate>
			</table>

		</div>
	</div>
</div>