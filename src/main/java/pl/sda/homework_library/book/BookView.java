package pl.sda.homework_library.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.homework_library.author.Author;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class BookView {

    private Long Id;
    private String title;
    private Short year;
    private Author author;
}
