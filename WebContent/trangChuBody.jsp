<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!--    BODY        -->
	<div id="slider-content">
		<div id="menu_ngang">
			<h4>
				<b>DANH MỤC</b>
			</h4>
			<ul>
				<logic:iterate id="danhMuc" property="dsDanhMuc" name="trangChuForm">
					<li><a href="#"><b><bean:write name="danhMuc" property="tenDanhMuc" /></b></a></li>
				</logic:iterate>
			</ul>
		</div>

		<!--slider-->
		<section id="slider">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<%
					int i = 0;
				%>
				<logic:iterate name="trangChuForm" property="dsBanner" id="banner">
					<%
						i++;
					%>
					<div class="item <%if (i == 1) {%>active<%}%>">
						<bean:define id="linkAnh" name="banner"
							property="linkAnh"></bean:define>
						<img src="${linkAnh}" alt="book1" width="1200" height="700">
						<div class="carousel-caption">
							<h3>
								<bean:write name="banner" property="tieuDe" />
							</h3>
							<p>"Những gì sách dạy chúng ta cũng giống như lửa. Chúng ta
								lấy nó từ nhà hàng xóm, thắp nó trong nhà ta, đem nó truyền cho
								người khác và nó trở thành tài sản của tất cả mọi người."</p>
						</div>
					</div>
				</logic:iterate>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		</section>
		<!--/slider-->

		<%-- 	<html:link styleClass="btn btn-primary" --%>
		<%-- 		action="/ket-qua-tim-kiem.do?page=1">Tim kiem</html:link> --%>

		<!-- -sanpham -->
		<!--book new-->
		<div class="book-new">
			<h3>
				<img src="images/home/newn.png"
					style="height: 30px; width: 70px; margin-right: 10px;"><b>SÁCH
					MỚI NHẤT </b>
			</h3>

			<div class="box">
				<!-- sp -->
				<logic:iterate name="trangChuForm" property="dsMoiNhat" id="sp">
					<div class="sp">
						<bean:define id="linkAnh1" name="sp" property="linkAnh1"></bean:define>
						<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
						<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><img
							src="${linkAnh1}" class="w3-hover-opacity"
							style="height: 73%; width: 90%; display: block; margin-left: 10px; margin-top: 10px;"></a>
						<h5>
							<b><bean:write name="sp" property="tenSach" /></b>
						</h5>
						<p>
							<bean:write name="sp" property="tacGia" />
						</p>
						<h4>
							<b><bean:write name="sp" property="gia" /></b>
						</h4>
					</div>
				</logic:iterate>
				<!-- sp -->
			</div>
		</div>

		<!--book hot-->
		<div class="book-hot">
			<h3>
				<img src="images/home/hotn.png" class="w3-hover-opacity"
					style="height: 50px; width: 70px; margin-right: 10px;"><b>SÁCH
					HOT</b>
			</h3>

			<div class="box">
				<!-- sp -->
				<logic:iterate name="trangChuForm" property="dsNgauNhien" id="sp">
					<div class="sp">
						<bean:define id="linkAnh1" name="sp" property="linkAnh1"></bean:define>
						<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
						<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><img
							src="${linkAnh1}" class="w3-hover-opacity"
							style="height: 73%; width: 90%; display: block; margin-left: 10px; margin-top: 10px;"></a>
						<h5>
							<b><bean:write name="sp" property="tenSach" /></b>
						</h5>
						<p>
							<bean:write name="sp" property="tacGia" />
						</p>
						<h4>
							<b><bean:write name="sp" property="gia" /></b>
						</h4>
					</div>
				</logic:iterate>
				<!-- sp -->
			</div>
		</div>

	</div>
	<!--    END BODY        -->