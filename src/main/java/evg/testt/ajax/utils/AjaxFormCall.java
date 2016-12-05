package evg.testt.ajax.utils;

/**
 * Created by DENNNN on 05.12.2016.
 */
public class AjaxFormCall {
    private int from;
    private int destination;
    private int personId;

    public AjaxFormCall() {
    }

    public AjaxFormCall(int from, int destination, int personId) {
        this.from = from;
        this.destination = destination;
        this.personId = personId;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
