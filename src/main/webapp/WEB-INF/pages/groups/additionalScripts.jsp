<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/fullcalendar.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/DatePickerForEvents.js"></script>

<script>
    $(document).ready(function() {

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
</script>