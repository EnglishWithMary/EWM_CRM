package evg.testt.model;

public enum StateType {
    STATE_ACTIVE(1), STATE_TRASHED(2), STATE_DELETED(3);

    private int stateId;

    StateType(int id) {
        stateId = id;
    }

    public int getStateId() {
        return stateId;
    }
}
