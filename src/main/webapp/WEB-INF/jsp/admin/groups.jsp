<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h3>Create Event</h3>

<c:if test="${not empty message}">
	<div class="${message.type.cssClass}">${message.text}</div>
</c:if>

<form:form action="/admin/groups" method="POST" modelAttribute="groupForm">
	<div class="formInfo">
		<s:bind path="*">
			<c:choose>
				<c:when test="${status.error}">
					<div class="error">Unable to create group. Please fix the errors below and resubmit.</div>
				</c:when>
			</c:choose>
		</s:bind>
	</div>
	
	<fieldset>
		<form:label path="groupName">
			Group Name 
			<form:errors path="groupName" cssClass="error" />
		</form:label>
		<form:input path="groupName" />
		<form:label path="groupDesc">
			Group Description 
			<form:errors path="groupDesc" cssClass="error" />
		</form:label>
		<form:input path="groupDesc" />
	</fieldset>
	<p><button type="submit">Create Group</button>
</form:form>
<a href="<c:url value="/admin"/>">Back to Admin</a>
</body>
</html>