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
<title>REQUEST BOOK</title>
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
				<html:form action="/them-yeu-cau.do" method="post">
					<div class="row form-group">
						<div class="col-lg-offset-4 col-lg-4">
							<h3 style="font-weight: bold;">BOOK REQUEST</h3>
						</div>
					</div>

					<div class="row form-group">
						<div class=" col-lg-offset-4 col-lg-4">
							<html:text property="tenSach" styleClass="form-control" value=""></html:text>
							<html:errors property="tenSachError" />
						</div>
					</div>

					<div class="row form-group">
						<div class="col-lg-offset-4 col-lg-4">
							<html:submit styleClass="btn btn-primary form-control"
								property="submit" value="submit">Submit</html:submit>
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
	</div>
</body>
</html>