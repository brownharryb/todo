$(document).ready(function(){
		enableParticleJs();
		loginSignFormSwith();
		enableTodoCheck();
});


var enableTodoCheck = function(){
	$(".activity-checkbox").on("change", function(e){
		var activityid = $(e.target).data("activityid");
		var done = $(e.target).prop("checked");
		$.ajax({
			url:"/marktododone",
			data:{"activity_id":activityid,
					"done":done},
			success:function(r){
				if(r !== null && r.done != null){
					$(e.target).toggleClass("item__checkbox__done", r.done);
				}
			},
			error:function(err){
				console.log(err);
			}
		});
	});
}

var loginSignFormSwith = function(){
	$('.message a').click(function(){
		   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
		});
}

var enableParticleJs = function(){
	particlesJS.load('particles-js',"/static/js/particlesjs.json");
}


var deleteActivity = function(todoId){
	$.ajax({
		url:"/deletetodo",
		data:{"activity_id":todoId},
		success:function(r){
			window.location.href = "/";
		},
		error:function(err){
			console.log(err);
		}
	});
}

var registerUser = function(){
	var data = $(".register-form").serializeArray();	
	$.ajax({
		url:"/register",
		data:data,
		success:function(r){
			if(r.error != ""){
				$(".register-form .form-err").html(r.error);
			}else{
				alert("User created!!");
				window.location.href = "/";
			}
		},
		error:function(err){
			console.log(err);
		}
	});
}


var config = {
		  "particles": {
			    "number": {
			      "value": 80,
			      "density": {
			        "enable": true,
			        "value_area": 800
			      }
			    },
			    "color": {
			      "value": "#ffffff"
			    },
			    "shape": {
			      "type": "circle",
			      "stroke": {
			        "width": 0,
			        "color": "#000000"
			      },
			      "polygon": {
			        "nb_sides": 5
			      },
			      "image": {
			        "src": "img/github.svg",
			        "width": 100,
			        "height": 100
			      }
			    },
			    "opacity": {
			      "value": 0.5,
			      "random": false,
			      "anim": {
			        "enable": false,
			        "speed": 1,
			        "opacity_min": 0.1,
			        "sync": false
			      }
			    },
			    "size": {
			      "value": 10,
			      "random": true,
			      "anim": {
			        "enable": false,
			        "speed": 80,
			        "size_min": 0.1,
			        "sync": false
			      }
			    },
			    "line_linked": {
			      "enable": true,
			      "distance": 300,
			      "color": "#ffffff",
			      "opacity": 0.4,
			      "width": 2
			    },
			    "move": {
			      "enable": true,
			      "speed": 12,
			      "direction": "none",
			      "random": false,
			      "straight": false,
			      "out_mode": "out",
			      "bounce": false,
			      "attract": {
			        "enable": false,
			        "rotateX": 600,
			        "rotateY": 1200
			      }
			    }
			  },
			  "interactivity": {
			    "detect_on": "canvas",
			    "events": {
			      "onhover": {
			        "enable": false,
			        "mode": "repulse"
			      },
			      "onclick": {
			        "enable": true,
			        "mode": "push"
			      },
			      "resize": true
			    },
			    "modes": {
			      "grab": {
			        "distance": 800,
			        "line_linked": {
			          "opacity": 1
			        }
			      },
			      "bubble": {
			        "distance": 800,
			        "size": 80,
			        "duration": 2,
			        "opacity": 0.8,
			        "speed": 3
			      },
			      "repulse": {
			        "distance": 400,
			        "duration": 0.4
			      },
			      "push": {
			        "particles_nb": 4
			      },
			      "remove": {
			        "particles_nb": 2
			      }
			    }
			  },
			  "retina_detect": true
			}