package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author george = new Author("George","Orwell");
        Book libro1984 = new Book("1984","12341234");
        george.getBooks().add(libro1984);
        libro1984.getAuthors().add(george);
        authorRepository.save(george);
        bookRepository.save(libro1984);

        Author rod = new Author("Rod","Johnson");
        Book noEJ8 = new Book("J2EE Development without EJ8","123456789");
        rod.getBooks().add(noEJ8);
        noEJ8.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJ8);

        Publisher santillana = new Publisher("Santillana","Avenida de la Castellana 1", "Madrid", "Madrid", 1);
        publisherRepository.save(santillana);

        System.out.println("Data started by boostrap");
        System.out.println("Number of book saved: "+bookRepository.count());
        System.out.println("The publisher is: "+santillana.toString());



    }
}
