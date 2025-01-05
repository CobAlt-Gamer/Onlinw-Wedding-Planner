// UTIL
function showAlert(id, alertType, message) {
	$(id).addClass(alertType).find(".d-flex > div").text(message);
	$(document).find(".spinner-show").addClass("d-none");
	$(id).parent().removeClass("d-none").hide().fadeIn(500).delay(1500).animate({ height: 'toggle' }, 500, function() {
		$(this).addClass("d-none");
		$(id).removeClass(alertType);
	});
}

function tomSelectInit(id) {
	var el;
	if (window.TomSelect) {
		new TomSelect((el = $(id)), {
			copyClassesToDropdown: false,
			dropdownParent: "body",
			controlInput: "<input>",
			render: {
				item: function(data, escape) {
					if (data.customProperties) {
						return ('<div><span class="dropdown-item-indicator">' + data.customProperties + "</span>" + escape(data.text) + "</div>");
					}
					return "<div>" + escape(data.text) + "</div>";
				},
				option: function(data, escape) {
					if (data.customProperties) {
						return ('<div><span class="dropdown-item-indicator">' + data.customProperties + "</span>" + escape(data.text) + "</div>");
					}
					return "<div>" + escape(data.text) + "</div>";
				}
			},
		});
	}
}

function loadDropDowns() {
	// Loads Service Categories
	$.ajax({
		url: SERVICE_CATEGORY + "/categories",
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		success: function(categories) {
			categories.forEach(category => {
				if (category.active == true) {
					$("#service-category").append(`
                        <option value="${category.serviceCategoryId}">${category.serviceCategoryName}</option>
                    `);
					$("#edit-service-category").append(`
                        <option value="${category.serviceCategoryId}">${category.serviceCategoryName}</option>
                    `);
				}
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			// tomSelectInit("#edit-service-category"); // don't enable it not working in models
			tomSelectInit("#service-category");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});

	// Loads Services
	$.ajax({
		url: SERVICES + "/services",
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		success: function(services) {
			services.forEach(service => {
				$("#select-service").append(`
                        <option value="${service.serviceId}">${service.serviceName}</option>
                 `);
				$("#edit-select-service").append(`
                        <option value="${service.serviceId}">${service.serviceName}</option>
                 `);
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			tomSelectInit("#select-service");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});
}

function initDatatable(id, sortClass, listClass, values) {
	new List(id, {
		sortClass: sortClass,
		listClass: listClass,
		valueNames: values,
	});
}

// ENDPOINT: service-categories
const SERVICE_CATEGORY = "/service-categories";

const SERVICES = "/services";

const SERVICE_VARIATION = "/service-variation";

// Get All service-categories & services
$(document).ready(function() {
	loadDropDowns();
	initDatatable("table-default", "table-sort", "table-tbody", ["sort-id", "sort-name", "sort-description",
		"sort-created", "sort-status", "sort-action"]);
});

// ADD SERVICE FOR CATEGORY
$("#add-service").on("submit", function(e) {
	e.preventDefault();
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: SERVICES + "/add",
		type: "POST",
		data: $(this).serialize(),
		statusCode: {
			200: () => $("#add-service").trigger("reset"),
			500: () => showAlert("#add-service-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#add-service-msg", "alert-success", "Service Added Successfully");
		},
		error: function(data) {
			console.log(data);
		}
	});
});


const maxFiles = 5; // Maximum number of files allowed
let storedFiles = []; // Maintains the files list
$('#file-input').change(function(event) {
	const newFiles = event.target.files;

	// Check for maximum file limit
	if (newFiles.length + storedFiles.length > maxFiles) {
		$("#file-list-alert").html('<div class="alert alert-important alert-danger alert-dismissible" role="alert"><div class="d-flex"><div>You can only select up to ' + maxFiles + ' images at a time. Please remove ' + ((newFiles.length + storedFiles.length) - maxFiles) + ' files and try again.</div></div><a class="btn-close" data-bs-dismiss="alert" aria-label="close"></a></div>');
		return;
	}

	// Combine new files with stored files
	let combinedFiles = [...storedFiles, ...newFiles];

	// Validate file types before adding to combinedFiles
	const validFiles = [];
	for (const file of combinedFiles) {
		if (file.type.startsWith('image/')) {
			validFiles.push(file);
		} else {
			$("#file-list-alert").html('<div class="alert alert-important alert-danger alert-dismissible" role="alert"><div class="d-flex"><div>Invalid file: "' + file.name + '". Please select only image files.</div></div><a class="btn-close" data-bs-dismiss="alert" aria-label="close"></a></div>');
		}
	}
	combinedFiles = validFiles;

	// Update file list and image previews
	$('#file-list').empty();
	for (const file of combinedFiles) {
		const listItem = $('<li></li>');
		const imagePreview = $('<img class="avatar avatar-sm">');
		const fileNameSpan = $('<span></span>');
		const fileInfoSpan = $('<span></span>');
		const removeButton = $('<button class="ms-2 btn btn-sm btn-danger">Remove</button>');

		// Create image preview using FileReader
		const reader = new FileReader();
		reader.onload = function(event) {
			imagePreview.attr('src', event.target.result);
		};
		reader.readAsDataURL(file);

		fileNameSpan.text(file.name.length > 6 ? file.name.substring(0, 6) + '...' : file.name);
		fileInfoSpan.text('(' + Math.ceil(file.size / 1024) + ' KB)');
		removeButton.click(function() {
			// Remove from storedFiles and update UI
			const index = combinedFiles.indexOf(file);
			combinedFiles.splice(index, 1);
			storedFiles = combinedFiles;
			listItem.remove();
		});

		listItem.append(imagePreview);
		listItem.append(fileNameSpan);
		listItem.append(fileInfoSpan);
		listItem.append(removeButton);

		$('#file-list').append(listItem);
	}
	// Store the combined files for future use
	storedFiles = combinedFiles;
});

// ADD SERVICE ITEM
$('#add-service-item').on("submit", function(event) {
	event.preventDefault(); // Prevent form submission

	if (storedFiles.length == 0) {
		showAlert("#add-service-item-msg", "alert-danger", "No Images Selected, Please Select atleast 1 Image");
		return;
	}

	// Gather form data
	let formData = new FormData(this);

	// Add stored files to form data
	for (const file of storedFiles) {
		formData.append('files[]', file);
	}
	
	// Perform AJAX submission
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: SERVICES + '/add-item',
		method: 'POST',
		data: formData,
		processData: false,
		contentType: false,
		statusCode: {
			200: () => {
				$("#add-service-item").trigger("reset");
				$("#file-list").empty();
				storedFiles = [];
			},
			500: () => showAlert("#add-service-item-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#add-service-item-msg", "alert-success", "Service Item Added Successfully");
		},
		error: function(data) {
			console.log(data);
		},
	});
});

$(document).on("click", ".edit-service", function() {
	let serviceId = $(this).data("service-id");
	let serviceName = $(this).data("service-name");
	let serviceDescription = $(this).data("service-description");
	let serviceCategory = $(this).data("category");
	let status = $(this).data("status");
	let csrf = $('meta[name="_csrf"]').attr('content');


	$("#edit-service-id").val(serviceId);
	$("#edit-service-name").val(serviceName);
	$('#edit-service-category option[value="' + serviceCategory + '"]').attr("selected", "selected");
	$("#edit-service-description").val(serviceDescription);

	if (status == 1) {
		$("#edit-service-active").prop("checked", true);
		$("#edit-service-inactive").prop("checked", false);
	} else {
		$("#edit-service-active").prop("checked", false);
		$("#edit-service-inactive").prop("checked", true);
	}

	$.ajax({
		url: SERVICES + "/service-items/" + serviceId,
		type: "GET",
		statusCode: {
			404: () => $("#model-table-body").html(`
			<tr>
				<td colspan="3" class="text-danger text-center">No Service Items Found</td>
			</tr>
			`)
		},
		success: function(serviceItems) {
			let bodyData = "";
			$.each(serviceItems, function(index, value) {
				bodyData += ` 
			        <tr>
			            <td class="sort-servive-item-id" class="text-secondary">${value.serviceItemId}</td>
			            <td class="sort-service-item-name">
			                <div class="d-flex py-1 align-items-center">
			                    <div class="flex-fill">
			                        <div class="font-weight-medium">${value.itemName}</div>
			                    </div>
			                </div>
			            </td>
			            <td>
			                <div class="btn-list flex-nowrap">
			                	<button class="btn edit-service-item" data-bs-target="#modal-edit-item" data-bs-toggle="modal" data-service-item-id="${value.serviceItemId}">Edit</button>
			                    <button class="btn delete-service-item" data-csrf="${csrf}" data-service-item-id="${value.serviceItemId}">Delete</button>
			                </div>
			            </td>
			        </tr>`
			});
			$("#model-table-body").html(bodyData);
			initDatatable("table-service-items-wrapper", "table-sort", "table-service-item-body", ["sort-service-item-id", "sort-service-item-name", "sort-action"]);
		},
		error: function(error) {
			console.log(error);
		}
	});
});

// to prevent auto submission on model whicle clicking on data table
$("#edit-service-form").on("submit", function(e) {
	e.preventDefault();
});

// Update Service
$("#update-service-btn").on("click", function() {
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: SERVICES + "/update",
		type: "PUT",
		data: $("#edit-service-form").serialize(),
		statusCode: {
			500: () => showAlert("#edit-service-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#edit-service-msg", "alert-success", "Service Updated Successfully");
		}
	});
});

// delete service
$(document).on("click", ".delete-service", function() {
	let id = $(this).data("service-id");
	let csrf = $(this).data("csrf");
	let element = this;
	$.ajax({
		url: SERVICES + "/delete/" + id,
		type: "DELETE",
		data: { _csrf: csrf },
		statusCode: {
			500: function(data) {
				$(element).closest("tbody").append("<tr><td colspan='6' class='alert alert-danger' role='alert'>Please, delete service items before deleting service</td></tr>");
				$(element).closest("tbody").find("tr:last-child")
					.hide()
					.fadeIn(500)
					.delay(1000)
					.animate({ opacity: 1, height: 'toggle' }, 5000, function() {
						$(this).fadeOut(500);
					});
			},
		},
		success: function(data) {
			$(element).closest("tr").html("<td colspan='6' class='alert alert-success' role='alert'>" + data + "</td>")
				.hide() // Initially hide the row
				.fadeIn(500) // Fade in the row with a 500-millisecond animation
				.delay(1000) // Wait for 1 second
				.animate({ opacity: 0, height: 'toggle' }, 500, function() {
					$(this).fadeOut(500); // Remove the row after the animation
				});
		}
	});
});


// delete service item
$(document).on("click", ".delete-service-item", function() {
	let id = $(this).data("service-item-id");
	let csrf = $(this).data("csrf");
	let element = this;
	// let actionStatus;
	$.ajax({
		beforeSend: function() {
			//	actionStatus = $(element).closest("tbody").append("<tr><td colspan='5' class='alert alert-warning' role='alert'>Please wait while we delete service item...</td></tr>");
		},
		url: SERVICES + "/delete-item/" + id,
		type: "DELETE",
		data: { _csrf: csrf },
		statusCode: {
			500: function(data) {
				$(element).closest("tbody").append("<tr><td colspan='3' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
				$(element).closest("tbody").find("tr:last-child")
					.hide()
					.fadeIn(500)
					.delay(1000)
					.animate({ opacity: 0, height: 'toggle' }, 5000, function() {
						$(this).fadeOut(500);
					});
			},
		},
		success: function(data) {
			$(element).closest("tr").html("<td colspan='3' class='alert alert-success' role='alert'>" + data + "</td>")
				.hide() // Initially hide the row
				.fadeIn(500) // Fade in the row with a 500-millisecond animation
				.delay(1000) // Wait for 1 second
				.animate({ opacity: 0, height: 'toggle' }, 500, function() {
					$(this).fadeOut(500); // Remove the row after the animation
				});
		},
		complete: function() {
			//	$(actionStatus).hide();
		}
	});
});

// load Service Item Model
$(document).on("click", ".edit-service-item", function() {
	let serviceItem = $(this).data("service-item-id");
	let csrf = $('meta[name="_csrf"]').attr('content');
	$("#table-options-wrapper").hide();

	$.ajax({
		url: SERVICES + "/service-item/" + serviceItem,
		type: "GET",
		success: function(data) {
			$("#edit-service-item-id").val(data.serviceItemId);
			$('#edit-select-service option[value="' + data.service.serviceId + '"]').attr("selected", "selected");
			$("#edit-service-item-name").val(data.itemName);
			$("#edit-service-item-price").val(data.approxPrice);
			if (data.status == 1) {
				$("#edit-service-item-active").prop("checked", true);
				$("#edit-service-item-inactive").prop("checked", false);
			} else {
				$("#edit-service-item-active").prop("checked", false);
				$("#edit-service-item-inactive").prop("checked", true);
			}

			let images = "";
			$.each(data.images, function(index, value) {
				images += `
				<div>
					<img class="avatar avatar-lg" src="${value.url}" alt="${data.itemName}" />
				</div>
				`;
			});
			$("#service-item-images").html(images);

			if (data.variations.length == 0) {
				$("#table-options-wrapper").hide();
			} else {
				let bodyData = '';
				$.each(data.variations, function(index, value) {
					bodyData += ` 
			        <tr>
			            <td class="sort-option-id" class="text-secondary">${value.variationOptionId}</td>
			            <td class="sort-option-name">
			                <div class="d-flex py-1 align-items-center">
			                    <div class="flex-fill">
			                        <div class="font-weight-medium">${value.variationOptionName}</div>
			                    </div>
			                </div>
			            </td>
			            <td>
			                <div class="btn-list flex-nowrap">
			                    <button class="btn delete-service-option" data-service-item-id="${serviceItem}" data-csrf="${csrf}" data-option-id="${value.variationOptionId}">Delete</button>
			                </div>
			            </td>
			        </tr>`
				});
				$("#model-table-options-body").html(bodyData);
				initDatatable("table-options-wrapper", "table-sort", "table-options-body", ["sort-option-id", "sort-option-name", "sort-action"]);
				$("#table-options-wrapper").fadeIn();
			}
		},
		error: function(data) {
			console.log(data);
		}
	});
});

// update Service Item
$("#edit-service-item").on("submit", function(e) {
	e.preventDefault();

});

$("#update-service-item").on("click", function() {
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: SERVICES + "/update-item",
		type: "PUT",
		data: $("#edit-service-item").serialize(),
		statusCode: {
			500: () => showAlert("#edit-service-item-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#edit-service-item-msg", "alert-success", "Service Updated Successfully");
		}
	});
});


// delete service item Option
$(document).on("click", ".delete-service-option", function() {
	let item = $(this).data("service-item-id");
	let option = $(this).data("option-id");
	let csrf = $(this).data("csrf");
	let element = this;
	// let actionStatus;
	$.ajax({
		beforeSend: function() {
			//	actionStatus = $(element).closest("tbody").append("<tr><td colspan='5' class='alert alert-warning' role='alert'>Please wait while we delete service item...</td></tr>");
		},
		url: SERVICE_VARIATION + "/delete/item/" + item + "/option/" + option,
		type: "DELETE",
		data: { _csrf: csrf },
		statusCode: {
			500: function(data) {
				$(element).closest("tbody").append("<tr><td colspan='3' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
				$(element).closest("tbody").find("tr:last-child")
					.hide()
					.fadeIn(500)
					.delay(1000)
					.animate({ opacity: 0, height: 'toggle' }, 5000, function() {
						$(this).fadeOut(500);
					});
			},
		},
		success: function(data) {
			$(element).closest("tr").html("<td colspan='3' class='alert alert-success' role='alert'>" + data + "</td>")
				.hide() // Initially hide the row
				.fadeIn(500) // Fade in the row with a 500-millisecond animation
				.delay(1000) // Wait for 1 second
				.animate({ opacity: 0, height: 'toggle' }, 500, function() {
					$(this).fadeOut(500); // Remove the row after the animation
				});
		},
		complete: function() {
			//	$(actionStatus).hide();
		}
	});
});