package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.nagi.Author;
import guru.springframework.spring5webapp.nagi.Book;
import guru.springframework.spring5webapp.nagi.Publisher;
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

        Author nagi = new Author("Nagi","Reddy");
        Book spring5 = new Book("Learning Spring","1234543");
        Publisher publisher = new Publisher("Nagireddy", "Aakruthi Aura", "Bangalore", "Karnakata", "560066");

        nagi.getBooks().add(spring5);
        spring5.getAuthors().add(nagi);
        publisher.getBooks().add(spring5);

        authorRepository.save(nagi);
        bookRepository.save(spring5);
        publisherRepository.save(publisher);

        Author nayana = new Author("Nayana","Patil");
        Book abc = new Book("Learning ABC","1234543");

        nayana.getBooks().add(abc);
        abc.getAuthors().add(nayana);
        publisher.getBooks().add(abc);

        authorRepository.save(nayana);
        bookRepository.save(abc);
        publisherRepository.save(publisher);

        Author parimala = new Author("Parimala","Patil");
        Book hr = new Book("Learning SAP","1234543");

        parimala.getBooks().add(hr);
        hr.getAuthors().add(parimala);
        publisher.getBooks().add(hr);

        authorRepository.save(parimala);
        bookRepository.save(hr);
        publisherRepository.save(publisher);

        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors: "+ authorRepository.count());
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Number of Publisher: "+ publisherRepository.count());
        System.out.println("Publisher no.of Books: "+ publisher.getBooks().size());
    }
}
