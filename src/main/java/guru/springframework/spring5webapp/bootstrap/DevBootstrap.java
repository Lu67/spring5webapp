package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;
	private BookRepository bookRepository;

	public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository,
			BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {

		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher bild = new Publisher("Bild", "Bahnhofstr. 123, Berlin");
		Book ddd = new Book("Domain Driven Design", "1234", bild);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		publisherRepository.save(bild);
		bookRepository.save(ddd);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher athena = new Publisher("ATHENA", "Hauptstr. 26, Oberhausen");
		Book noEJB = new Book("J2EE Development without EJB", "23444", athena);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		publisherRepository.save(athena);
		bookRepository.save(noEJB);
	}
}
