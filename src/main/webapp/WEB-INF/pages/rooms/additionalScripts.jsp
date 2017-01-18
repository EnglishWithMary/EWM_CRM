<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Scripts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.45/js/bootstrap-datetimepicker.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/assets/js/DatePickerForEvents.js"></script>

<script>
    $(document).ready(function() {

        // page is now ready, initialize the calendar...

        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay,listWeek'
            },
            navLinks: true, // can click day/week names to navigate views
            editable: true,
            events: window.location.pathname + "/events"
        })

    });
//    $(document).ready(function () {
//        $.ajax({
//            url: window.location.pathname + "/events",
//            success: function (result) {
//
//            }
//        });
//    });
</script>