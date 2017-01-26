package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.UrlWrapper;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEventWithUrl;
import evg.testt.util.fullcalendar.events.SimpleFullcalendarEventWithUrl;

public class SimpleFullcalendarWithUrlBuilderImpl extends SimpleFullcalendarBuilderImpl implements SimpleFullcalendarBuiderWithUrl {
    protected ISimpleFullcalendarEventWithUrl simpleFullcalendarEventWithUrl;

    protected UrlWrapper wrapper;

    public SimpleFullcalendarWithUrlBuilderImpl() {
        this.simpleFullcalendarEventWithUrl = new SimpleFullcalendarEventWithUrl();
    }

    public ISimpleFullcalendarEventWithUrl getSimpleFullcalendarEventWithUrl() {
        return this.simpleFullcalendarEventWithUrl;
    }

    public SimpleFullcalendarBuiderWithUrl setWrapper(UrlWrapper wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    @Override
    public ISimpleFullcalendarEventWithUrl build() {
        return
                ((SimpleFullcalendarBuiderWithUrl) (
                        ((SimpleFullcalendarBuider)
                                (new SimpleFullcalendarWithUrlBuilderImpl()
                                        .setColor(groupEvent.getRoom().getColor())
                                        .setStart(groupEvent.getStartDate())
                                        .setEnd(groupEvent.getEndDate())
                                ))
                                .setId(groupEvent.getId())
                                .setTitle(groupEvent.getTitle())
                )).setUrl(wrapper.content(groupEvent.getGroupId().toString()).wrap())
                .getSimpleFullcalendarEventWithUrl();
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
