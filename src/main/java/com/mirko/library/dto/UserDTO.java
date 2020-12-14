package com.mirko.library.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is compulsory")
    @Size(min = 2, max = 64, message = "Max length can be only 64 characters")
    @Pattern(regexp = "[a-z-A-Z\\s]*", message = "First name has invalid characters")
    private String firstName;

    @NotBlank(message = "Last name is compulsory")
    @Size(min = 2, max = 64, message = "Max length can be only 64 characters")
    @Pattern(regexp = "[a-z-A-Z\\s]*", message = "Last name has invalid characters")
    private String lastName;

    @NotBlank(message = "User name is compulsory")
    @Size(min = 2, max = 64, message = "Max length can be only 64 characters")
    private String userName;

    @NotBlank(message = "Password is compulsory")
    @Size(min = 4, max = 64, message = "Max length can be only 64 characters")
    private String password;

    @NotBlank(message = "Email is compulsory")
    @Size(min = 6, max = 64, message = "Max length can be only 64 characters")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
    private String email;

    public UserDTO() {
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String userName;
        private String password;
        private String email;

        public Builder () {}

        public Builder withID(Long id){
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withUserName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder withPassword(String password){
            this.password = password;
            return this;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public UserDTO build(){
            UserDTO userDTO = new UserDTO();
            userDTO.id = this.id;
            userDTO.firstName = this.firstName;
            userDTO.lastName = this.lastName;
            userDTO.userName = this.userName;
            userDTO.password = this.password;
            userDTO.email = this.email;

            return userDTO;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
