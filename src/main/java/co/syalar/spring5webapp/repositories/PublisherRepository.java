package co.syalar.spring5webapp.repositories;

import co.syalar.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
