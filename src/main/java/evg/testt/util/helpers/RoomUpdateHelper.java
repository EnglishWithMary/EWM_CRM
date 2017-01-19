package evg.testt.util.helpers;

import evg.testt.model.Room;

public class RoomUpdateHelper {

    public static Room updateRoom(Room r){
        Room room = new Room();
        room.setId(r.getId());
        room.setColor(r.getColor());
        room.setName(r.getName());
        return room;
    }
}
