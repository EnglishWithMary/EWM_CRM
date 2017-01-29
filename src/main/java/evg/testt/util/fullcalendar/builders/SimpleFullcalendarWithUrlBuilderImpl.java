package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.UrlWrapper;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEventWithUrl;
import evg.testt.util.fullcalendar.events.SimpleFullcalendarEventWithUrl;

public class SimpleFullcalendarWithUrlBuilderImpl extends SimpleFullcalendarBuilderImpl implements SimpleFullcalendarBuiderWithUrl {
    protected ISimpleFullcalendarEventWithUrl simpleFullcalendarEventWithUrl;

    protected GroupEvent groupEvent;

    protected UrlWrapper wrapper;

    public SimpleFullcalendarWithUrlBuilderImpl() {
        this.simpleFullcalendarEventWithUrl = new SimpleFullcalendarEventWithUrl();
    }

    public SimpleFullcalendarBuiderWithUrl generateSimpleFullcalendarEventWithUrl() {
        simpleFullcalendarEventWithUrl.setUrl(wrapper.content(groupEvent.getGroupId().toString()).wrap());
        simpleFullcalendarEventWithUrl.setId(groupEvent.getId());
        simpleFullcalendarEventWithUrl.setTitle(groupEvent.getTitle());
        simpleFullcalendarEventWithUrl.setStart(groupEvent.getStartDate());
        simpleFullcalendarEventWithUrl.setEnd(groupEvent.getEndDate());
        simpleFullcalendarEventWithUrl.setColor(groupEvent.getRoom().getColor());
        return this;
    }

    public SimpleFullcalendarBuiderWithUrl setWrapper(UrlWrapper wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    @Override
    public ISimpleFullcalendarEventWithUrl build() {
        return simpleFullcalendarEventWithUrl;
//                ((SimpleFullcalendarBuiderWithUrl) (
//                        ((SimpleFullcalendarBuider)
//                                (new SimpleFullcalendarWithUrlBuilderImpl()
//                                        .setColor(groupEvent.getRoom().getColor())
//                                        .setStart(groupEvent.getStartDate())
//                                        .setEnd(groupEvent.getEndDate())
//                                ))
//                                .setId(groupEvent.getId())
//                                .setTitle(groupEvent.getTitle())
//                )).setUrl(wrapper.content(groupEvent.getGroupId().toString()).wrap())
//                .getSimpleFullcalendarEventWithUrl();
    }

    @Override
    public SimpleFullcalendarBuiderWithUrl setUrl(String url) {
        this.simpleFullcalendarEventWithUrl.setUrl(url);
        return this;
    }

    @Override
    public SimpleFullcalendarBuiderWithUrl setGroupEvent(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
        return this;
    }
}
