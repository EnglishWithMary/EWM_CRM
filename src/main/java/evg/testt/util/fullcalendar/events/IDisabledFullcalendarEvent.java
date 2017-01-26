package evg.testt.util.fullcalendar.events;

public interface IDisabledFullcalendarEvent extends IFullcalendarEvent{

    void setOverlap(Boolean overlap);
    void setRendering(String rendering);
    Boolean getOverlap();
    String getRendering();
}
