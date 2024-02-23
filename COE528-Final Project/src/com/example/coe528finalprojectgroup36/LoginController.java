package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Data;
import com.example.coe528finalprojectgroup36.Backend.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button loginButton;
    @FXML
    private Label userLabel, passwordLabel;
    @FXML
    private Label badLog;

    public void executeLogin(){
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        System.out.println("Username: " + username);
        try{
            Login L = new Login(username,password);
            if(L.ownerLog()){
                Main.setScene("owner-start-screen.fxml");
                L = null;
            }
            else if(L.userLog()){
                Main.setCurrentCustomer(username);
                Main.setScene("customer-start-screen.fxml");

                L = null;

            }
            else{
                badLog.setText("Invalid login. Please try again");
                L = null;
            }
        }catch (Exception e){
            badLog.setText("Error. Please try again");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
