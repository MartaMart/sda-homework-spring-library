package pl.sda.homework_library.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.sda.homework_library.author.AuthorRequestBody;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class BookRequestBody {
    @NotNull(message = "Book title can't be null.")
    private String title;
    @NotNull(message = "Year of publication can't be null.")
    private Short year;
    @NotNull(message = "The book doesn't have author. Allocate author to book.")
    private AuthorRequestBody author;
}
