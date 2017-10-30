<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- HEADER -->
<div id="header">
	<div class="container">
		<div class="logo">
			<a href="trang-chu.do"><img src="images/logobook.png" alt=""
				style="height: 100%; width: 100%" /></a>
		</div>

		<div class="find-books">
			<a href="ket-qua-tim-kiem.do" class="btn btn-primary-outline"> <span
				class="glyphicon glyphicon-search"></span> Find books
			</a>
		</div>

		<div id="credentials">
			<ul class="">
				<li><div style="height: 40px;">
						<a href="trang-ca-nhan.do"><img class="img-circle"
							style="height: 40px; width: 40px;" alt="" src="${Avatar}">
							${userName} </a>
					</div></li> &nbsp;&nbsp;&nbsp;&nbsp;
				<li><div style="height: 40px; padding-top: 7px;">
						<a href="dang-xuat.do"><i class="glyphicon glyphicon-off"></i>
							Đăng xuất</a>
					</div></li>
			</ul>
		</div>
	</div>
</div>
<!-- END HEADER -->