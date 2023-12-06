package bankapplication.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException businessExeption){
        return new ResponseEntity<>(businessExeption.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handle(NoSuchElementException businessExeption){
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle( Throwable businessExeption){
        var message= "unexpected server error, see the logs";
        logger.error(message);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
