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

			<div class="box">
				<logic:iterate id="book" property="dsMoiNhat" name="trangChuForm">
					<div class="sp">
						<a href="#"><img src="images/No-image.jpg"
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
				
<!-- 				<div class="sp"> -->
<!-- 					<a href="#"><img src="images/No-image.jpg" -->
<!-- 						class="w3-hover-opacity"></a> -->
<!-- 					<h4 class="ten-sach"> -->
<!-- 						<b>Hai van dam duoi day bien tac gia mario puzo bien tac gia -->
<!-- 							mario puzo</b> -->
<!-- 					</h4> -->
<!-- 					<p class="tac-gia">Tac gia</p> -->
<!-- 					<h4 class="gia-tien"> -->
<!-- 						<b>Gia tien</b> -->
<!-- 					</h4> -->
<!-- 				</div> -->

			</div>
		</div>

		<br>
		<br>
		<br>
		<p>10 bai dang duoc xem nhieu nhat</p>

		<div class="books">
			<div class="owl-carousel owl-theme">
				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 1</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>

				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 2</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>

				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 3</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>

				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 4</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>

				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 5</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>

				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>SACH 6</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END BODY -->