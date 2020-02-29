package nadiya.brytan.library.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class BookRequest {
    @NotBlank
    private String name;
    @NotNull
    private Long authorId;
    @NotBlank
    private String language;
    @NotNull
    @Positive
    private Integer pageNum;
}
