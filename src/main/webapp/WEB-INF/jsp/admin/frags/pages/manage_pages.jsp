<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form commandName="page" action="/admin/manage/pages">
	<fieldset>
		<form:label path="pageUrl">
			Page Url <form:errors path="pageUrl" />
		</form:label>
		<form:input name="pageUrl" path="pageUrl" />
		<form:label path="pageName">
			Page Name <form:errors path="pageName" />
		</form:label>
		<form:input name="pageName" path="pageName" />
		
		<input type="hidden" name="_page" value="0" />
		<input type="hidden" name="_target" value="1" />
		<input type="submit" name="submit" value="Cancel" />
		<input type="submit" name="submit" value="Submit" />
	</fieldset>
</form:form>