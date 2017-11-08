<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PROFILE</title>
    <link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstraps/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/body.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/user.css">
</head>
<body>
	<div id="page">
		<jsp:include page="/loggedHeader.jsp"></jsp:include>

		<jsp:include page="/userBody.jsp"></jsp:include>

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT TABLE PAGINATION -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="bootstraps/js/dataTables.bootstrap.min.js"></script>

		<script>
			$(document).ready(function() {
				$('#danh-sach-cho-duyet').DataTable();
			});
			$(document).ready(function() {
				$('#danh-sach-dang-ban').DataTable();
			});
			$(document).ready(function() {
				$('#danh-sach-da-ban').DataTable();
			});
		</script>
		<!-- END SCRIPT TABLE PAGINATION -->
	</div>
</body>
</html>