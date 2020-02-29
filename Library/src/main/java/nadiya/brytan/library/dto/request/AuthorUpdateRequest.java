package nadiya.brytan.library.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorUpdateRequest extends AuthorRequest {
    @NotNull
    Long id;
}
