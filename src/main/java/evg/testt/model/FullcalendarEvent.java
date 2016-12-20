package evg.testt.model;

import lombok.Data;

import java.util.Date;

public @Data
class FullcalendarEvent {
    private Date start;

    private Date end;

    private String title;

    public FullcalendarEvent(){

    }

    public FullcalendarEvent(
            Date start,
            Date end,
            String title
    ){
        this.start = start;
        this.end = end;
        this.title = title;
    }
}
