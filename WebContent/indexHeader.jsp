<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

    
 <!--   HEADER       -->
 	<script>
 	jQuery(function(){
	$("#tuKhoa").autocomplete("List.jsp")
	})
	</script>
    <header id="header">

        <div class="header_top">
            <!--header_top-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="contactinfo">
                            <ul class="nav nav-pills">
                                <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                                <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="social-icons pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/header_top-->

        <div id="header_fixed" class="header-middle">
            <!--header-middle-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="logo pull-left">
                            <a href="trang-chu.do"><img src="images/home/logobook.png" alt="" style="height: 100%; width: 100%" /></a>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="search_area">
                            <div class="form-group">
<!--                                 <select> -->
<!-- 									  <option value="tacgia">Tác giả</option> -->
<!-- 									  <option value="tensach">Tên sách</option> -->
<!-- 									  <option value="gia">Giá</option> -->
<!-- 									</select> -->
                                <form action="ket-qua-tim-kiem.do" method="post">
                                	<input style="display: none;" name="page" value="1">
                                	
	                                <input id="tuKhoa"  type="text" name="tuKhoa" value="" placeholder="Từ khóa tìm kiếm... " style="width: 92%" class="input_text">
    	                            <button type="submit" id="search-link"><i class="glyphicon glyphicon-search"></i></button>
                                
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-3" style="margin-top: 15px;">
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">
                                <li><a href="reg.jsp"><i class="fa fa-user"></i> Đăng ký</a></li>
                                <li><a href="log.jsp"><i class="fa fa-lock"></i> Đăng nhập</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/header-middle-->



        <div class="header-bottom">
            <!--header-bottom-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
                        </div>
                        <div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="trang-chu.do" class=""><b>Trang Chủ</b></a></li>
<!-- 								<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a> -->
								<li class=""><a href="#">Danh Mục Sách</a>
<!--                                     <ul role="menu" class="sub-menu"> -->
<!--                                         <li><a href="blog.html">Blog List</a></li> -->
<!-- 										<li><a href="blog-single.html">Blog Single</a></li> -->
<!--                                     </ul> -->
                                </li> 
                                
								<li><a href="ngau-nhien.do">Ngẫu Nhiên</a></li>
								<li><a href="moi-nhat.do.do">Mới Nhất</a></li>
								<li><a href="yeu-cau.do">Yêu Cầu</a></li>
								<li><a href="dang-ban.do">Bán Sách</a></li>								
								<li><a href="#">Liên Hệ</a></li>
							</ul>
						</div>
                    </div>
                </div>
            </div>
        </div>
        <!--/header-bottom-->
    </header>
    <!--   END HEADER   -->