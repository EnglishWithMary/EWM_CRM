package evg.testt.util.fullcalendar.convertors;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.UrlWrapper;
import evg.testt.util.fullcalendar.events.IDisabledFullcalendarEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEventWithUrl;
import evg.testt.util.fullcalendar.factories.FullcalendarBuilderFactoryImpl;

import java.util.ArrayList;
import java.util.List;

public class FullcalendarConverter {
    private static FullcalendarConverter instance;

    private static FullcalendarBuilderFactoryImpl factory;

    private FullcalendarConverter() {
    }

    private FullcalendarConverter(FullcalendarBuilderFactoryImpl fullcalendarBuilderFactory) {
        factory = fullcalendarBuilderFactory;
    }

    public static FullcalendarConverter getInstance() {
        if (instance == null) {
            instance = new FullcalendarConverter(new FullcalendarBuilderFactoryImpl());
        }
        return instance;
    }

    public List<ISimpleFullcalendarEvent> convertToSimpleFullcalendarEvents(List<GroupEvent> events) {
        List<ISimpleFullcalendarEvent> list = new ArrayList<>();
        for (GroupEvent item : events) {
            list.add(factory.getSimpleFullcalendarBuider().setGroupEvent(item).build());
        }
        return list;
    }

    public List<IDisabledFullcalendarEvent> convertToDisabledFullcalendarEvents(List<GroupEvent> events) {
        List<IDisabledFullcalendarEvent> list = new ArrayList<>();
        for (GroupEvent item : events) {
            list.add(factory.getDisabledFullcalendarBuilder().setGroupEvent(item).build());
        }
        return list;
    }

    public List<ISimpleFullcalendarEventWithUrl> convertToSimpleFullcalendarEventsWithUrl(
            List<GroupEvent> events,
            UrlWrapper wrapper
    ) {
        List<ISimpleFullcalendarEventWithUrl> list = new ArrayList<>();
        for (GroupEvent item : events) {
            list.add(factory.getSimpleFullcalendarBuiderWithUrl()
                    .setGroupEvent(item)
                    .setWrapper(wrapper).build());
        }
        return list;
    }
}
