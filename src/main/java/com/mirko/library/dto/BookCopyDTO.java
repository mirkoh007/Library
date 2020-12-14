package com.mirko.library.dto;

public class BookCopyDTO {

    private Long id;
    private String serialNumber;
    private BookDTO book;

    private BookCopyDTO ()  {}

    public static class Builder{

        private Long id;
        private String serialNumber;
        private BookDTO book;

        public Builder () {}

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withSerialNumber(String serialNumber){
            this.serialNumber = serialNumber;
            return this;
        }

        public Builder withBookDTO(BookDTO book){
            this.book = book;
            return this;
        }

        public BookCopyDTO build(){
            BookCopyDTO bookCopyDTO = new BookCopyDTO();
            bookCopyDTO.id = id;
            bookCopyDTO.serialNumber = serialNumber;
            bookCopyDTO.book = book;

            return bookCopyDTO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookCopyDTO{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", book=" + book +
                '}';
    }
}
