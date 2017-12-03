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
			<h3>Thông tin cá nhân</h3>
			<p>
				<label>Họ tên</label> 
				<input value="${hoTen}" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Khu vực</label> 
				<input value="${tenTinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Giới tính</label> 
				<input value="${gioiTinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
			<p>
				<label>Năm sinh</label> 
				<input value="${namSinh }" class="w3-input w3-border w3-round" type="text" disabled>
			</p>
		</div>

		<div class="row-item user-info w3-container w3-light-grey">
			<h3>Thông tin liên lạc</h3>
			<p>
				<label>Số điện thoại</label> 
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
			SỬA THÔNG TIN
		</a>
		<a href="#user-functions" class="btn btn-success"> 
			<span class="glyphicon glyphicon-list-alt"></span> 
			BÀI ĐĂNG CỦA BẠN
		</a>
	</div>

	<div id="box-yeu-cau" class="body-row">
		<div class="books">
			<h3>
				<b>SÁCH BẠN ĐÃ YÊU CẦU</b>
			</h3>
			<table id="danh-sach-yeu-cau"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tiêu đề</th>
						<th>Xóa</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tiêu đề</th>
						<th>Xóa</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate id="sp" property="dsYeuCau" name="trangNguoiDungForm">
						<bean:define id="maYeuCau" name="sp" property="maYeuCau"></bean:define>
						<tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td>
	                        	<form id="xoa_yeu_cau_${maYeuCau}" action="xoa-yeu-cau.do" method="post"
								onsubmit="return confirm('Do you want to delete this request?');">
									<input name="maYeuCau" value="${maYeuCau}" style="display: none;">
								
									<a onclick="if(document.getElementById('xoa_yeu_cau_${maYeuCau}').onsubmit()){document.getElementById('xoa_yeu_cau_${maYeuCau}').submit()};"
										href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
	                        </td>
	                    </tr>
					</logic:iterate>
				</tbody>
			</table>

		</div>
	</div>
	<div id="user-functions"></div>
	<br>
	<br>
	<div class="body-row user-functions">
		<a href="#box-cho-duyet">
			<div class="user-function row-item pending-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/pending-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>CHỜ DUYỆT</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongChoDuyet" name="trangNguoiDungForm"/></p>
					</div>
				</div>
			</div>
		</a> 
		
		<a href="#box-dang-ban">
			<div class="user-function row-item selling-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/selling-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>ĐANG BÁN</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongDangBan" name="trangNguoiDungForm"/></p>
					</div>
				</div>
			</div>
		</a> 
		
		<a href="#box-da-ban">
			<div class="user-function row-item sold-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/sold-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 20px;">
						<p>ĐÃ BÁN</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongDaBan" name="trangNguoiDungForm"/></p>
					</div>
				</div>
			</div>
		</a>
		
		<a href="#box-xem-sau">
			<div class="user-function row-item watch-later-feature">
				<div class="col-lg-4" style="height: 100%;">
					<img alt="pending icon" src="images/home/watch-later-icon.png" style="width: 100%; margin-top: 13px;">
				</div>
				<div class="col-lg-8" style="height: 100%;">
					<div style="margin-top: 13px; font-size: 18px;">
						<p>XEM SAU</p>
					</div>
					
					<div style="font-size: 20px;">
						<p><bean:write property="soLuongXemSau" name="trangNguoiDungForm"/></p>
					</div>
				</div>
			</div>
		</a> 
	</div>

	<br><br>
	<div id="box-cho-duyet" class="body-row">
		<div class="books">
			<h3>
				<b>CHỜ DUYỆT</b>
			</h3>
			<table id="danh-sach-cho-duyet"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Chỉnh sửa</th>
						<th>Xóa</th>
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
								onsubmit="return confirm('Bạn có thực sự muốn XÓA bài đăng này?');">
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
	<div id="box-dang-ban" class="body-row">
		<div class="books">
			<h3>
				<b>ĐANG BÁN</b>
			</h3>
			<table id="danh-sach-dang-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Sửa</th>
						<th>Xóa</th>
						<th>Đã bán</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Sửa</th>
						<th>Xóa</th>
						<th>Đã bán</th>
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
									onsubmit="return confirm('Bạn có thực sự muốn XÓA bài đăng này?');">
									<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
									<a onclick="if(document.getElementById('xoa_bai_dang_${maRaoBan}').onsubmit()){document.getElementById('xoa_bai_dang_${maRaoBan}').submit()};"
										href="javascript:{}"><i class="glyphicon glyphicon-trash font-size-20"></i></a>
								</form>
	                        </td>
	                        <td>
		                        <form id="ban_bai_dang_${maRaoBan}" action="ban-bai-dang.do" method="post"
									onsubmit="return confirm('Bạn có thực sự muốn chuyển bài đăng này sang ĐÃ BÁN?');">
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
	<div id="box-da-ban" class="body-row">
		<div class="books">
			<h3>
				<b>ĐÃ BÁN</b>
			</h3>
			<table id="danh-sach-da-ban"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Xóa</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày đăng</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Xóa</th>
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
								onsubmit="return confirm('Bạn có thực sự muốn XÓA bài đăng này?');">
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
	<div id="box-xem-sau" class="body-row">
		<div class="books">
			<h3>
				<b>XEM SAU</b>
			</h3>
			<table id="danh-sach-xem-sau"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Xóa</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên sách</th>
						<th>Danh mục</th>
						<th>Giá</th>
						<th>Ngày bán</th>
						<th>Nhà xuất bản</th>
						<th>Năm xuất bản</th>
						<th>Xóa</th>
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
								onsubmit="return confirm('Bạn có thực sự muốn XÓA bài đăng này khỏi DANH SÁCH XEM SAU?');">
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

