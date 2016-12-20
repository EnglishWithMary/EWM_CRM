package evg.testt.util.fullcalendar;

import evg.testt.model.FullcalendarEvent;
import evg.testt.model.GroupEvent;

import java.util.ArrayList;
import java.util.List;

public class FullcalendarHeleper {
    public static FullcalendarEvent convertGroupEventToFullcalendarEvent(GroupEvent groupEvent){
        FullcalendarEvent fullcalendarEvent = new FullcalendarEvent(
                groupEvent.getStartDate(),
                groupEvent.getEndDate(),
                groupEvent.getTitle()
        );
        return fullcalendarEvent;
    }

    public static GroupEvent convertFullcalendarEventToGroupEvent(FullcalendarEvent fullcalendarEvent){
        GroupEvent groupEvent = new GroupEvent();
        groupEvent.setTitle(fullcalendarEvent.getTitle());
        groupEvent.setStartDate(fullcalendarEvent.getStart());
        groupEvent.setEndDate(fullcalendarEvent.getEnd());
        return groupEvent;
    }

    public static List<FullcalendarEvent> convertGroupEventsToFullcalendarEvents(List<GroupEvent> groupEvents){
        List<FullcalendarEvent> fullcalendarEvents = new ArrayList<>();
        for(GroupEvent groupEvent : groupEvents){
            fullcalendarEvents.add(convertGroupEventToFullcalendarEvent(groupEvent));
        }
        return fullcalendarEvents;
    }

    public static List<GroupEvent> convertFullcalendarEventsToGroupEvents(List<FullcalendarEvent> fullcalendarEvents){
        List<GroupEvent> groupEvents = new ArrayList<>();
        for(FullcalendarEvent fullcalendarEvent : fullcalendarEvents){
            groupEvents.add(convertFullcalendarEventToGroupEvent(fullcalendarEvent));
        }
        return groupEvents;
    }
}
