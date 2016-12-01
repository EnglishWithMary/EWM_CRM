$().ready(function(){
    var jVal = {
        'username' : function() {
            $('body').append('<div id="nameInfo" class="info"></div>');
            var nameInfo = $('#nameInfo');
            var ele = $('#username');
            var pos = ele.offset();
            var errors = [];
            nameInfo.css({
                top: pos.top-3,
                left: pos.left+ele.width()+15
            });
            var patt = /[A-Za-z]/;
            if(ele.val().length < 2) {
                errors.push('min 2 characters')
            }
            if(!patt.test(ele.val())) {
                errors.push('incorect characters,A-Za-z');
            }
            if(errors.length == 0){
                nameInfo.removeClass('error').addClass('correct').html('OK').show();
                ele.removeClass('wrong').addClass('normal');
            }else {
                jVal.errors = true;
                nameInfo.removeClass('correct').addClass('error').html(errors[0]).show();
                ele.removeClass('normal').addClass('wrong');
            }
        },
        'pass' : function() {
            $('body').append('<div id="passInfo" class="info"></div>');
            var passInfo = $('#passInfo');
            var ele = $('#pass');
            var pos = ele.offset();
            var errors = [];
            passInfo.css({
                top: pos.top-3,
                left: pos.left+ele.width()+15
            });
            var patt = /[0-9a-zA-Z!@#$%^&]*/;
            if(ele.val().length < 4) {
                errors.push('min 6 characters')
            }
            if(!patt.test(ele.val())) {
                errors.push('incorect characters,A-Za-z0-9!@#$%^&*');
            }
            if(errors.length == 0){
                passInfo.removeClass('error').addClass('correct').html('OK').show();
                ele.removeClass('wrong').addClass('normal');
            }else {
                jVal.errors = true;
                passInfo.removeClass('correct').addClass('error').html(errors[0]).show();
                ele.removeClass('normal').addClass('wrong');
            }
        }
    };
//==========================================================================================================================//
    $('#send').click(function (){
        var obj = $.browser.webkit ? $('body') : $('html');
        obj.animate({ scrollTop: $('#jform').offset().top }, 750, function (){
            jVal.errors = false;
            jVal.username();
            jVal.pass();

        });
        return false;
    });
    $('#username').change(jVal.username);
    $('#pass').change(jVal.pass);

});


















// $().ready(function () {
//     $("#formLogin").validate({
//         rules: {
//             username: {
//                 required: true,
//                 minlength: 6,
//                 maxlength: 20
//             },
//                 password: {
//                     required: true,
//                     minlength: 6,
//                 maxlength: 20
//             }
//         },
//         messages: {
//             username: {
//                 required: "Please enter your Login",
//                 minlength: "Login should be at least 6 chars",
//                 maxlength: "Login should be less than 20 chars"
//             },
//             password: {
//                 required: "Please enter your Password",
//                 minlength: "Password should be at least 6 chars",
//                 maxlength: "Middle Name should be less than 20 chars"
//             }
//         }
//     });
//     $("#username").focus(function () {
//         var username = $("#username").val();
//         var password = $("#password").val();
//         if(username && password && !this.value){
//             this.value = username + password;
//         }
//     })
// });