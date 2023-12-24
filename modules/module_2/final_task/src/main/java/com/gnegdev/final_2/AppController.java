package com.gnegdev.final_2;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


public class AppController {
    private ObservableList<Row> rowsData = FXCollections.observableArrayList();

    @FXML
    private TableView<Row> energyTableView;
    @FXML
    private TableColumn<Row, Integer> strikeNumberColumn;
    @FXML
    private TableColumn<Row, String> jotaroEnergyColumn;
    @FXML
    private TableColumn<Row, String> dioEnergyColumn;
    @FXML
    private ProgressBar jotaroEnergyBar;
    @FXML
    private ProgressBar dioEnergyBar;
    @FXML
    private TextField infoText;


    @FXML
    protected void initialize() {
        strikeNumberColumn.setCellValueFactory(new PropertyValueFactory<Row, Integer>("strikeNumber"));
        jotaroEnergyColumn.setCellValueFactory(new PropertyValueFactory<Row, String>("jotaroEnergy"));
        dioEnergyColumn.setCellValueFactory(new PropertyValueFactory<Row, String>("dioEnergy"));

        energyTableView.setItems(rowsData);
    }

    @FXML
    protected void startAsJotaro() {
        rowsData = FXCollections.observableArrayList();
        initialize();
        int jotaroEnergy = 100;
        int dioEnergy = 100;
        while(true) {
            rowsData.add(new Row(jotaroEnergy, dioEnergy));

            dioEnergy -= (int) (Math.random() * (30 - 1) + 1);
            dioEnergyBar.setProgress(dioEnergy / 100.0);
            if(dioEnergy <= 0) {
                infoText.setText("Jotaro Kujo has won on " + Row.getNextStrikeNumber() + " strike.");
                dioEnergyBar.setProgress(-1);
                break;
            }

            jotaroEnergy -= (int) (Math.random() * (30 - 1) + 1);
            jotaroEnergyBar.setProgress(jotaroEnergy / 100.0);
            if(jotaroEnergy <= 0) {
                infoText.setText("Dio Brando has won on " + Row.getNextStrikeNumber() + " strike.");
                jotaroEnergyBar.setProgress(-1);
                break;
            }
        }
        rowsData.add(new Row(jotaroEnergy, dioEnergy));
        Row.resetNextStrikeNumber();
    }

    @FXML
    protected void startAsDio() {
        rowsData = FXCollections.observableArrayList();
        initialize();
        int jotaroEnergy = 100;
        int dioEnergy = 100;
        while(true) {
            rowsData.add(new Row(jotaroEnergy, dioEnergy));

            jotaroEnergy -= (int) (Math.random() * (30 - 1) + 1);
            jotaroEnergyBar.setProgress(jotaroEnergy / 100.0);
            if(jotaroEnergy <= 0) {
                infoText.setText("Dio Brando has won on " + Row.getNextStrikeNumber() + " strike.");
                break;
            }

            dioEnergy -= (int) (Math.random() * (30 - 1) + 1);
            dioEnergyBar.setProgress(dioEnergy / 100.0);
            if(dioEnergy <= 0) {
                infoText.setText("Jotaro Kujo has won on " + Row.getNextStrikeNumber() + " strike.");
                break;
            }
        }
        rowsData.add(new Row(jotaroEnergy, dioEnergy));
        Row.resetNextStrikeNumber();
    }
}
