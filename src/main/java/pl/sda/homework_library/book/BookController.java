package pl.sda.homework_library.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
class BookController {
    private final BookService bookService;

    //dodanie nowej książki
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addBook(@Valid @RequestBody BookRequestBody bookRequestBody){
        bookService.addBook(bookRequestBody);
    }
    //usunięcie książki
    @DeleteMapping("/{id}")
    void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

    //aktualizacja książki
    @PutMapping("/{id}")
    void updateBook(@Valid @RequestBody BookRequestBody bookRequestBody, @PathVariable Long id){
        bookService.updateBook(bookRequestBody, id);
    }
    //wyświetlenie wszystkich książek
    @GetMapping
    List<BookView> getAllBooks(){
        return bookService.getAllBooks();
    }

    //wyświetlenie książki po id
    @GetMapping("/{id}")
    BookView getBookById(@PathVariable Long id){
        return bookService.getBookViewById(id);
    }
}
