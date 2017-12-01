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
	<title>BROWSING HISTORY</title>
	<link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="bootstraps/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="wm-zoom/jquery.wm-zoom-1.0.min.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
	<link rel="stylesheet" href="css/user.css">
	<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
</head>
<body>
	<div id="page">
		<!--    HEADER       -->
		<jsp:include page="/loggedHeader.jsp"></jsp:include>
		<!--    END HEADER   -->

		<!-- 	BODY -->
		<div id="page-body" class="container">
			<div class="body-row">
				<div class="books">
					<h3>
						<b>BROWSING HISTORY</b>
					</h3>
					<table id="cac-bai-dang-da-xem"
						class="table table-striped table-bordered" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th>Image</th>
								<th>Book title</th>
								<th>Author</th>
								<th>Publisher</th>
								<th>Publish year</th>
								<th>Category</th>
								<th>Region</th>
								<th>Price</th>
								<th>Posted date</th>
								<th>Details</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Image</th>
								<th>Book title</th>
								<th>Author</th>
								<th>Publisher</th>
								<th>Publish year</th>
								<th>Category</th>
								<th>Region</th>
								<th>Price</th>
								<th>Posted date</th>
								<th>Details</th>
							</tr>
						</tfoot>
						<!-- ++++++++++++++++++  -->
						<tbody>
							<logic:iterate name="lichSuXemBaiDangForm"
								property="listBaiDangDaXem" id="sp">
								<tr>
									<bean:define id="anh" name="sp" property="linkAnh1"></bean:define>
									<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>

									<td>
										<div class="wm-zoom-container my-zoom">
											<div class="wm-zoom-box">
												<img class="wm-zoom-default-img" src="${anh}"
													data-hight-src="${anh}" 
													data-loader-src="images/loader.gif"
													style="width: 100px; height: 130px;">
											</div>
										</div>
									</td>

									<td><bean:write name="sp" property="tenSach" /></td>
									<td><bean:write name="sp" property="tacGia" /></td>
									<td><bean:write name="sp" property="nxb" /></td>
									<td><bean:write name="sp" property="namxb" /></td>
									<td><bean:write name="sp" property="tenDanhMuc" /></td>
									<td><bean:write name="sp" property="tenTinhBan"></bean:write></td>
									<td><bean:write name="sp" property="gia"></bean:write></td>
									<td><bean:write name="sp" property="ngayBan"></bean:write></td>
									
									<td>
										<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}">
											<i class="glyphicon glyphicon-folder-open font-size-20"></i>
										</a>
									</td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>

				</div>
			</div>

			<br><br>

			<div class="body-row">
		
				<div class="books">
					<h3 style="color: red;">
						<b>FEATURED POSTS FROM LAST MONTH SO FAR</b>
					</h3>

					<div class="owl-carousel owl-theme">

						<logic:iterate id="book" property="dsHot" name="lichSuXemBaiDangForm">
							<div class="sp">
								<bean:define id="anh" name="book" property="linkAnh1"></bean:define>
								<bean:define id="maRaoBan" name="book" property="maRaoBan"></bean:define>

								<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"> <img
									src="${anh}" class="w3-hover-opacity">
								</a>
								<h4 class="ten-sach">
									<b><bean:write name="book" property="tenSach" /></b>
								</h4>
								<p class="tac-gia">
									<bean:write name="book" property="tacGia" />
								</p>
								<h4 class="gia-tien">
									<b><bean:write name="book" property="gia" /></b>
								</h4>
							</div>
						</logic:iterate>

					</div>
				</div>
			</div>
		</div>
		<!-- 	END BODY -->

		<!--    FOOTER      -->
		<jsp:include page="/footer.jsp"></jsp:include>
		<!--    END FOOTER  -->

		<!-- SCRIPT -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
		<!-- SCRIPT -->

		<!-- SCRIPT TABLE PAGINATION -->
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="bootstraps/js/dataTables.bootstrap.min.js"></script>

		<script>
			$(document).ready(function() {
				$('#cac-bai-dang-da-xem').DataTable();
			});
		</script>
		<!-- END SCRIPT TABLE PAGINATION -->
		
		<!-- SCRIPT IMAGE ZOOM -->
		<script src="wm-zoom/jquery.wm-zoom-1.0.min.js"></script>

		<script type="text/javascript">
			/* $('.my-zoom').WMZoom({
				config : {

					// stage size
					stageW : 100,
					stageH : 140,

					// set to true to enable the inner zoom mode
					inner : false,

					// [top, right, bottom, left]
					position : 'right',

					// margin
					margin : 10
				}
			}); */
		</script>
		<!-- END SCRIPT IMAGE ZOOM -->

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