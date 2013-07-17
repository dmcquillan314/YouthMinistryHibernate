<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h4>Manage Links</h4>

<c:if test="${not empty fileName}">
	FileName : "
	<strong> ${fileName} </strong>" - Uploaded Successful.
</c:if>

        
<form:form modelAttribute="uploadItem" action="/upload" method="post"
	enctype="multipart/form-data">
            <fieldset>
		                
		<legend>Upload Fields</legend>
		                                       
		<form:label for="name" path="name">Name</form:label>
		<br />                     
		<form:input path="name" />
		                    
		<form:label for="fileData" path="fileData">File</form:label>
		<br />                     
		<form:input path="fileData" type="file" />
		                    <input type="submit" />                   
		            
	</fieldset>
</form:form>
