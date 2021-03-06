<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vi">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MANAGING USERS</title>
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
		<jsp:include page="/adminHeader.jsp"></jsp:include>

		<jsp:include page="/danhSachNguoiDungBody.jsp"></jsp:include>

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT TABLE PAGINATION -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="bootstraps/js/dataTables.bootstrap.min.js"></script>

		<script>
			$(document).ready(function() {
				$('#danh-sach-nguoi-dung').DataTable();
			});
		</script>
		<!-- END SCRIPT TABLE PAGINATION -->
		
		<script type="text/javascript" src="js/script.js"></script>
	</div>
</body>
</html>