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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import pl.pjatk.s17174.final_project.main.ObjectPlus;
import pl.pjatk.s17174.final_project.main.ObjectPlusPlus;
import pl.pjatk.s17174.final_project.model.MainModel;
import pl.pjatk.s17174.final_project.utils.Utils;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class ConnectionsController implements Initializable {
    public MainModel model;
    public ObservableList<ObjectPlusPlus> observableList = FXCollections.observableArrayList();
    public ObservableList<ObjectPlusPlus> observableListResult = FXCollections.observableArrayList();
    public ObservableList<Class> observableClassList = FXCollections.observableArrayList();
    @FXML
    public ListView<ObjectPlusPlus> listViewLeft;
    @FXML
    public ListView<ObjectPlusPlus> listViewRight;
    @FXML
    public AnchorPane connectionsPane;
    @FXML
    public Button findConnectionsButton;
    @FXML
    public Button backToMainMenuButton;
    @FXML
    public AnchorPane root;
    @FXML
    public ComboBox<Class> classChoice;
    @FXML
    public ComboBox<Class> classLinkChoice;
    List<ObjectPlusPlus> linkedClasses;
    Class className = null;
    Class classNameLinks = null;

    public void findConnections(ActionEvent event) {
        int selModel = listViewLeft.getSelectionModel().getSelectedIndex();
        try {
            System.out.println(ObjectPlus.getExtent(className));
            linkedClasses = (List<ObjectPlusPlus>) ObjectPlus.getExtent(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Utils.showAlertDialog("Klasa nie znaleziona, spróbuj ponownie");
        }

        try {
            observableListResult.setAll(linkedClasses.get(selModel).getLinks(classNameLinks.getSimpleName()));
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showAlertDialog("Nie znaleziono asocjacji pomiędzy tymi klasami: \n"
                    + className.getSimpleName() + " have " + e.getMessage());
        }
        listViewRight.setItems(observableListResult.sorted());
        System.out.println(observableListResult);
    }

    @FXML
    public void backToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../resources/main_window.fxml"));
        root.setMinSize(500, 820);
        connectionsPane.getChildren().setAll(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            model = MainModel.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.showAlertDialog("Błąd wczytywania instancji modelu");
        }
        observableClassList.addAll(ObjectPlus.allExtents.keySet());
        classChoice.setItems(observableClassList);
        classChoice.getSelectionModel().selectFirst();
        classLinkChoice.setItems(observableClassList);
        classLinkChoice.getSelectionModel().selectLast();


        classChoice.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, number, number2) -> {
                    try {
                        observableList.clear();
                        className = classChoice.getValue();
                        observableList.addAll((Collection<? extends ObjectPlusPlus>) ObjectPlusPlus.getExtent(className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        Utils.showAlertDialog("Klasa nie znaleziona, spróbuj ponownie");
                    }
                    listViewLeft.setItems(observableList);

                }
        );

        classLinkChoice.getSelectionModel().selectedIndexProperty().addListener(
                (observableValue, number, number2) -> {
                    try {
                        observableListResult.clear();
                        classNameLinks = classLinkChoice.getValue();
                        observableListResult.addAll((Collection<? extends ObjectPlusPlus>) ObjectPlusPlus.getExtent(classNameLinks));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        Utils.showAlertDialog("Klasa nie znaleziona, spróbuj ponownie");
                    }
                    listViewRight.setItems(observableListResult);

                });
    }


}
