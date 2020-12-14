package com.mirko.library.dto;

import java.util.Objects;

public class ActiveOverdueRentingDTO {

    private Long userId;
    private Long bookCopyId;
    private Long bookId;
    private Long days;

    public ActiveOverdueRentingDTO() {
    }

    public static class Builder {
        private Long userId;
        private Long bookCopyId;
        private Long bookId;
        private Long days;

        public Builder() {

        }

        public Builder withUserID(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withBookCopyID(Long bookCopyId) {
            this.bookCopyId = bookCopyId;
            return this;
        }

        public Builder withBookID(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder withDays(Long days) {
            this.days = days;
            return this;
        }

        public ActiveOverdueRentingDTO build(){
            ActiveOverdueRentingDTO activeOverdueRentingDTO = new ActiveOverdueRentingDTO();
            activeOverdueRentingDTO.userId = userId;
            activeOverdueRentingDTO.bookId = bookId;
            activeOverdueRentingDTO.bookCopyId = bookCopyId;
            activeOverdueRentingDTO.days = days;

            return activeOverdueRentingDTO;
        }

    }

    @Override
    public String toString() {
        return "ActiveOverdueRentingDTO{" +
                "bookId=" + bookId +
                ",userId=" + userId +
                ", bookCopyId=" + bookCopyId +
                ", days=" + days +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveOverdueRentingDTO that = (ActiveOverdueRentingDTO) o;
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
