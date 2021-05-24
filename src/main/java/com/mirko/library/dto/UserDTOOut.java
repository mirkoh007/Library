package com.mirko.library.dto;

import com.mirko.library.model.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDTOOut {

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

    @NotBlank(message = "Email is compulsory")
    @Size(min = 6, max = 64, message = "Max length can be only 64 characters")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
    private String email;

    private Role role;

    public UserDTOOut() {
    }

    public static class Builder{

        private Long id;
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private Role role;

        public Builder ()  {}

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

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserDTOOut build(){
            UserDTOOut userDTOOut = new UserDTOOut();
            userDTOOut.id = this.id;
            userDTOOut.firstName = this.firstName;
            userDTOOut.lastName = this.lastName;
            userDTOOut.userName = this.userName;
            userDTOOut.email = this.email;
            userDTOOut.role = this.role;

            return userDTOOut;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTOOut{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTOOut that = (UserDTOOut) o;
        return id.equals(that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                userName.equals(that.userName) &&
                email.equals(that.email) &&
                role.equals(that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, email, role);
    }
}
