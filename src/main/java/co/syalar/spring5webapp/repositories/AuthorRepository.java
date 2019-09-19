package co.syalar.spring5webapp.repositories;

import co.syalar.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
