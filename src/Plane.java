/*
 * Copyright (c) 2020
 * Łukasz Brzozowski (s17174) @ PJATK
 */


import java.time.LocalDate;

public class Plane extends ObjectPlusPlus {

    private String name;
    private String model;
    private LocalDate yearOfProduction;
    private int seats;
    private LocalDate dateOfLatestTechnicalReview;
    private LocalDate dateOfNextTechnicalReview;


    public Plane(String name, String model, LocalDate yearOfProduction, int seats, LocalDate dateOfLatestTechnicalReview) {
        this.name = name;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.seats = seats;
        this.dateOfLatestTechnicalReview = dateOfLatestTechnicalReview;
        setDateOfNextTechnicalReview();
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public int getSeats() {
        return seats;
    }

    public LocalDate getDateOfLatestTechnicalReview() {
        return dateOfLatestTechnicalReview;
    }

    public LocalDate getDateOfNextTechnicalReview() {
        return dateOfNextTechnicalReview;
    }

    public void setDateOfNextTechnicalReview() {
        this.dateOfNextTechnicalReview = this.dateOfLatestTechnicalReview.plusMonths(6);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", seats=" + seats +
                ", dateOfLatestTechnicalReview=" + dateOfLatestTechnicalReview +
                '}';
    }
}
