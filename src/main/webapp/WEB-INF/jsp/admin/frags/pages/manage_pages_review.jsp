<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="admin">
	manage page - review
	<form:form commandName="page" action="/admin/manage/pages" class="page layout">
		<fieldset>
			
			<input type="hidden" name="_cancel" value="2" />
			<input type="hidden" name="_page" value="3" />
			<input type="hidden" name="_final" value="true" />
			<input type="submit" class="cancel button" name="submit" value="Cancel" />
			<input type="submit" class="submit button" name="submit" value="Submit" />
		</fieldset>
	</form:form>
</div>