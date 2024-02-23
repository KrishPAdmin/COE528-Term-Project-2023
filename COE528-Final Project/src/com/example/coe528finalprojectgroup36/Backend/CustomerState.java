package com.example.coe528finalprojectgroup36.Backend;


import com.example.coe528finalprojectgroup36.Backend.Customer;

public abstract class CustomerState {

    private String name;

    public CustomerState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void updateState(Customer customer) {
        if (customer.getPoints() >= 1000) customer.getState();
    }
}


