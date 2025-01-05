<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Logs | <%=Configurations.NAME%>
</title>
<jsp:include page="components/head-imports.jsp" />
</head>

<body>
	<div class="page">
		<!-- Navbar -->
		<jsp:include page="components/navbar.jsp"/>
		
			<div class="page-wrapper">
				<!-- Page header -->
				<div class="page-header d-print-none">
					<div class="container-xl">
						<div class="row g-2 align-items-center">
							<div class="col">
								<h2 class="page-title">Logs</h2>
							</div>
						</div>
					</div>
				</div>
				<!-- Page body -->
				<div class="page-body">
					<div class="container-xl">
						<div class="card">
							<div class="card-body">
								<h4>Checked URL</h4>
								<div>
									<pre>
									<code>GET <a class="text-reset" target="_blank"
												href="https://tabler.io/demo">https://tabler.io/demo</a>
									</code>
								</pre>
								</div>
								<h4>Request Timing</h4>
								<div>
									<pre>Effective URL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
											class="text-reset" target="_blank"
											href="https://tabler.io/demo">https://tabler.io/demo</a><br>Redirect count&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0<br>Name lookup time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.4e-05<br>Connect time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0.000521<br>Pre-transfer time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0.0<br>Start-transfer time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0.0<br>App connect time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0.0<br>Redirect time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0.0<br>Total time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;28.000601<br>Response code&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0<br>Return keyword&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;operation_timedout</pre>
								</div>
								<h4>Response Headers</h4>
								<div>
									<pre>HTTP/1.1 200 Connection established</pre>
								</div>
							</div>
							<div class="card-footer">
								<h4>Escalation</h4>
								<div>Entire team</div>
							</div>
						</div>
					</div>
				</div>
				
				<jsp:include page="components/footer.jsp" />

			</div>
			</div>

	<jsp:include page="components/footer-imports.jsp" />

	
	<script type="text/javascript">
		$(document).ready(function () {
		  $("#help").addClass("active");
		  $("#logs").addClass("active");
		});
	  </script>
</body>

</html>