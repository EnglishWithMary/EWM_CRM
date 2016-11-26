package evg.testt.model;

<<<<<<< HEAD
import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "states")
public @Data class State extends BaseModel {

    private String state;
=======
public enum State {

	ACTIVE("Active"),
	INACTIVE("Inactive"),
	DELETED("Deleted"),
	LOCKED("Locked");
	
	private String state;

	private State(final String state){
		this.state = state;
	}

	public String getState(){
		return this.state;
	}

	@Override
	public String toString(){
		return this.state;
	}

	public String getName(){
		return this.name();
	}
>>>>>>> 5ef3a92b5c6b9a7fefcab426c5e62303b1946b08
}
