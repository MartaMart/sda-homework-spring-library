package pl.sda.homework_library.author;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AuthorExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    AuthorExceptionResponseBody handleAuthorNotFoundException(AuthorNotFoundException e) {
        return new AuthorExceptionResponseBody(List.of(e.getMessage()), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    AuthorExceptionResponseBody handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<String> errorMessageList =
                allErrors.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        return new AuthorExceptionResponseBody(errorMessageList, LocalDateTime.now());
    }


}
