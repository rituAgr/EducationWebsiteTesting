package com.Ritu.EducationWebsite.Exception;

import com.Ritu.EducationWebsite.Topic.TopicController;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(assignableTypes = {TopicController.class})
public class TopicControllerAdvice {

    @ExceptionHandler(TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleTopicNotFoundException(final TopicNotFoundException ex) {
        return new ErrorResponse("TOPIC_NOT_FOUND", "The Topic was not found");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInValidIDException(final ConstraintViolationException ex) {
        return new ErrorResponse("ID is inValid", "Id is invalid");
    }

    @ExceptionHandler(InValidInputParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInValidInputParametersException(final InValidInputParametersException ex) {
        return new ErrorResponse("Input parameter don't meet accepted criteria", "update id in url dont match the body id");
    }


}