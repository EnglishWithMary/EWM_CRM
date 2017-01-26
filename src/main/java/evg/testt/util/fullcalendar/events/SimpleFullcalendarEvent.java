package evg.testt.util.fullcalendar.events;

import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import lombok.Data;

public @Data class SimpleFullcalendarEvent extends FullcalendarEvent implements ISimpleFullcalendarEvent{
    protected Integer id;

    protected String title;
}
