<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SELL BOOK</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/user.css">
	<link rel="stylesheet" href="css/product_detail.css">
	<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
</head>
<body>
	<div id="page">
		<jsp:include page="/loggedHeader.jsp"></jsp:include>

		<!-- BODY -->
		<div id="page-body" class="container">

			<div class="body-row">
				<h2 class="col-lg-offset-1">BOOK DETAILS</h2>
				<br>
				<html:form action="/dang-ban.do" method="post"
					enctype="multipart/form-data">
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Book title</label>
						<div class="col-lg-5">
							<html:text property="tenSach" styleClass="form-control" value=""></html:text>
							<html:errors property="tenSachError" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Category</label>
						<div class="col-lg-5">
							<html:select property="maDanhMuc" styleClass="form-control">
								<html:optionsCollection name="dangBanForm" property="dsDanhMuc"
									label="tenDanhMuc" value="maDanhMuc" />
							</html:select>
						</div>
					</div>

					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Author</label>
						<div class="col-lg-5">
							<html:text property="tacGia" styleClass="form-control" value=""></html:text>
							<html:errors property="tacGiaError" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Publish year</label>
						<div class="col-lg-5">
							<html:text property="namxb" styleClass="form-control" value=""></html:text>
							<html:errors property="namxbError" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Publisher</label>
						<div class="col-lg-5">
							<html:text property="nxb" styleClass="form-control" value=""></html:text>
							<html:errors property="nxbError" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Price</label>
						<div class="col-lg-5">
							<html:text property="gia" styleClass="form-control" value=""></html:text>
							<html:errors property="giaError" />
						</div> (VND)
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Region</label>
						<div class="col-lg-5">
							<html:select property="maTinh" styleClass="form-control">
								<html:optionsCollection name="dangBanForm" property="dsTinh"
									label="tenTinh" value="maTinh" />
							</html:select>
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Description</label>
						<div class="col-lg-5">
							<html:text property="moTa" styleClass="form-control" value=""></html:text>
							<html:errors property="moTaError" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Image 1</label>
						<div class="col-lg-5">
							<html:file property="anh1" />
							<html:errors property="linkAnh1Error" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Image 2</label>
						<div class="col-lg-5">
							<html:file property="anh2" />
							<html:errors property="linkAnh2Error" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Image 3</label>
						<div class="col-lg-5">
							<html:file property="anh3" />
							<html:errors property="linkAnh3Error" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Image 4</label>
						<div class="col-lg-5">
							<html:file property="anh4" />
							<html:errors property="linkAnh4Error" />
						</div>
					</div>
					<div class="row form-group">
						<label class="col-lg-offset-1 col-lg-2">Image 5</label>
						<div class="col-lg-5">
							<html:file property="anh5" />
							<html:errors property="linkAnh5Error" />
						</div>
					</div>
					<div class="row form-group">
						<div class="col-lg-offset-3 col-lg-5">
							<html:submit styleClass="btn btn-primary form-control" property="submit"
								value="submit">Submit</html:submit>
<!-- 							<button class="btn btn-primary" type="reset">Cancel</button> -->
						</div>
					</div>
				</html:form>
			</div>

		</div>
		<!-- END BODY -->

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<!-- END SCRIPT -->
		
		
		<script type="text/javascript" src="js/script.js"></script>
	</div>
</body>
</html>