package nadiya.brytan.library.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthorRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String country;
}
