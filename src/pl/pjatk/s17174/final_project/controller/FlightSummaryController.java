/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.swing.*;

public class FlightSummaryController {

    @FXML
    public Label hiLabel;
    @FXML
    public ImageView loginIV;
    @FXML
    public Label passengerDataLabel;
    @FXML
    public Label flightFromLabel;
    @FXML
    public Label flightToLabel;
    @FXML
    public Label filghtNumberLabelLeft;
    @FXML
    public Label filghtNumberLabelRight;
    @FXML
    public Label dateOfFlightLabelLeft;
    @FXML
    public Label dateOfFlightLabelRight;
    @FXML
    public Label nameLabelLeft;
    @FXML
    public Label nameLabelRight;
    @FXML
    public Label surnameLabelLeft;
    @FXML
    public Label addressLabelRight;
    @FXML
    public Label surnameLabelRight;
    @FXML
    public Label addressLabelLeft;
    @FXML
    public Label emailLabelLeft;
    @FXML
    public Label emailLabelRight;
    @FXML
    public Label phoneLabelLeft;
    @FXML
    public Label phoneLabelRight;
    @FXML
    public Label timeOfFlightLabelLeft;
    @FXML
    public Label timeOfFlightLabelRight;
    @FXML
    public RadioButton bussinessClassRB;
    @FXML
    public RadioButton economyClassRB;
    @FXML
    public RadioButton premiumClassRB;
    @FXML
    public Button searchSeatsButton;
    @FXML
    public Pane flightSummaryPane;
    @FXML
    public ToggleGroup buttonGroup;

    @FXML
    public void searchSeatsAction(ActionEvent event) {
    }
}
