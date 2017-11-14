<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div id="page-body" class="container">
	<div class="body-row">
		<br> <br>
		
		<div class="col-lg-offset-4 col-lg-4">
			<h3><b>EDIT CATEGORY NAME</b></h3>
			<html:form action="/sua-danh-muc.do" method="post">
				<div class="row form-group">
<!-- 					<label class="col-lg-12">Tên danh mục</label> -->
					<div class="col-lg-12">
						<html:text property="tenDanhMuc" styleClass="form-control"><bean:write name="danhMucForm" property="tenDanhMuc"/></html:text>
						<br>
						<p style="color: red;">
							<bean:write name="danhMucForm" property="tenDanhMucError" />
						</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-lg-12">
						<bean:define id="maDanhMuc" name="danhMucForm" property="maDanhMuc"></bean:define>
						<input type="text" name="maDanhMuc" value="${maDanhMuc}" style="display: none;">
						<input type="submit" name="submit" value="Submit" class="btn btn-primary"></input>
					</div>
				</div>
			</html:form>
		</div>
		
		<br> <br> <br> <br><br> <br> <br> <br>
	</div>
</div>