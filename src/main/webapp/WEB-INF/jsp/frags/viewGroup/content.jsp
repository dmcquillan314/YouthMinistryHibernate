 test view group test ${model.groupName}
<h5>Active Event Entries</h5>
<c:forEach items="${model.events}" var="event">
	<p>Event name: ${event.eventName}</p>
	<p>Event description: ${event.eventDesc}</p>
	<p>Event start time: ${event.startTime}</p>
	<p>Event end time: ${event.endTime}</p>
	<p>Event end time: ${event.location.locationName}</p>
	<p>Event end time: ${event.location.street}</p>
	<p>Event end time: ${event.location.city}</p>
	<p>Event end time: ${event.location.state}</p>
	<p>Event end time: ${event.location.zipcode}</p>
	<p>Event end time: ${event.location.country}</p>
	<c:forEach items="${event.groups}" var="group">
		<p>Group name: ${group.groupName}</p>
	</c:forEach>
</c:forEach>
