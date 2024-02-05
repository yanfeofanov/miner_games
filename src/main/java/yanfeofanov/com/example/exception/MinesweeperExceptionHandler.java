package yanfeofanov.com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MinesweeperExceptionHandler {


    @ExceptionHandler(MinesweeperExceptionBadRequest.class)
    public ResponseEntity<?> handlerNotFound(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }
}
