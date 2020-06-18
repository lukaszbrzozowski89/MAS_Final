/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ReservationController {
    @FXML
    public Label airportFromLabel;
    @FXML
    public Label airportToLabel;
    @FXML
    public ComboBox<String> airportFromCB;
    @FXML
    public DatePicker flightDatePicker;
    @FXML
    public Label flightDateLabel;
    @FXML
    public Label passengerNumberLabel;
    @FXML
    public ComboBox<String> airportToCB;
    @FXML
    public ComboBox<String> passengerNumberCB;
    @FXML
    public Button searchButton;
    @FXML
    public Pane flightSummaryPane;
    @FXML
    public Pane reservationPane;

    @FXML
    public void searchButtonClicked(ActionEvent event) throws IOException {
        flightSummaryPane = FXMLLoader.load(getClass().getResource("../resources/flight_window.fxml"));
        reservationPane.getChildren().setAll(flightSummaryPane);
    }
}
