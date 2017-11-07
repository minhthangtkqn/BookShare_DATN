<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div id="page-body" class="container">
	<div class="body-row">
	
		<div class="books" style="width: 65%; display: inline-block;">
			<h3><b>DANH SÁCH DANH MỤC</b></h3>
			<table id="danh-sach-danh-muc"
				class="table table-striped table-bordered" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th>Tên danh mục</th>
						<th>Số lượng đã bán</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Tên danh mục</th>
						<th>Số lượng đã bán</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
				</tfoot>
				<!-- ++++++++++++++++++  -->
				<tbody>
					<logic:iterate name="danhMucForm" property="dsDanhMuc" id="sp">
						<tr>
							<bean:define id="maDanhMuc" name="sp" property="maDanhMuc"></bean:define>
							<td><bean:write name="sp" property="tenDanhMuc" /></td>
							<td><bean:write name="sp" property="soLuongDaBan" /></td>
							<td><a href="sua-danh-muc.do?maDanhMuc=${maDanhMuc}">Sửa</a></td>
							<td>
								<form id="xoa_danh_muc_${maDanhMuc}" action="xoa-danh-muc.do"
									method="post"
									onsubmit="return confirm('Bạn thực sự muốn xóa danh mục này ?');">
									<input name="maDanhMuc" value="${maDanhMuc}"
										style="display: none;"> 
									<input name="action" value="submit" style="display: none;">
									<a	onclick="if(document.getElementById('xoa_danh_muc_${maDanhMuc}').onsubmit()){document.getElementById('xoa_danh_muc_${maDanhMuc}').submit()};"
										href="javascript:{}">Xóa</a>
								</form>
							</td>
						</tr>
					</logic:iterate>
				</tbody>
			</table>
		</div>
	
		<div style="display: inline-block; margin-left: 30px;">
			<h3 style="text-align: center;">THÊM DANH MỤC MỚI</h3>
			<html:form action="/them-danh-muc.do" method="post">
				<div class="row form-group">
					<label class="col-lg-6">Tên danh mục</label>
					<div class="col-lg-10">
						<html:text property="tenDanhMuc" styleClass="form-control"></html:text>
						<br>
						<p style="color: red;">
							<bean:write name="danhMucForm" property="tenDanhMucError" />
						</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-lg-3 col-lg-offset-2">
						<input type="submit" name="submit" value="THÊM" class="btn btn-primary"></input>
					</div>
				</div>
			</html:form>
		</div>
	</div>
</div>

