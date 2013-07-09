<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage content items</h4>

<c:forEach items="${contentItems}" var="contentItem">
	<form:form
		action="/admin/updatepagecontent/${contentItem.pageContentId}"
		method="POST" commandName="pageContent">
		<div class="formInfo">
			<form:errors path="*" />
		</div>

		<fieldset>
			<form:label path="pageContentName">
				Page Content Name 
				<form:errors path="pageContentName" cssClass="error" />
			</form:label>
			<form:input path="pageContentName"
				value="${contentItem.pageContentName}" />
			<form:label path="images">
				Images  
				<form:errors path="images" cssClass="error" />
			</form:label>
			<form:select cssClass="ImageSelect" path="images" multiple="true">
				<c:forEach items="${images}" var="image">
					<c:set var="selected" value="false" />
					<c:forEach items="${contentItem.images}" var="pImage">
						<c:if test="${image.imageId == pImage.imageId}">
							<c:set var="selected" value="true" />
						</c:if>
					</c:forEach>
					<option value="${image.imageId}" ${selected ? "selected" : ""}>${image.imageName}</option>
				</c:forEach>
			</form:select>

			<form:label path="contentTitle">
				Content Title 
				<form:errors path="contentTitle" cssClass="error" />
			</form:label>
			<form:input path="contentTitle" value="${contentItem.contentTitle}" />

			<form:label path="contentBody">
				Content Body 
				<form:errors path="contentBody" cssClass="error" />
			</form:label>
			<form:input path="contentBody" value="${contentItem.contentBody}" />
			<button type="submit">Update Page Content</button>
		</fieldset>
	</form:form>
</c:forEach>

<form:form action="/admin/createpagecontent" method="POST"
	commandName="pageContent">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="pageContentName">
			Page Content Name 
			<form:errors path="pageContentName" cssClass="error" />
		</form:label>
		<form:input path="pageContentName" />
		<form:label path="images">
			Images  
			<form:errors path="images" cssClass="error" />
		</form:label>
		<form:select id="imageSelect" path="images" multiple="true"
			items="${images}" itemLabel="imageName" itemValue="imageId" />

		<form:label path="contentTitle">
			Content Title 
			<form:errors path="contentTitle" cssClass="error" />
		</form:label>
		<form:input path="contentTitle" />

		<form:label path="contentBody">
			Content Body 
			<form:errors path="contentBody" cssClass="error" />
		</form:label>
		<form:input path="contentBody" />
		<button type="submit">Create Page Content</button>
	</fieldset>
</form:form>
