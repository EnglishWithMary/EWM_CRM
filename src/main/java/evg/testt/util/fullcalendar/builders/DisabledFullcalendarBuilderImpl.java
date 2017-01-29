package evg.testt.util.fullcalendar.builders;

import evg.testt.model.GroupEvent;
import evg.testt.util.fullcalendar.events.DisabledFullcalendarEvent;
import evg.testt.util.fullcalendar.events.IDisabledFullcalendarEvent;
import evg.testt.util.fullcalendar.events.IFullcalendarEvent;

public class DisabledFullcalendarBuilderImpl extends FullcalendarBuilderImpl implements DisabledFullcalendarBuilder {
    protected IDisabledFullcalendarEvent disabledFullcalendarEvent;

    protected GroupEvent groupEvent;

    public DisabledFullcalendarBuilderImpl() {
        disabledFullcalendarEvent = new DisabledFullcalendarEvent();
    }

    public DisabledFullcalendarBuilder generateDisabledFullcalendarEvent() {
        disabledFullcalendarEvent.setColor("red");
        disabledFullcalendarEvent.setStart(groupEvent.getStartDate());
        disabledFullcalendarEvent.setEnd(groupEvent.getEndDate());
        disabledFullcalendarEvent.setRendering("background");
        disabledFullcalendarEvent.setOverlap(false);
        return this;
    }

    @Override
    public IDisabledFullcalendarEvent build() {
        return disabledFullcalendarEvent;
//                (
//                        (DisabledFullcalendarBuilder)
//                                (
//                                        new DisabledFullcalendarBuilderImpl()
//                                                .setColor("red")
//                                                .setStart(groupEvent.getStartDate())
//                                                .setEnd(groupEvent.getEndDate())
//                                )
//                )
//                        .setOverLap(false)
//                        .setRendering("background")
//                        .getDisabledFullcalendarEvent();
    }

    @Override
    public DisabledFullcalendarBuilder setOverLap(Boolean overlap) {
        disabledFullcalendarEvent.setOverlap(overlap);
        return this;
    }

    @Override
    public DisabledFullcalendarBuilder setRendering(String rendering) {
        disabledFullcalendarEvent.setRendering(rendering);
        return this;
    }

    @Override
    public DisabledFullcalendarBuilder setGroupEvent(GroupEvent groupEvent){
        this.groupEvent = groupEvent;
        return this;
    }
}
