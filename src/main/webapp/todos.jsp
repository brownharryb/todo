<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
	<div id="particles-js">
		<div class="todos-wrapper center">
			<form method="post" action="">
				<input type="text" name="activity">
				<input type="date" name="date">
				<input type="time" name="time">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit">Add Todo</button>
			</form>
			${error}
			<hr>
			${activity}
			<c:forEach items="${activities}" var="activity">
			    <div class="item">
			    	<form>
			    		<div style="padding:10px;">
				    		<input type="hidden" name="todoId">
				    		<p>${activity.activity}</p>
			    		</div>
			    		<div class="todo-actions">
			    			<button type="button" onclick="deleteActivity(${activity.todoId})">Delete</button>
			    		</div>
			    	</form>
			    </div>
			    
			</c:forEach>		
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/js/particles.min.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>