<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NOTE</title>
    <link rel="stylesheet" href="bootstraps/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstraps/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/body.css">
    <link rel="stylesheet" href="css/footer.css">
</head>
<body>
    <div id="page">
	    <jsp:include page="loggedHeader.jsp"></jsp:include>
	    
	    <!--    BODY        -->
		<h2 style="margin-left: 10%;"></>Xin chào ${userName} tài khoản của bạn đã bị khóa vì lí do:<h2>
		<p style="color:red; margin-left: 10%;">   ${reason}</p>
		<a style="margin-left: 10%;" href="trang-chu.do">Bấm vào đây để trở về trang chủ</a>
	 	<!--    END BODY        -->
	    
	    <jsp:include page="footer.jsp"></jsp:include>
	    
	<!--        FOOTER      -->
	<!--     <footer id="footer"> -->
	
	<!--         <div class="footer-widget"> -->
	<!--             <div class="container"> -->
	<!--                 <div class="row"> -->
	<!--                     <div class="col-sm-2"> -->
	<!--                         <div class="single-widget"> -->
	<!--                             <h2>Service</h2> -->
	<!--                             <ul class="nav nav-pills nav-stacked"> -->
	<!--                                 <li><a href="#">Online Help</a></li> -->
	<!--                                 <li><a href="#">Contact Us</a></li> -->
	<!--                                 <li><a href="#">Order Status</a></li> -->
	<!--                                 <li><a href="#">Change Location</a></li> -->
	<!--                                 <li><a href="#">FAQ’s</a></li> -->
	<!--                             </ul> -->
	<!--                         </div> -->
	<!--                     </div> -->
	<!--                     <div class="col-sm-2"> -->
	<!--                         <div class="single-widget"> -->
	<!--                             <h2>Quock Shop</h2> -->
	<!--                             <ul class="nav nav-pills nav-stacked"> -->
	<!--                                 <li><a href="#">T-Shirt</a></li> -->
	<!--                                 <li><a href="#">Mens</a></li> -->
	<!--                                 <li><a href="#">Womens</a></li> -->
	<!--                                 <li><a href="#">Gift Cards</a></li> -->
	<!--                                 <li><a href="#">Shoes</a></li> -->
	<!--                             </ul> -->
	<!--                         </div> -->
	<!--                     </div> -->
	<!--                     <div class="col-sm-2"> -->
	<!--                         <div class="single-widget"> -->
	<!--                             <h2>Policies</h2> -->
	<!--                             <ul class="nav nav-pills nav-stacked"> -->
	<!--                                 <li><a href="#">Terms of Use</a></li> -->
	<!--                                 <li><a href="#">Privecy Policy</a></li> -->
	<!--                                 <li><a href="#">Refund Policy</a></li> -->
	<!--                                 <li><a href="#">Billing System</a></li> -->
	<!--                                 <li><a href="#">Ticket System</a></li> -->
	<!--                             </ul> -->
	<!--                         </div> -->
	<!--                     </div> -->
	<!--                     <div class="col-sm-2"> -->
	<!--                         <div class="single-widget"> -->
	<!--                             <h2>About Shopper</h2> -->
	<!--                             <ul class="nav nav-pills nav-stacked"> -->
	<!--                                 <li><a href="#">Company Information</a></li> -->
	<!--                                 <li><a href="#">Careers</a></li> -->
	<!--                                 <li><a href="#">Store Location</a></li> -->
	<!--                                 <li><a href="#">Affillate Program</a></li> -->
	<!--                                 <li><a href="#">Copyright</a></li> -->
	<!--                             </ul> -->
	<!--                         </div> -->
	<!--                     </div> -->
	<!--                     <div class="col-sm-3 col-sm-offset-1"> -->
	<!--                         <div class="single-widget"> -->
	<!--                             <h2>About Shopper</h2> -->
	<!--                             <form action="#" class="searchform"> -->
	<!--                                 <input type="text" placeholder="Your email address" /> -->
	<!--                                 <button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button> -->
	<!--                                 <p>Get the most recent updates from <br />our site and be updated your self...</p> -->
	<!--                             </form> -->
	<!--                         </div> -->
	<!--                     </div> -->
	
	<!--                 </div> -->
	<!--             </div> -->
	<!--         </div> -->
	
	<!--         <div class="footer-bottom"> -->
	<!--             <div class="container"> -->
	<!--                 <div class="row"> -->
	<!--                     <p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p> -->
	<!--                     <p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p> -->
	<!--                 </div> -->
	<!--             </div> -->
	<!--         </div> -->
	
	<!--     </footer> -->
	<!--        END FOOTER  -->
	
		<script src="js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
    </div>
</body>
</html>