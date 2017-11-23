<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<bean:define id="nd" name="trangNguoiDungForm" property="nguoiDung"></bean:define>
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
		<a href="sua-nguoi-dung.do" class="btn btn-success"> 
			<span class="glyphicon glyphicon-pencil"></span> 
			EDIT PROFILE
		</a>
		<a href="lich-su-xem-bai-dang.do" class="btn btn-success"> 
			<span class="glyphicon glyphicon-list-alt"></span> 
			BROWSING HISTORY
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
						<p><bean:write property="soLuongChoDuyet" name="trangNguoiDungForm"/></p>
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
						<p><bean:write property="soLuongDangBan" name="trangNguoiDungForm"/></p>
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
						<p><bean:write property="soLuongDaBan" name="trangNguoiDungForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
		<a href="#danh-sach-xem-sau">
			<div class="user-function row-item watch-later-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/watch-later-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 18px;">
						<p>WATCH LATER</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongXemSau" name="trangNguoiDungForm"/></p>
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
						<th>Edit</th>
						<th>Delete</th>
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
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsChoDuyet" name="trangNguoiDungForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
                        		<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
	                        	<a href="sua-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-pencil font-size-20"></i></a>
	                        </td>
	                        <td>
	                        	<form id="xoa_bai_dang_${maRaoBan}" action="xoa-bai-dang.do" method="post"
								onsubmit="return confirm('Do you want to delete this Post?');">
								<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
								<a onclick="if(document.getElementById('xoa_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('xoa_bai_dang_${maRaoBan}').submit()};"
									href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
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
						<th>Edit</th>
						<th>Delete</th>
						<th>Set as sold</th>
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
						<th>Edit</th>
						<th>Delete</th>
						<th>Set as sold</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsDangBan" name="trangNguoiDungForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
                        		<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
	                        	<a href="sua-bai-dang.do?maRaoBan=${maRaoBan}"><i class="glyphicon glyphicon-pencil font-size-20"></i></a>
	                        </td>
	                        <td>
	                        	<form id="xoa_bai_dang_${maRaoBan}" action="xoa-bai-dang.do" method="post"
									onsubmit="return confirm('Do you want to delete this Post?');">
									<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
									<a onclick="if(document.getElementById('xoa_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('xoa_bai_dang_${maRaoBan}').submit()};"
										href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
	                        </td>
	                        <td>
		                        <form id="ban_bai_dang_${maRaoBan}" action="ban-bai-dang.do" method="post"
									onsubmit="return confirm('Do you want to set this notice as SOLD?');">
									<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
									<a onclick="if(document.getElementById('ban_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('ban_bai_dang_${maRaoBan}').submit()};"
										href="javascript:{}"><i class="glyphicon glyphicon-ok font-size-20"></i></a>
								</form>
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
						<th>Delete</th>
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
						<th>Delete</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsDaBan" name="trangNguoiDungForm">
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
	                        	<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
	                        	<form id="xoa_bai_dang_${maRaoBan}" action="xoa-bai-dang.do" method="post"
								onsubmit="return confirm('Do you want to delete this Post?');">
								<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
								<a onclick="if(document.getElementById('xoa_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('xoa_bai_dang_${maRaoBan}').submit()};"
									href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
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
				<b>WATCH LATER</b>
			</h3>
			<table id="danh-sach-xem-sau"
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
						<th>Delete</th>
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
						<th>Delete</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsXemSau" name="trangNguoiDungForm">
						<tr>
                        	<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
	                        
	                        <td><a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><bean:write name="sp" property="tenSach" /></a></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        <td>
	                        	<form id="xoa_xem_sau_${maRaoBan}" action="xoa-xem-sau.do" method="post"
								onsubmit="return confirm('Do you want to delete this Post from WATCH LATER list?');">
								<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
								<input name="preLink" value="trangCaNhan" style="display: none;">
								<a onclick="if(document.getElementById('xoa_xem_sau_${maRaoBan}').onsubmit()){document.getElementById('xoa_xem_sau_${maRaoBan}').submit()};"
									href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
	                        </td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>
	
</div>
<!-- END BODY -->

