<%@page
	import="com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.wedding.planner.entity.VariationOption"%>
<%@page import="com.wedding.planner.entity.Variation"%>
<%@page import="java.util.List"%>
<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Variations | <%=Configurations.NAME%>
</title>

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
							<div class="page-pretitle">Manage</div>
							<h2 class="page-title">Variations</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- Page body -->
			<div class="page-body">
				<div class="container-xl">
					<div class="row g-5">
						<div class="col-xl-6">
							<form class="card" id="add-variation">
								<div class="card-header">
									<h3 class="card-title">Add Variation</h3>
								</div>
								<div class="card-body">
									<div class="mb-3">
										<label class="form-label required">Variation Name</label>
										<div>
											<input type="text" class="form-control"
												placeholder="Enter Variation Name" id="variation-name"
												name="variation-name" required />
										</div>
									</div>
									<div class="mb-3">
										<label class="form-label required">Select Service
											Category</label> <select type="text" class="form-select"
											id="service-category" name="service-category" required>
											<option value>Select Service Category</option>
										</select>
									</div>
								</div>
								<div class="card-footer d-flex justify-content-between">
									<div class="d-none">
										<div id="add-variation-msg"
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
							<form class="card" id="add-variation-option">
								<div class="card-header">
									<h3 class="card-title">Add Variation Option</h3>
								</div>
								<div class="card-body">
									<div class="mb-3">
										<label class="form-label required">Select Variation</label> <select
											type="text" class="form-select" id="variations-select"
											name="variations-select" required>
											<option value>Select Variation</option>
										</select>
									</div>
									<div class="mb-3">
										<label class="form-label required">Variation Option</label>
										<div>
											<input type="text" class="form-control"
												placeholder="Enter Variation Option Name"
												id="variation-option-name" name="variation-option-name"
												required />
										</div>
									</div>
								</div>
								<div class="card-footer d-flex justify-content-between">
									<div class="d-none">
										<div id="add-variation-option-msg"
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
					</div>

					<div class="col-md-12 mt-5">
						<div class="card">
							<div class="card-body">
								<div id="table-default" class="table-responsive">
									<table class="table">
										<thead>
											<tr>
												<th><button class="table-sort" data-sort="sort-id">Id</button>
												</th>
												<th><button class="table-sort"
														data-sort="sort-variation-name">Variation Name</button></th>
												<th><button class="table-sort"
														data-sort="sort-variation-option">Variation
														Option</button></th>
												<th><button class="table-sort"
														data-sort="sort-category">Category</button></th>
												<th><button class="table-sort" data-sort="sort-actions">Actions</button>
												</th>
											</tr>
										</thead>
										<tbody class="table-tbody">
											<%
											List<Variation> variations = (List<Variation>) request.getAttribute("variationList");
											List<VariationOption> options = (List<VariationOption>) request.getAttribute("variationOptionList");
											for (Variation variation : variations) {
											%>
											<tr>
												<td class="sort-id" class="text-secondary"><%=variation.getVariationId()%></td>
												<td class="sort-variation-name">
													<div class="d-flex py-1 align-items-center">
														<div class="flex-fill">
															<div class="font-weight-medium"><%=variation.getVariationName()%></div>
														</div>
													</div>
												</td>

												<td class="sort-variation-option">
													<div class="d-flex py-1 align-items-center">
														<div class="flex-fill">
															<ul class="font-weight-medium list">
																<%
																List<VariationOption> filteredOptions = options.stream()
																		.filter(option -> option.getVariation().getVariationId() == variation.getVariationId())
																		.map(option -> VariationOption.builder().variationOptionId(option.getVariationOptionId())
																		.variationOptionName(option.getVariationOptionName()).build())
																		.collect(Collectors.toList());

																// Printing the filtered options
																for (VariationOption optionName : filteredOptions) {
																	out.print("<li class='list-item'>" + optionName.getVariationOptionName() + "</li>");
																}
																%>
															</ul>
														</div>
													</div>
												</td>
												<td class="sort-category">
													<div class="d-flex py-1 align-items-center">
														<div class="flex-fill">
															<div class="font-weight-medium"><%=variation.getServiceCategory().getServiceCategoryName()%></div>
														</div>
													</div>
												</td>

												<td class="sort-actions">
													<div class="btn-list flex-nowrap">
														<button class="btn edit-variation" data-bs-toggle="modal"
															data-options='<%=new ObjectMapper().writeValueAsString(filteredOptions)%>'
															data-variation-id="<%=variation.getVariationId()%>"
															data-variation-name="<%=variation.getVariationName()%>"
															data-bs-target="#modal-edit">Edit</button>
														<button class="btn delete-variation" data-csrf="${_csrf.token}" data-variation-id="<%=variation.getVariationId()%>">Delete</button>
													</div>
												</td>
											</tr>
											<%
											}
											%>
										</tbody>
										<tfoot>

											<tr>
												<th><button class="table-sort" data-sort="sort-id">Id</button>
												</th>
												<th><button class="table-sort"
														data-sort="sort-variation-name">Variation Name</button></th>
												<th><button class="table-sort"
														data-sort="sort-variation-option">Variation
														Option</button></th>
												<th><button class="table-sort"
														data-sort="sort-category">Category</button></th>
												<th><button class="table-sort" data-sort="sort-actions">Actions</button>
												</th>
											</tr>

										</tfoot>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="components/footer.jsp" />
		</div>
	</div>


	<!-- MODELS  -->

	<div class="modal modal-blur fade" id="modal-edit" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">

			<div class="modal-content">
				<form id="edit-variation-form">
					<div class="modal-header">
						<h5 class="modal-title">Edit Variation</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>

					<div class="modal-body">
						<div class="mb-3">
							<label class="form-label required">Variation Name</label>
							<div>
								<input type="text" class="form-control"
									placeholder="Enter Variation Name" id="edit-variation-name"
									name="edit-variation-name" required />
							</div>
						</div>

						<div class="mb-3">
							<div id="table-options-wrapper" class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-option-id">option Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-option-name">option Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</thead>
									<tbody id="model-table-body"
										class="table-tbody table-options-body">
										<!-- Dynamic Bounding -->
									</tbody>
									<tfoot>
										<tr>
											<th><button class="table-sort"
													data-sort="sort-option-id">option Id</button></th>
											<th><button class="table-sort"
													data-sort="sort-option-name">option Name</button></th>
											<th><button class="table-sort" data-sort="sort-action">action</button></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
						<div class="mb-3">
							<div class="d-none">
								<div id="edit-variation-msg"
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
						<input type="hidden" name="${_csrf.parameterName}" id="#edit-csrf"
										value="${_csrf.token}" />
						<input type="hidden" id="edit-variation-id"
							name="edit-variation-id" value="" />
						<button type="button" class="btn me-auto" data-bs-dismiss="modal">Close</button>
						<div
							class="d-none spinner-show spinner-border spinner-border text-secondary ms-4"
							role="status"></div>
						<button id="update-variation-btn" class="btn btn-primary">Update
							Variation</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="components/footer-imports.jsp" />

	<!-- FILE SPECIFIC IMPORTS -->
	<script src="resources/api/manage/variations.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#nav-manage").addClass("active");
			$("#variations").addClass("active");
		});
	</script>

</body>

</html>