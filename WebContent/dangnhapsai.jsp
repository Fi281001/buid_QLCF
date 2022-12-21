<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
	.main{
	text-align: left;
	width: 300px;
	}
</style>
</head>
<body >
<div style="margin-top: 150px">
<div align="center">
<div class="main">
<h2 align="center">Đăng Nhập</h2>

<form action="ktdn" method="post" id="form" style="width: 350px">

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="txtun" value="">

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="txtpass" required>
    
      <div class="g-recaptcha" data-sitekey="6LdFKBMjAAAAADCYVmxuxZooLabzQ9tYmiGjONxi"></div>
      <div id="error"></div>
        
    <input style="background: darkorange" name="butdn" type="submit" value="Login">
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>
 <div class="container" style="background-color:#f1f1f1">
    <a href="dangky.jsp">Register</a>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
 <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  <script>
			window.onload = function (){
				let isValid = false;
				const form = document.getElementById("form");
				const error = document.getElementById("error");
				
				form.addEventListener("submit", function (event){
					event.preventDefault();
					const response = grecaptcha.getResponse();
					if (response){
						form.submit();
					} else {
						error.innerHTML = "Please check";
					}
				});
			}
		</script>
</div>
</div>
</div>
</body>
</html>