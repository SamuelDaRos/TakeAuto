package it.iisvittorioveneto.itt.takeauto;

import java.time.LocalDate;

public class User {
    private String email, username, password;
    private LocalDate dateOfBirth;
    private String fiscalCode;
    private Booking booking;
    private int phoneNumber;

    public User(String email, String username, String password, LocalDate dateOfBirth, String fiscalCode, Booking booking, int phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.fiscalCode = fiscalCode;
        this.booking = booking;
        this.phoneNumber= phoneNumber;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
