package evg.testt.model;

public enum PersonState {
    STATE_ACTIVE(1), STATE_HIDDEN(2), STATE_TRASHED(3), STATE_DELETED(4);

    private int stateId;

        PersonState(int id){
            stateId = id;
    }

    public int getStateId()
    {
        return stateId;
    }
}
