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
			<i class="glyphicon glyphicon-th-list"></i> Managing users
		</a>
		<a href="danh-muc.do" class="btn btn-success"> 
			<i class="glyphicon glyphicon-align-left"></i> Managing categories
		</a>
	</div>

	<div class="body-row user-functions">
		<a href="#danh-sach-cho-duyet">
			<div class="user-function row-item pending-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/pending-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>PENDING</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongChoDuyet" name="trangQuanLyForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
		<a href="#danh-sach-dang-ban">
			<div class="user-function row-item selling-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/selling-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>SELLING</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongDangBan" name="trangQuanLyForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
		<a href="#danh-sach-da-ban">
			<div class="user-function row-item sold-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/sold-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>SOLD</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongDaBan" name="trangQuanLyForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
		<a href="#danh-sach-bi-khoa">
			<div class="user-function row-item locked-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/lock-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>LOCKED</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongKhoa" name="trangQuanLyForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
	</div>
	
	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>PENDING</b>
			</h3>
			<table id="danh-sach-cho-duyet"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
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
								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-check font-size-20"></i></a>
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
				<b>SELLING</b>
			</h3>
			<table id="danh-sach-dang-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
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
								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-check font-size-20"></i></a>
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
				<b>SOLD</b>
			</h3>
			<table id="danh-sach-da-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
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
	
	<!-- ++++++++++++++++++++++++++++++ -->
	<br><br>
	<div class="body-row">
		<div class="books">
			<h3>
				<b>LOCKED</b>
			</h3>
			<table id="danh-sach-bi-khoa"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Book title</th>
						<th>Category</th>
						<th>Price</th>
						<th>Posted date</th>
						<th>Publisher</th>
						<th>Publish year</th>
						<th>Details</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsKhoa" name="trangQuanLyForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
                        		<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-check font-size-20"></i></a>
	                        </td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	
</div>
<!-- END BODY -->