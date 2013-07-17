<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu">
	<nav>
		<a href="<c:url value="/admin/manage/content" />">Content</a>
		<a href="<c:url value="/admin/manage/images" />">Images</a>
		<a href="<c:url value="/admin/manage/links" />">Links</a>
		<a href="<c:url value="/admin/manage/menus" />">Menus</a>
		<a href="<c:url value="/admin/manage/pages" />">Pages</a>
		<a href="<c:url value="/admin/manage/renderers" />">Renderers</a>
		<a href="<c:url value="/admin/manage/media" />">Media</a>
		<a href="<c:url value="/j_spring_security_logout" />">Logout</a>
	</nav>
</div>