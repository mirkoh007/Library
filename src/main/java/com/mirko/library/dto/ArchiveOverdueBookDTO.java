package com.mirko.library.dto;

import java.util.Objects;

public class ArchiveOverdueBookDTO {
    
    private Long userId;
    private Long bookCopyId;
    private Long bookId;
    private Long days;

    private ArchiveOverdueBookDTO() {}

    public static class Builder{
        private Long userId;
        private Long bookCopyId;
        private Long bookId;
        private Long days;

        public Builder() {

        }

        public Builder withUserID(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder withBookCopyID(Long bookCopyId){
            this.bookCopyId = bookCopyId;
            return this;
        }

        public Builder withBookID(Long bookId){
            this.bookId = bookId;
            return this;
        }

        public Builder withDays(Long days){
            this.days = days;
            return this;
        }

        public ArchiveOverdueBookDTO build(){
            ArchiveOverdueBookDTO overDueBookDTO = new ArchiveOverdueBookDTO();
            overDueBookDTO.userId = userId;
            overDueBookDTO.bookId = bookId;
            overDueBookDTO.bookCopyId = bookCopyId;
            overDueBookDTO.days = days;

            return overDueBookDTO;
        }
    }

    @Override
    public String toString() {
        return "OverDueBookDTO{" +
                "userId=" + userId +
                ", bookCopyId=" + bookCopyId +
                ", bookId=" + bookId +
                ", days=" + days +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchiveOverdueBookDTO that = (ArchiveOverdueBookDTO) o;
        return userId.equals(that.userId) &&
                bookCopyId.equals(that.bookCopyId) &&
                bookId.equals(that.bookId) &&
                days.equals(that.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookCopyId, bookId, days);
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

    public Long getDays() {
        return days;
    }

    public void setDays(Long days) {
        this.days = days;
    }
}
