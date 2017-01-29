package evg.testt.util.fullcalendar.events;

import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import lombok.Data;

public class SimpleFullcalendarEvent extends FullcalendarEvent implements ISimpleFullcalendarEvent{
    protected Integer id;

    protected String title;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
