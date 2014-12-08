<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="home">
	<tiles:putAttribute name="content">

		<h1>Hello world!</h1>

		<P>The time on the server is ${serverTime}.</P>

	</tiles:putAttribute>

</tiles:insertDefinition>

