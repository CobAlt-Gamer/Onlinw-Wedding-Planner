<%@page import="com.wedding.planner.entity.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Users> userList = (List<Users>) request.getAttribute("userList");
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
							<h2 class="page-title">Users</h2>
						</div>
						<!-- Page title actions -->
						<div class="col-auto ms-auto d-print-none">
							<form action="users" method="get">
								<div class="d-flex">
									<input type="search"
										class="form-control d-inline-block w-9 me-3" name="search"
										placeholder="Search User" value="<%=request.getParameter("search")!=null?request.getParameter("search"):"" %>" />
									<button type="submit" class="btn btn-primary">
										<!-- Download SVG icon from http://tabler-icons.io/i/search -->
										<i class="ti ti-search icon"></i> Search User   
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
						for (Users user : userList) {
						%>
						<div class="col-md-6 col-lg-3">
							<div class="card">
								<div class="card-body p-4 text-center">
									<span class="avatar avatar-xl mb-3 rounded"
										style="background-image: url(<%=user.getAvatar() != null ? user.getAvatar().getUrl() : Configurations.LOGO_COMPACT%>)"></span>
									<h3 class="m-0 mb-1">
										<span><%=user.getFirstName() + " " + user.getLastName()%></span>
									</h3>
									<div class="mt-3">
										<span class="badge bg-green-lt">User</span>
									</div>
								</div>
								<div class="d-flex flex-wrap">
									<%
									if (user.getEmail() != null) {
									%>
									<a href="mailto:<%=user.getEmail()%>" class="card-btn"> <i
										class="ti ti-mail icon"></i>&nbsp; Email
									</a>
									<%
									}
									if (user.getPhone() != null) {
									%>
									<a href="tel:<%=user.getPhone()%>" class="card-btn"> <i
										class="ti ti-phone icon"></i>&nbsp; Call
									</a>
									<%
									}
									%>
									<a
										href="user/<%=user.getStatus() ? "block" : "unblock"%>/<%=user.getUserId()%>"
										class="card-btn"> <i
										class="ti ti-<%=user.getStatus() ? "x" : "checks"%> icon"></i>&nbsp;
										<%=user.getStatus() ? "Block" : "Unblock"%>
									</a>
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
			$("#users").addClass("active");
		});
	</script>

</body>

</html>