// Password Box Visibility 
$(document).ready(function() {
	$("#showPassword").on("click", function() {
		if ($("#password").attr("type") == "password") {
			$("#password").attr("type", "text");
			$("#eye-icon").removeClass("ti-eye");
			$("#eye-icon").addClass("ti-eye-closed");
		} else {
			$("#password").attr("type", "password");
			$("#eye-icon").removeClass("ti-eye-closed");
			$("#eye-icon").addClass("ti-eye");
		}
	});

	$("#states").on('change', function() {
		let state = $(this).val();
		$("#cities").html(`
					<option value>Select City</option>
		`);
		$.ajax({
			url: "/cities",
			type: "GET",
			data: { state: state },
			success: function(items) {
				items.forEach(item => {
					$("#cities").append(`
		                        <option value="${item.cityId}">${item.cityName}</option>
		            `);
				});
			}
		});
	});
});
