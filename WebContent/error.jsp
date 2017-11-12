<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERROR</title>
    <link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/w3.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/body.css">
	<link rel="stylesheet" href="css/footer.css">
</head>
<body>
	<div id="page">
		<jsp:include page="/unloggedHeader.jsp"></jsp:include>
		<div id="page-body" class="container">
			<br> <br> <br>
			<div class="body-row">
				<p class="error-notification">
					<html:errors property="error" />
				</p>
			</div>
			<br> <br> <br>
		</div>
		<jsp:include page="/footer.jsp"></jsp:include>
	</div>
</body>
</html>