$(document).ready(function () {

//        Date.parseDate = function( input, format ){
//            return moment(input,format).toDate();
//        };
//        Date.prototype.dateFormat = function( format ){
//            return moment(this).format(format);
//        };

//        element.datetimepicker({
//            format:      'YYYY-MM-DD\\THH:mm:ssZ',
//            formatTime:  'HH:mm',
//            formatDate:  'YYYY-MM-DD'
//        });

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
//                var title = function(){
//                    $('#myModal').modal();
//                };
            $('#myModal').modal();
//                var title = $('#myModal #title').val();
//                var title = prompt("Text");
//                $('#myModal').modal();
//                if (title) {
//                    $('#calendar').fullCalendar('renderEvent',
//                        {
//                            title: title,
//                            start: start,
//                            end: end
//                        },
//                        true // make the event "stick"
//                    );
//                }
            $('#date-start input').val(formatDate(start));
            $('#date-end input').val(formatDate(end));
//                alert(title + start.toString() + end.toString() + allDay.valueOf());
//                calendar.fullCalendar('unselect');

            /**
             * CREATE FUNCTION THAT TRIGGERS MODAL WINDOW AFTER ENTERING TIME
             */
        }
    })
});
