<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!-- BODY -->
<div id="page-body" class="container">
	<div class="body-row">
		<div class="row-item user-info">
			<p>Tên: Hoàng Minh Thắng</p>
			<p>Địa chỉ: Tam Kỳ, Quảng Nam</p>
			<p>Tài sản: Nhà 4 mặt tiền</p>
			<p>Công ty: TLDs</p>
			<p>Năm sinh: 1990</p>
		</div>

		<div class="row-item user-img">
			<img src="images/No-image.jpg" alt=""
				style="height: 100%; width: 100%" />
		</div>
	</div>

	<div class="body-row user-functions">
		<a href="#danh-sach-cho-duyet">
			<div class="user-function row-item">DS CHỜ DUYỆT</div>
		</a> <a href="#danh-sach-dang-ban">
			<div class="user-function row-item">DS ĐANG BÁN</div>
		</a> <a href="#danh-sach-mua-sau">
			<div class="user-function row-item">DS MUA SAU</div>
		</a> <a href="#danh-sach-da-ban">
			<div class="user-function row-item">DS ĐÃ BÁN</div>
		</a>
	</div>

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
					<tr>
						<td>Bố già</td>
						<td>Tiểu thuyết nước ngoài</td>
						<td>108.000</td>
						<td>28/10/2016</td>
						<td>Nhà xuất bản Văn học</td>
						<td>2015</td>
					</tr>
					<tr>
						<td>Bố già</td>
						<td>Tiểu thuyết trinh thám</td>
						<td>164.000</td>
						<td>26/10/2016</td>
						<td>Nhà xuất bản Trẻ</td>
						<td>2015</td>
					</tr>
					<tr>
						<td>2 vạn dbiển</td>
						<td>Tiểu thuyết nước ngoài</td>
						<td>108.000</td>
						<td>28/10/2016</td>
						<td>Nhà xuất bản Văn học</td>
						<td>2016</td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</div>
<!-- END BODY -->

