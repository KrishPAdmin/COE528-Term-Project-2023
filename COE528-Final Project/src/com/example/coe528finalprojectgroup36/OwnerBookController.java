package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Book;
import com.example.coe528finalprojectgroup36.Backend.Data;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;


public class OwnerBookController implements Initializable {

    private ObservableList<Book> visibleBooks;

    @FXML
    private Button deleteButton,backButton,addButton;
    @FXML
    private TextField priceField,nameField;

    @FXML
    private TableView<Book> booksTable;
    @FXML
    private TableColumn<Book,String> nameColumn;
    @FXML
    private TableColumn<Book, Double> priceColumn;

    @FXML
    private Label error;

    public void addBook(){
      //initalize vars
        String name = "";
        double price = 0.0;
        try {
            error.setText("");
            //try to declare vars, if they are formatted poorly, we throw an error.
            name = nameField.getText();
            if( name.isEmpty()|| name.trim().isEmpty()){
                throw new Exception();
            }
            price = Double.parseDouble(priceField.getText());
            if(price < 0){
                throw  new Exception();
            }
            Book b = new Book(name,price);
            visibleBooks.add(b);
            Data.addBook(b);
        }catch(Exception e){
            error.setText("Bad input. please try again");
        }
    }

    public void deleteSelected(){
        ObservableList<Book> toRemove = booksTable.getSelectionModel().getSelectedItems();
        System.out.println(toRemove);
        visibleBooks.removeAll(toRemove);
        Data.removeBook(new ArrayList<>(toRemove));
    }

    public void backToMain(){
        Main.setScene("owner-start-screen.fxml");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        visibleBooks = FXCollections.observableArrayList(Data.getBooks());
        booksTable.setItems(visibleBooks);
        booksTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //define cell factory as string property, which we take from getter method
        nameColumn.setCellValueFactory(name -> new SimpleStringProperty(name.getValue().getName()));
        //Double properties aren't actually doubles so we attach .asObject() to convert it proeprly
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
    }
}
