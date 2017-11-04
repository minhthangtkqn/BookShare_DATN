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
	<title>TIM KIEM</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
</head>

<%-- <bean:define id="pageNumber" name="ketQuaTimKiemForm" property="page"></bean:define> --%>
<%-- <bean:define id="soLuongKetQua" name="ketQuaTimKiemForm" property="soLuongKetQua"></bean:define> --%>
<%-- <body onload="createPaginationPanel(${pageNumber}, ${soLuongKetQua})"> --%>

<body>
	<div id="page">
		<jsp:include page="/loggedHeader.jsp"></jsp:include>

		<jsp:include page="/ketQuaTimKiemBody.jsp"></jsp:include>

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT OWL SLIDER -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="owlcarousel/owl.carousel.min.js"></script>
		<script type="text/javascript" src="js/jquery.autocomplete.js"></script>

		<!-- SCRIPT AUTO COMPLETE -->
		<script>
			// 		jQuery(function() {
			// 			$("#tuKhoa").autocomplete("List.jsp");
			// 		});
		</script>
		<!-- END SCRIPT AUTO COMPLETE -->

		<script>
			$('.owl-carousel').owlCarousel({
				rtl : false,
				loop : true,
				margin : 10,
				nav : true,
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
	</div>
</body>

</html>
