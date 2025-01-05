<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><%=Configurations.NAME%></title>
<link href="resources/css/tabler.min.css" rel="stylesheet" />
<style>
@import url('https://rsms.me/inter/inter.css');

:root {
	--tblr-font-sans-serif: 'Inter Var', -apple-system, BlinkMacSystemFont,
		San Francisco, Segoe UI, Roboto, Helvetica Neue, sans-serif;
}

body {
	font-feature-settings: "cv03", "cv04", "cv11";
}
</style>
</head>
<body>
	<div class="page">
		<div class="page-wrapper">
			<!-- Page body -->
			<div class="page-body">
				<div class="container-xl d-flex flex-column justify-content-center">
					<div class="empty">
						<div class="empty-img">
							<img src="static/illustrations/undraw_printing_invoices_5r4r.svg"
								height="128" alt="">
						</div>
						<p class="empty-title">Opps !</p>
						<p class="empty-subtitle text-secondary fw-bold">
							<%=request.getAttribute("error") != null ? request.getAttribute("error") : "An Unknown Error Occurred"%>
						</p>
						<div class="empty-action">
							<a href="/home" class="btn btn-primary"> <svg
									xmlns="http://www.w3.org/2000/svg" class="icon" width="24"
									height="24" viewBox="0 0 24 24" stroke-width="2"
									stroke="currentColor" fill="none" stroke-linecap="round"
									stroke-linejoin="round">
									<path stroke="none" d="M0 0h24v24H0z" fill="none" />
									<path d="M5 12l14 0" />
									<path d="M5 12l6 6" />
									<path d="M5 12l6 -6" /></svg> Take me home
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="components/footer-imports.jsp"></jsp:include>
</body>
</html>