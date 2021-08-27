package pl.sda.homework_library.book;

import pl.sda.homework_library.author.Author;
import pl.sda.homework_library.author.AuthorMapper;


class BookMapper {

    //Book->BookView
    static BookView mapBookToBookView(Book book) {
        return BookView.of(book.getId(), book.getTitle(), book.getYear(), book.getAuthor());
    }

    //BookRequestBody->Book
    static Book mapBookRequestToBook(BookRequestBody bookRequestBody) {
        Author author = AuthorMapper.mapRequestBodyToAuthor(bookRequestBody.getAuthor());

        return Book.builder().title(bookRequestBody.getTitle()).year(bookRequestBody.getYear()).author(author).build();
    }
}
