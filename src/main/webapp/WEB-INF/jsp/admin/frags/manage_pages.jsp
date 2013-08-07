<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage pages</h4>
<c:forEach items="${pages}" var="page">
	<form:form action="/admin/updatepage/${page.pageId}" method="POST"
		commandName="page">
		<div class="formInfo">
			<form:errors path="*" />
		</div>
		<fieldset>
			<form:label path="pageName">
				Page Name 
				<form:errors path="pageName" cssClass="error" />
			</form:label>
			<form:input path="pageName" value="${page.pageName}" />
			<form:label path="pageUrl">
				Page Url 
				<form:errors path="pageUrl" cssClass="error" />
			</form:label>
			<form:input path="pageUrl" value="${page.pageUrl}" />
			<c:if test="${not empty contentItems}">
	        	Content Items <form:errors path="contentItems"
					cssClass="error" />
				<form:select id="contentSelect" path="contentItems" multiple="true"
					items="${contentItems}" itemLabel="pageContentName"
					itemValue="pageContentId" />
			</c:if>
			<button type="submit">Update page</button>
		</fieldset>
	</form:form>
</c:forEach>
<form:form action="/admin/createpage" method="POST" commandName="page">
	<div class="formInfo">
		<form:errors path="*" />
	</div>
	<fieldset>
		<form:label path="pageName">
			Page Name 
			<form:errors path="pageName" cssClass="error" />
		</form:label>
		<form:input path="pageName" />
		<form:label path="pageUrl">
			Page Url 
			<form:errors path="pageUrl" cssClass="error" />
		</form:label>
		<form:input path="pageUrl" />
		<c:if test="${not empty contentItems}">
        	Content Items <form:errors path="contentItems" cssClass="error" />
			<form:select id="contentSelect" path="contentItems" multiple="true"
				items="${contentItems}" itemLabel="pageContentName"
				itemValue="pageContentId" />
		</c:if>
		<c:if test="${not empty pages}">
        	Parent Page <form:errors path="parentPageId" cssClass="error" />
			<form:select id="parentPageSelect" path="parentPageId"
				items="${pages}" itemLabel="pageName"
				itemValue="pageId" />
		</c:if>
		<button type="submit">Create page</button>
	</fieldset>
</form:form>