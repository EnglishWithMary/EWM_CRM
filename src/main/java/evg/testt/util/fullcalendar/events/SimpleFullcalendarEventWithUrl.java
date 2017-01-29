package evg.testt.util.fullcalendar.events;

import evg.testt.util.fullcalendar.events.SimpleFullcalendarEvent;
import lombok.Data;

public class SimpleFullcalendarEventWithUrl  extends SimpleFullcalendarEvent implements ISimpleFullcalendarEventWithUrl{
    protected String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }
}
