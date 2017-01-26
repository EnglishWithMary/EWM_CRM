package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.IDisabledFullcalendarEvent;

public interface DisabledFullcalendarBuilder extends FullCalendarBuilder {

    DisabledFullcalendarBuilder setOverLap(Boolean overlap);

    DisabledFullcalendarBuilder setRendering(String rendering);

    IDisabledFullcalendarEvent getDisabledFullcalendarEvent();

    DisabledFullcalendarBuilder setGroupEvent(GroupEvent groupEvent);

    IDisabledFullcalendarEvent build();

}
