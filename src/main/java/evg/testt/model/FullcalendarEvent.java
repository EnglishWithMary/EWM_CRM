package evg.testt.model;

import lombok.Data;

import java.util.Date;

public @Data
class FullcalendarEvent {

    private Integer id;

    private String title;

    private Date start;

    private Date end;

    public FullcalendarEvent(){

    }

    public FullcalendarEvent(
            Integer id,
            Date start,
            Date end,
            String title
    ){
        this.id = id;
        this.start = start;
        this.end = end;
        this.title = title;
    }
}
