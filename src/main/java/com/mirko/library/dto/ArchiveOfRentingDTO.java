package com.mirko.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class ArchiveOfRentingDTO {

    private Long id;
    private Long userId;
    private Long bookCopyId;
    private Long bookId;
    private LocalDate dateOfRenting;
    private LocalDate dateOfReturning;

    public ArchiveOfRentingDTO() {
    }

    public static class Builder{

        private Long id;
        private Long userId;
        private Long bookCopyId;
        private Long bookId;
        @JsonFormat(pattern = "dd-MM-yyyy")
        @NotNull
        private LocalDate dateOfRenting;
        @JsonFormat(pattern = "dd-MM-yyyy")
        @NotNull
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

        public ArchiveOfRentingDTO build(){
            ArchiveOfRentingDTO archiveOfRentingDTO = new ArchiveOfRentingDTO();
            archiveOfRentingDTO.id = this.id;
            archiveOfRentingDTO.userId = this.userId;
            archiveOfRentingDTO.bookCopyId = this.bookCopyId;
            archiveOfRentingDTO.bookId = this.bookId;
            archiveOfRentingDTO.dateOfRenting = this.dateOfRenting;
            archiveOfRentingDTO.dateOfReturning = this.dateOfReturning;

            return archiveOfRentingDTO;
        }
    }

    @Override
    public String toString() {
        return "ArchiveDTO{" +
                "id=" + id +
                ", userId=" + userId +
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
        ArchiveOfRentingDTO that = (ArchiveOfRentingDTO) o;
        return id.equals(that.id) &&
                userId.equals(that.userId) &&
                bookCopyId.equals(that.bookCopyId) &&
                bookId.equals(that.bookId) &&
                dateOfRenting.equals(that.dateOfRenting) &&
                dateOfReturning.equals(that.dateOfReturning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, bookCopyId, bookId, dateOfRenting, dateOfReturning);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
