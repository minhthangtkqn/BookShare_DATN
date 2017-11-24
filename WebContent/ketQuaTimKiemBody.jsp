<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
<div id="page-body" class="container">
<bean:define id="tuKhoa" name="ketQuaTimKiemForm" property="tuKhoa"></bean:define>

	<div class="body-row">
		<div class="search">
			<html:form action="/ket-qua-tim-kiem.do" method="post"
				styleClass="search-form">
				<input autocomplete="off" id="tuKhoa" name="tuKhoa" oninput="recommend()" class="search-input search-item"
					type="text" value="${tuKhoa}" placeholder="Type the book title or the author name ...">
				<button class="search-button search-item btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>

				<html:select property="maDanhMuc" >
					<option value="all">All categories</option>
					<html:optionsCollection name="ketQuaTimKiemForm"
						property="dsDanhMuc" label="tenDanhMuc" value="maDanhMuc" />
				</html:select>

				<html:select property="maTinh" >
					<option value="all">All regions</option>
					<html:optionsCollection name="ketQuaTimKiemForm" property="dsTinh"
						label="tenTinh" value="maTinh" />
				</html:select>

				<select name="sapXepGia">
					<option value="1">Price: Low to high</option>
					<option value="0">Price: High to low</option>
				</select>

				<select name="sapXepThoiGian">
					<option value="0">Latest posts first</option>
					<option value="1">Oldest posts first</option>
				</select>
			</html:form>

		</div>

		<div id="goi-y">
			<p>
				Search criteria will help you quickly find the book that you want.
			</p>
			<p>
				Note: 
				<span style="color: red; font-weight: bold;">
					We will suggest you some book titles from posts.
				</span>
			<p>
		</div>
	</div>

	<div class="body-row" style="margin-top: 50px;">
		<div class="books" >
			<h3>
				<b>SEARCH RESULTS</b>
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
				<b>FEATURED POSTS FROM LAST MONTH SO FAR</b>
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

