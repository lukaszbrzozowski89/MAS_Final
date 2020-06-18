/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {
    @FXML
    public Button goToReservationButton;
    @FXML
    Pane root;
    @FXML
    Pane reservationPane;

    @FXML
    public void goToReservation(ActionEvent event) throws IOException {
        reservationPane = FXMLLoader.load(getClass().getResource("../resources/reservation_window.fxml"));
        root.getChildren().setAll(reservationPane);
    }

}
