package stockApp.Exception;
//MethodArgumentNotValidException
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class StockExcepHandler {
    //MethodArgumentNotValidException

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object>  exceptiondHandle(MethodArgumentNotValidException exception){
//map lo 1st field name , 2nd error name
        Map<String,String> map=new HashMap<>();
        exception.getAllErrors().stream().forEach(objectError -> {
            String fieldName=((FieldError)objectError).getField();
            String errorMessage=objectError.getDefaultMessage();
            map.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);



    }
}

