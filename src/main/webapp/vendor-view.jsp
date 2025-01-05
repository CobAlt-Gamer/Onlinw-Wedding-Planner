<%@page import="com.wedding.planner.entity.States"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@page import="com.wedding.planner.entity.Vendor"%>
<%@page import="com.fasterxml.jackson.annotation.JacksonInject.Value"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%
Vendor vendor = (Vendor) request.getAttribute("vendor");
List<States> states = (List<States>) request.getAttribute("states");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>View Vendor | <%=Configurations.NAME%>
</title>
<jsp:include page="components/head-imports.jsp" />
</head>
<body>

	<div class="page">

		<!-- Navigation -->
		<jsp:include page="components/navbar.jsp" />

		<div class="page-wrapper">
			<!-- Page header -->
			<form action="/update-vendor" method="POST">
				<div class="page-header d-print-none">
					<div class="container-xl">
						<div class="row g-2 align-items-center">
							<div class="col">
								<!-- Page pre-title -->
								<div class="page-pretitle"></div>
								<h2 class="page-title">
									<a class="btn btn-ghost-primary text-decoration-none"
										href="/vendors"><i class="ti ti-arrow-narrow-left icon"></i><%=vendor.getUser().getFirstName() + " " + vendor.getUser().getLastName()%></a>
								</h2>
							</div>

							<div class="col">
								<div class="text-green bg-transparent text-uppercase fw-bold"><%=request.getAttribute("success") != null ? request.getAttribute("success") : ""%></div>
								<div class="text-green bg-transparent text-uppercase fw-bold"><%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%></div>
							</div>
							<!-- Page title actions -->
							<div class="col-auto ms-auto d-print-none small">
								<div class="me-3 mb-3">
									<label class="row"> <span class="col">Login
											Status: <span
											class='text-<%=vendor.getUser().getLoggedIn() ? "green" : "red"%> bg-transparent'><%=vendor.getUser().getLoggedIn() ? "Logged In" : "Logged Out"%></span>
									</span> <span class="col-auto"> <label
											class="form-check form-check-single form-switch"> <input
												class="form-check-input" name="loginStatus" value="true"
												type="checkbox"
												<%=vendor.getUser().getLoggedIn() ? "checked" : "disabled"%>>
										</label>
									</span>
									</label>
								</div>
								<div class="me-3 mb-3">
									<label class="row"> <span class="col">Status : <span
											class='text-<%=vendor.getUser().getStatus() ? "green" : "red"%> bg-transparent'><%=vendor.getUser().getStatus() ? "Active" : "In Active"%></span></span>
										<span class="col-auto"> <label
											class="form-check form-check-single form-switch"> <input
												class="form-check-input" name="status" value="true"
												type="checkbox"
												<%=vendor.getUser().getStatus() ? "checked" : ""%>>
										</label>
									</span>
									</label>
								</div>
								<!--  
								<div class="me-3 mb-3">
									<label class="row"> <span class="col">Delete: </span> <span
										class="col-auto"> <a
											href="/delete-vendor/<%=vendor.getVendorId()%>"
											class="btn nav-link me-2"> <i class="ti-trash ti icon"></i>
										</a>
									</span>
									</label>
								</div>
								 -->
							</div>
						</div>
					</div>
				</div>

				<!-- Page body -->
				<div class="page-body">
					<div class="container-xl">
						<div class="row row-cards">
							<div class="card">
								<div class="card-body">
									<div class="mb-3">
										<h3 class="card-title">Vendor Details</h3>
									</div>
									<div class="row row-cards">
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">First Name</label> <input
													type="text" class="form-control" placeholder="First Name"
													name="first_name" maxlength="30"
													value="<%=vendor.getUser().getFirstName()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Last Name</label> <input
													type="text" class="form-control" placeholder="Last Name"
													maxlength="30" name="last_name"
													value="<%=vendor.getUser().getLastName()%>">
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Email address</label> <input
													type="email" class="form-control" placeholder="Email"
													autocomplete="username" maxlength="30" name="email"
													value="<%=vendor.getUser().getEmail()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Phone Number</label> <input
													type="number" class="form-control" placeholder="Phone"
													maxlength="13" minlength="10" name="phone"
													value="<%=vendor.getUser().getPhone()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Password</label> <input
													type="password" class="form-control" placeholder="Password"
													autocomplete="current-password" maxlength="30"
													name="password">
											</div>
										</div>

									</div>
									<div class="hr"></div>
									<div class="mb-3">
										<h3 class="card-title">Operation Data</h3>
									</div>
									<div class="row row-cards">
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Business Name</label> <input
													type="text" class="form-control" placeholder="Business Name"
													name="business_name" value="<%=vendor.getBusinessName()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Business Contact</label> <input
													type="number" class="form-control"
													placeholder="Business Contact" name="business_contact"
													value="<%=vendor.getBusinessContact()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">GST Number</label> <input
													type="number" class="form-control"
													placeholder="GST Number" name="gst_number"
													value="<%=vendor.getGstNumber()%>" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<div class="form-label required">State</div>
												<select class="form-select" name="state" id="states"
													required>
													<option>Select State</option>
													<%
													for (States state : states) {
													%>
													<option value="<%=state.getStateId()%>"
														<%=vendor.getUser().getAddress().get(0).getCity().getState().getStateId().equals(state.getStateId()) ? "selected"
		: ""%>><%=state.getStateName()%></option>
													<%
													}
													%>
												</select>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<div class="form-label required">City</div>
												<select class="form-select" name="city" id="cities" required>
													<option
														value="<%=vendor.getUser().getAddress().get(0).getCity().getCityId()%>"><%=vendor.getUser().getAddress().get(0).getCity().getCityName()%></option>
												</select>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label required">Address Line 1</label> <input
													type="text" class="form-control" name="address_line_1"
													value="<%=vendor.getUser().getAddress().get(0).getAddressLine1()%>"
													placeholder="Address Line 1" required>
											</div>
										</div>
										<div class="col-sm-6 col-md-6">
											<div class="mb-3">
												<label class="form-label">Address Line 2</label> <input
													type="text" class="form-control" name="address_line_2"
													value="<%=vendor.getUser().getAddress().get(0).getAddressLine2()%>"
													placeholder="Address Line 2">
											</div>
										</div>
									</div>
								</div>
								<div class="card-footer d-flex justify-content-end">
									<input type="hidden" name="vendor_id"
										value="<%=vendor.getVendorId()%>" /> <input type="hidden"
										name="user_id" value="<%=vendor.getUser().getUserId()%>" /> <input
										type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<button type="submit" class="btn btn-primary">
										<i class="ti ti-user-edit icon"></i>Update
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<jsp:include page="components/footer.jsp" />
		</div>
	</div>
	<jsp:include page="components/footer-imports.jsp" />
	<script type="text/javascript" src="resources/api/vendor/vendor.js"></script>
</body>
</html>