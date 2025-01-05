<%@page import="com.wedding.planner.entity.Vendor"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Vendor> vendorList = (List<Vendor>) request.getAttribute("vendorList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, viewport-fit=cover" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Vendors | <%=Configurations.NAME%></title>
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
							<h2 class="page-title">Vendors</h2>
						</div>
						<!-- Page title actions -->
						<div class="col-auto ms-auto d-print-none">
							<form action="vendors" method="get">
								<div class="d-flex">
									<input type="search"
										class="form-control d-inline-block w-9 me-3" name="search"
										value="<%=request.getParameter("search")!=null?request.getParameter("search"):"" %>" 
										placeholder="Search vendor " /> <button type="submit"
										class="btn btn-primary"> <!-- Download SVG icon from http://tabler-icons.io/i/search -->
										<i class="ti ti-search icon"></i> Search Vendor
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Page body -->
			<div class="page-body">
				<div class="container-xl">
					<div class="row row-cards">
						<%
						for (Vendor vendor : vendorList) {
						%>
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body p-4 text-center">
									<span class="avatar avatar-xl mb-3 rounded"
										style="background-image: url(<%=vendor.getUser().getAvatar() != null ? vendor.getUser().getAvatar().getUrl() : Configurations.LOGO_COMPACT%>)"></span>
									<h3 class="m-0 mb-1">
										<a href="vendor?vendor=<%=vendor.getVendorId()%>"><%=vendor.getBusinessName() %></a>
									</h3>
									<div class="text-secondary"><%=vendor.getUser().getFirstName() + " " + vendor.getUser().getLastName()%></div>
									<div class="mt-3">
										<span class="badge bg-purple-lt">Vendor</span>
									</div>
								</div>
								<div class="d-flex">
									<%
									if (vendor.getApproved().equals(false)) {
									%>
									<a href="vendor/approve/<%=vendor.getVendorId()%>" class="card-btn">Approve &nbsp;<i
										class="ti ti-checks icon"></i></a>
									<%
									} else {
									%>
									<a href="mailto:<%=vendor.getUser().getEmail()%>"
										class="card-btn"> <i class="ti ti-mail icon"></i>&nbsp;
										Email
									</a> <a href="tel:<%=vendor.getBusinessContact()%>"
										class="card-btn"> <i class="ti ti-phone icon"></i>&nbsp;
										Call
									</a>
									<%
									}
									%>
								</div>
							</div>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
			<jsp:include page="components/footer.jsp" />
		</div>
	</div>
	<!-- Libs JS -->
	<!-- Tabler Core -->
	<jsp:include page="components/footer-imports.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#vendors").addClass("active");
		});
	</script>

</body>

</html>