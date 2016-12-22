package evg.testt.model;

import lombok.Data;

import java.util.Date;

public @Data class RoomEvent {
    private Integer id;
    private String title;
    private Date start;
    private Date end;
}
