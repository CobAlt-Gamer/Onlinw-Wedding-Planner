<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.wedding.planner.entity.Booking"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Booking> bookings = (List<Booking>) request.getAttribute("bookingsList");
%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>My Bookings | <%=Configurations.NAME%>
</title>
<jsp:include page="components/head-imports.jsp" />
</head>
<body>
	<div class="page">
		<!-- Navbar -->
		<jsp:include page="components/navbar.jsp"></jsp:include>
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
								<div class="card">
									<div class="card-body">
										<div class="divide-y">

											<%
											for (Booking booking : bookings) {
											%>
											<div>
												<div class="row">
													<div class="col-auto">
														<span class="avatar">AA</span>
													</div>
													<div class="col">
														<div class="text-truncate">
															<strong><%=booking.getBookedService().getItemName()%></strong>
															is Booked By <strong><%=booking.getBookedBy().getFirstName() + " " + booking.getBookedBy().getLastName()%></strong>.
														</div>
														<div class="text-secondary">
															<strong>Date Of Event: </strong>
															<%=booking.getEventDate().format(DateTimeFormatter.ofPattern("d/M/Y"))%></div>
													</div>
												</div>
											</div>
											<%
											}
											%>
										</div>
									</div>
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
	<jsp:include page="components/footer-imports.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#my-bookings").addClass("active");
			$("#settings").addClass("active");
		});
	</script>
</body>
</html>