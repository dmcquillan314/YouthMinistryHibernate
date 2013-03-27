<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h3>Create Event</h3>
<form:form method="POST" commandName="group">
	<div class="formInfo">
		<form:errors path="*"/>
	</div>
	
	<fieldset>
		<form:label path="groupName">
			Group Name 
			<form:errors path="groupName" cssClass="error" />
		</form:label>
		<form:input path="groupName" />
		<form:label path="groupDesc">
			Group Description <form:errors path="groupDesc" cssClass="error" />
			
		</form:label>
		<form:input path="groupDesc" />
	</fieldset>
	<p><button type="submit">Create Group</button>
</form:form>
<br>
List Groups
${groups}
<c:forEach var="group" items="${groups}">
	${group.groupName}
</c:forEach>
</br>
</body>
</html>