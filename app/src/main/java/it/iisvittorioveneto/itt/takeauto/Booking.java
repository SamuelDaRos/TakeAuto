package it.iisvittorioveneto.itt.takeauto;

import java.time.LocalDateTime;

public class Booking {
    private String startDate;
    private String endDate;
    private User user;
    private Car car;
    Login l= new Login();

    public Booking(String startDate,String endDate, Car car) {
        this.startDate=startDate;
        this.endDate = endDate;
        this.user = l.getActualUser();
        this.car = car;
    }

    public String getStartDate() { return startDate; }

    public String getEndDate() {
        return endDate;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }
}
