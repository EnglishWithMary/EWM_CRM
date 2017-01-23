$(document).ready(function () {

    $(".restore").click(function () {
        var  person_id = $(this).parent().parent().find(".personId").val();
        var json = {"person_id": person_id};
        // alert(JSON.stringify(json));
        var tableLine = $(this).parent().parent();
        $.ajax({
            url: '/trash/restore',
            dataType: 'text json',
            type: 'POST',
            data: person_id,
            contentType: 'application/json',

            success: function (data) {
                console.log(data);
                tableLine.remove();
            },

            error: function (data) {
                console.log("Errors");
                console.log(data);
            }
        });
    });

    $(".delete").click(function () {
        var  person_id = $(this).parent().parent().find(".personId").val();
        var json = {"person_id": person_id};
        // alert(JSON.stringify(json));
        var tableLine = $(this).parent().parent();
        $.ajax({
            url: '/trash/delete',
            dataType: 'text json',
            type: 'POST',
            data: person_id,
            contentType: 'application/json',

            success: function (data) {
                console.log(data);
                tableLine.remove();
            },

            error: function (data) {
                console.log("Errors");
                console.log(data);
            }
        });
    });
});