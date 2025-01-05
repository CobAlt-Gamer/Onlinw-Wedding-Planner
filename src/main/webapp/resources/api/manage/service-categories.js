// UTIL
function showAlert(id, alertType, message) {
    $(id).addClass(alertType).find(".d-flex > div").text(message);
    $(document).find(".spinner-show").addClass("d-none");
    $(id).parent().removeClass("d-none").hide().fadeIn(500).delay(1500).animate({ height: 'toggle' }, 500, function () {
        $(this).addClass("d-none");
        $(id).removeClass(alertType);
    });
}

// APIs REQUESTS FOR SERVICE CATEGORIES

// ENDPOINT: service-categories/add-service-category
const SERVICE_CATEGORY = "/service-categories"

// ADD SERVICE CATEGORY
$("#add-service-category").on("submit", function (e) {
    e.preventDefault();
    $(document).find(".spinner-show").removeClass("d-none");
    $.ajax({
        url: SERVICE_CATEGORY + "/add-service-categories",
        type: "POST",
        data: new FormData(this),
        enctype: "multipart/form-data",
        cache: false,
        contentType: false,
        processData: false,
        statusCode: {
            200: () => $("#add-service-category").trigger("reset"),
            500: () => showAlert("#add-service-category-msg", "alert-danger", "Internal Server Error"),
        },
        success: function () {
            showAlert("#add-service-category-msg", "alert-success", "Service Category Added Successfully");
        },
    });
});


// DELETE SERVICE CATEGORY
$(document).on("click", ".delete-service-category", function () {
    let id = $(this).data("id");
    let csrf = $(this).data("csrf");
    let element = this;
    $.ajax({
        url: SERVICE_CATEGORY + "/delete-service-categories/" + id,
        type: "DELETE",
        data: { _csrf: csrf },
        statusCode: {
            403: function (data) {
                $(element).closest("tbody").append("<tr><td colspan='4' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
                $(element).closest("tbody").find("tr:last-child")
                    .hide()
                    .fadeIn(500)
                    .delay(1000)
                    .animate({ opacity: 0, height: 'toggle' }, 500, function () {
                        $(this).fadeOut("slow");
                    });
            },
            404: function (data) {
                $(element).closest("tr").fadeOut("slow");
                $(element).closest("tbody").append("<tr><td colspan='4' class='alert alert-danger' role='alert'>" + data.responseText + "</td></tr>");
                $(element).closest("tbody").find("tr:last-child")
                    .hide()
                    .fadeIn(500)
                    .delay(1000)
                    .animate({ opacity: 0, height: 'toggle' }, 500, function () {
                        $(this).fadeOut(500);
                    });
            },
        },
        success: function (data) {
            $(element).closest("tr").html("<td colspan='4' class='alert alert-success' role='alert'>"+data+"</td>")
                .hide() // Initially hide the row
                .fadeIn(500) // Fade in the row with a 500-millisecond animation
                .delay(1000) // Wait for 1 second
                .animate({ opacity: 0, height: 'toggle' }, 500, function () {
                    $(this).fadeOut(500); // Remove the row after the animation
                });
        }
    });
});

// .edit-service-category on click 
$(document).on("click", ".edit-service-category", function () {
    let id = $(this).data("id");
    let name = $(this).data("name");
    let image = $(this).data("image");
    let active = $(this).data("active");

    $("#edit-service-category-id").val(id);
    $("#edit-service-category-name").val(name);
    $("#edit-service-category-image").attr("src", image);

    if (active == 1) {
        $("#edit-service-category-active").prop("checked", true);
        $("#edit-service-category-inactive").prop("checked", false);
    } else {
        $("#edit-service-category-active").prop("checked", false);
        $("#edit-service-category-inactive").prop("checked", true);
    }
});

// #edit-service-category-form on submit
$("#edit-service-category-form").on("submit", function (e) {
    e.preventDefault();
    $(document).find(".spinner-show").removeClass("d-none");
    $.ajax({
        url: SERVICE_CATEGORY + "/edit-service-categories",
        type: "PUT",
        data: new FormData(this),
        enctype: "multipart/form-data",
        cache: false,
        contentType: false,
        processData: false,
        statusCode: {
            500: () => showAlert("#edit-service-category-msg", "alert-danger", "Internal Server Error"),
        },
        success: function () {
            showAlert("#edit-service-category-msg", "alert-success", "Service Category Edited Successfully");
        },
    });
});