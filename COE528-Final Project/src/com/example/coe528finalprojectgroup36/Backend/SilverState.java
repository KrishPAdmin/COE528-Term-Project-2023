package com.example.coe528finalprojectgroup36.Backend;

public class SilverState extends CustomerState {
    private static final String NAME = "Silver";
    private final static int POINT_THRESHOLD = 1000;

    public SilverState () {
        super(NAME);
    }

    @Override
    public void updateState(Customer customer) {
        if (customer.getPoints() >= POINT_THRESHOLD) {
            customer.setState(new GoldState("Gold"));
        }
    }
}