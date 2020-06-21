/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

import com.sun.webkit.network.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import pl.pjatk.s17174.final_project.enums.PaymentStatus;
import pl.pjatk.s17174.final_project.enums.ReservationStatus;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import javax.swing.plaf.RootPaneUI;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SummaryController implements Initializable {
    @FXML
    public Button docsButton;
    @FXML
    public Label thanksTF;
    @FXML
    public AnchorPane summaryAP;
    @FXML
    public AnchorPane root;
    MainModel mainModel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainModel = MainModel.getInstance();
            mainModel.getReservation().setStatus(ReservationStatus.PAID);
            thanksTF.setWrapText(true);
            thanksTF.setAlignment(Pos.CENTER);
            thanksTF.setFont(Font.font(18));
            thanksTF.setText(mainModel.getPassenger().getName() + "!\n" +
                    "Dziękujemy za skorzystanie z naszych usług \n" +
                    "Do zobaczenia na pokładzie\n\n" +
                    "Poniżej możesz pobrać swoje dokumenty podróży"
            );
        } catch (Exception e) {
            Utils.showAlertDialog(e.getMessage());
            e.printStackTrace();
        }
//
    }

    @FXML
    public void getDocsButton(ActionEvent event) {
        try {
            saveFile();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showAlertDialog("Błąd pobierania - spróbuj ponownie");
            return;
        }

        try {
            mainModel.getReservation().setStatus(ReservationStatus.FINISHED);
            root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
            summaryAP.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void saveFile() throws Exception {
        mainModel.getReservation().generateReservationDocs();
    }
}
