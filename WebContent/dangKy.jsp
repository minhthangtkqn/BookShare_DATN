<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head lang="vi">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>REGISTER</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/user.css">
</head>
<body>
	<div id="page">
		<!-- 	HEADER -->
		<jsp:include page="unloggedHeader.jsp"></jsp:include>
		<!-- 	END HEADER -->


		<!--    BODY        -->
		<div id="page-body" class="container">
			<h3>CREATE AN ACCOUNT</h3>
			<br>
			<html:form action="/dang-ky" method="post">
				<div class="row form-group">
					<label class="col-lg-2">Username</label>
					<div class="col-lg-3">
						<html:text property="taiKhoan" styleClass="form-control"></html:text>
						<p style="color: red;">
							<bean:write name="dangKyForm" property="loiTaiKhoan" />
						</p>
					</div>
				</div>

				<div class="row form-group">
					<label class="col-lg-2">Password</label>
					<div class="col-lg-3">
						<html:password property="matKhau" styleClass="form-control"></html:password>
						<p style="color: red;">
							<bean:write name="dangKyForm" property="loiMatKhau" />
						</p>
					</div>
				</div>

				<div class="row form-group">
					<label class="col-lg-2">Confirm Password</label>
					<div class="col-lg-3">
						<html:password property="nhapLaiMatKhau" styleClass="form-control"></html:password>
						<p style="color: red;">
							<bean:write name="dangKyForm" property="loiNhapLaiMatKhau" />
						</p>
					</div>
				</div>

				<div class="row form-group">
					<div class="col-lg-3 col-lg-offset-2">
						<p style="color: red;">
							<bean:write name="dangKyForm" property="loiDangKy" />
						</p>
					</div>
				</div>

				<div class="row form-group">
					<div class="col-lg-3 col-lg-offset-2">
						<html:submit styleClass="btn btn-primary">Create</html:submit>
						<button class="btn btn-primary" type="reset">Cancel</button>
					</div>
				</div>
			</html:form>
		</div>
		<!--    END BODY 	-->


		<!--    FOOTER 		-->
		<jsp:include page="footer.jsp"></jsp:include>
		<!--    END FOOTER        -->

		<!-- SCRIPT -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<!-- END SCRIPT -->
		
		
		<script type="text/javascript" src="js/script.js"></script>
	</div>
</body>
</html>