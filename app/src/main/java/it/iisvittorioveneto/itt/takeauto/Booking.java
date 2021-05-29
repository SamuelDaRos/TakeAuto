package it.iisvittorioveneto.itt.takeauto;

import java.time.LocalDateTime;

public class Booking {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User user;
    private Car car;
    Login l= new Login();

    public Booking(LocalDateTime startDate,LocalDateTime endDate, Car car) {
        this.startDate=startDate;
        this.endDate = endDate;
        this.user = l.getActualUser();
        this.car = car;
    }

    public LocalDateTime getStartDate() { return startDate; }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }
}
