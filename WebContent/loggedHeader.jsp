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

		<div class="float-right" style="height: 40px; margin-top: 10px; margin-bottom: 10px;">
			<ul class="list-inline list-unstyled">
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

		<div class="float-right" style="height: 30px; margin-top: 15px; margin-bottom: 15px;">
			<a href="dang-ban.do" class="btn btn-primary-outline font-size-12 border-hover" style="color: white;">
				<span class="glyphicon glyphicon-pencil"></span> Sell book
			</a>
		</div>

		<div class="float-right" style="height: 30px; margin-top: 15px; margin-bottom: 15px;">
			<a href="ket-qua-tim-kiem.do" class="btn btn-primary-outline font-size-12 border-hover" style="color: white;">
				<span class="glyphicon glyphicon-search"></span> 
				Find books
			</a>
		</div>
		
		<div class="float-right" style="height: 30px; margin-top: 15px; margin-bottom: 15px;">
			<a href="lich-su-xem-bai-dang.do" class="btn btn-primary-outline font-size-12 border-hover" style="color: white;">
				<span class="glyphicon glyphicon-time"></span> 
				Browsing History
			</a>
		</div>

	</div>
</div>
<!-- END HEADER -->