package evg.testt.controller;

import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by User on 03.11.2016.
 */
@ControllerAdvice
@PropertySource(value = "classpath:standard.properties")
public class ErrorController {

    @Value("${turn.on.error.page}")
    private String isTurnedOn;

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ModelAndView error404(HttpServletRequest req, Exception ex) throws Exception {
        if(isTurnedOn.equals("true")) {
            ex.printStackTrace();
            return new ModelAndView(JspPath.ERROR);
        }
        else
            throw ex;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView anyException(HttpServletRequest req, Exception ex) throws Exception {

        if(isTurnedOn.equals("true")) {
            ex.printStackTrace();
            return new ModelAndView(JspPath.ERROR);
        }
        else
            throw ex;
    }
}

