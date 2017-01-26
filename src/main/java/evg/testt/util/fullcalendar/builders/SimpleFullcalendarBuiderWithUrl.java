package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.UrlWrapper;
import evg.testt.util.fullcalendar.builders.SimpleFullcalendarBuider;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEventWithUrl;
import evg.testt.util.fullcalendar.events.SimpleFullcalendarEvent;

public interface SimpleFullcalendarBuiderWithUrl extends SimpleFullcalendarBuider {

    SimpleFullcalendarBuiderWithUrl setUrl(String url);

    ISimpleFullcalendarEventWithUrl getSimpleFullcalendarEventWithUrl();

    SimpleFullcalendarBuiderWithUrl setGroupEvent(GroupEvent groupEvent);

    SimpleFullcalendarBuiderWithUrl setWrapper(UrlWrapper wrapper);

    ISimpleFullcalendarEventWithUrl build();

}
