<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
<div id="page-body" class="container">

	<div class="body-row">
		<div class="search">
			<html:form action="/ket-qua-tim-kiem.do" method="post"
				styleClass="search-form">
				<input id="tuKhoa" name="tuKhoa" oninput="recommend()" class="search-input search-item"
					type="text" placeholder="Bạn muốn tìm sản phẩm gì?">
				<button class="search-button search-item btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>

				<html:select property="maDanhMuc" styleClass="form-control">
					<option value="all">Tất cả danh mục</option>
					<html:optionsCollection name="ketQuaTimKiemForm"
						property="dsDanhMuc" label="tenDanhMuc" value="maDanhMuc" />
				</html:select>

				<html:select property="maTinh" styleClass="form-control">
					<option value="all">Tất cả tỉnh thành</option>
					<html:optionsCollection name="ketQuaTimKiemForm" property="dsTinh"
						label="tenTinh" value="maTinh" />
				</html:select>

				<select name="sapXepGia">
					<option value="0">Gia cao truoc</option>
					<option value="1">Gia thap truoc</option>
				</select>

				<select name="sapXepThoiGian">
					<option value="0">Bai moi' truoc</option>
					<option value="1">Bai cu~ truoc</option>
				</select>
			</html:form>

		</div>

		<div id="goi-y">
			<p>Vai goi y cho nguoi xem de tim duoc san pham mong muon</p>
		</div>
	</div>

<!-- 	<div class="row-item"> -->
<!-- 		<p style="font-size: 18px;">20 trong tong so 1234 ket qua</p> -->
<!-- 	</div> -->

	<div class="body-row" style="margin-top: 50px;">
		<div class="books" >
			<h3>
				<b>KẾT QUẢ TÌM KIẾM</b>
			</h3>
			
			<div class="box">
				<logic:iterate id="book" property="listRaoBan" name="ketQuaTimKiemForm">
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

		<br> <br> <br>
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

<script>
	function recommend(){
		$("#tuKhoa").autocomplete("List.jsp");
	}
</script>