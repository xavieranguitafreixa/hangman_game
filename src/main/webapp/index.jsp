<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Hangman Game</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>

<script>
$("#hangmanform").validate();
</script>

<script type="text/javascript">
		
		$(document).ready(function() {
			
			// restrict letter
			$('.letter').keypress(function(key) {
				if((key.charCode < 97 || key.charCode > 122) && (key.charCode < 65 || key.charCode > 90) && (key.charCode != 45)) return false;
			});
			
		});
	
	</script>

<style type="text/css">
body {
	padding: 1em;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Hangman Game</h1>
		<p>Introduce a letter and start playing!</p>

		<h1>Try it</h1>

		<form id="hangmanform" class="form-inline" role="form"
			action="./session" method="post">
			<label for="letter">Letter</label> <input class="letter"
				id="letter" type="text" name="letter" maxlength="1" required /> <input
				type="submit" value="Try letter!" />
		</form>

		<hr />

		<a href="./newGame">New game</a>

		<hr />

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Attribute Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope}" var="attr">
					<tr>
						<td><c:out value="${attr.key}" /></td>
						<td><c:out value="${attr.value}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<img src="${sessionScope.img}" />"
	</div>
</body>
</html>
