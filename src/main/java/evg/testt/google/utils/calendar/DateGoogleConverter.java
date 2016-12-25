package evg.testt.google.utils.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.EventDateTime;

import java.util.Date;

public class DateGoogleConverter {
    public static Date convertGoogleDateTimeToDate(EventDateTime dateTime){
        return new Date(dateTime.getDateTime().getValue());
    }
    public static EventDateTime convertDateToGoogleTimeDate(Date date){
        return new EventDateTime().setDateTime(new DateTime(date));
    }
}
