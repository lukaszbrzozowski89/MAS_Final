/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pl.pjatk.s17174.final_project.main.Address;
import pl.pjatk.s17174.final_project.main.Passenger;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    public Button backToMainMenuButton;
    public TextField nameTF;
    public TextField surnameTF;
    public TextField eMailTF;
    public TextField phoneTF;
    public TextField cityTF;
    public TextField postalCodeTF;
    public TextField streetTF;
    public Button signUpButton;
    public AnchorPane signUpPane;
    public AnchorPane root;
    public DatePicker birthDateDP;

    public void backToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        root.setMinSize(500, 820);
        signUpPane.getChildren().setAll(root);
    }

    public void signUp(ActionEvent event) throws Exception {
        if (checkInput(nameTF.getText()) && checkInput(surnameTF.getText()) && checkEmail(eMailTF.getText())
                && checkInputDigits(phoneTF.getText()) && checkInput(streetTF.getText()) &&
                !postalCodeTF.getText().isEmpty() && checkInput(cityTF.getText())) {

            Passenger passenger = new Passenger(nameTF.getText(), surnameTF.getText(),
                    LocalDate.of(birthDateDP.getValue().getYear(),
                            birthDateDP.getValue().getMonthValue(),
                            birthDateDP.getValue().getDayOfMonth()),
                    new Address(cityTF.getText(), streetTF.getText(), postalCodeTF.getText()),
                    eMailTF.getText(), phoneTF.getText());
            MainModel.getInstance().addPassenger(passenger);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Konto założone poprawnie");
            alert.showAndWait();

            root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
            signUpPane.getChildren().setAll(root);
        } else {
            Utils.showAlertDialog("Wypełnij poprawnie wszystkie pola");
        }
    }

    public boolean checkInput(String message) {
        return message.matches("\\D+");
    }

    public boolean checkInputDigits(String message) {
        return message.matches("\\d+");
    }

    public boolean checkEmail(String message) {
        return !message.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
