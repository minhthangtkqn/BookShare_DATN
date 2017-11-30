<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- HEADER -->
<div id="header">
	<div class="container">
		<div class="height-100-percent" style="width: 11%; float: left;">
			<a style="color: black;" href="trang-chu.do">
				<img src="images/logobook.png" alt="" class="logo"/>
			</a>
		</div>

		<div class="float-right height-100-percent" style="padding-top: 12px;">
			<ul class="list-inline list-unstyled">
				<li><a style="color: black;" href="dangKy.jsp"><i class="fa fa-user"></i> Register</a></li>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a style="color: black;" href="dangNhap.jsp"><i class="fa fa-lock"></i> Log in</a></li>
			</ul>
		</div>
		
		<div class="col-lg-5 height-100-percent" >
			<html:form action="/ket-qua-tim-kiem.do" method="post" styleClass="height-100-percent">
				<input autocomplete="off" id="tuKhoa" name="tuKhoa" oninput="recommend()" 
				class="search-input search-item col-lg-9 height-100-percent" type="text" 
				placeholder="Book title or author name ...">

				<button type="submit"
					class="search-btn-header col-lg-3 w3-btn w3-blue border-hover height-100-percent"> 
						Find books
				</button>
			</html:form>
		</div>

	</div>
</div>
<!-- END HEADER -->