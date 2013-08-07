<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="/static/common/css/compiled.css"/>" type="text/css" rel="stylesheet" />
</head>
<body> 
	<form action="<c:url value="/signin/authenticate"/>" id="signin" method="POST">
	 	<div class="formInfo">
	  		<c:if test="${param.error eq 'bad_credentials'}">
	  		<div class="error">
	  			Your sign in information was incorrect.
	  			Please try again or <a href="<c:url value="/signup" />">sign up</a>.
	  		</div>
	 	 	</c:if>
	 	 	<c:if test="${param.error eq 'multiple_users'}">
	 	 	<div class="error">
	 	 		Multiple local account are connected to the provider account.
	 	 		Try again with a different provider or with your username and password.
	 	 	</div>
	 	 	</c:if>
		</div>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="submit" />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="reset" type="reset" />
				</td>
			</tr>
		</table>
 
	</form>
	<a href="<c:url value='/signup' />">Signup</a>

	<h3>Sign in via a provider:</h3>
	<p>(Uses SocialAuthenticationFilter)</p>

	<!-- FACEBOOK SIGNIN -->
    <p><a href="<c:url value="/auth/facebook"/>">Connect with facebook</a><br/></p></body>
</html>