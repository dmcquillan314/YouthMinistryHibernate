<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/common/templates/page/template.jsp" flush="true">
	<jsp:param name="header" value="/frags/common/header.jsp"/>
	<jsp:param name="main_menu" value="/frags/common/main_menu.jsp"/>
	<jsp:param name="content" value="/admin/frags/pages/manage_pages_attach_content.jsp"/>
	<jsp:param name="footer" value="/frags/common/footer.jsp"/>
</jsp:include>