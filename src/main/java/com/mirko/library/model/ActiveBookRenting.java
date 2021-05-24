package com.mirko.library.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@IdClass(ActiveBookRentID.class)
@Table(name = "rentedbooks")
public class ActiveBookRenting {

    @Id
    private Long bookCopyId;
    @Id
    private Long userId;

    @Column(nullable = false)
    private LocalDate dateOfRenting;

    @Column(nullable = false)
    private Long bookId;

    public ActiveBookRenting() {
    }

    public static class Builder {

        private LocalDate dateOfRenting;
        private Long bookId;
        private Long bookCopyId;
        private Long userId;

        public Builder() {
        }

        public Builder withDateOfRenting(LocalDate dateOfRenting) {
            this.dateOfRenting = dateOfRenting;
            return this;
        }

        public Builder withBookID(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder withBookCopyID(Long bookCopyId) {
            this.bookCopyId = bookCopyId;
            return this;
        }

        public Builder withUserID(Long userId) {
            this.userId = userId;
            return this;
        }

        public ActiveBookRenting build() {
            ActiveBookRenting activeBookRenting = new ActiveBookRenting();
            activeBookRenting.dateOfRenting = this.dateOfRenting;
            activeBookRenting.userId = this.userId;
            activeBookRenting.bookCopyId = this.bookCopyId;
            activeBookRenting.bookId = this.bookId;

            return activeBookRenting;

        }

        @Override
        public String toString() {
            return "Builder{" +
                    "dateOfRenting=" + dateOfRenting +
                    ", book_id=" + bookId +
                    ", book_copy_id=" + bookCopyId +
                    ", user_id=" + userId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return dateOfRenting.equals(builder.dateOfRenting) &&
                    bookId.equals(builder.bookId) &&
                    bookCopyId.equals(builder.bookCopyId) &&
                    userId.equals(builder.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dateOfRenting, bookId, bookCopyId, userId);
        }
    }

    public LocalDate getDateOfRenting() {
        return dateOfRenting;
    }

    public void setDateOfRenting(LocalDate dateOfRenting) {
        this.dateOfRenting = dateOfRenting;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long book_id) {
        this.bookId = book_id;
    }

    public Long getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(Long book_copy_id) {
        this.bookCopyId = book_copy_id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user_id) {
        this.userId = user_id;
    }

}
