package evg.testt.util.fullcalendar.events;

import java.util.Date;

public interface IFullcalendarEvent {

    void setColor(String color);

    void setStart(Date start);

    void setEnd(Date end);

    String getColor();

    Date getStart();

    Date getEnd();
}
