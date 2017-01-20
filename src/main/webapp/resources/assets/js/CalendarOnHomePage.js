$(document).ready(function () {
    $('#calendar').fullCalendar({
        header: {
            left: '',
            center: 'title',
            right: ''
        },
        navLinks: false, // can click day/week names to navigate views
        editable: false,
        droppable: false,
        events: '/groups/this-day-events',
        defaultView: 'agendaDay',
        timezone: 'local'
    })
});
