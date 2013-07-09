<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Renderers</h4>

<c:forEach items="${renderers}" var="renderer">
	<form:form action="/admin/updaterenderer/${renderer.rendererId}" method="POST" commandName="renderer">
		<div class="formInfo">
			<form:errors path="*" />
		</div>
	
		<fieldset>
			<form:label path="rendererName">
				Renderer Name <form:errors path="rendererName" cssClass="error" />
			</form:label>
			<form:input path="rendererName" value="${renderer.rendererName}" />
			<form:label path="rendererDescription">
				Renderer Description <form:errors path="rendererDescription" cssClass="error" />
			</form:label>
			<form:input path="rendererDescription" value="${renderer.rendererDescription}" />
			<form:label path="rendererJspPath">
				Renderer JSP Path <form:errors path="rendererJspPath" cssClass="error" />
			</form:label>
			<form:input path="rendererJspPath" value="${renderer.rendererJspPath}" />
			<button type="submit">Update Renderer</button>
		</fieldset>
	</form:form>
</c:forEach>

<form:form action="/admin/createrenderer" method="POST" commandName="renderer">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="rendererName">
			Renderer Name <form:errors path="rendererName" cssClass="error" />
		</form:label>
		<form:input path="rendererName" />
		<form:label path="rendererDescription">
			Renderer Description <form:errors path="rendererDescription" cssClass="error" />
		</form:label>
		<form:input path="rendererDescription" />
		<form:label path="rendererJspPath">
			Renderer JSP Path <form:errors path="rendererJspPath" cssClass="error" />
		</form:label>
		<form:input path="rendererJspPath" />
		<button type="submit">Create Renderer</button>
	</fieldset>
</form:form>