package pl.sda.homework_library.book;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.sda.homework_library.author.AuthorExceptionResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    BookExceptionResponseBody handleBookNotFoundException(BookNotFoundException e){
        return new BookExceptionResponseBody(List.of(e.getMessage()), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    BookExceptionResponseBody handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> errorMessageList =
                allErrors.stream().map(objectError -> objectError.getDefaultMessage())
                        .collect(Collectors.toList());
        return new BookExceptionResponseBody(errorMessageList,LocalDateTime.now());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    BookExceptionResponseBody handleNullPointerException(NullPointerException e){
        return new BookExceptionResponseBody(List.of(e.getMessage()),LocalDateTime.now());
    }
}
