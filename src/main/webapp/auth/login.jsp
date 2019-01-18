<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
	<div id="particles-js">
		<div class="form-wrapper center">
			<form action="/login" method="post">
				${error}
				<div><input type="text" name="username" placeholder="Username"/></div>
				<div><input type="password" name="password" placeholder="Password"/></div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" value="Login"/>
			</form>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/js/particles.min.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>