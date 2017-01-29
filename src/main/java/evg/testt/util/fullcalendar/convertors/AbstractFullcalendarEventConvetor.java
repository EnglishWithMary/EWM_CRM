package evg.testt.util.fullcalendar.convertors;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import lombok.Data;

public @Data
abstract class AbstractFullcalendarEventConvetor implements FullcalendarEventConvetor {
    protected GroupEvent groupEvent;

    public AbstractFullcalendarEventConvetor(){

    }
    public AbstractFullcalendarEventConvetor(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
    }

}
