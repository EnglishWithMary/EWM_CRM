$(document).ready(function () {
    $('#color-picker').colorpicker();
    $('#form').validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 20
            }
        },
        messages: {
            name: {
                required: "Please enter Room's Name",
                minlength: "Name should be at least 3 chars",
                maxlength: "Name should be less than 20 chars"
            }
        }
    });
});
