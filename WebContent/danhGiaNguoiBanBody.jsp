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
	
		<!-- RATING -->
		<div class="body-row">
			
			<div class="form-group col-lg-7">
				<div class="black-border note">
					<p>
						Vui lòng chọn điểm đánh giá và để lại bình 
						luận trước khi gửi đánh giá
					</p>
				</div>

				<br>

				<html:form action="danh-gia-nguoi-ban.do" method="post">
					<input name="maNguoiBan" value="${maNguoiBan}" style="display: none;">
					<input id="rating-seller" name="diemDanhGia">
					<p style="color: red;">
						<html:errors property="diemDanhGiaError"/>
					</p>
					
					<html:textarea rows="7" property="binhLuan" styleClass="form-control"></html:textarea>
					<p style="color: red;">
						<html:errors property="binhLuanError" />
					</p>
					
					<html:submit styleClass="w3-btn w3-red form-control" property="submit" value="submit">Submit</html:submit>
					
				</html:form>
			</div>
			
			<div class="col-lg-offset-1 col-lg-4">
				
				<h2 class="info-title">
					<b>THÔNG TIN NGƯỜI BÁN</b>
				</h2>
				<div class="anh_nguoiban">
					<bean:define id="anh" name="nguoiBan" property="anh"></bean:define>
					<img style="height: 200px; width: 200px;" src="${anh}">
				</div>
				<div class="text_info">
<!-- 					<p> -->
<!-- 						Tài khoản: -->
<%-- 						<bean:write name="nguoiBan" property="taiKhoan" /> --%>
<!-- 					</p> -->
					
					<p>
						Tên:
						<bean:write name="nguoiBan" property="hoTen" />
					</p>
					
					<p>
						Năm sinh:
						<bean:write name="nguoiBan" property="namSinh" />
					</p>
					
					<p>
						Email:
						<bean:write name="nguoiBan" property="email" />
					</p>
					
					<p>
						Số điện thoại:
						<bean:write name="nguoiBan" property="dienThoai" />
					</p>
					
				</div>
			</div>
		</div>
		<!-- END RATING -->
		
	</div>
</div>
<!-- END BODY -->