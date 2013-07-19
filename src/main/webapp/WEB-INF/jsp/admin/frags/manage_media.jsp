<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Links</h4>

<c:if test="${not empty fileName}">
	FileName : "
	<strong> ${fileName} </strong>" - Uploaded Successful.
</c:if>

        
<form:form method="post" action="/admin/uploadmedia" commandName="document" enctype="multipart/form-data">
	<fieldset>
		<form:errors path="*" cssClass="error"/>
		
		<form:label path="fileName">File name</form:label>
		<form:input path="fileName" />
		
		<form:label path="fileDescription">File detail</form:label>
		<form:textarea path="fileDescription" />
	
		<form:label path="fileData">File</form:label>
		<form:input type="file" path="fileData" name="file" id="file" />
		
		<input type="submit" value="Upload File"/>
	</fieldset>
</form:form>

