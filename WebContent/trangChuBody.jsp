<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">

	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>NHỮNG BÀI ĐĂNG MỚI NHẤT</b>
			</h3>
			
			<div class="box">
			
				<logic:iterate id="book" property="dsMoiNhat" name="trangChuForm">
					<div class="sp">
						<bean:define id="anh" name="book" property="linkAnh1"></bean:define>
						<bean:define id="maRaoBan" name="book" property="maRaoBan"></bean:define>
						
						<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><img src="${anh}"
							class="w3-hover-opacity"></a>
						<h4 class="ten-sach">
							<b><bean:write name="book" property="tenSach" /></b>
						</h4>
						<p class="tac-gia"><bean:write name="book" property="tacGia" /></p>
						<h4 class="gia-tien">
							<b><bean:write name="book" property="gia" /></b>
						</h4>
					</div>
				</logic:iterate>

			</div>
		</div>

		<br>
		<br>
		<br>
		
		<div class="books">
			<h3 style="color: red;">
				<b>NHỮNG BÀI ĐĂNG NỔI BẬT TRONG THÁNG</b>
			</h3>

			<div class="owl-carousel owl-theme">

				<logic:iterate id="book" property="dsHot" name="trangChuForm">
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