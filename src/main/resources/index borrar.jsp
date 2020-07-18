<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wj" uri="http://www.webjars.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Session Attributes</title>
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<style type="text/css">
		body {
			padding: 1em;
		}
	</style>
</head>
<body>
	<div class="container">
		<h1>descr</h1>
		<p>This application demonstrates how to use a Redis instance to back your session. Notice that there is no JSESSIONID cookie. We are also able to customize the way of identifying what the requested session id is.</p>

		<h1>Try it</h1>

		<form class="form-inline" role="form" action="./session" method="post">
			<label for="letter">Attribute Name</label>
			<input id="letter" type="text" name="letter" maxlength="1" min="1" />
			<input type="submit" value="Set Attribute"/>
		</form>
		
		<a href="./newGame"  >New game</a>

		<hr/>

		<table class="table table-striped">
			<thead>
			<tr>
				<th>Attribute Name</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${sessionScope}" var="attr">
				<tr>
					<td><c:out value="${attr.currentPhrase}"/></td>
					<td><c:out value="${attr.wrongAttempts}"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
