<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ZfullLogin.SignuoDAO.SignupDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
<meta name="google-signin-client_id" content="70311988550-07tst2vdvplv5lpem4qne2sis6e22g00.apps.googleusercontent.com">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://use.fontawesome.com/bacae9e57c.js"></script>

<script>
	
$(document).ready(function() {
	$('#dummy').hide();
    $('#sign-in').click(function(event) {
    	event.preventDefault();
            var name = $('#userName').val();
            var pass = $('#userPass').val();
            $.post('Login', {
                    userName : name,
                    userPass : pass
            }, function(data) {
            	if (data.url != null){
	            	window.location.href = data.url;
            	}
            	else{
            		$('#dummy').show();
            		$('#login-response').text(data);
            		$('#dummy').text(data);
            	}
            });
    });
    
    $('#sign-up').click(function(event){
    	event.preventDefault();
    	window.location.href = "signup.jsp";
    });
});
	
function onSignIn(googleUser) {
	console.log("-----------------------------------");
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  console.log("-----------------------------------");
	  $.get("google", {
		  user: profile.getName(),
		  email: profile.getId()
	  }, function(data){
		  alert(data);
	  });
}	
	
</script>
</head>
<body class="img-fluid">
<div class = "container-fluid">
	<div class="check" id="dummy"></div>
	<div class = "row">
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12"></div>
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12 form-box">
			<form>
				<div class="login-box">
					<h1>Login</h1>
					<div class="form-group text-box">
						<i class="fa fa-user"></i><input type="text" class="form-control" placeholder="Username" name="uname" id="userName"/><br>
					</div>
					<div class="form-group text-box">
						<i class="fa fa-lock"></i><input type="password" class="form-control"  placeholder="Password" name="pass" id="userPass"/><br>
					</div>
					<button class="btn btn-primary submit-button" id="sign-in">Sign-in</button><br>
					<button class="btn btn-primary submit-button" id="sign-up">Sign-up</button>
					<div class="or-class" align="center">____________or____________</div>
					<div class="g-signin2" data-onsuccess="onSignIn" align="center"></div>
				</div>
			</form>
		</div>
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12"></div>
		
	</div>
</div><br>
	<!-- <div class = "row">
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12"></div>
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12">
			<button class="btn btn-primary submit-button" id="sign-up">Sign-up</button>
		</div>
		<div class="col-12 col-sm-4 col-md-4 col-lg-12col-xs-12"></div>
	</div>  -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>