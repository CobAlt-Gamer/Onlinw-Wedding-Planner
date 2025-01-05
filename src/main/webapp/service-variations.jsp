<%@page import="com.wedding.planner.entity.ServiceVariation"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Variation - Vendors | <%=Configurations.NAME%></title>

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
							<div class="page-pretitle">Manage</div>
							<h2 class="page-title">Variations On Services</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- Page body -->
			<div class="page-body">
				<div class="container-xl">
					<div class="row g-5">
						<form class="card" id="add-service-variation">
							<div class="row">
								<div class="card-header">
									<h3 class="card-title">Add Variations</h3>
								</div>
								<div class="col-md-6">
									<div class="card-body">
										<div class="mb-3">
											<label class="form-label required">Select Service</label> <select
												class="form-select" id="select-service"
												name="select-service" required>
												<option value>Select Service</option>
											</select>
										</div>
										<div class="mb-3">
											<label class="form-label required">Select Service
												Item</label> <select class="form-select" id="select-service-item"
												name="select-service-item" required>
												<option value>Select Service First</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="card-body">
										<div class="mb-3">
											<label class="form-label required">Select Variation</label> <select
												class="form-select" id="select-variation"
												name="select-variation" required>
												<option value>Select Service First</option>
											</select>
										</div>
										<div class="mb-3">
											<label class="form-label required">Select Variation
												Option</label> <select class="form-select"
												id="select-variation-option" name="select-variation-option"
												required>
												<option value>Select Variation First</option>
											</select>
										</div>
									</div>
								</div>
								<div class="card-footer d-flex justify-content-between">
									<div class="d-none">
										<div id="add-service-variation-msg"
											class="alert alert-important alert-dismissible" role="alert">
											<div class="d-flex">
												<i class="ti-check ti icon"></i>
												<div></div>
											</div>
										</div>
									</div>
										<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
									<div class="d-flex align-items-center">
										<button type="submit" class="btn btn-primary">Submit</button>
										<div
											class="d-none spinner-show spinner-border spinner-border text-secondary ms-4"
											role="status"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<jsp:include page="components/footer.jsp"></jsp:include>

		</div>
	</div>
	<!-- Footer Imports -->
	<jsp:include page="components/footer-imports.jsp"></jsp:include>


	<script type="text/javascript" src="resources/api/manage/service-varitions.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#nav-manage").addClass("active");
			$("#service-variation").addClass("active");
		});
	</script>
</body>
</html>
