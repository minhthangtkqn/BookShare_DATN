<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- HEADER -->
<div id="header">
	<div class="container">
		<div class="col-lg-2">
			<a style="color: white;" href="trang-chu.do"><img src="images/logobook.png" alt=""
				style="height: 100%; width: 100%;" /></a>
		</div>

		<div class="col-lg-offset-5 col-lg-2" style="height: 30px; margin-top: 15px; margin-bottom: 15px;">
			<a style="color: white;" href="ket-qua-tim-kiem.do" class="btn btn-primary-outline">
				<span class="glyphicon glyphicon-search"></span>
				Find books
			</a>
		</div>

		<div class="col-lg-3" style="height: 20px; margin-top: 20px; margin-bottom: 20px;">
			<ul class="list-inline list-unstyled" style="float: right;">
				<li><a style="color: white;" href="dangKy.jsp"><i class="fa fa-user"></i> Register</a></li>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a style="color: white;" href="dangNhap.jsp"><i class="fa fa-lock"></i> Log in</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- END HEADER -->