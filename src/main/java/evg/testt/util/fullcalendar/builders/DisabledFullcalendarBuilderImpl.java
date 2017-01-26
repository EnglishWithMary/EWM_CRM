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

    public IDisabledFullcalendarEvent getDisabledFullcalendarEvent() {
        return this.disabledFullcalendarEvent;
    }

    @Override
    public IDisabledFullcalendarEvent build() {
        return
                (
                        (DisabledFullcalendarBuilder)
                                (
                                        new DisabledFullcalendarBuilderImpl()
                                                .setColor("red")
                                                .setStart(groupEvent.getStartDate())
                                                .setEnd(groupEvent.getEndDate())
                                )
                )
                        .setOverLap(false)
                        .setRendering("background")
                        .getDisabledFullcalendarEvent();
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
