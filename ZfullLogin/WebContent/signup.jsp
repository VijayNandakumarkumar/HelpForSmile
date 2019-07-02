<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/login.css">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://use.fontawesome.com/bacae9e57c.js"></script>
	<title>Insert title here</title>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#dummy1').hide();
			$("#sign-up").click(function(event){
				event.preventDefault();
				var n = $('#uname1').val();
				var i = $('email1').val();
				var p1 = $('#pword1').val();
				var p2 = $('#pword2').val();
				$.post('Signup', {
					idd: i,
					namee: n,
					pwdd: p1,
					pwddd: p2
				}, function(data){
					if (data.message != null){
						$('#dummy1').show();
						$('#dummy1').text(data.message);
						if(data.url == "login.jsp"){
							window.location.href = data.url;
						}
					}
					else{
						window.location.href = data.url;
					}
            	});
				});	
			});
	</script>
</head>
<body>

	<div class = "container-fluid">
	<div class="check1" id="dummy1"></div>
		<div class = "row">
			<div class="col-0 col-sm-0 col-sd-0 col-lg-4 col-xs-4"></div>
			<div class="col-0 col-sm-0 col-sd-0 col-lg-4 col-xs-4 form-box">
				<form>
					<div class="signup-box">
						<h1>Sign-up</h1>
						<div class="form-group text-box">
							<input type="text" name="username1" id="uname1" placeholder="username"/>
						</div>
						<div class="form-group text-box">
							<input type="text" name="emailid1" id="email1" placeholder="username@mail.com"/>
						</div>
						<div class="form-group text-box">
							<input type="password" name="pwd1" id="pword1" placeholder="password"/>
						</div>
						<div class="form-group text-box">
							<input type="password" name="pwd2" id="pword2" placeholder="password"/>
						</div>
						<button class="btn btn-primary submit-button" id="sign-up">Sign-up</button><br>
					</div>
				</form>
			</div>
			<div class="col-0 col-sm-0 col-sd-0 col-lg-4 col-xs-4"></div>
		</div>
	</div>
</body>
</html>