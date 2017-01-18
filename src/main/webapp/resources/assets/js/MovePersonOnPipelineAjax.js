$(document).ready(function () {

        $(".pipe .person").draggable({
        cancel: "a.ui-icon",
        revert: "invalid",
        containment: "document",
        helper: "clone",
        cursor: "move",
    });

    $(".pipe").droppable({
        accept: ".pipe .person",
        hoverClass: "pipehover",

        drop: function( event, ui ) {
            var i = 0; //used as flag to find out if element added or not
            $(this).children('.person').each(function () {

                if ($(this).offset().top >= ui.offset.top) //compare
                {
                    $(ui.draggable).insertBefore($(this));
                    i = 1;
                    return false; //break loop
                }

            })
            if (i == 0) //if element dropped at the end of card
            {
                movePerson( ui.draggable, $(event.target) );
            }

            //personId
            var $draggable_item = ui.draggable;
            //var $from_input = $($draggable_item).find("#from");

            var from = $($draggable_item).find("#from").val(); // Source card number
            var personId = $($draggable_item).find("#personId").val(); // Draggable person

            var $target = $(event.target); // Pipe where we drag person

            var destination = $($target).find("#destination").val(); // Destination card number

            $($draggable_item).find("#from").attr("value", destination);

            var positions=[];
            // $(this).is($draggable_item)
            // find position and id of person on card
            $($(event.target)).children(".person").each(function (index) {
                var id = $(this).find("#personId").val();
                var position = index + 1;

                // Write in array id of clone and another elements on pipe
                // except element which clone we are dragging.
                // @personId presents id of clone of draggable element
               if($(this).is($draggable_item) || id != personId)
               {
                   positions.push({"position": position, "id": id});
               }

            });

            var json = { "destination" : destination, "from" : from, "personId" : personId, "array": positions};

            // if(destination != from) {
                $.ajax({
                    url: '/pipeline/moveLeadAjax',
                    dataType: 'json',
                    type: 'POST',
                    data: JSON.stringify(json),
                    contentType: 'application/json',

                    success: function (data) {
                    }
                });
            // }
        }
    });

    function movePerson($item, $target) {
        $item.appendTo($target).fadeIn();
    }

    $(".person").width($(".person").parent().width() * 0.95);

    $('.pipe_wrapper #deleteCardForm').first().remove();

});