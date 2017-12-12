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
			<a href="trang-chu.do">
				<img src="images/logobook.png" alt=""
				class="logo" />
			</a>
		</div>
		
		<div class="col-lg-5 height-100-percent" >
			<html:form action="/ket-qua-tim-kiem.do" method="post" styleClass="height-100-percent">
				<input autocomplete="off" id="tuKhoa" name="tuKhoa" oninput="recommend()" 
				class="search-input search-item col-lg-9 height-100-percent" type="text" 
				placeholder="Book title or author name ...">

				<button type="submit"
					class="search-btn-header col-lg-3 w3-btn w3-blue border-hover height-100-percent"> 
						Tìm kiếm
				</button>
			</html:form>
		</div>

		<div class="float-right" style="height: 100%; margin-top: 3px;">
			<ul class="list-inline list-unstyled">
				<li class="dropdown">
					<div style="height: 40px;">
						<a href="trang-ca-nhan.do" style="color: black;"><img class="img-circle"
							style="height: 40px; width: 40px;" alt="" src="${Avatar}">
							${userName} </a>
					</div>
					<div class="dropdown-content">
						<div><a href="trang-ca-nhan.do">Trang cá nhân</a></div>
						<div><a href="danh-sach-thong-bao.do">Thông báo của bạn</a></div>
					</div>
				</li> &nbsp;&nbsp;
				<li><div style="height: 40px; padding-top: 7px;">
						<a href="dang-xuat.do" style="color: black;"><i class="glyphicon glyphicon-off"></i>
							Đăng xuất</a>
					</div></li>
			</ul>
		</div>

		<div class="float-right height-100-percent">
			<a href="dang-ban.do" 
				style="color: black;"
				class="btn btn-primary-outline font-size-12 border-hover height-100-percent">
				<span class="glyphicon glyphicon-pencil feature-icon"></span>
				<div class="feature-title">Bán sách</div>
			</a>
		</div>

		<div class="float-right height-100-percent">
			<a href="lich-su-xem-bai-dang.do" 
				class="btn btn-primary-outline font-size-12 border-hover height-100-percent" 
				style="color: black;">
				<span class="glyphicon glyphicon-time feature-icon"></span> 
				<div class="feature-title">Sách đã xem</div>
			</a>
		</div>

	</div>
</div>
<!-- END HEADER -->