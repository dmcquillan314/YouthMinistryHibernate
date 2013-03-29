<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<h3>Manage Content</h3>
<form:form action="/admin/creategroup" method="POST" commandName="group">
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
<form:form action="/admin/createtextentry" method="POST" commandName="textEntry">
	<div class="formInfo">
		<form:errors path="*"/>
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
			
		</form:label>
		<form:input path="contentBody" />
	</fieldset>
	<p><button type="submit">Create page content</button>
</form:form>
<form:form action="/admin/createimage" method="POST" commandName="image">
	<div class="formInfo">
		<form:errors path="*"/>
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
	</fieldset>
	<p><button type="submit">Create page content</button>
</form:form>
</body>
</html>