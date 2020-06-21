/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import pl.pjatk.s17174.final_project.main.Flight;
import pl.pjatk.s17174.final_project.main.ObjectPlus;
import pl.pjatk.s17174.final_project.main.ObjectPlusPlus;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationController implements Initializable {
    @FXML
    public Label loginIDLabel;
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
    public AnchorPane flightSummaryPane;
    @FXML
    public AnchorPane reservationPane;
    @FXML
    public AnchorPane root;
    @FXML
    public AnchorPane loginAP;
    @FXML
    public Label dateOfFlightLabelRight;
    @FXML
    public Button backToMainMenuButton;
    MainModel mainModel;
    ObservableList<String> passengerNumber = FXCollections.observableArrayList();

    @FXML
    public void searchButtonClicked(ActionEvent event) throws Exception {
        List<Flight> flightList = (List<Flight>) ObjectPlus.getExtent(Flight.class);
        System.out.println(flightList);
        for (Flight fl : flightList) {
            System.out.println(fl);
            if (fl.getAirportTo().getName().equals(getAirportToCB()) && fl.getAirportFrom().getName().equals(getAirportFromCB())) {
                System.out.println(getAirportFromCB());
                System.out.println(getAirportToCB());
                mainModel.setFlight(flightList.get(fl.getId()));

            }
        }
        if (MainModel.getInstance().getFlight() == null) {
            Utils.showAlertDialog("Nie ma takiego lotu");
            return;
        }
        mainModel.setFlightFrom(getAirportFromCB());
        mainModel.setFlightTo(getAirportToCB());
        mainModel.setFlightDate(flightDatePicker.getValue());
        mainModel.setPassengerNumber(passengerNumberCB.getSelectionModel().getSelectedItem());
        ObjectPlusPlus[] obj = mainModel.getFlight().getLinks(Utils.flightInstanceClass);
        mainModel.setFlightInstance((Flight.FlightInstance) obj[0]);
        for (int i = 0; i < Integer.parseInt(mainModel.getPassengerNumber()); i++) {
            mainModel.createReservation();
            System.out.println(mainModel.getReservation());
        }
        flightSummaryPane = FXMLLoader.load(getClass().getResource("../resources/flight_window.fxml"));
        System.out.println(flightDatePicker.getValue());
        reservationPane.getChildren().setAll(flightSummaryPane);

    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        reservationPane.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainModel = MainModel.getInstance();
            airportFromCB.setItems(mainModel.fillComboboxFrom());
            airportFromCB.getSelectionModel().selectFirst();
            airportToCB.setItems(mainModel.fillComboboxTo());
            airportToCB.getSelectionModel().selectLast();

            flightDatePicker.setValue(LocalDate.now().plusDays(1));
            passengerNumber.addAll("1", "2", "3", "4");
            passengerNumberCB.setItems(passengerNumber);
            passengerNumberCB.getSelectionModel().selectFirst();
            loginIDLabel.setText("Cześć " + mainModel.getPassenger().getName());

        } catch (Exception e) {
            Utils.showAlertDialog(e.getMessage());
            e.printStackTrace();
        }
    }

    public String getAirportFromCB() {
        return airportFromCB.getSelectionModel().getSelectedItem();
    }

    public String getAirportToCB() {
        return airportToCB.getSelectionModel().getSelectedItem();
    }


}
