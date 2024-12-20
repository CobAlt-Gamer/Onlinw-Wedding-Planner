// JavaScript for form validation and interactivity
document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    if (username === "" || password === "") {
        document.getElementById('error-message').style.display = "block";
    } else {
        document.getElementById('error-message').style.display = "none";
        alert("Login successful!");
        // Redirect to the main dashboard or other page after successful login
    }
});
