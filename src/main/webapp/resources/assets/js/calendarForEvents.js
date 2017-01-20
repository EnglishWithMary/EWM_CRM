$(document).ready(function () {
    var path = window.location.pathname;
    $('#success').click(function (data) {

        var eventId = $('#myModal').find("#eventId").val();
        var json = {
            "id": eventId,
            "title": $('#title').val(),
            "start": new Date($('#date-start').find("input").val()),
            "end": new Date($('#date-end').find("input").val())
        };
        $.ajax({
            url: path + '/room/' + $('#room').val() + '/add-event-test',
            dataType: 'json',
            type: 'POST',
            data: JSON.stringify(json),
            contentType: 'application/json',
            timeout: 100000,
            success: function (data) {
                $('#calendar').fullCalendar('refetchEvents');
            }
        });

        $('#myModal').find("#eventId").attr("value", 0);
        $('#myModal').modal('toggle');
    });

    $('#delete').click(function (data) {

        var eventId = $('#myModal').find("#eventId").val();
        var json = {
            "id": eventId,
        };

        if(eventId > 0) {
            $.ajax({
                url: path + '/delete/event',
                dataType: 'json',
                type: 'POST',
                data: JSON.stringify(json),
                contentType: 'application/json',
                timeout: 100000,
                success: function (data) {
                    $('#calendar').fullCalendar('refetchEvents');
                },
            });
        }
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
        timezone: "local",
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
        },

        eventClick: function(event, jsEvent, view){
            $('#myModal').modal();
            $('#date-start').val(formatDate(event.start));
            $('#date-end').val(formatDate(event.end));
            $('#myModal').find("#eventId").attr("value", event.id);
            $('#myModal').find("#title").attr("value", event.title);
        },

        eventDrop: function(event, delta, revertFunc) {
            var json = {
                "id": event.id,
                "title": event.title,
                "start": new Date(formatDate(event.start)),
                "end": new Date(formatDate(event.end))
            };
            $.ajax({
                url: path + '/room/' + $('#room').val() + '/add-event-test',
                dataType: 'json',
                type: 'POST',
                data: JSON.stringify(json),
                contentType: 'application/json',
                timeout: 100000
            });
        }
    })
});
