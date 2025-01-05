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
	var el, instance;
	if (window.TomSelect) {
		instance = new TomSelect((el = $(id)), {
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

		// Store reference to the original destroy method
		var originalDestroy = instance.destroy;

		// Override destroy method
		instance.destroy = function() {
			originalDestroy.call(instance); // Call the original destroy method
			instance = null; // Reset the instance
		};

		return instance;
	}
}

function loadDropDowns() {
	// Loads Services
	$.ajax({
		url: SERVICES + "/services",
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		success: function(services) {
			services.forEach(service => {
				if (service.status == true) {
					$("#select-service").append(`
                        <option value="${service.serviceId}">${service.serviceName}</option>
                    `);
					/*
					$("#edit-select-service").append(`
						<option value="${service.serviceId}">${service.serviceName}</option>
					`);
					*/
				}
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			// tomSelectInit("#edit-select-service"); // don't enable it not working in models
			servicesDropdown = tomSelectInit("#select-service");
			serviceItemDropdown = tomSelectInit("#select-service-item");
			variationDropdown = tomSelectInit("#select-variation");
			variationOptionsDropdown = tomSelectInit("#select-variation-option");
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

// ENDPOINT: variations
const VARIATIONS = "/variations";

// ENDPOINT: services
const SERVICES = "/services";

// ENDPOINT: service-variation
const SERVICE_VARIATION = "/service-variation";

// Get All service-categories & services
$(document).ready(function() {
	loadDropDowns();
	initDatatable("table-default", "table-sort", "table-tbody", ["sort-map-id", "sort-service", "sort-service-items",
		"sort-service-variations", "sort-action"]);
});

// SERVICE DROPDOWN INSTANCE
let servicesDropdown;
let serviceItemDropdown;
let variationDropdown;
let variationOptionsDropdown;

$("#select-service").on('change', function() {
	serviceItemDropdown.destroy();
	variationDropdown.destroy();
	variationOptionsDropdown.destroy();
	$("#select-variation-option").html(`
		<option value>Select Variation First</option>
	`)
	variationOptionsDropdown = tomSelectInit("#select-variation-option");

	let service = $(this).val();
	// Loads Service Items
	loadServiceItems(service);
	loadVariations(service);
});

$("#select-variation").on('change', function() {
	variationOptionsDropdown.destroy();
	let variation = $(this).val();
	loadvariationOption(variation);
});

// loads Services
function loadServiceItems(service) {
	$.ajax({
		url: SERVICES + "/service-items/" + service,
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		statusCode: {
			404: () => {
				$("#select-service-item").html(`
				<option class="text-danger" value>No Items Found</option>
				`);
			}
		},
		success: function(items) {
			$("#select-service-item").html(`
				<option class="text-danger" value>Select Service Item</option>
				`);
			items.forEach(item => {
				$("#select-service-item").append(`
                        <option value="${item.serviceItemId}">${item.itemName}</option>
                    `);
				/*
				$("#edit-select-service").append(`
					<option value="${service.serviceId}">${service.serviceName}</option>
				`);
				*/
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			// tomSelectInit("#edit-select-service"); // don't enable it not working in models
			serviceItemDropdown = tomSelectInit("#select-service-item");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});
}

// loads Variations 
function loadVariations(service) {
	$.ajax({
		url: VARIATIONS + "/variations/" + service,
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		statusCode: {
			404: () => {
				$("#select-variation").html(`
				<option class="text-danger" value>No Variations Available</option>
				`);
			}
		},
		success: function(variations) {
			$("#select-variation").html(`
				<option class="text-danger" value>Select Variation</option>
				`);
			variations.forEach(variation => {
				$("#select-variation").append(`
                        <option value="${variation.variationId}">${variation.variationName}</option>
                    `);
				/*
				$("#edit-select-service").append(`
					<option value="${service.serviceId}">${service.serviceName}</option>
				`);
				*/
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			// tomSelectInit("#edit-select-service"); // don't enable it not working in models
			variationDropdown = tomSelectInit("#select-variation");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});
}

// loads Variation Options
function loadvariationOption(variation) {
	$.ajax({
		url: VARIATIONS + "/variation-options/" + variation,
		type: "GET",
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		statusCode: {
			404: () => {
				$("#select-variation-option").html(`
				<option class="text-danger" value>No Variation Options Available</option>
				`);
			}
		},
		success: function(options) {
			$("#select-variation-option").html(`
				<option class="text-danger" value>Select Option</option>
			`);
			options.forEach(option => {
				$("#select-variation-option").append(`
                        <option value="${option.variationOptionId}">${option.variationOptionName}</option>
                    `);
				/*
				$("#edit-select-service").append(`
					<option value="${service.serviceId}">${service.serviceName}</option>
				`);
				*/
			});
		},
		error: function(error) {
			console.log(error);
		},
		complete: function() {
			// tomSelectInit("#edit-select-service"); // don't enable it not working in models
			variationOptionsDropdown = tomSelectInit("#select-variation-option");
			$(document).find(".spinner-show").addClass("d-none");
		}
	});
}


// ADD SERVICE VARIATION MAPPING
$("#add-service-variation").on("submit", function(e) {
	e.preventDefault();
	$.ajax({
		beforeSend: function() {
			$(document).find(".spinner-show").removeClass("d-none");
		},
		url: SERVICE_VARIATION + "/add",
		type: "POST",
		data: $(this).serialize(),
		statusCode: {
			200: () => {
				$("#add-service-variation").trigger("reset");
				servicesDropdown.destroy();
				serviceItemDropdown.destroy();
				variationDropdown.destroy();
				variationOptionsDropdown.destroy();
				servicesDropdown = tomSelectInit("#select-service");
				serviceItemDropdown = tomSelectInit("#select-service-item");
				variationDropdown = tomSelectInit("#select-variation");
				variationOptionsDropdown = tomSelectInit("#select-variation-option");
			},
			500: () => showAlert("#add-service-variation-msg", "alert-danger", "Internal Server Error"),
		},
		success: function() {
			showAlert("#add-service-variation-msg", "alert-success", "Service Variation Added Successfully");
		},
		error: function(data) {
			console.log(data);
		}
	});
});