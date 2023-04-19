$('document').ready(function () {

var password = document.getElementById('password');
var confirmPassword = document.getElementById('confirmPassword');

   const validatePassword = ()=> {
       if (password.value !== confirmPassword.value) {
            confirmPassword.setCustomValidity("Passwords Don't Match!");
       } else {confirmPassword.setCustomValidity("");}
   }

password.onchange = validatePassword;
confirmPassword.onkeyup = validatePassword;

// var selectedFile;
//
// $('#submit-button').on("click",(event)=>{
//    event.preventDefault();
//    setFilename();
// });
//
// //Input name retrieval
// const saveFile = ()=>{
//     var fileName = $('#photo-add').val();
//
//     //Update name
//     if(selectedFile){
//         selectedFile = new File([selectedFile], fileName,{type: selectedFile.type})
//     }
// }


});