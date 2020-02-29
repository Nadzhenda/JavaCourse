package nadiya.brytan.library.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import nadiya.brytan.library.entity.Author;
import nadiya.brytan.library.entity.Book;


@Getter
@Setter
public class BookResponse {
    private Long id;
    private String name;
    private String language;
    private Integer pageNum;
    private String author;

    public BookResponse (Book book) {
        id = book.getId();
        name = book.getName();
        language = book.getLanguage();
        pageNum = book.getPageNum();
        author = book.getAuthor().getName();
    }
}
