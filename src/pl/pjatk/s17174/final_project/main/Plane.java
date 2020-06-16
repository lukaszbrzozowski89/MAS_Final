/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import java.time.LocalDate;

/**
 * Class to create and store data about plane
 * links with:
 * 1. FlightInstance with cardinality 1..* - 1..*
 * 2. Owner - 0..* - 1
 *
 * @author Lukasz
 * @see Flight.FlightInstance
 */

public class Plane extends ObjectPlusPlus {

    private String name;
    private String model;
    private LocalDate yearOfProduction;
    private int seats;
    private LocalDate dateOfLatestTechnicalReview;
    private LocalDate dateOfNextTechnicalReview;


    public Plane(String name, String model, LocalDate yearOfProduction, int seats, LocalDate dateOfLatestTechnicalReview) {
        super();
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
