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
				if (category.active == true)
					$("#service-category").append(`
                        <option value="${category.serviceCategoryId}">${category.serviceCategoryName}</option>
                    `);
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			tomSelectInit("#service-category");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});

	// Loads Variations
	$.ajax({
		url: VARIATION + "/variations",
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		success: function(variations) {
			variations.forEach(variation => {
				$("#variations-select").append(`
                        <option value="${variation.variationId}">${variation.variationName}</option>
                    `);
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			tomSelectInit("#variations-select");
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
const SERVICE_CATEGORY = "/service-categories"
const VARIATION = "/variations"

// Get All service-categories
$(document).ready(function() {
	loadDropDowns();
	initDatatable("table-default", "table-sort", "table-tbody", ["sort-id", "sort-variation-name", "sort-variation-option", "sort-category", "sort-action"]);
});

// ADD VARIATION FOR CATEGORY
$("#add-variation").on("submit", function(e) {
	e.preventDefault();
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: VARIATION + "/add-variations",
		type: "POST",
		data: $(this).serialize(),
		statusCode: {
			200: () => $("#add-variation").trigger("reset"),
			500: () => showAlert("#add-variation-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#add-variation-msg", "alert-success", "Variation Added Successfully");
		},
	});
});

// ADD VARIATION OPTION
$("#add-variation-option").on("submit", function(e) {
	e.preventDefault();
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: VARIATION + "/add-variation-options",
		type: "POST",
		data: $(this).serialize(),
		statusCode: {
			200: () => $("#add-variation-option").trigger("reset"),
			500: () => showAlert("#add-variation-option-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#add-variation-option-msg", "alert-success", "Variation Added Successfully");
		},
	});
});

$(document).on("click", ".edit-variation", function() {
	var options = $(this).data("options")
	let variationId = $(this).data("variation-id")
	let variationName = $(this).data("variation-name")

	$("#edit-variation-id").val(variationId);
	$("#edit-variation-name").val(variationName);

	let bodyData = "";
	$.each(options, function(key, value) {
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
                    <button class="btn delete-option" data-option-id="${value.variationOptionId}">Delete</button>
                </div>
            </td>
        </tr>
        `
	});
	$("#model-table-body").html(bodyData);

	initDatatable("table-options-wrapper", "table-sort", "table-options-body", ["sort-option-id", "sort-option-name", "sort-action"]);
});

// to prevent auto submission on model whicle clicking on data table
$("#edit-variation-form").on("submit", function(e) {
	e.preventDefault();
});

// Update variation
$("#update-variation-btn").on("click", function() {
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: VARIATION + "/edit-variations",
		type: "PUT",
		data: $("#edit-variation-form").serialize(),
		statusCode: {
			500: () => showAlert("#edit-variation-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#edit-variation-msg", "alert-success", "Variation Updated Successfully");
		},
	});
});


// delete variation option
$(document).on("click", ".delete-option", function() {
	let id = $(this).data("option-id");
	let csrf = $('meta[name="_csrf"]').attr('content');
	let element = this;
	$.ajax({
		url: VARIATION + "/delete-variation-option/" + id,
		type: "DELETE",
		data: { _csrf: csrf },
		statusCode: {
			404: function(data) {
				$(element).closest("tr").fadeOut("slow");
				$(element).closest("tbody").append("<tr><td colspan='3' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
				$(element).closest("tbody").find("tr:last-child")
					.hide()
					.fadeIn(500)
					.delay(1000)
					.animate({ opacity: 0, height: 'toggle' }, 500, function() {
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
		}
	});
});


// delete variation option
$(document).on("click", ".delete-variation", function() {
	let id = $(this).data("variation-id");
	let csrf = $(this).data("csrf");
	let element = this;
	$.ajax({
		url: VARIATION + "/delete-variations/" + id,
		type: "DELETE",
		data: { _csrf: csrf },
		statusCode: {
			404: function(data) {
				$(element).closest("tr").fadeOut("slow");
				$(element).closest("tbody").append("<tr><td colspan='5' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
				$(element).closest("tbody").find("tr:last-child")
					.hide()
					.fadeIn(500)
					.delay(1000)
					.animate({ opacity: 0, height: 'toggle' }, 500, function() {
						$(this).fadeOut(500);
					});
			},
		},
		success: function(data) {
			console.log(data)
			$(element).closest("tr").html("<td colspan='5' class='alert alert-success' role='alert'>" + data + "</td>")
				.hide() // Initially hide the row
				.fadeIn(500) // Fade in the row with a 500-millisecond animation
				.delay(1000) // Wait for 1 second
				.animate({ opacity: 0, height: 'toggle' }, 500, function() {
					$(this).fadeOut(500); // Remove the row after the animation
				});
		}
	});
});