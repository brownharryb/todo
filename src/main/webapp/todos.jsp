<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo List | Todo App</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Hind:400,500,600&amp;subset=latin-ext" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/todomain.css">
<link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
	<div id="particles-js">
	<main class="app center">
  <nav class="nav">
    <a href="/" class="nav__item active">Todo List</a>
  </nav>
  <div class="add">
    <form method="post" action="">
    			<p class="form-err" style="margin-left:25px;margin-bottom:10px;">${error}</p>
				<input class="add__input" type="text" name="activity" placeholder="+ Add todo item">
				<input type="date" class="add__input" name="date">
				<input type="time" class="add__input" name="time">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button class="btn btn-success" type="submit" style="width:100%;">Add Todo</button>
			</form>
  </div>

  
  <ul class="list">
  <c:forEach items="${activities}" var="activity">
  	<li class="item">
      <label class="item__checkbox item__checkbox--3">
      	<input class="activity-checkbox" data-activityid="${activity.todoId}" type="checkbox" <c:if test="${activity.done}">checked</c:if> />
      		<i class="fas fa-check"></i>
      </label>
      <div>
      	<p class="todo-activity-text">${activity.activity}</p>
      	<small class="datetime-info">${activity.datetime}</small>
      </div>
      	
      <button class="item__delete" onclick="deleteActivity(${activity.todoId})" >
      	<i class="fas fa-trash-alt">
      </i></button>
    </li>			    
</c:forEach>
  </ul>
</main>
		<div class="todos-wrapper center">
			${error}
			<hr>
			
			
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
<div class="logout-btn" onclick="window.location.href='/logout';"><i class="fas fa-sign-out-alt"></i></div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous"></script>
<script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/particles.min.js"></script>
<script type="text/javascript" src="/static/js/todomain.js"></script>
<script type="text/javascript" src="/static/js/main.js"></script>
</body>
</html>