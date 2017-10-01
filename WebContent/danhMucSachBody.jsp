<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
<div id="slider-content">
	<div class="body-row">
		<div class="row-item">
			<html:form action="/danh-muc.do" method="post">
				<html:select property="maDanhMuc" styleClass="form-control" onchange="this.form.submit()">
					<html:optionsCollection name="danhMucForm" property="dsDanhMuc"
						label="tenDanhMuc" value="maDanhMuc" />
				</html:select>
			</html:form>
		</div>
		<div class="row-item">
			<p style="font-size: 18px;">20 trong tong so 1234 ket qua</p>
		</div>
	</div>
	<div class="body-row">
		<div class="book-new">
			<h3>
				<b>KẾT QUẢ TÌM KIẾM</b>
			</h3>

			<div class="box">
				<!-- sp -->
				<logic:iterate name="danhMucForm" property="dsRaoBanTrongDanhMuc"
					id="sp">
					<div class="sp">
						<bean:define id="linkAnh" name="sp" property="linkAnh1"></bean:define>
						<bean:define id="maRaoBan" name="sp" property="maRaoBan"></bean:define>
						<a href="chi-tiet-bai-dang.do?maRaoBan=${maRaoBan}"><img
							src="${linkAnh}" class="w3-hover-opacity"
							style="height: 73%; width: 90%; display: block; margin-left: 10px; margin-top: 10px;"></a>
						<h5>
							<b><bean:write name="sp" property="tenSach" /></b>
						</h5>
						<p>
							<bean:write name="sp" property="tacGia" />
						</p>
						<h4>
							<b><bean:write name="sp" property="gia" /></b>
						</h4>
					</div>
				</logic:iterate>
				<!-- sp -->
			</div>
			<div id="pagination-div" align="center">
				<ul id="pagination-ul" class="pagination">
					<!-- 				<li class="active"><a href="#">1</a></li> -->
					<!-- 				<li><a href="#">2</a></li> -->
					<!-- 				<li><a href="#">3</a></li> -->
					<!-- 				<li><a href="#">4</a></li> -->
					<!-- 				<li><a href="#">5</a></li> -->
				</ul>
			</div>
		</div>
	</div>
</div>
<!--    END BODY    -->