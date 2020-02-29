package nadiya.brytan.library.service;

import nadiya.brytan.library.dto.request.AuthorRequest;
import nadiya.brytan.library.dto.request.AuthorUpdateRequest;
import nadiya.brytan.library.dto.request.PaginationRequest;
import nadiya.brytan.library.dto.response.AuthorResponse;
import nadiya.brytan.library.dto.response.PageResponse;
import nadiya.brytan.library.entity.Author;
import nadiya.brytan.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public void save(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setCountry(authorRequest.getCountry());
        authorRepository.save(author);
    }

    public void update(AuthorUpdateRequest authorUpdateRequest) {
        Author author = new Author();
        author.setId(authorUpdateRequest.getId());
        author.setCountry(authorUpdateRequest.getCountry());
        author.setName(authorUpdateRequest.getName());
        authorRepository.save(author);
    }

    public AuthorResponse findById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.get() != null) {
            return new AuthorResponse(author.get());
        } else {
            return null;
        }
    }

    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.get() != null) {
            return author.get();
        } else {
            return null;
        }
    }

    public PageResponse<AuthorResponse> findAll(PaginationRequest pagination) {
        final Page<Author> page = authorRepository.findAll(pagination.mapToPageable());
        return new PageResponse<>(
                page.get().map(AuthorResponse::new).collect(Collectors.toList()),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    public void delete(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if(author.get() != null) {
            authorRepository.delete(author.get());
        }
    }

}
