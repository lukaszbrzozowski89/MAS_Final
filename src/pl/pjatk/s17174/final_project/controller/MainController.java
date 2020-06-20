/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {
    @FXML
    public Button goToReservationButton;
    @FXML
    public Button showConnectionsButton;
    @FXML
    public AnchorPane root;
    @FXML
    public AnchorPane loginAP;
    @FXML
    public AnchorPane connectionsPane;

    @FXML
    public void goToReservation(ActionEvent event) throws IOException {
        loginAP = FXMLLoader.load(getClass().getResource("../resources/login_window.fxml"));
        root.getChildren().setAll(loginAP);
    }

    @FXML
    public void showConnections(ActionEvent event) throws IOException {
        connectionsPane = FXMLLoader.load(getClass().getResource("../resources/connections_window.fxml"));
        root.getChildren().setAll(connectionsPane);
    }

}
