<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, viewport-fit=cover" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Page 404 | <%=Configurations.NAME%></title>
<!-- CSS files -->
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
<body class=" border-top-wide border-primary d-flex flex-column">
	<script src="resources/js/demo-theme.min.js?1692870487"></script>

	<div class="page page-center">
		<div class="container-tight py-4">
			<div class="empty">
				<div class="empty-header">404</div>
				<p class="empty-title">Oops ! You just found an error page</p>
				<p class="empty-subtitle text-secondary">We are sorry but the
					page you are looking for was not found</p>
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
</body>
</html>