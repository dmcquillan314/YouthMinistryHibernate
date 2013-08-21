<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="admin">
	step 1
	<form:form commandName="page" action="/admin/manage/pages" class="page">
		<fieldset>
			<ul>
				<li>
					<form:label path="pageName">
						Page Name <form:errors path="pageName" />
					</form:label>
					<form:input name="pageName" path="pageName" />
				</li>
				<li>
					<form:label path="pageUrl">
						Page Url <form:errors path="pageUrl" />
					</form:label>
					<form:input name="pageUrl" path="pageUrl" />
				</li>
				<li>
					<form:label path="pageTitle">
						Page Title <form:errors path="pageTitle" />
					</form:label>
					<form:input name="pageTitle" path="pageTitle" />
				</li>
				<li>
					<form:label path="pageDescription">
						Page Description <form:errors path="pageDescription" />
					</form:label>
					<form:textarea name="pageDescription" path="pageDescription" />
				</li>
				<li>
					<form:label path="pageKeywords">
						Page Keywords <form:errors path="pageKeywords" />
					</form:label>
					<form:textarea name="pageKeywords" path="pageKeywords" />
				</li>
				<li>
					<input type="hidden" name="_page" value="0" />
					<input type="hidden" name="_target" value="1" />
					<input type="submit" class="submit button" name="submit" value="Submit" />
				</li>
			</ul>		
	
		</fieldset>
	</form:form>
</div>