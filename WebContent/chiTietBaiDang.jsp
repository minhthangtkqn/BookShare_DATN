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
	<title>CHI TIẾT BÀI ĐĂNG</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="kartik-star-rating/css/star-rating.css">
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
		<jsp:include page="/unloggedHeader.jsp"></jsp:include>

		<jsp:include page="/chiTietBaiDangBody.jsp"></jsp:include>

		<jsp:include page="/footer.jsp"></jsp:include>

		<!-- SCRIPT -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script>
			var slideIndex = 1;
			showDivs(slideIndex);

			function plusDivs(n) {
				showDivs(slideIndex += n);
			}

			function currentDiv(n) {
				showDivs(slideIndex = n);
			}

			function showDivs(n) {
				var i;
				var x = document.getElementsByClassName("mySlides");
				var dots = document.getElementsByClassName("tiny-img");
				if (n > x.length) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = x.length
				}
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				for (i = 0; i < dots.length; i++) {
					dots[i].className = dots[i].className.replace(
							" w3-opacity-off", "");
				}
				x[slideIndex - 1].style.display = "block";
				dots[slideIndex - 1].className += " w3-opacity-off";
			}
		</script>
		<!-- END SCRIPT -->

		<!-- SCRIPT OWL SLIDER -->
		<script src="owlcarousel/owl.carousel.min.js"></script>
		
		<script>
			$(document).ready(function() {
				$(".owl-carousel").owlCarousel();
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

		<script src="js/script.js"></script>
		<script>
			setHeight();
		</script>

		<!-- STAR RATING SCRIPT -->
		<script src="kartik-star-rating/js/star-rating.js"></script>
		<script>
			$(".rating-seller").rating({
				showCaption : true,
				showClear : false,
				stars : 5,
				size : 'md',
				displayOnly : true,
				min : 0,
				max : 5,
				step : 1
			});
		</script>
		<!-- END STAR RATING SCRIPT -->

	</div>
</body>
</html>