package evg.testt.controller;

import evg.testt.util.JspPath;
import org.apache.tiles.request.jsp.JspUtil;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * Created by User on 03.11.2016.
 */
@ControllerAdvice
public class ErrorController {
    @RequestMapping(value = "/error403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView(JspPath.ERROR);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView pageNotFound(NoHandlerFoundException ex) {
        return new ModelAndView(JspPath.ERROR);
    }

    @ExceptionHandler(ConversionNotSupportedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView iternalError(ConversionNotSupportedException ex) {
        return new ModelAndView(JspPath.ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView anyException(Exception ex) {
        return new ModelAndView(JspPath.ERROR);
    }
}

