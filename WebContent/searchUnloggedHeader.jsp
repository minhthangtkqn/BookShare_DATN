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

		<div class="float-right" style="height: 20px; margin-top: 20px; margin-bottom: 20px;">
			<ul class="list-inline list-unstyled">
				<li><a style="color: white;" href="dangKy.jsp"><i class="fa fa-user"></i> Register</a></li>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a style="color: white;" href="dangNhap.jsp"><i class="fa fa-lock"></i> Log in</a></li>
			</ul>
		</div>
		
	</div>
</div>
<!-- END HEADER -->