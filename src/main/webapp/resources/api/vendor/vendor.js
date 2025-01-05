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

let statesDropdown = tomSelectInit("#states");
loadCities($("#states").val(), $("#cities").val());
let citiesDropdown;

$("#states").on('change', function() {
	let state = $(this).val();
	$("#cities").html(`
				<option value>Select City</option>
	`);
	//citiesDropdown.destroy(); //error
	loadCities(state);
});

function loadCities(state, city) {
	$.ajax({
		url: "/cities",
		type: "GET",
		data: { state: state },
		success: function(items) {
			items.forEach(item => {
				if (city === item.cityId) {
					$("#cities").append(`
                        <option value="${item.cityId}" selected>${item.cityName}</option>
            `);
				} else {
					$("#cities").append(`
                        <option value="${item.cityId}">${item.cityName}</option>
            `);
				}

			});
		},
		complete: function() {
			//citiesDropdown = tomSelectInit("#cities"); //error
		}
	});
}
