package pl.sda.homework_library.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.homework_library.book.Book;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class AuthorView {
    private Long Id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private List<Book> books;
}
