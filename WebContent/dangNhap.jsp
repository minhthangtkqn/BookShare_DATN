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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BOOKSHARE</title>
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
		<!--    HEADER       -->
		<jsp:include page="/unloggedHeader.jsp"></jsp:include>
		<!--    END HEADER   -->

		<!-- 	BODY -->
		<div id="page-body" class="container">
			<br> <br> <br> <br>

			<div class="body-row">
				<html:form action="/dang-nhap" method="post"
					styleClass="form-horizontal">
					<div class="form-group">
						<label for="" class="col-lg-offset-2 col-lg-2 control-label">Tên tài khoản</label>
						<div class="col-lg-4">
							<html:text property="taiKhoan" styleClass="form-control"></html:text>
							<p style="color: red;">
								<bean:write name="dangNhapForm" property="loiTaiKhoan" />
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-lg-offset-2 col-lg-2 control-label">Mật khẩu</label>
						<div class="col-lg-4">
							<html:password property="matKhau" styleClass="form-control"></html:password>
							<p style="color: red;">
								<bean:write name="dangNhapForm" property="loiMatKhau" />
							</p>
						</div>
					</div>

<!-- 					<div class="form-group"> -->
<!-- 						<div class="col-lg-offset-4 col-lg-5"> -->
<!-- 							<div class="checkbox"> -->
<!-- 								<label> <input type="checkbox"> Remember me -->
<!-- 								</label> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="form-group">
						<div class="col-lg-offset-4 col-lg-5">
							<button type="submit" class="btn btn-primary">Log in</button>
						</div>
					</div>
				</html:form>
			</div>

			<br> <br> <br> <br>
		</div>
		<!-- 	END BODY -->

		<!--    FOOTER      -->
		<jsp:include page="/footer.jsp"></jsp:include>
		<!--    END FOOTER  -->
		
		<script type="text/javascript" src="js/script.js"></script>
	</div>
</body>
</html>