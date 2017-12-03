<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vi">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>TÌM KIẾM</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstraps/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/timKiem.css">
	<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
	<link rel="stylesheet" href="css/autoComplete.css">
</head>

<body>
	<div id="page">
		<jsp:include page="/searchLoggedHeader.jsp"></jsp:include>

		<jsp:include page="/ketQuaTimKiemBody.jsp"></jsp:include>

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT OWL SLIDER -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="owlcarousel/owl.carousel.min.js"></script>
		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
		
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="bootstraps/js/dataTables.bootstrap.min.js"></script>

		<script>
			$(document).ready(function() {
				$('#danh-sach-yeu-cau').DataTable();
			});
		</script>

		<script>
			$('.owl-carousel').owlCarousel({
				rtl : false,
				loop : true,
				margin : 10,
				nav : false,
				responsive : {
					0 : {
						items : 1
					},
					600 : {
						items : 2
					},
					1000 : {
						items : 4
					}
				}
			})
		</script>
		<!-- END SCRIPT OWL SLIDER -->

		<script>
			function recommend() {
				$("#tuKhoa").autocomplete("List.jsp");
			}
		</script>
	</div>
</body>

</html>
