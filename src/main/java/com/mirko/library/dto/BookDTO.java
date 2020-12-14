package com.mirko.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BookDTO {

    private Long id;

    @NotBlank(message = "Title name is compulsory")
    @Size(min=2, max=256, message = "Max length can be only 256 characters")
    private String title;

    @NotBlank(message = "Name of author name is compulsory")
    @Size(min=2, max=256, message = "Max length can be only 256 characters")
    @Pattern(regexp = "[a-z-A-Z\\s]*", message = "Name of author has invalid characters")
    private String authorName;

    @NotBlank(message = "Name of Publisher name is compulsory")
    @Size(min=2, max=256, message = "Max length can be only 256 characters")
    @Pattern(regexp = "[a-z-A-Z\\s]*", message = "Name of Publisher has invalid characters")
    private String publisher;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private LocalDate dateOfPublishing;

    public BookDTO() {
    }

    public static class Builder{

        private Long id;
        private String title;
        private String authorName;
        private String publisher;
        private LocalDate dateOfPublishing;

        public Builder () {}

        public Builder withID(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public Builder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        public Builder withDateOfPublishing(LocalDate dateOfPublishing) {
            this.dateOfPublishing = dateOfPublishing;
            return this;
        }

        public BookDTO build() {
            BookDTO bookDTO = new BookDTO();
            bookDTO.id = this.id;
            bookDTO.title = this.title;
            bookDTO.authorName = this.authorName;
            bookDTO.publisher = this.publisher;
            bookDTO.dateOfPublishing = this.dateOfPublishing;

            return bookDTO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(LocalDate dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", dateOfPublishing=" + dateOfPublishing +
                '}';
    }
}
