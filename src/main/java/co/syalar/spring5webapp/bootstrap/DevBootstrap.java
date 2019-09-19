package co.syalar.spring5webapp.bootstrap;

import co.syalar.spring5webapp.model.Author;
import co.syalar.spring5webapp.model.Book;
import co.syalar.spring5webapp.model.Publisher;
import co.syalar.spring5webapp.repositories.AuthorRepository;
import co.syalar.spring5webapp.repositories.BookRepository;
import co.syalar.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jd.rodriguez
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper Collins", "Fake Address 1");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher workx = new Publisher("Workx", "Fake Addres 2");
        Book noJEB = new Book("J2EE Development without EJB", "23444", workx);
        rod.getBooks().add(noJEB);
        authorRepository.save(rod);
        publisherRepository.save(workx);
        bookRepository.save(noJEB);
    }

}
