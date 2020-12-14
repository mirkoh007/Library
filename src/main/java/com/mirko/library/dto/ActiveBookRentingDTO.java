package com.mirko.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ActiveBookRentingDTO implements Serializable {

    private Long userId;
    private Long bookCopyId;
    private Long bookId;
    private LocalDate dateOfRenting;

    private ActiveBookRentingDTO() {}

    public static class Builder{
        private Long userId;
        private Long bookCopyId;
        private Long bookId;
        @JsonFormat(pattern = "dd-MM-yyyy")
        @NotNull
        private LocalDate dateOfRenting;

        public Builder() {

        }

        public Builder withUserID(Long user_id){
            this.userId = user_id;
            return this;
        }

        public Builder withBookCopyID(Long book_copy_id){
            this.bookCopyId = book_copy_id;
            return this;
        }

        public Builder withBookID(Long book_id){
            this.bookId = book_id;
            return this;
        }

        public Builder withDateOfRenting(LocalDate dateOfRenting){
            this.dateOfRenting = dateOfRenting;
            return this;
        }

        public ActiveBookRentingDTO build(){
            ActiveBookRentingDTO activeBookRentingDTO = new ActiveBookRentingDTO();
            activeBookRentingDTO.userId = userId;
            activeBookRentingDTO.bookCopyId = bookCopyId;
            activeBookRentingDTO.bookId = bookId;
            activeBookRentingDTO.dateOfRenting = dateOfRenting;

            return activeBookRentingDTO;
        }


    }

    @Override
    public String toString() {
        return "Builder{" +
                "user_id=" + userId +
                ", book_copy_id=" + bookCopyId +
                ", book_id=" + bookId +
                ", dateOfRenting=" + dateOfRenting +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builder builder = (Builder) o;
        return userId.equals(builder.userId) &&
                bookCopyId.equals(builder.bookCopyId) &&
                bookId.equals(builder.bookId) &&
                dateOfRenting.equals(builder.dateOfRenting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookCopyId, bookId, dateOfRenting);
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

}
