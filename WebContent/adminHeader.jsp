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
			<a href="trang-chu.do"><img src="images/logobook.png" alt=""
				style="height: 100%; width: 100%" /></a>
		</div>

		<div class="col-lg-offset-7 col-lg-3" style="height: 40px; margin-top: 10px; margin-bottom: 10px;">
			<ul class="list-inline list-unstyled" style="float: right;">
				<li><div style="height: 40px;">
						<a href="trang-ca-nhan.do" style="color: white;"><img class="img-circle"
							style="height: 40px; width: 40px;" alt="" src="${Avatar}">
							${userName} </a>
					</div></li> &nbsp;&nbsp;&nbsp;&nbsp;
				<li><div style="height: 40px; padding-top: 7px;">
						<a href="dang-xuat.do" style="color: white;"><i class="glyphicon glyphicon-off"></i>
							Log out</a>
					</div></li>
			</ul>
		</div>
	</div>
</div>
<!-- END HEADER -->