<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Sign In Link | <%=Configurations.NAME%></title>
<jsp:include page="components/head-imports.jsp" />
</head>

  </head>
  <body  class=" d-flex flex-column">
    <div class="page page-center">
      <div class="container container-tight py-4">
        <div class="text-center mb-4">
          <a href="." class="navbar-brand navbar-brand-autodark">
            <img src="<%=Configurations.LOGO%>" width="110" height="32" alt="Tabler" class="navbar-brand-image">
          </a>
        </div>
        <div class="text-center">
          <div class="my-5">
            <h2 class="h1">Check your inbox</h2>
            <p class="fs-h3 text-secondary">
              We've sent you a magic link to <strong>support@tabler.io</strong>.<br />
              Please click the link to confirm your address.
            </p>
          </div>
          <div class="text-center text-secondary mt-3">
            Can't see the email? Please check the spam folder.<br />
            Wrong email? Please <a href="#">re-enter your address</a>.
          </div>
        </div>
      </div>
    </div>
    <!-- Libs JS -->
    <jsp:include page="components/footer-imports.jsp" />
  </body>
</html>