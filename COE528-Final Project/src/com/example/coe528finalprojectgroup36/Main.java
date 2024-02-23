package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Customer;
import com.example.coe528finalprojectgroup36.Backend.CustomerState;
import com.example.coe528finalprojectgroup36.Backend.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    private  static Stage stage;

    private static Customer currentCustomer;
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-screen.fxml"));
            scene = new Scene(fxmlLoader.load());
        }catch(Exception e){
            e.printStackTrace();
        }

            this.stage = new Stage();
            this.stage.setTitle("Bibliotecha");
            this.stage.setOnCloseRequest(e ->{
                Data.save();
            });
            this.stage.setScene(scene);
            stage.setMinHeight(400);
            stage.setMinWidth(600);
            this.stage.show();

    }

    public static Scene getScene() {
        return scene;
    }
    public static void setScene(String fxml){
        try{
            Parent root = FXMLLoader.load(Main.class.getResource(fxml));
            scene = new Scene(root);
            stage.setScene(scene);



            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("ERROR: Could not find fxml root");
        }
    }

    public static void main(String[] args) {
        Data.load();
        launch();
    }

    public static void setCurrentCustomer(String customer){
        currentCustomer = Data.getCustomer(customer);
    }

    public static void setCurrentCustomer(Customer customer){
        currentCustomer = customer;
    }

    public static Customer getCurrentCustomer(){
        return currentCustomer;
    }
}