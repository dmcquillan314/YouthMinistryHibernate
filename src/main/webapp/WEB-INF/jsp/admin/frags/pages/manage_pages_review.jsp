<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
manage page - review
<form:form commandName="page" action="/admin/manage/pages">
	<fieldset>
		
		<input type="hidden" name="_cancel" value="2" />
		<input type="hidden" name="_page" value="3" />
		<input type="hidden" name="_final" value="true" />
		<input type="submit" name="submit" value="Cancel" />
		<input type="submit" name="submit" value="Submit" />
	</fieldset>
</form:form>