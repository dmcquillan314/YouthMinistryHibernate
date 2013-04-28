<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu">
	<nav>
		<c:forEach items="${groups}" var="group">
			<a href="/YouthMinistryHibernate/${group.groupName}">${group.groupName}</a>
		</c:forEach>
	</nav>
</div>