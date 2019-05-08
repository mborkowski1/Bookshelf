package com.example.bookshelf;

import com.example.bookshelf.model.Book;
import com.example.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookService bookService;

    @Autowired
    public DataInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .genre("fantasy")
                .title("Hobbit")
                .author("J.R.R. Tolkien")
                .description("Children's fantasy novel by English author J. R. R. Tolkien. It was published on 21 September 1937 to wide critical acclaim, being nominated for the Carnegie Medal and awarded a prize from the New York Herald Tribune for best juvenile fiction. The book remains popular and is recognized as a classic in children's literature.")
                .photo("https://live.staticflickr.com/7023/6582274097_8077f4cd81_b.jpg")
                .build();

        Book book2 = Book.builder()
                .genre("fantasy")
                .title("The Lord Of The Rings")
                .author("J.R.R. Tolkien")
                .description("Epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold.")
                .photo("https://live.staticflickr.com/6205/6028667903_fc4327d365_z.jpg")
                .build();

        Book book3 = Book.builder()
                .genre("fantasy")
                .title("Harry Potter And The Prisoner Of Azkaban")
                .author("J.K. Rowling")
                .description("Fantasy novel written by British author J. K. Rowling and the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry.")
                .photo("https://live.staticflickr.com/3945/33813010702_bc83931d3e_b.jpg")
                .build();

        Book book4 = Book.builder()
                .genre("fantasy")
                .title("Harry Potter And The Cursed Child")
                .author("J.K. Rowling")
                .description("The story begins nineteen years after the events of Harry Potter and the Deathly Hallows and follows Harry Potter, now a Ministry of Magic employee, and his younger son Albus Severus Potter, who is about to attend Hogwarts School of Witchcraft and Wizardry.")
                .photo("https://live.staticflickr.com/8285/28786496982_82c1a56152_b.jpg")
                .build();

        Book book5 = Book.builder()
                .genre("horror")
                .title("The Shining")
                .author("Stephen King")
                .description("Horror novel by American author Stephen King. Published in 1977, it is King's third published novel and first hardback bestseller: the success of the book firmly established King as a preeminent author in the horror genre.")
                .photo("https://live.staticflickr.com/7408/9257093312_1d78ba9c7b_b.jpg")
                .build();

        Book book6 = Book.builder()
                .genre("horror")
                .title("Frankenstein")
                .author("Mary Shelley")
                .description("Novel written by English author Mary Shelley (1797–1851) that tells the story of Victor Frankenstein, a young scientist who creates a hideous, sapient creature in an unorthodox scientific experiment.")
                .photo("https://live.staticflickr.com/4093/4984053610_558431bb86_b.jpg")
                .build();

        Book book7 = Book.builder()
                .genre("sci-fi")
                .title("The War Of The Worlds")
                .author("H.G. Wells")
                .description("Science fiction novel by English author H. G. Wells, first serialized in 1897 by Pearson's Magazine in the UK and by Cosmopolitan magazine in the US. The novel's first appearance in hardcover was in 1898 from publisher William Heinemann of London. Written between 1895 and 1897, it is one of the earliest stories to detail a conflict between mankind and an extraterrestrial race.")
                .photo("https://live.staticflickr.com/3593/3778730672_0991c46cf3_z.jpg")
                .build();

        Book book8 = Book.builder()
                .genre("sci-fi")
                .title("Dune")
                .author("Frank Herbert")
                .description("Dune is a 1965 science fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine. It tied with Roger Zelazny's This Immortal for the Hugo Award in 1966, and it won the inaugural Nebula Award for Best Novel. It is the first installment of the Dune saga, and in 2003 was cited as the world's best-selling science fiction novel.")
                .photo("https://live.staticflickr.com/2779/4521407037_50ecf08533_b.jpg")
                .build();


        bookService.saveBook(book1);
        bookService.saveBook(book2);
        bookService.saveBook(book3);
        bookService.saveBook(book4);
        bookService.saveBook(book5);
        bookService.saveBook(book6);
        bookService.saveBook(book7);
        bookService.saveBook(book8);
    }

}
