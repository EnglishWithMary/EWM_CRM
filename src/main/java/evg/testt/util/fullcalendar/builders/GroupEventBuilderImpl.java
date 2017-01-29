package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;

import java.util.Date;

public class GroupEventBuilderImpl implements GroupEventBuilder {

    private GroupEvent groupEvent;

    public GroupEventBuilderImpl(){
        groupEvent = new GroupEvent();
    }

    @Override
    public GroupEventBuilder setId(Integer id) {
        this.groupEvent.setId(id);
        return this;
    }

    @Override
    public GroupEventBuilder setTitle(String title) {
        this.groupEvent.setTitle(title);
        return this;
    }

    @Override
    public GroupEventBuilder setStart(Date start) {
        this.groupEvent.setStartDate(start);
        return this;
    }

    @Override
    public GroupEventBuilder setEnd(Date end) {
        this.groupEvent.setEndDate(end);
        return this;
    }

    @Override
    public GroupEventBuilder setRoom(Room room) {
        this.groupEvent.setRoom(room);
        return this;
    }

    @Override
    public GroupEventBuilder setGroupId(Integer id) {
        this.groupEvent.setGroupId(id);
        return this;
    }

    @Override
    public GroupEventBuilder setSimpleFullcalendarEvent(ISimpleFullcalendarEvent event) {
        return null;
    }

    @Override
    public GroupEvent build() {
        return this.groupEvent;
    }
}
