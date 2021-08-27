package pl.sda.homework_library.book;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class BookExceptionResponseBody {
    private final List<String> message;
    private final LocalDateTime localDateTime;
}
