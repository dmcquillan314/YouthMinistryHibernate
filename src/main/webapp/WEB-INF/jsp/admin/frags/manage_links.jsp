<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Links</h4>

<c:forEach items="${links}" var="link">
	<form:form action="/admin/updatelink/${link.linkId}" method="POST" commandName="link">
		<div class="formInfo">
			<form:errors path="*" />
		</div>
	
		<fieldset>
			<form:label path="linkName">
				Link Name <form:errors path="linkName" cssClass="errors" />
			</form:label>
			<form:input path="linkName" value="${link.linkName}" />
			<c:if test="${not empty pages}">
				<form:label path="page">
					Page <form:errors path="page" cssClass="errors" />
				</form:label>
				<form:select id="contentSelect" path="page" items="${pages}" 
							 itemLabel="pageName" itemValue="pageId" value="${link.page.pageId}" />
			</c:if>
			<form:label path="linkUrl">
				Link Url <form:errors path="linkUrl" cssClass="errors" />
			</form:label>
			<form:input path="linkUrl" value="${link.linkUrl}" />
			<form:label path="linkClass">
				Link Class <form:errors path="linkClass" cssClass="errors" />
			</form:label>
			<form:input path="linkClass" value="${link.linkClass}" />
			<form:label path="linkTarget">
				Link Class <form:errors path="linkTarget" cssClass="errors" />
			</form:label>
			<form:input path="linkTarget" value="${link.linkTarget}" />
			<button type="submit">Update Link</button>
		</fieldset>
	</form:form>
</c:forEach>

<form:form action="/admin/createlink" method="POST" commandName="link">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="linkName">
			Link Name <form:errors path="linkName" cssClass="errors" />
		</form:label>
		<form:input path="linkName"/>
		<c:if test="${not empty pages}">
			<form:label path="page">
				Page <form:errors path="page" cssClass="errors" />
			</form:label>
			<form:select id="pageSelect" path="page" items="${pages}" 
						 itemLabel="pageName" itemValue="pageId" />
		</c:if>
		<form:label path="linkUrl">
			Link Url <form:errors path="linkUrl" cssClass="errors" />
		</form:label>
		<form:input path="linkUrl"/>
		<form:label path="linkClass">
			Link Class <form:errors path="linkClass" cssClass="errors" />
		</form:label>
		<form:input path="linkClass"/>
		<form:label path="linkTarget">
			Link Class <form:errors path="linkTarget" cssClass="errors" />
		</form:label>
		<form:input path="linkTarget"/>
		<button type="submit">Create Link</button>
	</fieldset>
</form:form>