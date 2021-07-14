package thanh.code.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class RentalBook {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    public RentalBook() {
    }

    public RentalBook(Integer id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
