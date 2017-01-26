package evg.testt.util.fullcalendar.builders;


import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;

public interface SimpleFullcalendarBuider extends FullCalendarBuilder {
    SimpleFullcalendarBuider setId(Integer id);

    SimpleFullcalendarBuider setTitle(String title);

    ISimpleFullcalendarEvent getSimpleFullcalendarEvent();

    SimpleFullcalendarBuider setGroupEvent(GroupEvent groupEvent);

    ISimpleFullcalendarEvent build();

}
