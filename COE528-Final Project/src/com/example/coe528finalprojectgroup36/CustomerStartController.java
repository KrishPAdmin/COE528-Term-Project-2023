package com.example.coe528finalprojectgroup36;

import com.example.coe528finalprojectgroup36.Backend.Book;
import com.example.coe528finalprojectgroup36.Backend.Customer;
import com.example.coe528finalprojectgroup36.Backend.CustomerState;
import com.example.coe528finalprojectgroup36.Backend.Data;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;
import javafx.scene.control.TableColumn.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerStartController implements Initializable {
    @FXML
    TableView<Book> customerTable;
    @FXML
    private Button buyButton,redeemAndBuyButton,logoutButton;
    @FXML
    private Label customerWelcome, error;
    @FXML
    private TableColumn<Book,String> nameColumn;
    @FXML
    private TableColumn<Book,Double> priceColumn;
    @FXML
    private TableColumn<Book,Boolean> selectColumn;

    private ObservableList<Book> books;

    private Customer currentCustomer;

    public void getCart() throws Exception{
        int i = 0;
        for(Book b: Data.getBooks()){
            if (b.selectedProperty().get()){
                Main.getCurrentCustomer().addToCart(b);
                i++;
            }

        }
        if(i <= 0){
            throw new Exception();
        }
    }

    public void buy(){
        try {
            error.setText("");
            getCart();
            Main.getCurrentCustomer().setPurchaseType(false);
            Main.setScene("customer-cost-screen.fxml");
        }catch (Exception e){
            error.setText("Cannot buy 0 books");
        }


    }

    public void redeemBuy(){

        try {
            error.setText("");
            getCart();
            Main.getCurrentCustomer().setPurchaseType(true);
            Main.setScene("customer-cost-screen.fxml");
        }catch (Exception e){
            error.setText("Cannot buy 0 books");
        }
    }

    public void logout(){
        Main.setCurrentCustomer((Customer) null);
        Main.setScene("login-screen.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Main.getCurrentCustomer().updateCustomerState();

        currentCustomer = Main.getCurrentCustomer();
        books = FXCollections.observableArrayList(Data.getBooks());



        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()).asObject());
        selectColumn.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
        selectColumn.setCellFactory(column -> {
            TableCell<Book, Boolean> cell = new TableCell<Book, Boolean>() {
                private final CheckBox checkBox = new CheckBox();

                {
                    checkBox.setOnAction(event -> {
                        int index = getIndex();
                        if (index >= 0 && index < customerTable.getItems().size()) {
                            Book book = customerTable.getItems().get(index);
                            book.setSelected(checkBox.isSelected());

                        }
                    });
                    setGraphic(checkBox);
                }

                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        checkBox.setSelected(item);
                        setGraphic(checkBox);
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);
            return cell;
        });

        customerTable.setItems(books);
        customerTable.setEditable(true);
        selectColumn.setEditable(true);
        books = FXCollections.observableArrayList(Data.getBooks());
        customerWelcome.setText("Welcome "+ currentCustomer.getUsername() + ". You have " + currentCustomer.getPoints() +
                ". Your status is " + currentCustomer.getState() + ".");

    }
}