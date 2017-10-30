<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
<div id="page-body" class="container">

<!-- 	<div class="body-row"> -->
	
<!-- 		<div class="search"> -->
<!-- 			<form action="" class="search-form"> -->
<!-- 				<input id="tuKhoa" class="search-input search-item" type="text" -->
<!-- 					placeholder="Bạn muốn tìm sản phẩm gì?"> -->
<!-- 				<button class="search-button search-item" type="submit">X</button> -->
<!-- 			</form> -->

<!-- 			<select name="danh-muc"> -->
<!-- 				<option value="1">Tieu thuyet</option> -->
<!-- 			</select> -->
<!-- 			<select name="tinh-thanh"> -->
<!-- 				<option value="1">Da Nang</option> -->
<!-- 			</select>  -->
<!-- 			<select name="loc-gia"> -->
<!-- 				<option value="1">Gia thap truoc</option> -->
<!-- 				<option value="2">Gia cao truoc</option> -->
<!-- 			</select> -->
			

<%--  			<html:select property="maDanhMuc" <%--styleClass="form-control" >  --%>
<%-- 				<html:optionsCollection name="trangChuForm" property="dsDanhMuc" --%>
<%-- 					label="tenDanhMuc" value="maDanhMuc" /> --%>
<%-- 			</html:select> --%>
			
<%-- 			<html:select property="maTinh" <%--styleClass="form-control" >  --%>
<%-- 				<html:optionsCollection name="trangChuForm" property="dsTinh" --%>
<%-- 					label="tenTinh" value="maTinh" /> --%>
<%-- 			</html:select> --%>

<!-- 		</div> -->

<!-- 		<div id="goi-y"> -->
<!-- 			<p>Vai goi y cho nguoi xem de tim duoc san pham mong muon</p> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="body-row">
		<div class="search">
			<form action="ket-qua-tim-kiem.do" method="post" class="search-form">
				<input id="tuKhoa" name="tuKhoa" class="search-input search-item" type="text"
					placeholder="Bạn muốn tìm sản phẩm gì?">
				<button class="search-button search-item" type="submit">X</button>
			</form>

			<select name="danh-muc">
				<option value="1">Tieu thuyet</option>
				<option value="2">Sach giao khoa lop 1</option>
				<option value="3">Truyen trinh tham</option>
			</select> <select name="tinh-thanh">
				<option value="1">Da Nang</option>
				<option value="2">Ha Noi</option>
				<option value="3">TP Ho Chi Minh</option>
			</select> <select name="loc-gia">
				<option value="1">Gia thap truoc</option>
				<option value="2">Gia cao truoc</option>
			</select>
		</div>

		<div id="goi-y">
			<p>Vai goi y cho nguoi xem de tim duoc san pham mong muon</p>
		</div>
	</div>

	<div class="row-item">
		<p style="font-size: 18px;">20 trong tong so 1234 ket qua</p>
	</div>

	<div class="body-row">
		<div class="books">

			<div class="box">
				<div class="sp">
					<a href="#"><img src="images/No-image.jpg"
						class="w3-hover-opacity"></a>
					<h4 class="ten-sach">
						<b>Hai van dam duoi day bien tac gia mario puzo bien tac gia
							mario puzo</b>
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
						<b>Hai van dam duoi day bien tac gia mario puzo bien tac gia
							mario puzo</b>
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
						<b>Hai van dam duoi day bien tac gia mario puzo bien tac gia
							mario puzo</b>
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
						<b>Hai van dam duoi day bien tac gia mario puzo bien tac gia
							mario puzo</b>
					</h4>
					<p class="tac-gia">Tac gia</p>
					<h4 class="gia-tien">
						<b>Gia tien</b>
					</h4>
				</div>
			</div>
		</div>

		<br>
		<br>
		<br>
		<p>Goi y</p>

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
<!--    END BODY    -->