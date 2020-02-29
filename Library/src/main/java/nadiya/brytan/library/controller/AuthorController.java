package nadiya.brytan.library.controller;

import nadiya.brytan.library.dto.request.*;
import nadiya.brytan.library.dto.response.AuthorResponse;
import nadiya.brytan.library.dto.response.PageResponse;
import nadiya.brytan.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public void save(@Valid AuthorRequest authorRequest) {
        authorService.save(authorRequest);
    }

    @PutMapping("/update")
    public void update(@Valid AuthorUpdateRequest authorUpdateRequest) {
        authorService.update(authorUpdateRequest);
    }

    @GetMapping("/find")
    public AuthorResponse findById(@NotNull Long id) {
        return authorService.findById(id);
    }

    @GetMapping("/page")
    public PageResponse<AuthorResponse> findAll(@Valid PaginationRequest pagination) {
        return authorService.findAll(pagination);
    }

    @DeleteMapping("/delete")
    public void  delete(@NotNull Long id) {
        authorService.delete(id);
    }


}
