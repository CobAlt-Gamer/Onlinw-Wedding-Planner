<%@page import="com.wedding.planner.entity.ServiceCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.entity.Services"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Services> services = (List<Services>) request.getAttribute("services");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Services | <%=Configurations.NAME%></title>
<jsp:include page="components/head-imports.jsp" />

<style type="text/css">
.custom-file-upload {
	display: flex;
	align-items: center;
	border: 1px solid #ccc;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

.custom-file-upload input[type="file"] {
	display: none;
}

.custom-file-upload label {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
	transition: all 0.2s ease-in-out;
}

.custom-file-upload i {
	font-size: 20px;
	margin-right: 10px;
}

#file-list {
	list-style: none;
	padding: 0;
	margin: 0;
}

#file-list li {
	margin-bottom: 5px;
}

#file-list span {
	margin-left: 10px;
}
</style>
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
							<h2 class="page-title">Services</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- Page body -->
			<div class="page-body">

				<div class="container-xl">
					<div class="row g-5">
						<div class="col-xl-6">
							<form class="card" id="add-service">
								<div class="card-header">
									<h3 class="card-title">Add Service</h3>
								</div>
								<div class="card-body">
									<div class="mb-3">
										<label class="form-label required">Service Name</label>
										<div>
											<input type="text" class="form-control" name="service-name"
												placeholder="Enter Service" required />
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label required">Service Location</label>
										<div>
											<input type="text" class="form-control"
												name="service-location" placeholder="Enter Service Location"
												required />
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label required">Select Service
											Category</label> <select class="form-select" id="service-category"
											name="service-category" required>
											<option value>Select Service Category</option>
										</select>
									</div>
									<div class="mb-3">
										<label class="form-label required">Service Description</label>
										<div>
											<textarea class="form-control" rows="6"
												id="service-description" name="service-description"
												placeholder="Service  Description!" required></textarea>
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label">Status</label>
										<div class="d-flex justify-content-around">
											<label class="form-check"> <input
												class="form-check-input" name="service-status" value="1"
												type="radio" checked required /> <span
												class="form-check-label">Active</span>
											</label> <label class="form-check"> <input
												class="form-check-input" name="service-status" type="radio"
												value="0" required /> <span class="form-check-label">In
													Active</span>
											</label>
										</div>
									</div>
								</div>
								<div class="card-footer d-flex justify-content-between">
									<div class="d-none">
										<div id="add-service-msg"
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
							</form>

						</div>

						<div class="col-xl-6">
							<form class="card dropzone" id="add-service-item">
								<div class="card-header">
									<h3 class="card-title">Add Service Item</h3>
								</div>
								<div class="card-body">
									<div class="mb-3">
										<label class="form-label required">Select Service</label> <select
											class="form-select" id="select-service" name="select-service"
											required>
											<option value>Select Service</option>
										</select>
									</div>
									<div class="mb-3">
										<label class="form-label required">Service Item Name</label>
										<div>
											<input type="text" class="form-control"
												placeholder="Enter Service Item Name"
												name="service-item-name" required />
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label required">Approx. Price</label>
										<div class="input-group">
											<span class="input-group-text"> <i
												class="ti ti-currency-rupee icon"></i>
											</span> <input type="number" class="form-control"
												name="service-item-price" placeholder="Price"
												autocomplete="off" required />
										</div>
									</div>
									<div class="mb-3">
										<div class="card custom-file-upload">
											<div class="card-header">
												<input type="file" id="file-input" multiple accept="image/*"
													name="item-images"> <label
													class="btn btn-outline-primary" for="file-input"> <i
													class="ti icon ti-upload"></i> <span>Select Files</span>
												</label>
											</div>
											<div class="card-body">
												<ul id="file-list"></ul>
											</div>
											<div class="card-footer" id="file-list-alert"></div>
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label required">Status</label>
										<div class="d-flex justify-content-around">
											<label class="form-check"> <input
												class="form-check-input" name="service-item-status"
												value="1" type="radio" checked required /> <span
												class="form-check-label">Active</span>
											</label> <label class="form-check"> <input
												class="form-check-input" name="service-item-status"
												type="radio" value="0" required /> <span
												class="form-check-label">In Active</span>
											</label>
										</div>
									</div>
								</div>
								<div class="card-footer text-end">
									<div class="d-none">
										<div id="add-service-item-msg"
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
							</form>
						</div>



						<div class="col-md-12 mt-5">
							<div class="card">
								<div class="card-body">
									<div id="table-default" class="table-responsive">


										<table class="table">
											<thead>
												<tr>
													<th><button class="table-sort" data-sort="sort-id">Id</button></th>
													<th><button class="table-sort" data-sort="sort-name">Service
															Name</button></th>
													<th><button class="table-sort"
															data-sort="sort-description">Description</button></th>

													<th><button class="table-sort"
															data-sort="sort-created">Created By</button></th>
													<th><button class="table-sort" data-sort="sort-status">Status</button></th>
													<th><button class="table-sort"
															data-sort="sort-actions">Actions</button></th>
												</tr>
											</thead>
											<tbody class="table-tbody">
												<%
												for (Services service : services) {
												%>
												<tr>
													<td class="sort-id" class="text-secondary"><%=service.getServiceId()%></td>
													<td class="sort-name"><div class="flex-fill">
															<div class="font-weight-medium"><%=service.getServiceName()%></div>
														</div></td>
													<td class="sort-description">
														<div class="d-flex py-1 align-items-center">
															<div class="flex-fill">
																<div class="font-weight-medium">
																	<%=
																	service.getServiceDescription().length() > 20
																		? service.getServiceDescription().substring(0, 20)+"..."
																		: service.getServiceDescription()
																	%>
																</div>
															</div>
														</div>
													</td>
													<td class="sort-created">
														<div class="d-flex py-1 align-items-center">
															<div class="flex-fill">
																<div class="font-weight-medium"><%=service.getCreatedBy() != null ? service.getCreatedBy().getBusinessName() : "Admin"%></div>
															</div>
														</div>
													</td>
													<td class="sort-status">
														<div class="d-flex py-1 align-items-center">
															<div class="flex-fill">
																<div class="font-weight-medium">
																	<span
																		class="badge me-1 <%=service.getStatus() ? "bg-success" : "bg-danger"%>"></span>&nbsp;<%=service.getStatus() ? "Active" : "In Active"%></div>
															</div>
														</div>
													</td>

													<td class="sort-actions"><div
															class="btn-list flex-nowrap">

															<button data-service-id="<%=service.getServiceId()%>"
																data-service-name="<%=service.getServiceName()%>"
																data-service-description="<%=service.getServiceDescription()%>"
																data-status="<%=service.getStatus()%>"
																data-category="<%=service.getServicecategory().getServiceCategoryId()%>"
																class="btn edit-service" data-bs-toggle="modal"
																data-bs-target="#modal-edit">Edit</button>
															<button data-service-id="<%=service.getServiceId()%>" data-csrf="${_csrf.token}"
																class="btn delete-service">Delete</button>
														</div></td>
												</tr>
												<%
												}
												%>
											</tbody>
											<tfoot>
												<tr>
													<th><button class="table-sort" data-sort="sort-id">Id</button></th>
													<th><button class="table-sort" data-sort="sort-name">ServiceName</button></th>
													<th><button class="table-sort"
															data-sort="sort-description">Description</button></th>
													<th><button class="table-sort"
															data-sort="sort-created">Created By</button></th>
													<th><button class="table-sort" data-sort="sort-status">Status</button></th>
													<th><button class="table-sort"
															data-sort="sort-actions">Actions</button></th>
												</tr>
											</tfoot>
										</table>
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

	<!-- Models -->

	<!-- edit Service Model -->
	<div class="modal modal-blur fade" id="modal-edit" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form id="edit-service-form">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Edit Service</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="mb-3">
							<label class="form-label required">Service Name</label> <input
								type="text" name="edit-service-name" id="edit-service-name"
								placeholder="Service Name" class="form-control" required />
						</div>
						<div class="mb-3">
							<label class="form-label required">Select Service
								Category</label> <select class="form-select" id="edit-service-category"
								name="edit-service-category" required>
								<option value>Select Service</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label required">Service Description</label>
							<div>
								<textarea class="form-control" rows="6"
									id="edit-service-description" name="edit-service-description"
									placeholder="Service Description!" required></textarea>
							</div>
						</div>
						<div class="mb-5">
							<label class="form-label">Status</label>
							<div class="d-flex justify-content-around">
								<label class="form-check"> <input
									class="form-check-input" name="edit-service-status"
									id="edit-service-active" value="1" type="radio" checked
									required /> <span class="form-check-label">Active</span>
								</label> <label class="form-check"> <input
									class="form-check-input" name="edit-service-status"
									id="edit-service-inactive" value="0" type="radio" /><span
									class="form-check-label">In Active</span>
								</label>
							</div>
						</div>
						<div class="mb-3">
							<h3 class="h3 border-bottom">Service Items</h3>
						</div>

						<div class="mb-3">
							<div id="table-service-items-wrapper" class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-service-item-id">Service Item Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-service-item-name">Service Item
													Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</thead>
									<tbody id="model-table-body"
										class="table-tbody table-service-item-body">
										<!-- Dynamic Binding -->
									</tbody>
									<tfoot>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-service-item-id">Service Item Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-service-item-name">service Item
													Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>

						<div class="mb-3">
							<div class="d-none">
								<div id="edit-service-msg"
									class="alert alert-important alert-dismissible" role="alert">
									<div class="d-flex">
										<i class="ti-check ti icon"></i>
										<div></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
						<input type="hidden" id="edit-service-id" name="edit-service-id"
							value="" />
						<button type="button" class="btn me-auto" data-bs-dismiss="modal">Close</button>
						<div
							class="d-none spinner-show spinner-border spinner-border text-secondary ms-4"
							role="status"></div>
						<button type="button" id="update-service-btn"
							class="btn btn-primary">Update Service</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- view Service Items -->
	<div class="modal modal-blur fade" id="modal-edit-item" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form id="edit-service-item">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Update Service Item</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="mb-3">
							<label class="form-label required">Select Service</label> <select
								class="form-select" id="edit-select-service"
								name="edit-select-service" required>
								<option value>Select Service</option>
							</select>
						</div>
						<div class="mb-3">
							<label class="form-label required">Service Item Name</label>
							<div>
								<input type="text" class="form-control"
									placeholder="Enter Service Item Name"
									name="edit-service-item-name" id="edit-service-item-name"
									required />
							</div>
						</div>
						<div class="mb-3">
							<label class="form-label required">Approx. Price</label>
							<div class="input-group">
								<span class="input-group-text"> <i
									class="ti ti-currency-rupee icon"></i>
								</span> <input type="number" class="form-control"
									id="edit-service-item-price" name="edit-service-item-price"
									placeholder="Price" autocomplete="off" required />
							</div>
						</div>
						<div class="mb-3">
							<label class="form-label">Status</label>
							<div class="d-flex justify-content-around">
								<label class="form-check"> <input
									class="form-check-input" name="edit-service-item-status"
									id="edit-service-item-active" value="1" type="radio" required />
									<span class="form-check-label">Active</span>
								</label> <label class="form-check"> <input
									class="form-check-input" name="edit-service-item-status"
									id="edit-service-item-inactive" type="radio" value="0" required />
									<span class="form-check-label">In Active</span>
								</label>
							</div>
						</div>
						<div class="mb-3">
							<h3 class="h3 border-bottom">Images</h3>
							<div class="d-flex justify-content-around"
								id="service-item-images">
								<!-- Dynamic Binding -->
							</div>
						</div>

						<div class="mb-3">
							<div id="table-options-wrapper" class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-option-id">Option Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-option-name">Option Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</thead>
									<tbody id="model-table-options-body"
										class="table-tbody table-options-body">
										<!-- Dynamic Binding -->
									</tbody>
									<tfoot>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-option-id">Option Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-option-name">Option Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="mb-3">
							<div class="d-none">
								<div id="edit-service-item-msg"
									class="alert alert-important alert-dismissible" role="alert">
									<div class="d-flex">
										<i class="ti-check ti icon"></i>
										<div></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
						<input type="hidden" id="edit-service-item-id"
							name="edit-service-item-id" />
						<button type="button" class="btn me-auto" data-bs-dismiss="modal">Close</button>
						<div
							class="d-none spinner-show spinner-border spinner-border text-secondary ms-4"
							role="status"></div>
						<button type="submit" id="update-service-item"
							class="btn btn-primary">Update Service Item</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<jsp:include page="components/footer-imports.jsp" />

	<script src="resources/api/manage/services.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#nav-manage").addClass("active");
			$("#services").addClass("active");

		});
	</script>

</body>
</html>