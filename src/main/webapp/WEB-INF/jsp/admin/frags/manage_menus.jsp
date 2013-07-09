<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Menus</h4>

<c:forEach items="${menus}" var="menu">
	<form:form action="/admin/updatemenu/${menu.menuId}" method="POST" commandName="menu">
		<div class="formInfo">
			<form:errors path="*" />
		</div>
	
		<fieldset>
			<form:label path="menuName">
				Menu Name <form:errors path="menuName" cssClass="errors" />
			</form:label>
			<form:input path="menuName" value="${menu.menuName}" />
			<form:label path="menuDescription">
				Menu Description <form:errors path="menuDescription" cssClass="errors" />
			</form:label>
			<form:input path="menuDescription" value="${menu.menuDescription}" />
			<c:if test="${not empty contentItems}">
				<form:label path="links">
					Menu Links <form:errors path="links" cssClass="errors" />
				</form:label>
				<form:select id="contentSelect" path="links" multiple="true"
					items="${links}" itemLabel="linkName" value="${link.linkName}"
					itemValue="linkId" />
			</c:if>
			<button type="submit">Update Menu</button>		
		</fieldset>
	</form:form>
</c:forEach>

<form:form action="/admin/createmenu" method="POST" commandName="menu">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="menuName">
			Menu Name <form:errors path="menuName" cssClass="errors" />
		</form:label>
		<form:input path="menuName" />
		<form:label path="menuDescription">
			Menu Description <form:errors path="menuDescription" cssClass="errors" />
		</form:label>
		<form:input path="menuDescription" />
		<c:if test="${not empty contentItems}">
			<form:label path="links">
				Menu Links <form:errors path="links" cssClass="errors" />
			</form:label>
			<form:select id="contentSelect" path="links" multiple="true"
				items="${links}" itemLabel="linkName"
				itemValue="linkId" />
		</c:if>
		<button type="submit">Create Menu</button>		
	</fieldset>
</form:form>