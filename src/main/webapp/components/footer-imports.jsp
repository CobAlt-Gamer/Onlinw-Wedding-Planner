<script src="resources/js/demo-theme.min.js"></script>

<!-- Libs JS -->
<script src="resources/libs/apexcharts/dist/apexcharts.min.js" defer></script>
<script src="resources/libs/jsvectormap/dist/js/jsvectormap.min.js"
	defer></script>

<!-- tinymce -->
<script src="resources/libs/tinymce/tinymce.min.js" defer></script>

<!-- dropzone -->
<script src="resources/libs/dropzone/dist/dropzone-min.js" defer></script>

<!-- Tabler Core -->
<script src="resources/js/tabler.min.js" defer></script>
<script src="resources/js/demo.min.js" defer></script>
<script src="resources/js/jquery-3.7.1.min.js"></script>

<!-- No Ui Slider -->
<script src="resources/libs/nouislider/dist/nouislider.min.js" defer></script>

<!-- Lite Picker -->
<script src="resources/libs/litepicker/dist/litepicker.js" defer></script>

<!-- Tom Select -->
<script src="resources/libs/tom-select/dist/js/tom-select.base.min.js"
	defer></script>


<!-- List For DataTables-->
<script src="resources/libs/list.js/dist/list.min.js" defer></script>

<script>
	$("#reset-cache").on("click", function() {
		$.ajax({
			url : "/logs/reset-cache",
			type : "GET",
			success : function() {
				alert('cache cleared successfully');
			}
		});
	});
</script>