package it.iisvittorioveneto.itt.takeauto;

import java.time.LocalDate;

public class User {
    private String email, username, password;
    //private LocalDate dateOfBirth;
    //private String phoneNumber, fiscalCode;
    private Booking booking;

    public User(String email, String username, String password/*, LocalDate dateOfBirth, String phoneNumber, String fiscalCode*/) {
        this.email = email;
        this.username = username;
        this.password = password;
        //this.dateOfBirth = dateOfBirth;
        //this.phoneNumber= phoneNumber;
        //this.fiscalCode = fiscalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }*/

    public Booking getBooking() {
        return booking;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }*/
}
