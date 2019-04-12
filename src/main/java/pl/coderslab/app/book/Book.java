package pl.coderslab.app.book;

import pl.coderslab.app.author.Author;
import pl.coderslab.app.publisher.Publisher;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    private Author author;
    @Column(scale=2, precision = 4)
    private BigDecimal rating;
    @ManyToOne
    private Publisher publisher;
    private String description;


    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}