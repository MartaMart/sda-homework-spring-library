package pl.sda.homework_library.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
class AuthorController {
    private final AuthorService authorService;

    //stworzenie nowego autora
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createAuthor(@Valid @RequestBody AuthorRequestBody author) {
        authorService.createAuthor(author);
    }

    //usunięcie autora wg id
    @DeleteMapping("/{id}")
    void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    //aktualizacja autora
    @PutMapping("/{id}")
    void updateAuthor(@Valid @RequestBody AuthorRequestBody authorRequestBody, @PathVariable Long id) {
        authorService.updateAuthor(authorRequestBody, id);
    }

    //    //wyświetlenie wszystkich autorów
    @GetMapping("/all")
    List<AuthorView> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    //wyświetlanie wszystkich autorów podzielonych na strony
    @GetMapping
    Page<AuthorView> getAllAuthorPage(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5"
            , name = "size") Integer authorsPerPage) {
        return authorService.getPageOfAuthors(page, authorsPerPage);
    }

    //wyświetlenie pojedyńczego autora
    @GetMapping("/{id}")
    AuthorView getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorViewById(id);
    }

}
