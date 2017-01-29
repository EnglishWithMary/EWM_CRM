package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.IFullcalendarEvent;

import java.util.Date;

public abstract class FullcalendarBuilderImpl implements FullCalendarBuilder {
    protected IFullcalendarEvent fullcalendarEvent;

    protected GroupEvent groupEvent;

    public FullcalendarBuilderImpl(){
    }

    @Override
    public FullCalendarBuilder setGroupEvent(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
        return this;
    }

    @Override
    public FullCalendarBuilder setColor(String color) {
        fullcalendarEvent.setColor(color);
        return this;
    }

    @Override
    public FullCalendarBuilder setStart(Date start) {
        fullcalendarEvent.setStart(start);
        return this;
    }

    @Override
    public FullCalendarBuilder setEnd(Date end) {
        fullcalendarEvent.setEnd(end);
        return this;
    }

    @Override
    public abstract IFullcalendarEvent build();
}
