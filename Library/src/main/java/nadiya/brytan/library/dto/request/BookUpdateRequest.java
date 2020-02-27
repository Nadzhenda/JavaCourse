package nadiya.brytan.library.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookUpdateRequest extends BookRequest {
    @NotNull
    Long id;
}
