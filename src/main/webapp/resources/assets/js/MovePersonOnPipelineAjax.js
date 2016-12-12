$(document).ready(function () {

        $(".pipe .person").draggable({
        cancel: "a.ui-icon",
        revert: "invalid",
        containment: "document",
        helper: "clone",
        cursor: "move"
    });

    $(".pipe").droppable({
        accept: ".pipe .person",

        hoverClass: "pipehover",

        drop: function( event, ui ) {
            movePerson( ui.draggable, $(event.target) );

            //personId
            var $draggable_item = ui.draggable;
            //var $from_input = $($draggable_item).find("#from");

            var from = $($draggable_item).find("#from").val(); // Source card number
            var personId = $($draggable_item).find("#personId").val(); // Draggable person

            var $target = $(event.target); // Pipe where we drag person

            var destination = $($target).find("#destination").val(); // Destination card number

            $($draggable_item).find("#from").attr("value", destination);

            var json = { "destination" : destination, "from" : from, "personId" : personId};

            if(destination != from) {
                $.ajax({
                    url: '/moveLeadAjax',
                    dataType: 'json',
                    type: 'POST',
                    data: JSON.stringify(json),
                    contentType: 'application/json',

                    success: function (data) {
                    }
                });
            }
        }
    });

    function movePerson($item, $target) {
        $item.appendTo($target).fadeIn();
    }

    $(".person").width($(".person").parent().width() * 0.95);

    $('.pipe_wrapper #deleteCardForm').first().remove();

});