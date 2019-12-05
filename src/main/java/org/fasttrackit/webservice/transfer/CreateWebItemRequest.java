package org.fasttrackit.webservice.transfer;


public class CreateWebItemRequest {

    private String lastName;
    private String firstName;
    private String phoneNumber;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CreateWebItemRequest{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
