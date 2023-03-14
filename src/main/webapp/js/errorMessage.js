document.addEventListener('DOMContentLoaded', function() {
  var errorMessage = document.getElementById('error-message');
  if (errorMessage.textContent !== "") {
    errorMessage.classList.add('show');
    setTimeout(function() {
      errorMessage.classList.remove('show');
    }, 5000);
  }
});