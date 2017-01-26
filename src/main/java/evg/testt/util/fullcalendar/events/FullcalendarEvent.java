package evg.testt.util.fullcalendar.events;

import lombok.Data;

import java.util.Date;

public @Data abstract
class FullcalendarEvent implements IFullcalendarEvent {

//    protected Integer id;

//    protected String title;

    protected String color;

//    private String url;

    protected Date start;

    protected Date end;

//    private Boolean overlap;
//
//    private String rendering;

    public FullcalendarEvent(){

    }
}
