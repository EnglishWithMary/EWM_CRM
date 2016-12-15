package evg.testt.google.utils.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;

import java.util.Date;

public class DateGoogleConverter {
    public static Date convertGoogleDateTimeToDate(EventDateTime dateTime){
        return new Date(dateTime.getDate().getValue());
    }
    public static EventDateTime convertDateToGoogleTimeDate(Date date){
        EventDateTime eventDateTime = new EventDateTime();
        eventDateTime.setDate(new DateTime(date));
        return eventDateTime;
    }
}
