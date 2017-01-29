package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;

import java.util.Date;

public interface GroupEventBuilder {

    GroupEventBuilder setId(Integer id);

    GroupEventBuilder setTitle(String title);

    GroupEventBuilder setStart(Date start);

    GroupEventBuilder setEnd(Date end);

    GroupEventBuilder setRoom(Room room);

    GroupEventBuilder setGroupId(Integer id);

    GroupEventBuilder setSimpleFullcalendarEvent(ISimpleFullcalendarEvent event);

    GroupEvent build();
}
