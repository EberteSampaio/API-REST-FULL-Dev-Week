package com.study_dio.eberte.infra;

import com.study_dio.eberte.infra.exceptions.UserAccountNumberExistsException;
import com.study_dio.eberte.infra.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionsAdviceHandler {
   private final Logger logger = LoggerFactory.getLogger(ExceptionsAdviceHandler.class);

   private static final String ERRO_LOG_MESSAGE = "Unexpected server error, see the logs";

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException exception){
        this.logger.error(ERRO_LOG_MESSAGE, exception);
        return exception.getMessage();
    }

    @ExceptionHandler(UserAccountNumberExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userAccountNumberExists(UserAccountNumberExistsException exception){
        this.logger.error(ERRO_LOG_MESSAGE, exception);
        return exception.getMessage();
    }
}
