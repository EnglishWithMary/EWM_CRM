package evg.testt.model;

import lombok.Data;

import java.util.Date;

public @Data
class FullcalendarEvent {

    private Integer id;

    private String title;

    private String color;

    private String url;

    private Date start;

    private Date end;

    private Boolean overlap = false;

    public FullcalendarEvent(){

    }
//
//    public FullcalendarEvent(
//            Integer id,
//            Date start,
//            Date end,
//            String title,
//            String color
//    ){
//        this.id = id;
//        this.start = start;
//        this.end = end;
//        this.title = title;
//        this.color = color;
//    }
}
