package evg.testt.model;

public enum StateType {
    STATE_ACTIVE("ACTIVE"), STATE_TRASHED("TRASHED"), STATE_DELETED("DELETED");

    private String state;

    StateType(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

