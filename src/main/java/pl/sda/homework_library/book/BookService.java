package pl.sda.homework_library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.homework_library.author.Author;
import pl.sda.homework_library.author.AuthorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.sda.homework_library.book.BookMapper.mapBookRequestToBook;
import static pl.sda.homework_library.book.BookMapper.mapBookToBookView;

@RequiredArgsConstructor
@Service
public class BookService {
    public BookRepository bookRepository;


    public void addBook(BookRequestBody bookRequestBody) {
        Book book = mapBookRequestToBook(bookRequestBody);
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.delete(getBookById(id));
    }

    public BookView getBookViewById(Long id) {
        Book bookById = getBookById(id);
        BookView bookView = mapBookToBookView(bookById);
        return bookView;
    }

    public Book getBookById(Long id) {
        Optional<Book> bookById = bookRepository.findById(id);
        return bookById.orElseThrow(()->new BookNotFoundException("There's no such book with id "+id+". "));
    }

    public List<BookView> getAllBooks() throws NullPointerException{
        List<Book> all = bookRepository.findAll();
        List<BookView> collect = all.stream().map(book -> mapBookToBookView(book)).collect(Collectors.toList());
        return collect;
    }

    public void updateBook(BookRequestBody bookRequestBody, Long id) {
        Book bookById = getBookById(id);

        bookById.setTitle(bookRequestBody.getTitle());

        Author author = AuthorMapper.mapRequestBodyToAuthor(bookRequestBody.getAuthor());
        bookById.setAuthor(author);

        bookById.setYear(bookRequestBody.getYear());

        bookRepository.save(bookById);
    }
}
