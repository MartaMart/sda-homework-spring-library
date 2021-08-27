package pl.sda.homework_library.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.homework_library.author.Author;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long Id;

    private String title;
    private Short year;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Author author;

}
