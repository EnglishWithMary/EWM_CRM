$(document).ready(function () {
    var path = window.location.pathname;

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        droppable: false,
        events: path + '/calendar/events',
        defaultView: 'month',
        timezone: 'local'
    })
});
