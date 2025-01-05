<%@page import="org.springframework.http.HttpStatus"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Forgot password | <%=Configurations.NAME%></title>
<jsp:include page="components/head-imports.jsp" />
</head>
<body class=" d-flex flex-column">
	<div class="page page-center">
		<div class="container container-tight py-4">
			<div class="text-center mb-4">
				<a href="#" class="navbar-brand navbar-brand-autodark"> <img
					src="<%=Configurations.LOGO%>" width="110" height="32"
					alt="<%=Configurations.NAME%>" class="navbar-brand-image">
				</a>
			</div>
			<%
			String token = (String) request.getAttribute("token");
			HttpStatus status = (HttpStatus) request.getAttribute("status");
			if (status != null && status.equals(HttpStatus.UNAUTHORIZED)) {
			%>
			<div class="caard card-md">
				<div class="card-body">
					<h2 class="card-title text-center mb-4 text-danger">Unauthorized,
						malfunctioned token detected</h2>
				</div>
			</div>
			<%
			} else if (token == null) {
			%>
			<form class="card card-md" method="post" id="password-reset-email">
				<div class="card-body">
					<h2 class="card-title text-center mb-4">Forgot Password</h2>
					<div class="mb-3">
						<label class="form-label">Email address</label> <input
							type="email" name="email" class="form-control"
							placeholder="Enter email" required>
					</div>
					<div class="mb-3 text-center" id="password-reset-email-message"></div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<div class="form-footer">
						<button type="submit" class="btn btn-primary w-100">
							<!-- Download SVG icon from http://tabler-icons.io/i/mail -->
							<i class="ti icon ti-mail"></i> send me password reset mail
						</button>
					</div>
				</div>
			</form>
			<div class="text-center text-secondary mt-3">
				Forget it, <a href="/sign-in">send me back</a> to the sign in
				screen.
			</div>
			<%
			} else {
			%>
			<form class="card card-md" method="POST" id="set-new-password">
				<div class="card-body">
					<h2 class="card-title text-center mb-4">Set New Password</h2>
					<div class="mb-3">
						<label class="form-label">Enter New Password</label> <input
							type="password" class="form-control" name="password"
							autocomplete="new-password" placeholder="Enter new password"
							required>
					</div>
					<div class="mb-3">
						<label class="form-label">Confirm New Password</label> <input
							type="password" class="form-control" name="con-password"
							autocomplete="new-password" placeholder="Confirm new password"
							required>
					</div>
					<div class="mb-3 text-center" id="set-new-password-message"></div>
					<input type="hidden" name="token" value="<%=token%>" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="form-footer">
						<button type="submit" class="btn btn-primary w-100">
							<!-- Download SVG icon from http://tabler-icons.io/i/mail -->
							<i class="ti icon ti-key"></i> Reset Password
						</button>
					</div>
				</div>
			</form>
			<div class="caard card-md" id="hidden-password-success">
				<div class="card-body">
					<h2 class="card-title text-center mb-4 text-success">Password
						Reset Successfully</h2>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<jsp:include page="components/footer-imports.jsp" />
	<script type="text/javascript">
		$("#hidden-password-success").hide();
		$(document).ready(function() {
			$("#password-reset-email").on("submit", function(e) {
				e.preventDefault();
				$.ajax({
					url : "/forgetPassword/reset-email",
					type : "POST",
					data : $(this).serialize(),
					statusCode: {
						200: () => $("#password-reset-email").trigger("reset"),
						404: () => $("#password-reset-email-message").html("<p class='text-danger'>There is no account associated with provided email</p>")
					},
					success : function(data) {
						$("#password-reset-email-message").html("<p class='text-success'>"+data+"</p>");
					},
					error:function(error){
						$("#password-reset-email-message").html("<p class='text-danger'>"+error+"</p>");
					}
				});
			});
			$("#set-new-password").on("submit",function(e){
				e.preventDefault();
				$.ajax({
					url:"/forgetPassword/set-new-password",
					type:"POST",
					data:$(this).serialize(),
					statusCode:{
						200: () => $("#set-new-password").hide(),
						404: () => $("#set-new-password-message").html("<p class='text-danger'>There is no account associated with provided email</p>")						
					},
					success : function(data) {
						$("#hidden-password-success").fadeIn("slow");
					},
					error:function(error){
						$("#set-new-password-message").html("<p class='text-danger'>"+error.responseText+"</p>");
					}
				});
			});
		});
	</script>
</body>
</html>