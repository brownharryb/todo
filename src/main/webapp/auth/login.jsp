<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Todo App</title>
<link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
	<div id="particles-js">
		<div class="login-page center">
			<div class="form">
				<form class="register-form" action="/register" method="post">
				<p class="form-err"></p>
					<input type="text" placeholder="name" name="username" /> <input type="password"
						placeholder="password" name="password" />
					<button onclick="registerUser()" type="button">create</button>
					<p class="message">
						Already registered? <a href="#">Sign In</a>
					</p>
					<p class="message">${userCount} out of 5 allowed users</p>
				</form>
				<form class="login-form" method="post" action="/login">
					<p class="form-err">${error}</p>
					<input type="text" name="username" placeholder="Username" /> <input
						type="password" name="password" placeholder="Password" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button type=submit">Login</button>
					<p class="message">
						Not registered? <a href="#">Create an account</a>
					</p>
				</form>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="/static/js/particles.min.js"></script>
	<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>