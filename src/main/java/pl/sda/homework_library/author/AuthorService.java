package pl.sda.homework_library.author;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pl.sda.homework_library.author.AuthorMapper.mapAuthorToView;
import static pl.sda.homework_library.author.AuthorMapper.mapRequestBodyToAuthor;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public void createAuthor(AuthorRequestBody authorRequestBody) {
        //dzięki importowi statycznemu możemy zamiast
        //AuthorMapper.mapRequestBodyToAuthor(authorRequestBody);
        //napisać mapRequestBodyToAuthor(authorRequestBody);

        Author author = mapRequestBodyToAuthor(authorRequestBody);
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Author authorById = getAuthorById(id);
        authorRepository.delete(authorById);
    }

    public AuthorView getAuthorViewById(Long id) {
        Author authorById = getAuthorById(id);
        return mapAuthorToView(authorById);
    }

    public Author getAuthorById(Long id) {
        Optional<Author> authorById = authorRepository.findById(id);
        return authorById.orElseThrow(() -> new AuthorNotFoundException("Author with id: " + id + " does not exist."));
    }

    public List<AuthorView> getAllAuthors() {
        List<Author> all = authorRepository.findAll();

        List<AuthorView> authorViews = all.stream().map(AuthorMapper::mapAuthorToView).collect(Collectors.toList());

        return authorViews;
    }

    public void updateAuthor(AuthorRequestBody authorRequestBody, Long id) {
        Author authorById = getAuthorById(id);
        Author newAuthor = mapRequestBodyToAuthor(authorRequestBody);

        authorById.setName(newAuthor.getName());
        authorById.setLastName(newAuthor.getLastName());
        authorById.setBirthDate(newAuthor.getBirthDate());
        authorRepository.save(authorById);
    }

    public Page<AuthorView> getPageOfAuthors(Integer page, Integer authorsPerPage) {
        PageRequest pageRequest = PageRequest.of(page, authorsPerPage);
        Page<Author> authorPage = authorRepository.findAll(pageRequest);
        Page<AuthorView> authorViewPage = authorPage.map(AuthorMapper::mapAuthorToView);
        return authorViewPage;
    }
}
