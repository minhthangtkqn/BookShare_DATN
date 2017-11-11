<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<bean:define id="maNguoiBan" name="danhGiaNguoiBanForm" property="maNguoiBan"></bean:define>
	
	<div class="body-row">
	
		<!-- RATING -->
		<div class="body-row">
			<form action="danh-gia-nguoi-ban.do" method="post">
				<input name="maNguoiBan" value="${maNguoiBan}"
					style="display: none;"> <input id="rating-seller"
					name="diemDanhGia"> <input name="binhLuan" type="text">
				<input type="submit" value="submit" class="w3-btn w3-red">
			</form>
		</div>
		<!-- END RATING maNguoiRaoBan -->
		
		
	</div>
</div>
<!-- END BODY -->