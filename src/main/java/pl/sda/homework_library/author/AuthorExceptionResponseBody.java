package pl.sda.homework_library.author;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AuthorExceptionResponseBody {
    private final List<String> message;
    private final LocalDateTime localDateTime;
}
