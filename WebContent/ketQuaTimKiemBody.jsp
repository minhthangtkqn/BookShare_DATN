<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
<div id="page-body" class="container">
<bean:define id="tuKhoa" name="ketQuaTimKiemForm" property="tuKhoa"></bean:define>
<bean:define id="sapXepGia" name="ketQuaTimKiemForm" property="sapXepGia"></bean:define>
<bean:define id="sapXepThoiGian" name="ketQuaTimKiemForm" property="sapXepThoiGian"></bean:define>
<bean:define id="maTinh" name="ketQuaTimKiemForm" property="maTinh"></bean:define>
<bean:define id="maDanhMuc" name="ketQuaTimKiemForm" property="maDanhMuc"></bean:define>

	<div class="body-row">
		<div class="search">
			<html:form action="/ket-qua-tim-kiem.do" method="post"
				styleClass="search-form">
				<input autocomplete="off" id="tuKhoa" name="tuKhoa" oninput="recommend()" class="search-input search-item"
					type="text" value="${tuKhoa}" placeholder="Type the book title or the author name ...">
				<button class="search-button search-item btn btn-success" type="submit"><span class="glyphicon glyphicon-search"></span></button>
				
				<select id="loaiTimKiem" name="loaiTimKiem" 
						style="width: 195px;" >
					<option value="sell">Tin bán sách</option>
					<option value="request">Tin mua sách</option>
				</select>


				<html:select property="maDanhMuc" >
					<option value="all">Tất cả các danh mục sách</option>
					<html:optionsCollection name="ketQuaTimKiemForm"
						property="dsDanhMuc" label="tenDanhMuc" value="maDanhMuc" />
				</html:select>

				<html:select property="maTinh" >
					<option value="all">Tất cả các vùng</option>
					<html:optionsCollection name="ketQuaTimKiemForm" property="dsTinh"
						label="tenTinh" value="maTinh" />
				</html:select>

				<select name="sapXepGia">
					<option value="ASC">Giá: Từ thấp đến cao</option>
					<option value="DESC">Giá: Từ cao đến thấp</option>
				</select>

				<select name="sapXepThoiGian">
					<option value="DESC">Bài mới trước</option>
					<option value="ASC">Bài cũ trước</option>
				</select>
			</html:form>

		</div>

		<div id="goi-y">
			<p>
				Các tiêu chí tìm kiếm sẽ giúp bạn nhanh chóng tìm được cuốn sách mà bạn muốn.
			</p>
			<p>
				Chú ý: 
					Nếu bạn không tìm được sách bạn muốn, click vào <a style="color: red; font-weight: bold;" href="them-yeu-cau.do">ĐÂY</a> để đăng yêu cầu mua sách.
			<p>
		</div>
	</div>

	<div class="body-row" style="margin-top: 50px;">
		<div class="books" >
			<h3>
				<b>KẾT QUẢ <logic:notEmpty name="ketQuaTimKiemForm" property="listRaoBan"> (<%=request.getAttribute("soLuongKetQua")%> bài đăng) </logic:notEmpty></b>
			</h3>
			
			<div class="box">
				<logic:notEmpty name="ketQuaTimKiemForm" property="listRaoBan">
				
					<div id="pagination-div" align="center">
						<ul id="pagination-ul" class="pagination">
							<% if((Integer) request.getAttribute("page") > 1 ){ %>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=(Integer) request.getAttribute("page") - 1%>"><i style="font-size: 21px;" class="glyphicon glyphicon-chevron-left"></i></a></li>
							<% } %>
						
							<%
								for (int i = (Integer) request.getAttribute("page") - 2;
											i < (Integer) request.getAttribute("page"); i++) {
									if(i > 0){
							%>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=i%>"><%=i%></a></li>
							<% 		}
								} %>


							<li class="active"><a><%=request.getAttribute("page")%></a></li>


							<%
								for (int j = (Integer) request.getAttribute("page") + 1; j <= (Integer) request.getAttribute("maxPage")
											&& j <= (Integer) request.getAttribute("page") + 2; j++) {
							%>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=j%>"><%=j%></a></li>
							<%	} %>
							
							<% if((Integer) request.getAttribute("page") < (Integer) request.getAttribute("maxPage") ){ %>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=(Integer) request.getAttribute("page") + 1%>"><i style="font-size: 21px;" class="glyphicon glyphicon-chevron-right"></i></a></li>
							<% } %>

						</ul>
					</div>
					
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

					<div id="pagination-div" align="center">
						<ul id="pagination-ul" class="pagination">
							<% if((Integer) request.getAttribute("page") > 1 ){ %>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=(Integer) request.getAttribute("page") - 1%>"><i style="font-size: 21px;" class="glyphicon glyphicon-chevron-left"></i></a></li>
							<% } %>
						
							<%
								for (int i = (Integer) request.getAttribute("page") - 2;
											i < (Integer) request.getAttribute("page"); i++) {
									if(i > 0){
							%>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=i%>"><%=i%></a></li>
							<% 		}
								} %>


							<li class="active"><a><%=request.getAttribute("page")%></a></li>


							<%
								for (int j = (Integer) request.getAttribute("page") + 1; j <= (Integer) request.getAttribute("maxPage")
											&& j <= (Integer) request.getAttribute("page") + 2; j++) {
							%>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=j%>"><%=j%></a></li>
							<%	} %>
							
							<% if((Integer) request.getAttribute("page") < (Integer) request.getAttribute("maxPage") ){ %>
							<li><a href="ket-qua-tim-kiem.do?tuKhoa=${tuKhoa}&sapXepGia=${sapXepGia}&sapXepThoiGian=${sapXepThoiGian}&maDanhMuc=${maDanhMuc}&maTinh=${maTinh}&page=<%=(Integer) request.getAttribute("page") + 1%>"><i style="font-size: 21px;" class="glyphicon glyphicon-chevron-right"></i></a></li>
							<% } %>

						</ul>
					</div>

				</logic:notEmpty>
				
				<logic:empty name="ketQuaTimKiemForm" property="listRaoBan">
					<logic:notEmpty name="ketQuaTimKiemForm" property="dsYeuCau">
						
						<table id="danh-sach-yeu-cau"
							class="table table-striped table-bordered" 
								cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Tên sách yêu cầu</th>
									<th>Tên người yêu cầu</th>
									<th>Email</th>
									<th>Số điện thoại</th>
								</tr>
							</thead>
			
							<tfoot>
								<tr>
									<th>Tên sách yêu cầu</th>
									<th>Tên người yêu cầu</th>
									<th>Email</th>
									<th>Số điện thoại</th>
								</tr>
							</tfoot>
							<!-- ++++++++++++++++++  -->
							<tbody>
								<logic:iterate id="sp" property="dsYeuCau" name="ketQuaTimKiemForm">
									<tr>
				                        <td><bean:write name="sp" property="tenSach" /></td>
				                        <td><bean:write name="sp" property="tenNguoiYeuCau" /></td>
				                        <td><bean:write name="sp" property="email" /></td>
				                        <td><bean:write name="sp" property="dienThoai" /></td>
				                    </tr>
								</logic:iterate>
							</tbody>
						</table>
					</logic:notEmpty>
					
					<logic:empty name="ketQuaTimKiemForm" property="dsYeuCau">
						<p class="empty-message">
							<br>
							Sản phẩm bạn tìm không có
						</p>
					</logic:empty>
				</logic:empty>
			</div>
		</div>

		<br> <br> <br>

		<div class="books">
			<h3 style="color: red;">
				<b>NHỮNG BÀI ĐĂNG NỔI BẬT TRONG THÁNG</b>
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

