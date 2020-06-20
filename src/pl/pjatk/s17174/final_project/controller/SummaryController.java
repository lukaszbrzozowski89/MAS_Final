/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.controller;

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

import java.net.URL;
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
            Thread.sleep(3000);
            mainModel = MainModel.getInstance();
            mainModel.getReservation().setStatus(ReservationStatus.PAID);
            mainModel.getPayment().setPaymentStatus(PaymentStatus.FINISHED);
            thanksTF.setWrapText(true);
            thanksTF.setAlignment(Pos.CENTER);
            thanksTF.setFont(Font.font(18));
            thanksTF.setText(mainModel.getPassenger().toString() + mainModel.getPayment().toString() + mainModel.getReservation().toString() + mainModel.getFlight().toString());
        } catch (Exception e) {
            Utils.showAlertDialog(e.getMessage());
            e.printStackTrace();
        }
//        mainModel.getPassenger().getName() + "!\n"+
//                "Dziękujemy za skorzystanie z naszych usług \n" +
//                "Do zobaczenia na pokładzie\n\n" +
//                "Poniżej możesz pobrać swoje dokumnety podróży"
//                    )
    }

    @FXML
    public void getDocsButton(ActionEvent event) throws Exception {
        mainModel.getReservation().setStatus(ReservationStatus.FINISHED);
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        summaryAP.getChildren().setAll(root);
    }
}
