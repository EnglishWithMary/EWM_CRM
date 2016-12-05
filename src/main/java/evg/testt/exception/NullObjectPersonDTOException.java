package evg.testt.exception;

import java.sql.SQLException;

/**
 * Created by DENNNN on 05.12.2016.
 */
public class NullObjectPersonDTOException extends SQLException {
    public NullObjectPersonDTOException(String reason) {
        super(reason);
    }
}
