$(document).ready(function () {
    var path = window.location.pathname;
    $('#change-room-select').change(function () {
        var href = this.options[this.selectedIndex].value;
        if (href !== "")
            window.location.pathname = href;
    });

    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        droppable: false,
        events: path + '/events',
        defaultView: 'month',
        timezone: 'local'
    })
});
