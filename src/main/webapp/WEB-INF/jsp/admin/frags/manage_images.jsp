<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage images</h4>
<c:forEach items="${images}" var="image">
	<form:form action="/admin/updateimage/${image.imageId}" method="POST"
		commandName="image">
		<div class="formInfo">
			<form:errors path="*" />
		</div>

		<fieldset>
			<form:label path="imageName">
				Image Name
				<form:errors path="imageName" cssClass="error" />
			</form:label>
			<form:input path="imageName" value="${image.imageName}" />
			<form:label path="pathToImage">
				Image Path
				<form:errors path="pathToImage" cssClass="error" />
			</form:label>
			<form:input path="pathToImage" value="${image.pathToImage}" />
			<form:label path="altText">
				Image Alt Text
				<form:errors path="altText" cssClass="error" />
			</form:label>
			<form:input path="altText" value="${image.altText}" />
			<form:label path="titleText">
				Image Title
				<form:errors path="titleText" cssClass="error" />
			</form:label>
			<form:input path="titleText" value="${image.titleText}" />
			<button type="submit">Update Image</button>
		</fieldset>
	</form:form>
</c:forEach>

<form:form action="/admin/createimage" method="POST" commandName="image">
	<div class="formInfo">
		<form:errors path="*" />
	</div>

	<fieldset>
		<form:label path="imageName">
			Image Name
			<form:errors path="imageName" cssClass="error" />
		</form:label>
		<form:input path="imageName" />
		<form:label path="pathToImage">
			Image Path
			<form:errors path="pathToImage" cssClass="error" />
		</form:label>
		<form:input path="pathToImage" />
		<form:label path="altText">
			Image Alt Text
			<form:errors path="altText" cssClass="error" />
		</form:label>
		<form:input path="altText" />
		<form:label path="titleText">
			Image Title
			<form:errors path="titleText" cssClass="error" />
		</form:label>
		<form:input path="titleText" />
		<button type="submit">Create Image</button>
	</fieldset>
</form:form>
