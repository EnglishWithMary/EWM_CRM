<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/resources/assets/js/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/fullcalendar.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/DatePickerForEvents.js"></script>

<%--<link rel="stylesheet" href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" />--%>


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