<%@page import="com.wedding.planner.repository.VendorRepository"%>
<%@page import="com.wedding.planner.entity.Vendor"%>
<%@page import="com.wedding.planner.enums.UserRole"%>
<%@page import="com.wedding.planner.entity.Users"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
Users user = (Users) request.getAttribute("user");
Vendor isVendor = (Vendor) request.getAttribute("vendor");
%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>Settings | <%=Configurations.NAME%>
</title>
<jsp:include page="components/head-imports.jsp" />
</head>
<body>
	<div class="page">
		<!-- Navbar -->
		<jsp:include page="components/navbar.jsp" />

		<div class="page-wrapper">
			<!-- Page header -->
			<div class="page-header d-print-none">
				<div class="container-xl">
					<div class="row g-2 align-items-center">
						<div class="col">
							<h2 class="page-title">Account Settings</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- Page body -->
			<div class="page-body">
				<div class="container-xl">
					<div class="card">
						<div class="row g-0">
							<div class="col-12 col-md-3 border-end">
								<jsp:include page="components/settings-sidebar.jsp" />
							</div>
							<div class="col-12 col-md-9 d-flex flex-column">
								<div class="card-body">
									<h2 class="mb-4">My Account</h2>
									<h3 class="card-title">Profile Details</h3>
									<div class="row align-items-center">
										<div class="col-auto">
											<span class="avatar avatar-xl" id="current-avatar"
												style="background-image: url(<%=user.getAvatar() != null ? user.getAvatar().getUrl() : Configurations.LOGO_COMPACT%>)"></span>
										</div>
										<div class="col-auto">
											<form method="POST" id="change-avatar" class="d-flex">
												<input type="file" class="form-control" id="user-avatar"
													name="user-avatar" required /> <input type="hidden"
													name="${_csrf.parameterName}" value="${_csrf.token}" />
												<button type="submit" class="btn ms-3 btn-outline-primary">Change
													avatar</button>
											</form>
										</div>
									</div>
									<h3 class="card-title mt-4"><%=user.getRole().equals(UserRole.ADMIN) ? "Admin" : "Vendor"%>
										Profile
									</h3>
									<form
										id="<%=user.getRole().equals(UserRole.VENDOR) ? "update-vendor" : "update-user"%>">
										<div class="row g-3">
											<div class="col-md">
												<div class="form-label">First Name</div>
												<input type="text" class="form-control" name="first_name"
													id="first_name" value="<%=user.getFirstName()%>" required>
											</div>
											<div class="col-md">
												<div class="form-label">Last Name</div>
												<input type="text" class="form-control" name="last_name"
													id="last_name" value="<%=user.getLastName()%>" required>
											</div>
											<sec:authorize access="hasRole('VENDOR')">
												<div class="col-md">
													<div class="form-label">GST ID</div>
													<input type="text" class="form-control" name="gst_number"
														id="gst_number" value="<%=isVendor.getGstNumber()%>"
														required>
												</div>

											</sec:authorize>
										</div>
										<sec:authorize access="hasRole('VENDOR')">
											<h3 class="card-title mt-4">Address Details</h3>
											<div class="row g3">
												<div class="col-md">
													<div class="form-label">Location</div>
													<input type="text" class="form-control"
														name="address_line_1" id="address_line_1"
														value="<%=user.getAddress().get(0).getAddressLine1()%>"
														required>
												</div>
												<div class="col-md">
													<div class="form-label">Location</div>
													<input type="text" class="form-control"
														name="address_line_2" id="address_line_2"
														value="<%=user.getAddress().get(0).getAddressLine2()%>"
														required>
												</div>
												<input type="hidden" name="address_id"
													value="<%=user.getAddress().get(0).getAddressId()%>" />
											</div>
										</sec:authorize>
										<h3 class="card-title mt-4">Email</h3>
										<p class="card-subtitle">This contact will be shown to
											others publicly, so choose it carefully.</p>
										<div>
											<div class="row g-2">
												<div class="col-auto">
													<input type="text" class="form-control w-auto" name="email"
														id="email" value="<%=user.getEmail()%>" required>
												</div>
											</div>
										</div>

										<h3 class="card-title mt-4">Password</h3>
										<p class="card-subtitle">Type your new password here</p>
										<div class="col-auto">
											<input type="text" class="form-control w-auto" id="password"
												name="password" placeholder="Password" />
										</div>

										<sec:authorize access="hasRole('VENDOR')">
											<h3 class="card-title mt-4">Accept Orders</h3>
											<p class="card-subtitle">accept the Orders for the
												services provided by you</p>
											<div>
												<label class="form-check form-switch form-switch-lg">
													<input class="form-check-input" type="checkbox"
													value="true" name="accepting_orders"
													<%=isVendor.getAcceptOrders() ? "checked" : ""%>> <span
													class="form-check-label form-check-label-on">You're
														currently Accepting Orders</span> <span
													class="form-check-label form-check-label-off">You're
														currently Not Accepting Orders</span>
												</label>
											</div>
											<input type="hidden" name="vendor_id"
												value="<%=isVendor.getVendorId()%>">
										</sec:authorize>
										<div class="card-footer bg-transparent mt-3">
											<div
												class="btn-list justify-content-between aliogn-items-center">
												<input type="hidden" name="user_id"
													value="<%=user.getUserId()%>">
												<div id="update-message"></div>
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" />
												<button type="submit" class="btn btn-primary">
													Submit</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="components/footer.jsp" />
		</div>

	</div>
	<!-- Libs JS -->
	<!-- Tabler Core -->
	<jsp:include page="components/footer-imports.jsp" />

	<script type="text/javascript"
		src="resources/api/account/my-account.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#my-account").addClass("active");
			$("#settings").addClass("active");
		});
	</script>
</body>
</html>