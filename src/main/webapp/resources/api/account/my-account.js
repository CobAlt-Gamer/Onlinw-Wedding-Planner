$("#change-avatar").on("submit", function(e) {
	e.preventDefault();
	$.ajax({
		url: "/my-account/user/avatar",
		type: "POST",
		data: new FormData(this),
		processData: false,
		contentType: false,
		success: function(data) {
			$("#change-avatar").trigger("reset");
			$("#current-avatar").css('background-image', 'url(' + data + ')');
		},
		error: function(err) {
			$("#current-avatar").html(err);
		}
	});
});

$("#update-user").on("submit",function(e){
	e.preventDefault();
	$.ajax({
		url:"/my-account/user/update",
		type:"PUT",
		data:$(this).serialize(),
		success:function(data){
		//	console.log(data);
			$("#update-message").html(`<p class="text-success">Account Updated Successfully</p>`);
		},
		error:function(err){
			console.log(err);
		}
	});
});

$("#update-vendor").on("submit",function(e){
	e.preventDefault();
	$.ajax({
		url:"/my-account/vendor/update",
		type:"PUT",
		data:$(this).serialize(),
		success:function(data){
		//	console.log(data);
			$("#update-message").html(`<p class="text-success">Account Updated Successfully</p>`);
		},
		error:function(err){
			console.log(err);
		}
	});
});