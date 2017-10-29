<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div class="container">
		<h3>Sửa tin bán sách</h3>
		<br>
		<html:form action="/sua-bai-dang.do" method="post" enctype="multipart/form-data">
			<div class="row form-group">
				<label class="col-lg-2">Tên sách</label>
				<div class="col-lg-3">
					<html:text property="tenSach" styleClass="form-control"></html:text>
					<html:errors property="tenSachError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Danh mục sách</label>
				<div class="col-lg-3">
                	<html:select property="maDanhMuc" styleClass="form-control">
					<html:optionsCollection name="dangBanForm" property="dsDanhMuc" 
						label="tenDanhMuc" value="maDanhMuc" />
					</html:select>
            	</div>
			</div>
		
			<div class="row form-group">
				<label class="col-lg-2">Tác giả</label>
				<div class="col-lg-3">
					<html:text property="tacGia" styleClass="form-control" ></html:text>
					<html:errors property="tacGiaError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Năm xuất bản</label>
				<div class="col-lg-3">
					<html:text property="namxb" styleClass="form-control" ></html:text>
					<html:errors property="namxbError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Nhà xuất bản</label>
				<div class="col-lg-3">
					<html:text property="nxb" styleClass="form-control" ></html:text>
					<html:errors property="nxbError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Giá</label>
				<div class="col-lg-3">
					<html:text property="gia" styleClass="form-control" ></html:text>
					<html:errors property="giaError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Địa chỉ</label>
				<div class="col-lg-3">
					<html:select property="maTinh" styleClass="form-control">
					<html:optionsCollection name="dangBanForm" property="dsTinh" 
						label="tenTinh" value="maTinh" />
								</html:select>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mô tả</label>
				<div class="col-lg-3">
					<html:text property="moTa" styleClass="form-control"></html:text>
					<html:errors property="moTaError"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ảnh 1</label>
				<div>
					<p>Bản cũ</p>
					<bean:define id="linkAnh1" name="dangBanForm" property="linkAnh1"></bean:define>
					<img src="${linkAnh1}" style="width: 130px; height: 200px;">
					<input name="linkAnh1" value="${linkAnh1}" style="display: none;">
				</div>
				<div class="col-lg-3">
					<html:file property="anh1" />
					<html:errors property="linkAnh1Error"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ảnh 2</label>
				<div>
					<p>Bản cũ</p>
					<bean:define id="linkAnh2" name="dangBanForm" property="linkAnh2"></bean:define>
					<img src="${linkAnh2}" style="width: 130px; height: 200px;">
					<input name="linkAnh2" value="${linkAnh2}" style="display: none;">
				</div>
				<div class="col-lg-3">
					<html:file property="anh2" />
					<html:errors property="linkAnh2Error"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ảnh 3</label>
				<div>
					<p>Bản cũ</p>
					<bean:define id="linkAnh3" name="dangBanForm" property="linkAnh3"></bean:define>
					<img src="${linkAnh3}" style="width: 130px; height: 200px;">
					<input name="linkAnh3" value="${linkAnh3}" style="display: none;">
				</div>
				<div class="col-lg-3">
					<html:file property="anh3" />
					<html:errors property="linkAnh3Error"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ảnh 4</label>
				<div>
					<p>Bản cũ</p>
					<bean:define id="linkAnh4" name="dangBanForm" property="linkAnh4"></bean:define>
					<img src="${linkAnh4}" style="width: 130px; height: 200px;">
					<input name="linkAnh4" value="${linkAnh4}" style="display: none;">
				</div>
				<div class="col-lg-3">
					<html:file property="anh4" />
					<html:errors property="linkAnh4Error"/>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Ảnh 5</label>
				<div>
					<p>Bản cũ</p>
					<bean:define id="linkAnh5" name="dangBanForm" property="linkAnh5"></bean:define>
					<img src="${linkAnh5}" style="width: 130px; height: 200px;">
					<input name="linkAnh5" value="${linkAnh5}" style="display: none;">
				</div>
				<div class="col-lg-3">
					<html:file property="anh5" />
					<html:errors property="linkAnh5Error"/>
				</div>
			</div>
			<bean:define id="maRaoBan" name="dangBanForm" property="maRaoBan"></bean:define>
			<input name="maRaoBan" value="${maRaoBan}" style="display: none;">
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
            	<html:submit styleClass="btn btn-primary" property="submit" value="submit">Sửa bài đăng</html:submit>
					<button class="btn btn-primary" type="reset">Reset</button>
				</div>
			</div>
		</html:form>
	</div>