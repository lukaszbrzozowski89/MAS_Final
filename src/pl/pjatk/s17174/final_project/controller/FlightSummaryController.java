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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import pl.pjatk.s17174.final_project.enums.*;
import pl.pjatk.s17174.final_project.main.Luggage;
import pl.pjatk.s17174.final_project.main.Payment;
import pl.pjatk.s17174.final_project.main.Reservation;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class FlightSummaryController implements Initializable {
    public Reservation reservation;
    public ObservableList<String> luggageSelect = FXCollections.observableArrayList();
    public ObservableList<PaymentMethod> paymentMethods = FXCollections.observableArrayList();

    @FXML
    public AnchorPane paymentAnim;
    @FXML
    public Label waitLabel;
    @FXML
    public Label loginIDLabel;
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
    public AnchorPane flightSummaryPane;
    @FXML
    public ToggleGroup buttonGroup;
    @FXML
    public Button backToMainMenuButton;
    @FXML
    public Button backToPreviousScreenButton;
    @FXML
    public AnchorPane root;
    @FXML
    public AnchorPane luggagePane;
    @FXML
    public Button luggageButton;
    @FXML
    public ComboBox<String> selectLuggageChoiceBox;
    @FXML
    public AnchorPane classTypeAP;
    @FXML
    public AnchorPane reservationPane;
    @FXML
    public AnchorPane paymentAP;
    @FXML
    public AnchorPane summaryAP;
    @FXML
    public Button paymentButton;
    @FXML
    public Label paymentLabel;
    @FXML
    public ComboBox<PaymentMethod> paymentMethodChoice;
    @FXML
    public Label infoPayment;
    @FXML
    public AnchorPane infoAP;
    @FXML
    public Label classLeftLabel;
    @FXML
    public Label classRightLabel;
    @FXML
    public Label lugaggeLeftLabel;
    @FXML
    public Label luggageRightLabel;
    MainModel mainModel;

    @FXML
    public void searchSeatsAction(ActionEvent event) {
        luggagePane.setVisible(true);
        classTypeAP.setVisible(false);
        backToPreviousScreenButton.setVisible(true);
        classRightLabel.setVisible(true);
        classLeftLabel.setVisible(true);

        if (bussinessClassRB.isSelected()) {
            reservation.setClassType(ClassType.BUSINESS);
        } else if (premiumClassRB.isSelected()) {
            reservation.setClassType(ClassType.PREMIUM);
        } else {
            reservation.setClassType(ClassType.ECONOMY);
        }
        classRightLabel.setText(reservation.getClassType().toString());
    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        reservation.setStatus(ReservationStatus.CANCELLED);
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        flightSummaryPane.getChildren().setAll(root);
    }

    @FXML
    public void addLuggageIfExist(ActionEvent event) {
        luggagePane.setVisible(false);
        lugaggeLeftLabel.setVisible(true);
        luggageRightLabel.setVisible(true);
        paymentAP.setVisible(true);
        if (selectLuggageChoiceBox.getSelectionModel().getSelectedItem().equals("Tak")) {
            mainModel.setLuggage(new Luggage(99, LuggageType.CHECKED));
            luggageRightLabel.setText("Tak");
        }
    }

    @FXML
    public void backToPreviousScreen(ActionEvent event) throws IOException {
        if (luggagePane.isVisible()) {
            classTypeAP.setVisible(true);
            luggagePane.setVisible(false);
            classRightLabel.setVisible(false);
            classLeftLabel.setVisible(false);
            luggageRightLabel.setVisible(false);
            lugaggeLeftLabel.setVisible(false);
        } else if (classTypeAP.isVisible()) {
            reservationPane = FXMLLoader.load(getClass().getResource("../resources/reservation_window.fxml"));
            flightSummaryPane.getChildren().setAll(reservationPane);
        } else if (paymentAP.isVisible()) {
            paymentAP.setVisible(false);
            luggagePane.setVisible(true);
            lugaggeLeftLabel.setVisible(false);
            luggageRightLabel.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            mainModel = MainModel.getInstance();
        } catch (Exception e) {
            Utils.showAlertDialog(e.getMessage());
            e.printStackTrace();
        }
        setVisibleOnStart();
        reservation = mainModel.getReservation();
        luggageSelect.addAll("Tak", "Nie");
        selectLuggageChoiceBox.setItems(luggageSelect);
        selectLuggageChoiceBox.getSelectionModel().selectFirst();
        dateOfFlightLabelRight.setText(mainModel.getFlightDate().toString());
        flightFromLabel.setText(mainModel.getFlightFrom());
        flightToLabel.setText(mainModel.getFlightTo());
        filghtNumberLabelRight.setText(mainModel.getFlight().getNumberOfFlight());
        timeOfFlightLabelRight.setText(mainModel.getFlightInstance().getTimeOfStart().toString());
        loginIDLabel.setText("Cześć " + mainModel.getPassenger().getName());
        nameLabelRight.setText(mainModel.getPassenger().getName());
        surnameLabelRight.setText(mainModel.getPassenger().getSurname());
        addressLabelRight.setText(mainModel.getPassenger().getAddress().toString());
        emailLabelRight.setText(mainModel.getPassenger().getEmail());
        phoneLabelRight.setText(mainModel.getPassenger().getPhoneNumber());
        paymentMethods.addAll(PaymentMethod.values());
        paymentMethodChoice.setItems(paymentMethods);
    }

    public void setVisibleOnStart() {
        classTypeAP.setVisible(true);
        paymentAP.setVisible(false);
        paymentAnim.setVisible(false);
        luggagePane.setVisible(false);
        lugaggeLeftLabel.setVisible(false);
        luggageRightLabel.setVisible(false);
        classLeftLabel.setVisible(false);
        classRightLabel.setVisible(false);
    }

    public void goToPayment(ActionEvent event) throws IOException {
        if (paymentMethodChoice.getSelectionModel().getSelectedItem() != null) {
            paymentAP.setVisible(false);
            infoAP.setVisible(false);
            paymentAnim.setVisible(true);
            reservation.setStatus(ReservationStatus.WAITING_FOR_PAYMENT);
            mainModel.setPayment(new Payment(1, paymentMethodChoice.getValue(), new BigDecimal(1200)));
            mainModel.getPayment().setPaymentStatus(PaymentStatus.DURING_PROCESSING);
            summaryAP = FXMLLoader.load(getClass().getResource("../resources/summary_window.fxml"));
            flightSummaryPane.getChildren().setAll(summaryAP);
        } else {
            Utils.showAlertDialog("Wybierz sposób płatności");
        }

    }

}
