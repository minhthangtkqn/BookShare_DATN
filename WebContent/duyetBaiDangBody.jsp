<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!--    BODY        -->
	<!---content main-->
<div id="content_detail">

	Mã Rao bán: <bean:write name="chiTietBaiDangForm" property="maRaoBan"/>
	<bean:define id="chiTiet" name="chiTietBaiDangForm" property="chiTiet"></bean:define>

</div>
<!--    END BODY    -->