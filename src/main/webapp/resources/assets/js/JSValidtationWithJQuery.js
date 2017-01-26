// jQuery.validator.setDefaults({
//     debug: true,
//     success: "valid"
// });
$(document).ready(function () {
    $('#form').validate({
        rules: {
            firstName: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            lastName: {
                required: true,
                minlength: 3,
                maxlength: 20
            },
            middleName: {
                maxlength: 20
            },
            login: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            username: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5,
                maxlength: 20
            },
            confirmPassword: {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            firstName: {
                required: "Please enter your First Name",
                minlength: "First Name should be at least 3 chars",
                maxlength: "First Name should be less than 20 chars"
            },
            lastName: {
                required: "Please enter your Last Name",
                minlength: "Last Name should be at least 3 chars",
                maxlength: "Last Name should be less than 20 chars"
            },
            middleName: {
                maxlength: "Middle Name should be less than 20 chars"
            },
            login: {
                required: "Please enter your Login",
                minlength: "Login should be at least 5 chars",
                maxlength: "Login should be less than 20 chars"
            },
            username: {
                required: "Please enter your Login",
                minlength: "Login should be at least 5 chars",
                maxlength: "Login should be less than 20 chars"
            },
            email:{
                required: "Please enter your email",
                email: "Incorrect email"
            },
            password: {
                required: "Please enter your Password",
                minlength: "Password should be at least 5 chars",
                maxlength: "Middle Name should be less than 20 chars"
            },
            confirmPassword: {
                required: "Please confirm your Password",
                equalTo: "Password don't match"
            }
        }
    });
    $("#login").focus(function () {
        var firstname = $("#firstName").val();
        var lastname = $("#lastName").val();
        if(firstname && lastname && !this.value){
            this.value = firstname + lastname;
        }
    })
});

