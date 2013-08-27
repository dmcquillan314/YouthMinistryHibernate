<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="columnClasses" value="${fn:split('one-col,two-col,three-col,four-col,five-col,six-col,seven-col,eight-col,nine-col,ten-col,eleven-col,twelve-col,thirteen-col,fourteen-col,fifteen-col,sixteen-col', ',')}" scope="page" />

<div class="admin">
	attach content - step 3
	<form:form commandName="page" action="/admin/manage/pages" class="page">
		<fieldset>
			<div class="layout ten-col attach-content">
				<c:forEach items="${page.rows}" var="row">
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
			</div>
			
			<div class="content-list six-col omega">
				<div class="content-list-item" data-content-id="1">
					<a href="#" class="dragabble" draggable="true">This is a draggable item</a>
				    <dl>
				        <dt>
				            content name
				        </dt>
				        <dd>
				            name for content
				        </dd>
				        <dt>
				            content description
				        </dt>
				        <dd>
				            content description listing
				        </dd>
				    </dl>
				</div>
				<div class="content-list-item" data-content-id="2">
				    <dl>
				        <dt>
				            content name
				        </dt>
				        <dd>
				            name for content
				        </dd>
				        <dt>
				            content description
				        </dt>
				        <dd>
				            content description listing
				        </dd>
				    </dl>
				</div>
				<div class="content-list-item" data-content-id="3">
				    <dl>
				        <dt>
				            content name
				        </dt>
				        <dd>
				            name for content
				        </dd>
				        <dt>
				            content description
				        </dt>
				        <dd>
				            content description listing
				        </dd>
				    </dl>
				</div>
				<div class="content-list-item" data-content-id="4">
				    <dl>
				        <dt>
				            content name
				        </dt>
				        <dd>
				            name for content
				        </dd>
				        <dt>
				            content description
				        </dt>
				        <dd>
				            content description listing
				        </dd>
				    </dl>
				</div>
			</div>
			<div class="form-navigation">
				<div class="nav-block right">
					<input type="hidden" name="_cancel" value="1" />
					<input type="hidden" name="_page" value="2" />
					<input type="hidden" name="_target" value="3" />
					<input type="submit" class="cancel button" name="submit" value="Cancel" />
					<input type="submit" class="submit button" name="submit" value="Submit" />
				</div>
			</div>
		</fieldset>
	</form:form>
</div>