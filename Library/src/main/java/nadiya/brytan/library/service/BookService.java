package nadiya.brytan.library.service;

import nadiya.brytan.library.dto.request.BookRequest;
import nadiya.brytan.library.dto.request.BookUpdateRequest;
import nadiya.brytan.library.dto.request.PaginationRequest;
import nadiya.brytan.library.dto.response.BookResponse;
import nadiya.brytan.library.dto.response.PageResponse;
import nadiya.brytan.library.entity.Author;
import nadiya.brytan.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import nadiya.brytan.library.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;

    public void save(BookRequest request) {
        Book book = new Book();
        book.setAuthor(authorService.getAuthorById(request.getAuthorId()));
        book.setName(request.getName());
        book.setLanguage(request.getLanguage());
        book.setPageNum(request.getPageNum());
        bookRepository.save(book);
    }

    public PageResponse<BookResponse> findAll(PaginationRequest pagination) {
        final Page<Book> page = bookRepository.findAll(pagination.mapToPageable());
        return new PageResponse<>(
                page.get().map(BookResponse::new).collect(Collectors.toList()),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    public void update(BookUpdateRequest request) {
        Book book = new Book();
        book.setAuthor(authorService.getAuthorById(request.getAuthorId()));
        book.setId(request.getId());
        book.setName(request.getName());
        book.setLanguage(request.getLanguage());
        book.setPageNum(request.getPageNum());
        bookRepository.save(book);
    }

    public void delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.get() != null){
            bookRepository.delete(book.get());
        }
    }

    public BookResponse findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.get() != null) {
            return new BookResponse(book.get());
        } else {
            return null;
        }
    }

}
