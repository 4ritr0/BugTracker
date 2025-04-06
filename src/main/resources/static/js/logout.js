// Add this script to your dashboard pages for logout functionality
function logout() {
    // Clear user data from localStorage
    localStorage.removeItem("userId");
    localStorage.removeItem("username");
    localStorage.removeItem("role");
    
    // Redirect to login page
    window.location.href = "/index.html";
  }
  
  // Example of how to use this in your dashboard HTML:
  // <button onclick="logout()">Logout</button>