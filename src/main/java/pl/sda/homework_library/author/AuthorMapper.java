package pl.sda.homework_library.author;

public class AuthorMapper {

    //AuthorRequestBody->Author
    //public because it is necessary for BookMapper class
    public static Author mapRequestBodyToAuthor(AuthorRequestBody authorRequestBody) {

        return Author.builder().name(authorRequestBody.getName()).lastName(authorRequestBody.getLastName()).birthDate(authorRequestBody.getBirthDate()).build();
    }

    //Author->AuthorView
    static AuthorView mapAuthorToView(Author author) {
        return AuthorView.of(author.getId(), author.getName(), author.getLastName(), author.getBirthDate(),
                author.getBooks());
    }

}
