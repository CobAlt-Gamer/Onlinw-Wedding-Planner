<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

<title>Sign In | <%=Configurations.NAME%></title>

<jsp:include page="components/head-imports.jsp" />
</head>
<body class=" d-flex flex-column">
	<div class="page page-center">
		<div class="container container-normal py-4">
			<div class="row align-items-center g-4">
				<div class="col-lg">
					<div class="container-tight">
						<div class="text-center mb-4">
							<a href="#" class="navbar-brand navbar-brand-autodark"><img
								src="<%=Configurations.LOGO%>" height="36" alt="Tabler" class="navbar-brand-image"></a>
						</div>
						<div class="card card-md">
							<div class="card-body">
								<h2 class="h2 text-center mb-4">Login to your account</h2>
								<form action="sign-in" method="POST" autocomplete="off"
									novalidate>
									<div class="mb-3">
										<label class="form-label">Email address</label> <input
											type="email" class="form-control" name="username" id="username"
											placeholder="your@email.com" autocomplete="off">
									</div>
									<div class="mb-2">
										<label class="form-label"> Password <span
											class="form-label-description"> <a
												href="/forgetPassword">I forgot password</a>
										</span>
										</label>
										<div class="input-group input-group-flat">
											<input type="password" class="form-control" name="password"
												id="password" placeholder="Your password" autocomplete="off">
											<span class="input-group-text"> <a
												class="link-secondary text-decoration-none"
												id="showPassword" title="Show password"
												data-bs-toggle="tooltip"> <!-- Download SVG icon from http://tabler-icons.io/i/eye -->
													<i id="eye-icon" class="ti icon ti-eye"></i>
											</a>
											</span>
										</div>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<!-- 
									<div class="mb-2">
										<label class="form-check"> <input type="checkbox"
											class="form-check-input" /> <span class="form-check-label">Remember
												me on this device</span>
										</label>
									</div>
									 -->
									<div class="form-footer">
										<button type="submit" class="btn btn-primary w-100">Sign
											in</button>
									</div>
								</form>
							</div>

						</div>
						<div class="text-center text-secondary mt-3">
							Don't have account yet? <a href="/sign-up" tabindex="-1">Sign
								up</a>
						</div>
					</div>
				</div>
				<div class="col-lg d-none d-lg-block">
					<img src="static/illustrations/undraw_secure_login_pdn4.svg"
						height="300" class="d-block mx-auto" alt="">
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="components/footer-imports.jsp" />

	<script type="text/javascript">
		// Password Box Visibility 
		$(document).ready(function() {
			$("#showPassword").on("click", function() {
				if ($("#password").attr("type") == "password") {
					$("#password").attr("type", "text");
					$("#eye-icon").removeClass("ti-eye");
					$("#eye-icon").addClass("ti-eye-closed");
				} else {
					$("#password").attr("type", "password");
					$("#eye-icon").removeClass("ti-eye-closed");
					$("#eye-icon").addClass("ti-eye");
				}
			});
		});
	</script>
</body>
</html>