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

				<html:select property="maDanhMuc" >
					<option value="all">Tất cả danh mục</option>
					<html:optionsCollection name="ketQuaTimKiemForm"
						property="dsDanhMuc" label="tenDanhMuc" value="maDanhMuc" />
				</html:select>

				<html:select property="maTinh" >
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
			<p>
				Hãy sử dụng các tiêu chí lựa chọn 
				để nhanh chóng tìm ra cuốn sách mong muốn
			</p>
			<p>
				Lưu ý: 
				<span style="color: red; font-weight: bold;">Bạn sẽ được gợi ý những 
				cuốn sách đã được đăng khi gõ từ khóa</span>
			<p>
		</div>
	</div>

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

		<div class="books">
			<h3 style="color: red;">
				<b>HOT TRONG THÁNG VỪA QUA</b>
			</h3>

			<div class="owl-carousel owl-theme">

				<logic:iterate id="book" property="dsHot" name="ketQuaTimKiemForm">
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
<!--    END BODY    -->

<script>
	function recommend(){
		$("#tuKhoa").autocomplete("List.jsp");
	}
</script>