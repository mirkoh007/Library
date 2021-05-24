package com.mirko.library.model;

import com.mirko.library.abstractclasses.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book extends AbstractEntity {

    @Column(nullable = false, length = 256)
    private String title;

    @Column(nullable = false, length = 256)
    private String authorName;

    @Column(nullable = false, length = 256)
    private String publisher;

    @Column(nullable = false)
    private LocalDate dateOfPublishing;

    public Book() {

    }

    public Book(String title, String authorName, String publisher, LocalDate dateOfPublishing) {
        super();
        this.title = title;
        this.authorName = authorName;
        this.publisher = publisher;
        this.dateOfPublishing = dateOfPublishing;
    }

    public static class Builder {

        private Long id;
        private String title;
        private String authorName;
        private String publisher;
        private LocalDate dateOfPublishing;

        public Builder() {
        }

        public Builder withID(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder withDateOfPublishig(LocalDate dateOfPublishig) {
            this.dateOfPublishing = dateOfPublishig;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.id = this.id;
            book.title = this.title;
            book.authorName = this.authorName;
            book.publisher = this.publisher;
            book.dateOfPublishing = this.dateOfPublishing;

            return book;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(LocalDate dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                authorName.equals(book.authorName) &&
                publisher.equals(book.publisher) &&
                dateOfPublishing.equals(book.dateOfPublishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorName, publisher, dateOfPublishing);
    }
}
