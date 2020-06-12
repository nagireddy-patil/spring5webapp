package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.nagi.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
