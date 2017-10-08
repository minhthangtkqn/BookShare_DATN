<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<div id="page-body" class="newContainer">
        <div class="body-row">
            <div class="row-item user-info">
            	<bean:define id="nguoiDung" name="trangNguoiDungForm" property="nguoiDung"></bean:define>
                <p>
                    Tên: <bean:write name="nguoiDung" property="hoTen" />
                </p>
                <p>
                    Địa chỉ:    <bean:write name="nguoiDung" property="tenTinh" />
                </p>
                <p>
                    Tài khoản:  <bean:write name="nguoiDung" property="taiKhoan" />
                </p>
                <p>
                    Năm sinh:   <bean:write name="nguoiDung" property="namSinh" />
                </p>
                <p>
                    Email:      <bean:write name="nguoiDung" property="email" />
                </p>
                <p>
                    Điện thoại: <bean:write name="nguoiDung" property="dienThoai" />
                </p>
                <a href="sua-nguoi-dung.do">Sửa thông tin của bạn >>></a>
            </div>

            <div class="row-item user-img">
            	<bean:define id="anh" name="nguoiDung" property="anh"></bean:define>
                <img src="${anh}" alt="" style="height: 100%; width: 100%" />
            </div>
        </div>

        <div class="body-row">
            <div class="user-function row-item">
                DS CHỜ DUYỆT
            </div>

            <div class="user-function row-item">
                DS ĐANG BÁN
            </div>

            <div class="user-function row-item">
                DS MUA SAU
            </div>

            <div class="user-function row-item">
                DS ĐÃ BÁN
            </div>
        </div>
        
        <div class="body-row">
            <div class="books">
                <h3>
                    <b>ĐANG CHỜ DUYỆT</b>
                </h3>
                <table border="1" class="books-table">
                    <thead>
                        <td>Tên sách</td>
                        <td>Danh mục</td>
                        <td>Giá bán</td>
                        <td>Ngày bán</td>
                        <td>Nhà xuất bản</td>
                        <td>Năm xuất bản</td>
                    </thead>
                    <!-- ++++++++++++++++++  -->
                    <logic:iterate name="trangNguoiDungForm" property="dsChoDuyet" id="sp">
	                    <tr>
	                        <td><bean:write name="sp" property="tenSach" /></td>
	                        <td><bean:write name="sp" property="tenDanhMuc" /></td>
	                        <td><bean:write name="sp" property="gia" /></td>
	                        <td><bean:write name="sp" property="ngayBan" /></td>
	                        <td><bean:write name="sp" property="nxb" /></td>
	                        <td><bean:write name="sp" property="namxb" /></td>
	                        
	                    </tr>
                    </logic:iterate>
                </table>
                
            </div>
        </div>

    </div>