package evg.testt.exception;

public class PersonFieldTypeNotFoundException extends RuntimeException {
    public PersonFieldTypeNotFoundException(String message){
        super(message);
    }
}