package evg.testt.dao;

import evg.testt.model.Room;

public interface RoomRepository extends BaseRepository<Room> {

    public Room findByName(String name);
}
