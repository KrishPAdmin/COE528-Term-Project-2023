package com.example.coe528finalprojectgroup36.Backend;
import java.util.ArrayList;


public class Customer extends User {

    private String username;
    private String password;
    private ArrayList<Book> shoppingCart = new ArrayList<Book>();
    private int points;
    protected CustomerState customerState;

    private boolean purchaseType;

    public Customer(String username, String password) {

        super(username, password);
        this.password = password;
        this.username = username;
        this.points = 0;
        this.customerState = new SilverState();
        this.purchaseType = false;

    }

    public Customer (String username, String password, int points) {
        super (username, password);
        this.password = password;
        this.username = username;
        this.points = points;
        this.customerState = new SilverState();
    }


    public String getUsername() {
        return username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;

    }

    public double purchase() {
        if(!purchaseType) {

            double totalCost = 0;
            for (Book book : shoppingCart) {
                totalCost += book.getPrice();
            }
            points += (int) (totalCost * 10);
            updateCustomerState();
            Data.bookList.removeAll((ArrayList<Book>) shoppingCart.clone());
            shoppingCart.clear();
            return totalCost;
        }
        else{
            double totalCost = 0;
            for (Book Book : shoppingCart) {
                totalCost += Book.getPrice();
            }
            double deductableCost = points*0.01;
            if(deductableCost>totalCost){
                totalCost = 0;
                points -= (int)totalCost*100;
            }
            else{
                totalCost -= deductableCost;
                points -= (int)deductableCost*100;
                points += (int) totalCost*10;
            }
            updateCustomerState();
            Data.bookList.removeAll((ArrayList<Book>)shoppingCart.clone());
            shoppingCart.clear();
            return totalCost;
        }
    }

    public void setPurchaseType(boolean purchaseType) {
        this.purchaseType = purchaseType;
    }

    public void addToCart(Book b){
        shoppingCart.add(b);
    }


    public String getState() {

        return customerState.getName();
    }
    public void setState(CustomerState state) {
        this.customerState = state;
    }

    public void updateCustomerState(){
        customerState.updateState(this);

    }
}

