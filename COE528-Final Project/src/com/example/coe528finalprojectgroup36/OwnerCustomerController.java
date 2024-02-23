package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Customer;
import com.example.coe528finalprojectgroup36.Backend.Data;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OwnerCustomerController implements Initializable {
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, String> usernameColumn;
    @FXML
    private TableColumn<Customer, String> passwordColumn;
    @FXML
    private TableColumn<Customer, Integer> pointsColumn;
    @FXML
    private TextField usernameField, passwordField;
    @FXML
    private Button addButton, backButton, deleteButton;

    @FXML
    private Label error;

    private ObservableList<Customer> customers;

    private boolean contains(String username){
        for(Customer c : customers){
            if(c.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public void addCustomer() {
        error.setText("");
        try {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();

            if (username.isEmpty() ||
                    password.isEmpty() ||
                    username.equals("admin")||
                    username.length() <= 0||
                    password.length() <=0 ||
                    this.contains(username)

            ) {
                throw new Exception();
            } else {
                Customer c = new Customer(username, password);
                customers.add(c);
                Data.addCustomer(c);
            }

        } catch (Exception e) {
            error.setText("Bad input. Please try again");
        }
    }

    public void deleteSelected() {
        ObservableList<Customer> toRemove = customerTable.getSelectionModel().getSelectedItems();
        customers.removeAll(toRemove);
        Data.removeCustomer(new ArrayList<>(toRemove));
    }

    public void backToMain() {
        Main.setScene("owner-start-screen.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customers = FXCollections.observableArrayList(Data.getCustomers());
        customerTable.setItems(customers);
        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        passwordColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));
        pointsColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPoints()).asObject());
        customerTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}