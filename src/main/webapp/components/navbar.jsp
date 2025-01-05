<%@page import="com.wedding.planner.entity.Users"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
Users user = (Users) pageContext.getRequest().getAttribute("currentUser");
%>
<sec:authorize access="hasAnyRole('ADMIN','VENDOR')">
	<header class="navbar navbar-expand-md d-print-none">
		<div class="container-xl">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbar-menu"
				aria-controls="navbar-menu" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<h1
				class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pe-0 pe-md-3">
				<a href="/home"> <img src="<%=Configurations.LOGO%>" width="110"
					height="32" alt="Tabler" class="navbar-brand-image" />
				</a>
			</h1>
			<div class="navbar-nav flex-row order-md-last">
				<div class="nav-item d-none d-md-flex me-3"></div>
				<div class="d-none d-md-flex">
					<a href="?theme=dark" class="nav-link px-0 hide-theme-dark"
						title="Enable dark mode" data-bs-toggle="tooltip"
						data-bs-placement="bottom"> <!-- Download SVG icon from http://tabler-icons.io/i/moon -->
						<i class="ti ti-moon icon"></i>
					</a> <a href="?theme=light" class="nav-link px-0 hide-theme-light"
						title="Enable light mode" data-bs-toggle="tooltip"
						data-bs-placement="bottom"> <!-- Download SVG icon from http://tabler-icons.io/i/sun -->
						<i class="ti ti-sun icon"></i>
					</a>
				</div>
				<div class="nav-item d-none d-md-flex me-3"></div>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link d-flex lh-1 text-reset p-0"
						data-bs-toggle="dropdown" aria-label="Open user menu"> <span
						class="avatar avatar-sm"
						style="background-image: url(<%=user.getAvatar() != null ? user.getAvatar().getUrl() : Configurations.LOGO_COMPACT%>);"></span>
						<div class="d-none d-xl-block ps-2">
							<sec:authorize access="isAuthenticated()">
								<div class="d-none d-xl-block ps-2">
									<div>
										<%=user.getFirstName() + " " + user.getLastName()%>
									</div>
									<div class="mt-1 small text-secondary">
										<sec:authentication property="principal.authorities" />
									</div>
								</div>
							</sec:authorize>
						</div>
					</a>
					<div class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
						<a href="/my-account" id="settings" class="dropdown-item">Settings</a>
						<form action="/logout" method="POST">
							<button class="dropdown-item">Logout</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</header>
	<header class="navbar-expand-md">
		<div class="collapse navbar-collapse" id="navbar-menu">
			<div class="navbar">
				<div class="container-xl">
					<ul class="navbar-nav">
						<li class="nav-item" id="nav-home"><a class="nav-link"
							href="/home"> <span
								class="nav-link-icon d-md-none d-lg-inline-block"> <!-- Download SVG icon from http://tabler-icons.io/i/home -->
									<i class="ti icon ti-home"></i>
							</span> <span class="nav-link-title"> Home </span>
						</a></li>
						<li class="nav-item dropdown" id="nav-manage"><a
							class="nav-link dropdown-toggle" href="#navbar-base"
							data-bs-toggle="dropdown" data-bs-auto-close="outside"
							role="button" aria-expanded="false"> <span
								class="nav-link-icon d-md-none d-lg-inline-block"> <!-- Download SVG icon from http://tabler-icons.io/i/package -->
									<i class="ti icon ti-package"></i>
							</span> <span class="nav-link-title"> Manage </span>
						</a>
							<div class="dropdown-menu">
								<div class="dropdown-menu-columns">
									<sec:authorize access="hasRole('ADMIN')">
										<div class="dropdown-menu-column">
											<a class="dropdown-item" id="service-categories"
												href="/service-categories"> Service Categories </a> <a
												class="dropdown-item" id="variations" href="/variations">
												Variations </a>
										</div>
									</sec:authorize>
									<sec:authorize access="hasAnyRole('ADMIN','VENDOR')">
										<div class="dropdown-menu-column">
											<a class="dropdown-item" id="services" href="/services">
												Services </a> <a class="dropdown-item" id="service-variation"
												href="/service-variation">Services Variations</a>
										</div>
									</sec:authorize>
								</div>
							</div></li>
						<sec:authorize access="hasRole('ADMIN')">
							<li class="nav-item" id="vendors"><a class="nav-link"
								href="/vendors"> <span
									class="nav-link-icon d-md-none d-lg-inline-block"> <!-- Download SVG icon from http://tabler-icons.io/i/briefcase -->
										<i class="ti icon ti-briefcase"></i>
								</span> <span class="nav-link-title"> Vendors </span>
							</a></li>
							<li class="nav-item" id="users"><a class="nav-link"
								href="/users"> <span
									class="nav-link-icon d-md-none d-lg-inline-block"> <!-- Download SVG icon from http://tabler-icons.io/i/users -->
										<i class="ti icon ti-users"></i>
								</span> <span class="nav-link-title"> Users </span>
							</a></li>
						</sec:authorize>
						<li class="nav-item dropdown" id="help"><a
							class="nav-link dropdown-toggle" href="#navbar-help"
							data-bs-toggle="dropdown" data-bs-auto-close="outside"
							role="button" aria-expanded="false"> <span
								class="nav-link-icon d-md-none d-lg-inline-block"> <!-- Download SVG icon from http://tabler-icons.io/i/lifebuoy -->
									<i class="ti icon ti-lifebuoy"></i>
							</span> <span class="nav-link-title"> Help </span>
						</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" target="_blank"
									href="https://documenter.getpostman.com/view/27911410/2sA2xcbb4T"
									id="documentation"> Documentation </a>
								<sec:authorize access="hasRole('ADMIN')">
									<button class="dropdown-item" id="reset-cache"> Reset Cache
									</button>
								</sec:authorize>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</header>
</sec:authorize>