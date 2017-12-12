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
	<title>THÔNG BÁO</title>
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
		<% if((Integer)session.getAttribute("type") == 0){ %>
		<jsp:include page="/adminHeader.jsp"></jsp:include>
		<% }else{ %>
		<% if((Integer)session.getAttribute("type") == 1 || (Integer)session.getAttribute("type") == 2){ %>
		<jsp:include page="/loggedHeader.jsp"></jsp:include>
		<% }} %>
		<!--    END HEADER   -->

		<!-- 	BODY -->
		<div id="page-body" class="container">
			<div class="body-row">
				<div class="books">
					<h3>
						<b>THÔNG BÁO CỦA BẠN</b>
					</h3>
					<logic:notEmpty name="thongBaoForm" property="listThongBao">
						<table id="thong-bao-cua-ban"
							class="table table-striped table-bordered" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th></th>
									<th>Thời gian</th>
								</tr>
							</thead>
	
							<tfoot>
								<tr>
									<th></th>
									<th>Thời gian</th>
								</tr>
							</tfoot>
							<!-- ++++++++++++++++++  -->
							<tbody>
								<logic:iterate name="thongBaoForm"
									property="listThongBao" id="sp">
									<tr>
										<td><bean:write name="sp" property="noiDung" /></td>
										<td><bean:write name="sp" property="thoiGian" /></td>
										
									</tr>
								</logic:iterate>
							</tbody>
						</table>
					</logic:notEmpty>

					<logic:empty name="thongBaoForm" property="listThongBao">
						<p class="empty-message">
							<br>
							Hiện tại không có thông báo nào cả
						</p>
					</logic:empty>
				</div>
			</div>

			<br>
			
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
				$('#thong-bao-cua-ban').DataTable();
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

	</div>
</body>
</html>