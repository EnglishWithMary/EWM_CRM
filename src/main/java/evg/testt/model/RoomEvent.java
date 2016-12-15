package evg.testt.model;

import lombok.Data;

import java.util.Date;

public @Data class RoomEvent {
    Integer id;
    String title;
    Date start;
    Date end;
}
