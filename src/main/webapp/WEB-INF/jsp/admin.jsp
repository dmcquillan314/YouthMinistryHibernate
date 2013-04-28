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
					<form:select id="userGroupSelect" path="groups" multiple="true"
					items="${groups}" itemLabel="groupName" itemValue="idAsString" />
				</li>
				<li>Roles: 
					<form:select id="userRoleSelect" path="roles" multiple="true"
					items="${roles}" itemLabel="name" itemValue="id" />
				</li>
			</ul>
			<form:button type="submit" name="submit">Update user</form:button>
		</form:form>
	</c:forEach>

	<form:form action="/admin/creategroup" method="POST"
		commandName="group">
		<h4>Current Groups</h4>
		<c:forEach items="${groups}" var="group">
			<p>Group Name: ${group.groupName}</p>
			<p>Group Description: ${group.groupDesc}</p>
		</c:forEach>
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
	<h4>Current content items</h4>
	<h5>Text Entries</h5>
	<c:forEach items="${textEntries}" var="textEntry">
		<p>Page Content Id: ${textEntry.pageContentId}</p>
		<p>Page Content Name: ${textEntry.pageContentName}</p>
		<p>Location: ${textEntry.location}</p>
		<p>Content Title: ${textEntry.contentTitle}</p>
		<p>Content Body: ${textEntry.contentBody}</p>
	</c:forEach>
	<form:form action="/admin/createtextentry" method="POST"
		commandName="textEntry">
		<div class="formInfo">
			<form:errors path="*" />
		</div>

		<fieldset>
			<form:label path="pageContentName">
			Page Content Name 
			<form:errors path="pageContentName" cssClass="error" />
			</form:label>
			<form:input path="pageContentName" />
			<form:label path="location">
			Location <form:errors path="location" cssClass="error" />

			</form:label>
			<form:input path="location" />
			<form:label path="contentTitle">
			Content Title <form:errors path="contentTitle" cssClass="error" />

			</form:label>
			<form:input path="contentTitle" />
			<form:label path="contentBody">
			Content Body <form:errors path="contentBody" cssClass="error" />
				<form:input path="contentBody" />
			</form:label>
			<c:if test="${not empty groups}">
        	Content group <form:errors path="groups" cssClass="error" />
				<form:select id="groupSelect" path="groups" multiple="true"
					items="${groups}" itemLabel="groupName" itemValue="idAsString" />
			</c:if>
		</fieldset>
		<p>
			<button type="submit">Create page content</button>
	</form:form>
	<h5>Image Entries</h5>
	<c:forEach items="${images}" var="image">
		<p>Page Content Id: ${image.pageContentId}</p>
		<p>Page Content Name: ${image.pageContentName}</p>
		<p>Location: ${image.location}</p>
		<p>Path To Image: ${image.pathToImage}</p>
		<p>Image Alt Text: ${image.altText}</p>
		<p>Image Title Text: ${image.titleText}</p>
	</c:forEach>
	<form:form action="/admin/createimage" method="POST"
		commandName="image">
		<div class="formInfo">
			<form:errors path="*" />
		</div>

		<fieldset>
			<form:label path="pageContentName">
			Page Content Name 
			<form:errors path="pageContentName" cssClass="error" />
			</form:label>
			<form:input path="pageContentName" />
			<form:label path="location">
			Location <form:errors path="location" cssClass="error" />

			</form:label>
			<form:input path="location" />
			<form:label path="pathToImage">
			Path to image <form:errors path="pathToImage" cssClass="error" />

			</form:label>
			<form:input path="pathToImage" />
			<form:label path="altText">
			Alternate text for image <form:errors path="altText" cssClass="error" />

			</form:label>
			<form:input path="altText" />
			<form:label path="titleText">
			Title text for image <form:errors path="titleText" cssClass="error" />

			</form:label>
			<form:input path="titleText" />
			<c:if test="${not empty groups}">
        	Content group <form:errors path="groups" cssClass="error" />
				<form:select id="groupSelect" path="groups" multiple="true"
					items="${groups}" itemLabel="groupName" itemValue="idAsString" />
			</c:if>
		</fieldset>
		<p>
			<button type="submit">Create page content</button>
	</form:form>
	<h5>Event Entries</h5>
	<c:forEach items="${events}" var="event">
		<p>Event name: ${event.eventName}</p>
		<p>Event description: ${event.eventDesc}</p>
		<p>Event start time: ${event.startTime}</p>
		<p>Event end time: ${event.endTime}</p>
		<p>Event end time: ${event.location.locationName}</p>
		<p>Event end time: ${event.location.street}</p>
		<p>Event end time: ${event.location.city}</p>
		<p>Event end time: ${event.location.state}</p>
		<p>Event end time: ${event.location.zipcode}</p>
		<p>Event end time: ${event.location.country}</p>
		<c:forEach items="${event.groups}" var="group">
			<p>Group name: ${group.groupName}</p>
		</c:forEach>
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
		<p>
			<button type="submit">Create page content</button>
	</form:form>
</body>
</html>