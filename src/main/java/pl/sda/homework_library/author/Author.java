package pl.sda.homework_library.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.homework_library.book.Book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String lastName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
