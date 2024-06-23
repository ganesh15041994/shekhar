<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<style>
body {
	color: #000;
	overflow-x: hidden;
	height: 100%;
	background-color: #B0BEC5;
	background-repeat: no-repeat;
}

.card0 {
	box-shadow: 0px 4px 8px 0px #757575;
	border-radius: 0px;
}

.card2 {
	margin: 0px 40px;
}

.logo {
	width: 200px;
	height: 100px;
	margin-top: 20px;
	margin-left: 35px;
}

.image {
	width: 360px;
	height: 280px;
}

.border-line {
	border-right: 1px solid #EEEEEE;
}

.line {
	height: 1px;
	width: 35%;
	background-color: #E0E0E0;
	margin-top: 10px;
}

.or {
	width: 20%;
	font-weight: bold;
}

.text-sm {
	font-size: 14px !important;
}

::placeholder {
	color: #BDBDBD;
	opacity: 1;
	font-weight: 300
}

:-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

::-ms-input-placeholder {
	color: #BDBDBD;
	font-weight: 300
}

input, textarea {
	padding: 10px 12px 10px 12px;
	border: 1px solid lightgrey;
	border-radius: 2px;
	margin-bottom: 5px;
	margin-top: 2px;
	width: 100%;
	box-sizing: border-box;
	color: #2C3E50;
	font-size: 14px;
	letter-spacing: 1px;
}

input:focus, textarea:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border: 1px solid #304FFE;
	outline-width: 0;
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0;
}

a {
	color: inherit;
	cursor: pointer;
}

.btn-blue {
	background-color: #1A237E;
	width: 150px;
	color: #fff;
	border-radius: 2px;
}

.btn-blue:hover {
	background-color: #000;
	cursor: pointer;
}

.bg-blue {
	color: #fff;
	background-color: #1A237E;
}

@media screen and (max-width: 991px) {
	.logo {
		margin-left: 0px;
	}
	.image {
		width: 300px;
		height: 220px;
	}
	.border-line {
		border-right: none;
	}
	.card2 {
		border-top: 1px solid #EEEEEE !important;
		margin: 0px 15px;
	}
}
</style>
</head>
<body>

	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex">
				<div class="col-lg-6">
					<div class="card1 pb-5">
						<div class="row">
							<img src="https://i.imgur.com/CXQmsmF.png" class="logo">
						</div>
						<div class="row px-3 justify-content-center mt-4 mb-5 border-line">
							<img src="https://i.imgur.com/uNGdWHi.png" class="image">
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="card2 card border-0 px-4 py-5">

						<div class="row px-3 mb-4">
							<div class="line"></div>
							<small class="or text-center">Login </small>
							<div class="line"></div>
						</div>
						<form action="/userLogin" method="POST">
							<div class="row px-3">
								<label class="mb-1"><h6 class="mb-0 text-sm">Email
										Address</h6></label> <input class="mb-4" type="text" name="email"
									placeholder="Enter a valid email address">
							</div>
							<div class="row px-3">
								<label class="mb-1"><h6 class="mb-0 text-sm">Password</h6></label>
								<input type="password" name="password"
									placeholder="Enter password">
							</div>
							<div class="row px-3 mb-4">
								<div
									class="custom-control custom-checkbox custom-control-inline">
									<input id="chk1" type="checkbox" name="chk"
										class="custom-control-input"> <label for="chk1"
										class="custom-control-label text-sm">Remember me</label>
								</div>
								<a href="#" class="ml-auto mb-0 text-sm">Forgot Password?</a>
							</div>
							<div class="row mb-3 px-3">
								<button type="submit" class="btn btn-blue text-center">Login</button>
							</div>
						</form>
						<div class="row mb-4 px-3">
							<small class="font-weight-bold">Don't have an account? <a
								class="text-danger ">Register</a></small>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>