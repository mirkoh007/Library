package com.mirko.library.model;

import java.io.Serializable;
import java.util.Objects;

public class ActiveBookRentID implements Serializable {

    private Long bookCopyId;

    private Long userId;

    public ActiveBookRentID(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveBookRentID that = (ActiveBookRentID) o;
        return bookCopyId.equals(that.bookCopyId) &&
                userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookCopyId, userId);
    }
}
