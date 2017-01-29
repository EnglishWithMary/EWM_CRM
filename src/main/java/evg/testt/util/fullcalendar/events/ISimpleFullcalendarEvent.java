package evg.testt.util.fullcalendar.events;

public interface ISimpleFullcalendarEvent extends IFullcalendarEvent{

    void setId(Integer id);

    void setTitle(String title);

    Integer getId();

    String getTitle();
}
