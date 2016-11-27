package evg.testt.dto;

import evg.testt.model.Admin;
import evg.testt.model.Person;

public class AdminDTO {
    private String firstName;
    private String lastName;

    public AdminDTO(){}

    public AdminDTO(Admin admin, Person person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
    }

    public Admin getAdmin(){
        return new Admin();
    }

    public Person getPerson(){
        Person person = new Person();
        person.setFirstName(this.firstName);
        person.setLastName(this.lastName);
        return person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
