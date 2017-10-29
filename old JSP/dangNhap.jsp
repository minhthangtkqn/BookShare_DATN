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
	<title>ĐĂNG NHẬP</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/price-range.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<link rel="shortcut icon" href="images/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144"
		href="images/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114"
		href="images/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72"
		href="images/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed"
		href="images/ico/apple-touch-icon-57-precomposed.png">

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
<!-- 	<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script> -->
	<script src="js/jquery.autocomplete.js"></script>
	
	<script>
		jQuery(function() {
			$("#bookname11").autocomplete("List.jsp")
		})
	</script>
</head>
<body>

	<!--    HEADER       -->
	<jsp:include page="/indexHeader.jsp"></jsp:include>
	<!--    END HEADER   -->

	<!-- 	BODY -->
	<div class="container">
		<h3>Đăng nhập hệ thống</h3>
		<br>
		<html:form action="/dang-nhap" method="post">
			<div class="row form-group">
				<label class="col-lg-2">Tên đăng nhập</label>
				<div class="col-lg-3">
					<html:text property="taiKhoan" styleClass="form-control"
						></html:text><br>
					<p style="color: red;"><bean:write name="dangNhapForm" property="loiTaiKhoan"/></p><br>
				</div>
			</div>
			<div class="row form-group">
				<label class="col-lg-2">Mật khẩu</label>
				<div class="col-lg-3">
					<html:password property="matKhau" styleClass="form-control"
						></html:password><br>
						<p style="color: red;"><bean:write name="dangNhapForm" property="loiMatKhau"/></p><br>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<p style="color: red;">
					</p>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-lg-3 col-lg-offset-2">
					<html:submit styleClass="btn btn-primary">Đăng nhập</html:submit>
					<button class="btn btn-primary" type="reset">Hủy</button>
				</div>
			</div>
		</html:form>
	</div>
	<!-- 	END BODY -->
	
	<!--    FOOTER      -->
	<jsp:include page="/footer.jsp"></jsp:include>
	<!--    END FOOTER  -->
</body>
</html>