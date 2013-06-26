<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<h4>Manage Users</h4>
	<c:forEach items="${users}" var="user">
		<form:form action="/admin/updateuser/${user.userId}" method="POST" commandName="user">
			<div class="formInfo">
				<form:errors path="*" />
			</div>
			<ul>
				<li>User: ${user.username}</li>
				<li>First Name: ${user.userProfile.firstName}</li>
				<li>Last Name: ${user.userProfile.lastName}</li>
				<li>Groups: 
					<form:select cssClass="userGroupSelect" path="groups" multiple="true">
						<c:forEach items="${groups}" var="group">
							<c:set var="selected" value="false"/>
							<c:forEach items="${user.groups}" var="uGroup">
								<c:if test="${group.groupName == uGroup.groupName}">
									<c:set var="selected" value="true"/>
								</c:if>
							</c:forEach>
							<option value="${group.idAsString}" ${selected ? "selected" : ""}>${group.groupName}</option>
						</c:forEach>
					</form:select>												
				</li>
				<li>Roles: 
					<form:select cssClass="userRoleSelect" path="roles" multiple="true">
						<c:forEach items="${roles}" var="role">
							<c:set var="selected" value="false"/>
							<c:forEach items="${user.roles}" var="uRole">
								<c:if test="${role.name == uRole.name}">
									<c:set var="selected" value="true"/>
								</c:if>
							</c:forEach>
							<option value="${role.id}" ${selected ? "selected" : ""}>${role.name}</option>
						</c:forEach>
					</form:select>												
				</li>
			</ul>
			<form:button type="submit" name="submit">Update user</form:button>
		</form:form>
	</c:forEach>
	<h4>Manage groups</h4>
	<c:forEach items="${groups}" var="group">
		<form:form action="/admin/updategroup/${group.groupId}" method="POST" commandName="group">
			<div class="formInfo">
				<form:errors path="*" />
			</div>
			
			<fieldset>
				<form:label path="groupName">
				Group Name
				<form:errors path="groupName" cssClass="error" />
				</form:label>
				<form:input path="groupName" value="${group.groupName}" />
				<form:label path="groupDesc">
				Group Name
				<form:errors path="groupDesc" cssClass="error" />
				</form:label>
				<form:input path="groupDesc" value="${group.groupDesc}" />
			</fieldset>
			<button type="submit">Update Group</button>
		</form:form>		
	</c:forEach>
	
	<form:form action="/admin/creategroup" method="POST"
		commandName="group">
		<h4>Groups</h4>
		<div class="formInfo">
			<form:errors path="*" />
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
		<button type="submit">Create Group</button>
	</form:form>
	<h4>Manage content items</h4>
	
	TODO 
	
	
	<h5>Manage events</h5>
	<c:forEach items="${events}" var="event">
		<form:form action="/admin/createevent" method="POST"
			commandName="eventLocation">
			<div class="formInfo">
				<form:errors path="*" />
			</div>
			<fieldset>
				<form:label path="event.eventName">
				Event Name 
				<form:errors path="event.eventName" cssClass="error" />
				</form:label>
				<form:input path="event.eventName" value="${event.eventName}" />
				<form:label path="event.eventDesc">
				Event Description <form:errors path="event.eventDesc" cssClass="error" />
				</form:label>
				<form:input path="event.eventDesc" value="${event.eventDesc}" />
				<form:label path="event.startTime">
				Start time (yyyyMMddHHmmss) <form:errors path="event.startTime" cssClass="error" />
				</form:label>
				<form:input path="event.startTime" value="${event.startTime}" />
				<form:label path="event.endTime">
				End time (yyyyMMddHHmmss)<form:errors path="event.endTime" cssClass="error" />
				</form:label>
				<form:input path="event.endTime" value="${event.endTime}" />
				<form:label path="location.locationName">
				Location name <form:errors path="location.locationName" cssClass="error"/>
				</form:label>
				<form:input path="location.locationName" value="${event.location.locationName}" />
				<form:label path="location.street">
				Street <form:errors path="location.street" cssClass="error"/>
				</form:label>
				<form:input path="location.street" value="${event.location.street}" />
				<form:label path="location.city">
				City <form:errors path="location.city" cssClass="error"/>
				</form:label>
				<form:input path="location.city" value="${event.location.city}" />
				<form:label path="location.state">
				State <form:errors path="location.state" cssClass="error"/>
				</form:label>
				<form:input path="location.state" value="${event.location.state}" />
				<form:label path="location.zipcode">
				Zipcode <form:errors path="location.zipcode" cssClass="error"/>
				</form:label>
				<form:input path="location.zipcode" value="${event.location.zipcode}" />
				<form:label path="location.country">
				Country <form:errors path="location.country" cssClass="error"/>
				</form:label>
				<form:input path="location.country" value="${event.location.country}" />
				<c:if test="${not empty groups}">
	        	Event group <form:errors path="event.groups" cssClass="error" />
				</c:if>
			</fieldset>
			<button type="submit">Update event</button>
		</form:form>
	</c:forEach>
	<form:form action="/admin/createevent" method="POST"
		commandName="eventLocation">
		<div class="formInfo">
			<form:errors path="*" />
		</div>
		<fieldset>
			<form:label path="event.eventName">
			Event Name 
			<form:errors path="event.eventName" cssClass="error" />
			</form:label>
			<form:input path="event.eventName" />
			<form:label path="event.eventDesc">
			Event Description <form:errors path="event.eventDesc" cssClass="error" />
			</form:label>
			<form:input path="event.eventDesc" />
			<form:label path="event.startTime">
			Start time (yyyyMMddHHmmss) <form:errors path="event.startTime" cssClass="error" />
			</form:label>
			<form:input path="event.startTime" />
			<form:label path="event.endTime">yyyyMMddHHmmss<form:errors path="event.endTime" cssClass="error" />
			</form:label>
			<form:input path="event.endTime" />
			
			<form:label path="location.locationName">
			Location name <form:errors path="location.locationName" cssClass="error"/>
			</form:label>
			<form:input path="location.locationName" />
			<form:label path="location.street">
			Street <form:errors path="location.street" cssClass="error"/>
			</form:label>
			<form:input path="location.street" />
			<form:label path="location.city">
			City <form:errors path="location.city" cssClass="error"/>
			</form:label>
			<form:input path="location.city" />
			<form:label path="location.state">
			State <form:errors path="location.state" cssClass="error"/>
			</form:label>
			<form:input path="location.state" />
			<form:label path="location.zipcode">
			Zipcode <form:errors path="location.zipcode" cssClass="error"/>
			</form:label>
			<form:input path="location.zipcode" />
			<form:label path="location.country">
			Country <form:errors path="location.country" cssClass="error"/>
			</form:label>
			<form:input path="location.country" />
			<c:if test="${not empty groups}">
        	Event group <form:errors path="event.groups" cssClass="error" />
				<form:select id="groupSelect" path="event.groups" multiple="true"
					items="${groups}" itemLabel="groupName" itemValue="idAsString" />
			</c:if>
		</fieldset>
		<button type="submit">Create event</button>
	</form:form>
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
	        	Content Items <form:errors path="contentItems" cssClass="error" />
					<form:select id="contentSelect" path="contentItems" multiple="true"
						items="${contentItems}" itemLabel="pageContentName" itemValue="pageContentId" />
				</c:if>
			</fieldset>
			<button type="submit">Update page</button>
		</form:form>
	</c:forEach>
	<form:form action="/admin/createpage" method="POST"
		commandName="page">
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
					items="${contentItems}" itemLabel="pageContentName" itemValue="pageContentId" />
			</c:if>
		</fieldset>
		<button type="submit">Create page</button>
	</form:form>
</body>
</html>