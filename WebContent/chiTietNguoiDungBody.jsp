<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<div>
	<div class="container">
		<bean:define id="nd" name="nguoiDungForm" property="nguoiDung"></bean:define>
		<div style="border: 1px solid black;">
			<p style="font-size: 17px; color: red; font-style: italic;">
				<b>THÔNG TIN CHI TIẾT</b>
			</p>
			<div class="anh_nguoiban">
				<bean:define id="anh" name="nd"
					property="anh"></bean:define>
				<img style="height: 200px; width: 200px;" src="${anh}">
			</div>
			<div class="text_info">
				<p>
					Tài khoản:
					<bean:write name="nd" property="taiKhoan" />
				</p>

				<p>
					Tên người bán:
					<bean:write name="nd" property="hoTen" />
				</p>

				<p>
					Giới tính:
					<bean:write name="nd" property="gioiTinh" />
				</p>
				<p>
					Năm sinh:
					<bean:write name="nd" property="namSinh" />
				</p>
				<p>
					Điện thoại:
					<bean:write name="nd" property="dienThoai" />
				</p>
				<p>
					Email:
					<bean:write name="nd" property="email" />
				</p>
				<p>
					Địa chỉ:
					<bean:write name="nd" property="tenTinh" />
				</p>
				<p>
					Ghi chú:
					<bean:write name="nd" property="ghiChu"/>
				</p>
				<p>
					Tình trạng:
					<bean:write name="nd" property="loaiNguoiDung"/>
				</p>
			</div>
			
		</div>
	</div>
</div>