package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerCostController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private Label costLabel,pointsLabel,statusLabel;

    public void logout(){
        Main.setCurrentCustomer((Customer) null);
        Main.setScene("login-screen.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        costLabel.setText("Total Cost: $" + Main.getCurrentCustomer().purchase());
        pointsLabel.setText("Points: " + Main.getCurrentCustomer().getPoints());
        statusLabel.setText("Status: " + Main.getCurrentCustomer().getState());
    }
}
