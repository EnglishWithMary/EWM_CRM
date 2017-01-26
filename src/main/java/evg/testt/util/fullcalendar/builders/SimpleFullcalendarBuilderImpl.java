package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.DisabledFullcalendarEvent;
import evg.testt.util.fullcalendar.events.IDisabledFullcalendarEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;
import evg.testt.util.fullcalendar.events.SimpleFullcalendarEvent;

public class SimpleFullcalendarBuilderImpl extends FullcalendarBuilderImpl implements SimpleFullcalendarBuider {
    protected ISimpleFullcalendarEvent simpleFullcalendarEvent;

    public SimpleFullcalendarBuilderImpl() {
        simpleFullcalendarEvent = new SimpleFullcalendarEvent();
    }

    public ISimpleFullcalendarEvent getISimpleFullcalendarEvent() {
        return this.simpleFullcalendarEvent;
    }

    @Override
    public ISimpleFullcalendarEvent build() {
        return (ISimpleFullcalendarEvent)
                (
                        (SimpleFullcalendarBuider)
                                (
                                        new SimpleFullcalendarBuilderImpl()
                                                .setColor(groupEvent.getRoom().getColor())
                                                .setStart(groupEvent.getStartDate())
                                                .setEnd(groupEvent.getEndDate())
                                )
                )
                        .setId(groupEvent.getId())
                        .setTitle(groupEvent.getTitle())
                        .getSimpleFullcalendarEvent();
    }

    @Override
    public SimpleFullcalendarBuider setId(Integer id) {
        this.simpleFullcalendarEvent.setId(id);
        return this;
    }

    @Override
    public SimpleFullcalendarBuider setTitle(String title) {
        this.simpleFullcalendarEvent.setTitle(title);
        return this;
    }

    @Override
    public ISimpleFullcalendarEvent getSimpleFullcalendarEvent() {
        return (ISimpleFullcalendarEvent) this.simpleFullcalendarEvent;
    }

    @Override
    public SimpleFullcalendarBuider setGroupEvent(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
        return this;
    }
}
