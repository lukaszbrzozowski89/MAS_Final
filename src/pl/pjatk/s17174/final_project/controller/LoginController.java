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
import javafx.scene.layout.AnchorPane;
import pl.pjatk.s17174.final_project.main.ObjectPlus;
import pl.pjatk.s17174.final_project.main.Passenger;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ObservableList<Passenger> passengers = FXCollections.observableArrayList();
    public Button backToMainMenuButton;
    public Button signUpBtn;
    @FXML
    public AnchorPane loginAP;
    @FXML
    public ComboBox<Passenger> usersCB;
    @FXML
    public Button loginButton;
    @FXML
    public AnchorPane reservationPane;
    @FXML
    public AnchorPane root;
    @FXML
    public AnchorPane signUpPane;
    MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainModel = MainModel.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showAlertDialog(e.getMessage());
        }
        try {
            passengers.setAll((Collection<? extends Passenger>) ObjectPlus.getExtent(Passenger.class));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Utils.showAlertDialog(e.getMessage());
        }
        usersCB.setItems(passengers);
        usersCB.getSelectionModel().selectFirst();
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        if (usersCB.getSelectionModel().getSelectedItem() != null) {
            mainModel.setPassenger(usersCB.getSelectionModel().getSelectedItem());
            reservationPane = FXMLLoader.load(getClass().getResource("../resources/reservation_window.fxml"));
            loginAP.getChildren().setAll(reservationPane);
        } else {
            Utils.showAlertDialog("Wybierz osobę");
        }

    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        root.setMinSize(550, 900);
        loginAP.getChildren().setAll(root);
    }

    public void signUp(ActionEvent event) throws IOException {
        signUpPane = FXMLLoader.load(getClass().getResource("../resources/signup_window.fxml"));
        loginAP.getChildren().setAll(signUpPane);
    }
}
