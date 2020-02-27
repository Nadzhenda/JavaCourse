package nadiya.brytan.library.dto.response;

import lombok.Getter;
import lombok.Setter;
import nadiya.brytan.library.entity.Book;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String name;
    private String author;
    private String language;
    private Integer pageNum;

    public BookResponse (Book book) {
        id = book.getId();
        name = book.getName();
        author = book.getAuthor();
        language = book.getLanguage();
        pageNum = book.getPageNum();
    }
}
