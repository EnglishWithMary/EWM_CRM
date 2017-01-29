package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;
import evg.testt.util.fullcalendar.events.SimpleFullcalendarEvent;

public class SimpleFullcalendarBuilderImpl extends FullcalendarBuilderImpl implements SimpleFullcalendarBuider {
    protected ISimpleFullcalendarEvent simpleFullcalendarEvent;

    protected GroupEvent groupEvent;

    public SimpleFullcalendarBuilderImpl() {
        simpleFullcalendarEvent = new SimpleFullcalendarEvent();
    }

    @Override
    public SimpleFullcalendarBuider generateFromGroupEvent() {
        simpleFullcalendarEvent.setId(groupEvent.getId());
        simpleFullcalendarEvent.setTitle(groupEvent.getTitle());
        simpleFullcalendarEvent.setStart(groupEvent.getStartDate());
        simpleFullcalendarEvent.setEnd(groupEvent.getEndDate());
        simpleFullcalendarEvent.setColor(groupEvent.getRoom().getColor());
        return this;
    }

    @Override
    public ISimpleFullcalendarEvent build() {
        return simpleFullcalendarEvent;
//                (ISimpleFullcalendarEvent)
//                (
//                        (SimpleFullcalendarBuider)
//                                (
//                                        new SimpleFullcalendarBuilderImpl()
//                                                .setColor(groupEvent.getRoom().getColor())
//                                                .setStart(groupEvent.getStartDate())
//                                                .setEnd(groupEvent.getEndDate())
//                                )
//                )
//                        .setId(groupEvent.getId())
//                        .setTitle(groupEvent.getTitle())
//                        .getSimpleFullcalendarEvent();
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

//    @Override
//    public ISimpleFullcalendarEvent getSimpleFullcalendarEvent() {
//        return (ISimpleFullcalendarEvent) this.simpleFullcalendarEvent;
//    }

    @Override
    public SimpleFullcalendarBuider setGroupEvent(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
        return this;
    }
}
