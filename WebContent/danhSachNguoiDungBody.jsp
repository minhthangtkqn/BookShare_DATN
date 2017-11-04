<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">

	<div class="body-row">
		<div class="books">
			<h3>
				<b>DANH SÁCH NGƯỜI DÙNG</b>
			</h3>
			<table id="danh-sach-nguoi-dung"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Ảnh</th>
						<th>Tên</th>
						<th>Tài khoản</th>
						<th>Địa chỉ</th>
						<th>Điện thoại</th>
						<th>Email</th>
						<th>Giới tính</th>
						<th>Năm sinh</th>
						<th>Xem chi tiết</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Ảnh</th>
						<th>Tên</th>
						<th>Tài khoản</th>
						<th>Địa chỉ</th>
						<th>Điện thoại</th>
						<th>Email</th>
						<th>Giới tính</th>
						<th>Năm sinh</th>
						<th>Xem chi tiết</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate name="danhSachNguoiDungForm" property="dsNguoiDung"
					id="sp">
					<tr>
						<bean:define id="anh" name="sp" property="anh"></bean:define>
						<bean:define id="maNguoiDung" name="sp" property="maNguoiDung"></bean:define>
						
						<td><img src="${anh}" style="width: 80px; height: 100px;"></td>
						<td><bean:write name="sp" property="hoTen" /></td>
						<td><bean:write name="sp" property="taiKhoan" /></td>
						<td><bean:write name="sp" property="tenTinh" /></td>
						<td><bean:write name="sp" property="dienThoai" /></td>
						<td><bean:write name="sp" property="email" /></td>
						<td><bean:write name="sp" property="gioiTinh"></bean:write></td>
						<td><bean:write name="sp" property="namSinh"></bean:write></td>
						<td><a href="chi-tiet-nguoi-dung.do?maNguoiDung=${maNguoiDung}">Chi tiết</a></td>
					</tr>
				</logic:iterate>
				</tbody>
			</table>

		</div>
	</div>
</div>
<!-- END BODY -->