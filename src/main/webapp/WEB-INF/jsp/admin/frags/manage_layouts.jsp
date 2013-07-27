<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Links</h4>

<%--<c:forEach items="${layouts}" var="layout">
	<form:form action="/admin/createlayout" method="POST"
		commandName="layout">
		<div class="formInfo">
			<form:errors path="*" />
		</div>

		<fieldset>
			<form:label path="layoutName">
				Layout Name <form:errors path="layoutName" cssClass="errors" />
			</form:label>
			<form:input path="layoutName" value="${layout.layoutName}" />
			<form:label path="layoutDescription">
				Layout Description <form:errors path="layoutDescription"
					cssClass="errors" />
			</form:label>
			<form:input path="layoutDescription"
				value="${layout.layoutDescription}" />
			<form:label path="jsonLayout">
				JSON Layout Representation
			</form:label>
			<form:input path="jsonLayout" value="${layout.jsonLayout}" />
			<button type="submit">Update Layout</button>
		</fieldset>
	</form:form>
</c:forEach>--%>

<form:form action="/admin/createlayout" method="POST"
	commandName="layout">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="layoutName">
			Layout Name <form:errors path="layoutName" cssClass="errors" />
		</form:label>
		<form:input path="layoutName" />
		<form:label path="layoutDescription">
			Layout Description <form:errors path="layoutDescription"
				cssClass="errors" />
		</form:label>
		<form:input path="layoutDescription" />
		<form:label path="jsonLayout">
			JSON Layout Representation
		</form:label>
		<form:input path="jsonLayout" />
		<button type="submit">Create Layout</button>
	</fieldset>
</form:form>