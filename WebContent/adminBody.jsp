<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<bean:define id="nd" name="trangQuanLyForm" property="admin"></bean:define>
<bean:define id="hoTen" name="nd" property="hoTen"></bean:define>
<bean:define id="tenTinh" name="nd" property="tenTinh"></bean:define>
<bean:define id="gioiTinh" name="nd" property="gioiTinh"></bean:define>
<bean:define id="namSinh" name="nd" property="namSinh"></bean:define>
<bean:define id="email" name="nd" property="email"></bean:define>
<bean:define id="dienThoai" name="nd" property="dienThoai"></bean:define>

<!-- BODY -->
<div id="page-body" class="container">
	<div class="body-row">
	
		<div class="row-item user-info w3-container w3-light-grey">
			<h3>Personal information</h3>
			<p>
				<label>Full Name</label> 
				<input value="${hoTen}" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Region</label> 
				<input value="${tenTinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Gender</label> 
				<input value="${gioiTinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Birth Year</label> 
				<input value="${namSinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
		</div>

		<div class="row-item user-info w3-container w3-light-grey">
			<h3>Contact information</h3>
			<p>
				<label>Phone number</label> 
				<input value="${dienThoai }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Email</label> 
				<input value="${email }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
		</div>

		<div class="row-item user-img">
			<img src="${Avatar }" alt=""
				style="width: inherit; height: auto;" />
		</div>
	</div>
	
	<div class="body-row">
		<a href="danh-sach-nguoi-dung.do" class="btn btn-success"> 
			<span class="glyphicon glyphicon-th-list"></span> Danh sách người dùng
			</a>
	</div>

	<div class="body-row user-functions">
		<a href="#danh-sach-cho-duyet">
			<div class="user-function row-item">DS CHỜ DUYỆT</div>
		</a> <a href="#danh-sach-dang-ban">
			<div class="user-function row-item">DS ĐANG BÁN</div>
		</a> <a href="#danh-sach-mua-sau">
			<div class="user-function row-item">???????????</div>
		</a> <a href="#danh-sach-da-ban">
			<div class="user-function row-item">DS ĐÃ BÁN</div>
		</a>
	</div>
	
	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>ĐANG CHỜ DUYỆT</b>
			</h3>
			<table id="danh-sach-cho-duyet"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Duyệt</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Duyệt</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsChoDuyet" name="trangQuanLyForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
                        		<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-pencil"></i></a>
	                        </td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>

		</div>
	</div>
	
	<!-- +++++++++++++++++++++++ -->
	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>ĐANG BÁN</b>
			</h3>
			<table id="danh-sach-dang-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Bỏ duyệt</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Bỏ duyệt</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsDangBan" name="trangQuanLyForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
                        		<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-pencil"></i></a>
	                        </td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- +++++++++++++++++++++++ -->
	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>ĐÃ BÁN</b>
			</h3>
			<table id="danh-sach-da-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá bán</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsDaBan" name="trangQuanLyForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	
</div>
<!-- END BODY -->