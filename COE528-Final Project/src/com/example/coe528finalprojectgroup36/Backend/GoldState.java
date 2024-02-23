package com.example.coe528finalprojectgroup36.Backend;

public class GoldState extends CustomerState  {

    public GoldState(String name) {
        super(name);
    }

    @Override
    public void updateState(Customer customer) {
        if (customer.getPoints() < 1000) {
            customer.setState(new SilverState());
        }
    }
}