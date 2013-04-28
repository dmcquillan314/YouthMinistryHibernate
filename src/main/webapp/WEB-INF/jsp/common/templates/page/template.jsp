<!DOCTYPE html>

<%
/*
	"Super" template.

	This template takes the following parameters:
	
	meta_content - Path to a JSP page containing additional meta tags for the page.
				   See this template for defaults
				   
    page_title - The title to be given to this page.   				  
   
    head_content - Path to a JSP page containing links to external stylesheet or java script or CSS or JavaScript 
    body_content - Path to a JSP page containing the content for the body of the page
    sub_body_content - Path to a JSP containing links to external stylesheet or java script or CSS or JavaScript or other hidden content.
*/
%>
<html>
    <head>		
		<!-- [if IE 7]>  
            <meta http-equiv="X-UA-Compatible" content="IE=7" >
        <![endif]-->
            
        <!-- [if IE 8]>  
            <meta http-equiv="X-UA-Compatible" content="IE=8" >
        <![endif]-->
            
        <!--[if IE 9]>
            <meta http-equiv="X-UA-Compatible" content="IE=edge" >
        <![endif]-->
		
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

    	<% 
      		if ((request.getParameter("meta_content") == null) || (request.getParameter("meta_content").equals("")))
      		{
      	%>
          	<meta http-equiv="no-cache" />
          	<meta http-equiv="Expires" content="-1" />
          	<meta http-equiv="Pragma" content="no-cache" />
          	<meta http-equiv="Cache-Control" content="no-cache" />
        <%
            } else {
        %>
        <%
        	}
        %>

    	<title>
	    	<% 
	      		if ((request.getParameter("page_title") != null) && (!request.getParameter("page_title").equals(""))) {
	      	%>
	      			<%= request.getParameter("page_title") %>
	      	<%		
      			}
      		%>
    	</title>
    	
    	<% 
			if (request.getParameter("head_content") != null) {
		%>
		<% 
		 	}
		%>	
	</head>
	
<%-- note: primary browser detection done with css_browser_selector.js, except ie9, for which it does not detect a version --%>

<!--[if IE 9]>
<body class="ie9">
<![endif]-->

<!--[if !IE] -->
<body>
<!-- <![endif]-->


		<% 
			if (request.getParameter("header") != null) {
		%>
			<jsp:include page="<%= \"/WEB-INF/jsp\" + request.getParameter(\"header\") %>"/>
		<%  
			}
		%>

		<% 
			if (request.getParameter("content") != null) {
		%>
			<jsp:include page="<%= \"/WEB-INF/jsp\" + request.getParameter(\"content\") %>"/>
		<%  
			}
		%>

		<% 
			if (request.getParameter("footer") != null) {
		%>
			<jsp:include page="<%= \"/WEB-INF/jsp\" + request.getParameter(\"footer\") %>"/>
		<%  
			}
		%>
	</body>
</html>