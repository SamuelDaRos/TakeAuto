package it.iisvittorioveneto.itt.takeauto;

import java.time.LocalDateTime;

public class Booking {
    private LocalDateTime endDate;
    private User user;
    private Car car;

    public Booking(LocalDateTime endDate, User user, Car car) {
        this.endDate = endDate;
        this.user = user;
        this.car = car;
    }

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
