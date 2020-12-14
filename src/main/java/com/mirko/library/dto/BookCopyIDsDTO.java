package com.mirko.library.dto;

import java.util.Objects;

public class BookCopyIDsDTO {

    private Long bookID;
    private Long bookCopyID;

    public BookCopyIDsDTO() {
    }

    public static class Builder{

        private Long bookID;
        private Long bookCopyID;

        public Builder () {}

        public Builder withBookCopyID(Long bookCopyID){
            this.bookCopyID = bookCopyID;
            return this;
        }

        public Builder withBookID(Long bookID){
            this.bookID = bookID;
            return this;
        }

        public BookCopyIDsDTO build(){
            BookCopyIDsDTO bookCopyIDsDTO = new BookCopyIDsDTO();
            bookCopyIDsDTO.bookCopyID = bookCopyID;
            bookCopyIDsDTO.bookID = bookID;

            return bookCopyIDsDTO;
        }
    }

    public Long getBookCopyID() {
        return bookCopyID;
    }

    public void setBookCopyID(Long bookCopyID) {
        this.bookCopyID = bookCopyID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "BookCopyIDsDTO{" +
                "bookID=" + bookID +
                ", bookCopyID=" + bookCopyID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCopyIDsDTO that = (BookCopyIDsDTO) o;
        return bookCopyID.equals(that.bookCopyID) &&
                bookID.equals(that.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookCopyID, bookID);
    }
}
