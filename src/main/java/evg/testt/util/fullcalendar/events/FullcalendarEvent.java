package evg.testt.util.fullcalendar.events;

import lombok.Data;

import java.util.Date;

public abstract class FullcalendarEvent implements IFullcalendarEvent {

//    protected Integer id;

//    protected String title;

//    private String url;

    protected String color;

    protected Date start;

    protected Date end;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Date getStart() {
        return start;
    }

    @Override
    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public Date getEnd() {
        return end;
    }

    @Override
    public void setEnd(Date end) {
        this.end = end;
    }

    //    private Boolean overlap;
//
//    private String rendering;

    public FullcalendarEvent(){

    }
}
