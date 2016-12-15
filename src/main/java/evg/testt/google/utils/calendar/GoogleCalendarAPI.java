package evg.testt.google.utils.calendar;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.util.List;

public class GoogleCalendarAPI {

    private static final String TIME_ZONE = "Europe/Kiev";

    private static final String APPLICATION_NAME = "EWM CRM TEST";

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static HttpTransport HTTP_TRANSPORT;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static GoogleCredential authorize() throws IOException {
        GoogleCredential credential = GoogleCredential.fromStream(
                GoogleCalendarAPI.class.getResourceAsStream("/ewm-key.json"))
                .createScoped(CalendarScopes.all());
        return credential;
    }

    private static com.google.api.services.calendar.Calendar
    getCalendarService() throws IOException {
        GoogleCredential credential;
        try {
            credential = authorize();
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        }
        return new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Returns list of <tt>com.google.api.services.calendar.model.Event</tt>
     * from <tt>com.google.api.services.calendar.model.Calendar</tt>
     * using given <tt>calendarId</tt>
     *
     * @param calendarId which presents current ID of calendar
     * @return List of events in calendar
     * @throws IOException may cause if Google API is not available
     */
    public static List<Event> getEventsByCalendarId(String calendarId) throws IOException{
        return  getCalendarService().events().list(calendarId).execute().getItems();
    }

    /**
     * Inserts <tt>com.google.api.services.calendar.model.Event</tt> into
     * <tt>com.google.api.services.calendar.model.Calendar</tt>
     * using given <tt>calendarID</tt>
     *
     * @param calendarId which presents current ID of calendar
     * @param event is a given event that needs to be inserted
     * @return <tt>com.google.api.services.calendar.model.Event</tt> of inserted event
     * @throws IOException may cause if Google API is not available
     */
    public static Event insertEvent(String calendarId, Event event) throws IOException{
        return getCalendarService().events().insert(calendarId, event).execute();
    }

    /**
     * Creates a new <tt>com.google.api.service.calendar.model.Calendar</tt>
     *
     * @param calendarSummary is calendar's name, it is used to recognize given calendar
     * @return Calendar.calendarId, calendarId is used for getting calendars from
     * given service (e.g. remote CRM placed at Google)
     * @throws IOException may cause if Google API is not available
     */
    public static String createCalendar(String calendarSummary) throws IOException{
        return getCalendarService().calendars().insert(
                new Calendar()
                        .setSummary(calendarSummary)
                        .setTimeZone(TIME_ZONE)
        ).execute().getId();
    }
}
