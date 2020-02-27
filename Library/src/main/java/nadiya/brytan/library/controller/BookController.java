package nadiya.brytan.library.controller;

import nadiya.brytan.library.dto.request.BookRequest;
import nadiya.brytan.library.dto.request.BookUpdateRequest;
import nadiya.brytan.library.dto.request.PaginationRequest;
import nadiya.brytan.library.dto.response.BookResponse;
import nadiya.brytan.library.dto.response.PageResponse;
import nadiya.brytan.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public void save(@Valid @RequestBody BookRequest bookRequest) {
        bookService.save(bookRequest);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        bookService.update(bookUpdateRequest);
    }

    @GetMapping("/find")
    public BookResponse findById(@NotNull Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/page")
    public PageResponse<BookResponse> findAll(@Valid @RequestBody PaginationRequest pagination) {
        return bookService.findAll(pagination);
    }

    @DeleteMapping("/delete")
    public void  delete(@NotNull Long id){
        bookService.delete(id);
    }

}
