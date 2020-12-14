package com.mirko.library.model;

import com.mirko.library.abstractclasses.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "archives")
public class ArchiveOfRenting extends AbstractEntity {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long bookCopyId;

    @Column(nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private LocalDate dateOfRenting;

    @Column(nullable = false)
    private LocalDate dateOfReturning;

    public ArchiveOfRenting() {
    }

    public static class Builder{
        private Long id;
        private Long userId;
        private Long bookCopyId;
        private Long bookId;
        private LocalDate dateOfRenting;
        private LocalDate dateOfReturning;

        public Builder() {}

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withUserId(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder withBookCopyId(Long bookCopyId){
            this.bookCopyId = bookCopyId;
            return this;
        }

        public Builder withBookId(Long bookId){
            this.bookId = bookId;
            return this;
        }

        public Builder withDateOfRenting(LocalDate dateOfRenting){
            this.dateOfRenting = dateOfRenting;
            return this;

        }

        public Builder withDateOfReturning(LocalDate dateOfReturning){
            this.dateOfReturning = dateOfReturning;
            return this;
        }

        public ArchiveOfRenting build(){
            ArchiveOfRenting archive = new ArchiveOfRenting();
            archive.id = id;
            archive.userId = userId;
            archive.bookCopyId = bookCopyId;
            archive.bookId = bookId;
            archive.dateOfRenting = dateOfRenting;
            archive.dateOfReturning = dateOfReturning;

            return archive;

        }

    }

    @Override
    public String toString() {
        return "ArchiveOfRenting{" +
                ", id=" + id +
                "userId=" + userId +
                ", bookCopyId=" + bookCopyId +
                ", bookId=" + bookId +
                ", dateOfRenting=" + dateOfRenting +
                ", dateOfReturning=" + dateOfReturning +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveOfRenting archive = (ArchiveOfRenting) o;
        return userId.equals(archive.userId) &&
                bookCopyId.equals(archive.bookCopyId) &&
                bookId.equals(archive.bookId) &&
                dateOfRenting.equals(archive.dateOfRenting) &&
                dateOfReturning.equals(archive.dateOfReturning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookCopyId, bookId, dateOfRenting, dateOfReturning);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(Long bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getDateOfRenting() {
        return dateOfRenting;
    }

    public void setDateOfRenting(LocalDate dateOfRenting) {
        this.dateOfRenting = dateOfRenting;
    }

    public LocalDate getDateOfReturning() {
        return dateOfReturning;
    }

    public void setDateOfReturning(LocalDate dateOfReturning) {
        this.dateOfReturning = dateOfReturning;
    }
}
