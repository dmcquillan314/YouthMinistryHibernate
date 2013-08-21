<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="admin">
	manage page - step 3
	<form:form commandName="page" action="/admin/manage/pages" class="page">
		<fieldset>
			
			<input type="hidden" name="_cancel" value="1" />
			<input type="hidden" name="_page" value="2" />
			<input type="hidden" name="_target" value="3" />
			<input type="submit" class="cancel button" name="submit" value="Cancel" />
			<input type="submit" class="submit button" name="submit" value="Submit" />
		</fieldset>
	</form:form>
</div>