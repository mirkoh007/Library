package com.mirko.library.dto;

import java.util.Objects;

public class RentedBookCopiesIDsDTO {

    private Long bookID;
    private Long bookCopyID;

    public RentedBookCopiesIDsDTO(){}

    public static class Builder{
        private Long bookCopyID;
        private Long bookID;

        public RentedBookCopiesIDsDTO.Builder withBookCopyID(Long bookCopyID){
            this.bookCopyID = bookCopyID;
            return this;
        }

        public RentedBookCopiesIDsDTO.Builder withBookID(Long bookID){
            this.bookID = bookID;
            return this;
        }

        public RentedBookCopiesIDsDTO build(){
            RentedBookCopiesIDsDTO rentedBookCopiesIDsDTO = new RentedBookCopiesIDsDTO();
            rentedBookCopiesIDsDTO.bookCopyID = bookCopyID;
            rentedBookCopiesIDsDTO.bookID = bookID;

            return rentedBookCopiesIDsDTO;
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
        return "RentedBookCopiesIDsDTO{" +
                "bookID=" + bookID +
                ", bookCopyID=" + bookCopyID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentedBookCopiesIDsDTO that = (RentedBookCopiesIDsDTO) o;
        return bookCopyID.equals(that.bookCopyID) &&
                bookID.equals(that.bookID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookCopyID, bookID);
    }
}
