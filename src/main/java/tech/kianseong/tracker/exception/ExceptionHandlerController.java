package tech.kianseong.tracker.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleException() {
        ErrorDto dto = new ErrorDto(HttpStatus.BAD_REQUEST, "Arguments not valid");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDto> handleTaskNotFound(TaskNotFoundException ex) {
        ErrorDto dto = new ErrorDto(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    @Data
    public static class ErrorDto {

        private final int status;
        private final String error;
        private final String message;

        public ErrorDto(HttpStatus httpStatus, String message) {
            status = httpStatus.value();
            error = httpStatus.getReasonPhrase();
            this.message = message;
        }

    }

}
