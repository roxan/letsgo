/**
 * 
 */
function checkPassword(form) {
   var password = form[form.id + ":newPassword"].value;
   var passwordConfirm = form[form.id + ":confirmNewPassword"].value;

   if(password == passwordConfirm)
      form.submit();
   else
      alert("Password and password confirm fields don't match");
}
