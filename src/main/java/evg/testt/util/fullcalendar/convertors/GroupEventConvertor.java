package evg.testt.util.fullcalendar.convertors;

import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import evg.testt.util.fullcalendar.events.ISimpleFullcalendarEvent;
import evg.testt.util.fullcalendar.factories.GroupEventBuilderFactoryImpl;

public class GroupEventConvertor {

    private static GroupEventConvertor instance;

    private GroupEventConvertor(){}

    public static GroupEventConvertor getInstance(){
        if(instance == null){
            instance = new GroupEventConvertor();
        }
        return instance;
    }

    public GroupEvent ConvertToGroupEvent(
            Integer groupId,
            Room room,
            ISimpleFullcalendarEvent event
    ){
        GroupEvent groupEvent = GroupEventBuilderFactoryImpl
                .getInstance()
                .getGroupEventBuilder()
                .setGroupId(groupId)
                .setRoom(room)
                .setId(event.getId())
                .setTitle(event.getTitle())
                .setStart(event.getStart())
                .setEnd(event.getEnd())
                .build();
        return groupEvent;
    }
}
