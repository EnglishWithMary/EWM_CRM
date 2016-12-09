package evg.testt.model;

import lombok.Data;

import javax.persistence.OneToOne;

public @Data abstract class RegisteredUser extends Human{

    @OneToOne
    User user;
}
