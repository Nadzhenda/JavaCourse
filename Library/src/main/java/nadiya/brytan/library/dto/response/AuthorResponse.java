package nadiya.brytan.library.dto.response;

import lombok.Getter;
import lombok.Setter;
import nadiya.brytan.library.entity.Author;
import nadiya.brytan.library.entity.Book;

import java.util.List;

@Getter
@Setter
public class AuthorResponse {
    private Long id;
    private String name;
    private String country;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.country = author.getCountry();
    }
}
