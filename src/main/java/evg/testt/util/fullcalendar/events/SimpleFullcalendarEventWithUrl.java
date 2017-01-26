package evg.testt.util.fullcalendar.events;

import evg.testt.util.fullcalendar.events.SimpleFullcalendarEvent;
import lombok.Data;

public @Data class SimpleFullcalendarEventWithUrl  extends SimpleFullcalendarEvent implements ISimpleFullcalendarEventWithUrl{
    protected String url;
}
