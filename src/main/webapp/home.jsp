<%@page import="com.wedding.planner.dto.StatisticsDTO"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
StatisticsDTO statistics= (StatisticsDTO) request.getAttribute("statistics");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Dashboard | <%=Configurations.NAME%> </title>
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
                <!-- Page pre-title -->
                <div class="page-pretitle">Overview</div>
                <h2 class="page-title">Dashboard</h2>
              </div>
            </div>
          </div>
        </div>
        <!-- Page body -->
        <div class="page-body">
          <div class="container-xl">
            <div class="row row-deck row-cards">              
              <div class="col-12">
                <div class="row row-cards">
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-primary text-white avatar">
                              <!-- Download SVG icon from http://tabler-icons.io/i/currency-rupee -->
                              <i class="ti-users ti icon"></i>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium"><%=statistics.users() %> Users</div>
                            <div class="text-secondary">
                              <%=statistics.newUsers() %> new users
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-green text-white avatar">
                              <!-- Download SVG icon from http://tabler-icons.io/i/shopping-cart -->
                              <i class="ti-briefcase ti icon"></i>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium"><%=statistics.vendors() %> Vendor</div>
                            <div class="text-secondary"><%=statistics.approvedVendors() %> Approved</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-primary text-white avatar">
                              <!-- Download SVG icon from http://tabler-icons.io/i/share -->
                              <i class="ti-settings ti icon"></i>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium"><%=statistics.services() %> Services</div>
                            <div class="text-secondary"><%=statistics.activeServices() %> Active</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-info text-white avatar">
                              <!-- Download SVG icon from http://tabler-icons.io/i/new-section -->
                              <i class="ti-new-section ti icon"></i>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium">
                              Comming Soon...
                            </div>
                            <div class="text-secondary">-</div>
                          </div>
                        </div>
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

    <jsp:include page="components/footer-imports.jsp" />

      <script type="text/javascript">
      $(document).ready(function () {
        $("#nav-home").addClass("active");
      });
    </script>
  </body>
</html>
