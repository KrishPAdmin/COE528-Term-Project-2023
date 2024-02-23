package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Data;
import javafx.scene.control.Button;

public class OwnerStartController {

    private Button bookButton, customerButton, logoutButton;

    public void openBooks(){

        Main.setScene("owner-books-screen.fxml");
    }

    public void openCustomers(){

        Main.setScene("owner-customer-screen.fxml");
    }

    public void logout(){
        Main.setScene("login-screen.fxml");
    }

}
