<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="columnClasses" value="${fn:split('one-col,two-col,three-col,four-col,five-col,six-col,seven-col,eight-col,nine-col,ten-col,eleven-col,twelve-col,thirteen-col,fourteen-col,fifteen-col,sixteen-col', ',')}" scope="page" />
<div class="admin">
	manage page step 2
	<form:form commandName="page" action="/admin/manage/pages" class="page">
		<fieldset>
			<form:errors path="rows" />
			<div class="layout-select">
				<c:forEach items="${layouts}" var="layout" varStatus="loopOuter">
					<input type="radio" id="layout${layout.layoutId}" name="layout" value="${layout.layoutId}" />
					<label class="${loopOuter.count} layout four-col${loopOuter.count % 4 == 0 ? ' omega' : ' ' }" for="layout${layout.layoutId}">
						<c:forEach items="${layout.rows}" var="row">
							<c:forEach items="${row.cols}" var="col" varStatus="loop">
								<c:choose>
									<c:when test="${loop.last}">
										<div class="${ columnClasses[col.columnWidth-1] } omega">
										</div>
									</c:when>
									<c:otherwise>
										<div class="${ columnClasses[col.columnWidth-1] }">
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:forEach>
					</label>
				</c:forEach>
			</div>
			<div class="form-navigation">
				<div class="nav-block right">
					<input type="hidden" name="_cancel" value="0" />
					<input type="hidden" name="_page" value="1" />
					<input type="hidden" name="_target" value="2" />
					<input type="submit" class="light-gray button" name="submit" value="Cancel" />
					<input type="submit" class="button" name="submit" value="Submit" />				
				</div>
			</div>
		</fieldset>
	</form:form>
</div>