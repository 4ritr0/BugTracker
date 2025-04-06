document.getElementById("loginForm").addEventListener("submit", function (e) {
    e.preventDefault();

    const role = document.getElementById("role").value;
    const userId = document.getElementById("userId").value;

    // Store userId in localStorage for use on dashboards
    localStorage.setItem("userId", userId);

    // Redirect to appropriate dashboard
    if (role === "tester") {
        window.location.href = "dashboard-tester.html";
    } else if (role === "pm") {
        window.location.href = "dashboard-pm.html";
    } else if (role === "dev") {
        window.location.href = "dashboard-dev.html";
    }
});

