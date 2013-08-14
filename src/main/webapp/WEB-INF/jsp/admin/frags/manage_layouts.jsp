<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Create Layout</h1>

<form:form action="/admin/createlayout" method="POST" commandName="layout" class="admin layout">

	<fieldset data-require="layout-component">
		<div class="layout-information">
			<div class="layout-name">
				<label for="layout-name"><h2>Layout Name</h2></label>
				<input type="text" placeholder="Layout Name" id="layout-name" />
			</div>
			<div class="layout-description">
				<label for="layout-description"><h3>Layout Description</h3></label>
				<input type="text" placeholder="Layout Description" id="layout-description" />
			</div>
		</div>

		<div class="errors-container">
			
		</div>

		<div class="layout-main-controls">
			<a href="#" class="add-row">Add row</a>
		</div>	
		<div class="layout-grid-view">

		</div>
		<div class="layout-choices">

		</div>
		<input type="hidden" value="" id="layoutJSON" name="layoutJSON" />
		<input type="submit" name="submit" value="Save Page" />
	</fieldset>
</form:form>