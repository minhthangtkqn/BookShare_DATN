<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">

	<div class="body-row">
		<div class="books">
			<h3>
				<b>DANH SÁCH NGƯỜI DÙNG</b>
			</h3>
			<table id="danh-sach-nguoi-dung"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên</th>
						<th>Tài khoản</th>
						<th>Địa chỉ</th>
						<th>Điện thoại</th>
						<th>Email</th>
						<th>Giới tính</th>
						<th>Năm sinh</th>
						<th>Xem chi tiết</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>Tên</th>
						<th>Tài khoản</th>
						<th>Địa chỉ</th>
						<th>Điện thoại</th>
						<th>Email</th>
						<th>Giới tính</th>
						<th>Năm sinh</th>
						<th>Xem chi tiết</th>
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
						<td>11111</td>
						<td><a href="#">Link</a></td>
					</tr>
					<tr>
						<td>Bố già</td>
						<td>Tiểu thuyết trinh thám</td>
						<td>164.000</td>
						<td>26/10/2016</td>
						<td>Nhà xuất bản Trẻ</td>
						<td>2015</td>
						<td>11111</td>
						<td><a href="#">Link</a></td>
					</tr>
					<tr>
						<td>2 vạn dbiển</td>
						<td>Tiểu thuyết nước ngoài</td>
						<td>108.000</td>
						<td>28/10/2016</td>
						<td>Nhà xuất bản Văn học</td>
						<td>2016</td>
						<td>11111</td>
						<td><a href="#">Link</a></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</div>
<!-- END BODY -->