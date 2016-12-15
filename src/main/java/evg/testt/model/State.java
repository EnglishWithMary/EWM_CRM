package evg.testt.model;

import lombok.Data;

public @Data class State{

    private String state;

    public State(){
        state = StateType.STATE_ACTIVE.getState();
    }

    public State(StateType stateType){
        state = stateType.getState();
    }
}
