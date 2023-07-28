package users.posts.comments.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.EmptyStackException;

public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

    @ExceptionHandler(EmptyStackException.class)
    public ResponseEntity<String> emptyInputException(EmptyInputException emptyInputException) {
        return new ResponseEntity<>("Input field is empty, Please look into it", HttpStatus.BAD_REQUEST);
    }

}
