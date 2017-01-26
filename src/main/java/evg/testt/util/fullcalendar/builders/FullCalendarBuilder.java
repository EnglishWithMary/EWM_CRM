package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.IFullcalendarEvent;

import java.util.Date;

public interface FullCalendarBuilder {

    FullCalendarBuilder setColor(String color);

    FullCalendarBuilder setStart(Date start);

    FullCalendarBuilder setEnd(Date end);

    FullCalendarBuilder setGroupEvent(GroupEvent groupEvent);

    IFullcalendarEvent build();

}
