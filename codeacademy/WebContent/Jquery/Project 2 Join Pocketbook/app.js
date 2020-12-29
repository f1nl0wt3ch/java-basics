var main = function() {
  $('form').submit(function() {
    var firstName = $('#first').val();
    var lastName = $('#last').val();
    var email = $('#email').val();
    var password = $('#password').val();
    if(firstName === "") {
      $('.first-name-error').html('<p>Please enter your first name</p>');
    }
   if(lastName === "") {
     $('.last-name-error').html('<p>Please enter your last name</p>');
   };
    if(email ==="") {
      $('.email-error').html('<p>Please enter your email address.</p>');
    }
    if(password ==="") {
      $('.password-error').html('<p>Please enter your password address.</p>');
    }
     return false;
  });
};

$(document).ready(main);