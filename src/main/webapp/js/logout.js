function logout() {
  var xhr = new XMLHttpRequest();
  xhr.open('GET', 'UserServlet?action=logout');
  xhr.onload = function() {
    if (xhr.status === 200) {
      window.location.href = 'login.jsp';
    } else {
      alert('An error occurred while logging out.');
    }
  };
  xhr.send();
}