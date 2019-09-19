package co.syalar.spring5webapp.repositories;

import co.syalar.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
