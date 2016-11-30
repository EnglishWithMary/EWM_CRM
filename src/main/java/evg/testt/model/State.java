package evg.testt.model;

import lombok.Data;

public @Data class State{

    private String state;

    public State(String state){
        this.state = state;
    }
}
