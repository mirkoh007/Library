package com.mirko.library.model;

import com.mirko.library.abstractclasses.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bookcopyies")
public class BookCopy extends AbstractEntity {

    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    public BookCopy() {
    }

    public static class Builder {

        private String serialNumber;
        private Book book;

        public Builder() {
        }

        public Builder withSerial(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public Builder withBook(Book book) {
            this.book = book;
            return this;
        }

        public BookCopy build() {
            BookCopy bookCopy = new BookCopy();
            bookCopy.serialNumber = this.serialNumber;
            bookCopy.book = this.book;

            return bookCopy;
        }
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "serialNumber='" + serialNumber + '\'' +
                ", book=" + book +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCopy bookCopy = (BookCopy) o;
        return serialNumber.equals(bookCopy.serialNumber) &&
                book.equals(bookCopy.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, book);
    }
}
