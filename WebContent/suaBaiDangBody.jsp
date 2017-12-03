<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!-- BODY -->
<div id="page-body" class="container">
	<div class="body-row">
		<h2 style="text-align: center;">SỬA THÔNG TIN BÀI ĐĂNG</h2>
	</div>
	
	<br>
	
	<div class="body-row">
		<html:form action="/sua-bai-dang.do" method="post"
			enctype="multipart/form-data">
			<div class="row">
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Tên sách</label>
					<div class="col-lg-7">
						<html:text property="tenSach" styleClass="form-control"></html:text>
						<html:errors property="tenSachError" />
					</div>
				</div>
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Danh mục</label>
					<div class="col-lg-7">
						<html:select property="maDanhMuc" styleClass="form-control">
							<html:optionsCollection name="dangBanForm" property="dsDanhMuc"
								label="tenDanhMuc" value="maDanhMuc" />
						</html:select>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Tác giả</label>
					<div class="col-lg-7">
						<html:text property="tacGia" styleClass="form-control"></html:text>
						<html:errors property="tacGiaError" />
					</div>
				</div>
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Năm xuất bản</label>
					<div class="col-lg-7">
						<html:text property="namxb" styleClass="form-control"></html:text>
						<html:errors property="namxbError" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Nhà xuất bản</label>
					<div class="col-lg-7">
						<html:text property="nxb" styleClass="form-control"></html:text>
						<html:errors property="nxbError" />
					</div>
				</div>
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Giá</label>
					<div class="col-lg-7">
						<html:text property="gia" styleClass="form-control"></html:text>
						<html:errors property="giaError" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Khu vực</label>
					<div class="col-lg-7">
						<html:select property="maTinh" styleClass="form-control">
							<html:optionsCollection name="dangBanForm" property="dsTinh"
								label="tenTinh" value="maTinh" />
						</html:select>
					</div>
				</div>
				<div class="col-xs-6 form-group">
					<label class="col-lg-4">Mô tả</label>
					<div class="col-lg-7">
						<html:text property="moTa" styleClass="form-control"></html:text>
						<html:errors property="moTaError" />
					</div>
				</div>
			</div>

			<!-- ++++++++++++++++++++++ -->
			<!-- ++++++++++++++++++++++ -->
			<!-- ++++++++++++++++++++++ -->
			<br>

			<bean:define id="linkAnh1" name="dangBanForm" property="linkAnh1"></bean:define>
			<bean:define id="linkAnh2" name="dangBanForm" property="linkAnh2"></bean:define>
			<bean:define id="linkAnh3" name="dangBanForm" property="linkAnh3"></bean:define>
			<bean:define id="linkAnh4" name="dangBanForm" property="linkAnh4"></bean:define>
			<bean:define id="linkAnh5" name="dangBanForm" property="linkAnh5"></bean:define>

			<div class="row">
				<div class="col-xs-3 form-group">
					<label class="col-lg-offset-4 col-lg-6">Ảnh 1</label>
					<div class="col-lg-12 old-img">
						<img src="${linkAnh1}" style="width: 100%; height: 100%;">
						<input name="linkAnh1" value="${linkAnh1}" style="display: none;">
					</div>
					<div class="col-lg-12">
						<html:file style="width: 100%;" property="anh1" />
						<html:errors property="linkAnh1Error" />
					</div>
				</div>
				
				<div class="col-xs-offset-1 col-xs-3 form-group">
					<label class="col-lg-offset-4 col-lg-6">Ảnh 2</label>
					<div class="col-lg-12 old-img">
						<img src="${linkAnh2}" style="width: 100%; height: 100%;">
						<input name="linkAnh2" value="${linkAnh2}" style="display: none;">
					</div>
					<div class="col-lg-12">
						<html:file style="width: 100%;" property="anh2" />
						<html:errors property="linkAnh2Error" />
					</div>
				</div>
				
				<div class="col-xs-offset-1 col-xs-3 form-group">
					<label class="col-lg-offset-4 col-lg-6">Ảnh 3</label>
					<div class="col-lg-12 old-img">
						<img src="${linkAnh3}" style="width: 100%; height: 100%;">
						<input name="linkAnh3" value="${linkAnh3}" style="display: none;">
					</div>
					<div class="col-lg-12">
						<html:file style="width: 100%;" property="anh3"/>
						<html:errors property="linkAnh3Error" />
					</div>
				</div>
			</div>
			
			<br>
			
			<div class="row">
				<div class="col-xs-offset-2 col-xs-3 form-group">
					<label class="col-lg-offset-4 col-lg-6">Ảnh 4</label>
					<div class="col-lg-12 old-img">
						<img src="${linkAnh4}" style="width: 100%; height: 100%;"> <input
							name="linkAnh4" value="${linkAnh4}" style="display: none;">
					</div>
					<div class="col-lg-12">
						<html:file style="width: 100%;" property="anh4" />
						<html:errors property="linkAnh4Error" />
					</div>
				</div>
				
				<div class="col-xs-offset-2 col-xs-3 form-group">
					<label class="col-lg-offset-4 col-lg-6">Ảnh 5</label>
					<div class="col-lg-12 old-img">
						<img src="${linkAnh5}" style="width: 100%; height: 100%;"> <input
							name="linkAnh5" value="${linkAnh5}" style="display: none;">
					</div>
					<div class="col-lg-12">
						<html:file style="width: 100%;" property="anh5" />
						<html:errors property="linkAnh5Error" />
					</div>
				</div>
			</div>

			
			
			<bean:define id="maRaoBan" name="dangBanForm" property="maRaoBan"></bean:define>
			
			<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
			<div class="row">
				<div class="col-lg-offset-5 col-lg-4 form-group">
					<html:submit styleClass="btn btn-primary" property="submit"
						value="submit">Save</html:submit>
					<button class="btn btn-primary" type="reset">Khôi phục thông tin</button>
				</div>
			</div>
		</html:form>

	</div>
</div>
<!-- END BODY -->
