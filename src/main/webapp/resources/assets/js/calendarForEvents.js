$(document).ready(function () {
    var path = window.location.pathname;
    $('#success').click(function (data) {
        // alert("text");
        var json = {
            "id": "null",
            "title": $('#title').val(),
            "start": new Date($('#date-start').datetimepicker('viewDate')),
            "end": new Date($('#date-end').datetimepicker('viewDate'))
        };
        $.ajax({
            url: path + '/room/' + $('#room').val() + '/add-event-test',
            dataType: 'json',
            type: 'POST',
            data: JSON.stringify(json),
            contentType: 'application/json',
            success: function (data) {
                // $('#calendar').fullCalendar('refetchEvents');
            },
            error: function (e) {
                // assert(e.responseText);
            }
        });
        $('#myModal').modal('toggle');
    });

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        navLinks: true, // can click day/week names to navigate views
        editable: true,
        droppable: true,
        events: window.location.pathname + "/events",
        /*
         * eventReceive isn't working correctly right now
         */
        eventReceive: function (event) {
            var title = event.title;
            var start = event.start.format("YYYY-MM-DD[T]HH:MM:SS");
            var end = event.end.format("YYYY-MM-DD[T]HH:MM:SS");
            $.ajax({
                url: window.location.pathname + '/add-event-test',
                data: 'title=' + title + '&start=' + start + '&end=' + end,
                type: 'POST',
                dataType: 'json',
                success: function (response) {
                    event.id = response.eventid;
                    $('#calendar').fullCalendar('updateEvent', event);
                },
                error: function (e) {
                    console.log(e.responseText);
                }
            });
            $('#calendar').fullCalendar('updateEvent', event);
        },
        selectable: true,
        selectHelper: true,
        select: function (start, end) {
            $('#myModal').modal();
            $('#date-start input').val(formatDate(start));
            $('#date-end input').val(formatDate(end));

            /**
             * CREATE FUNCTION THAT TRIGGERS MODAL WINDOW AFTER ENTERING TIME
             */
        }
    })
});
