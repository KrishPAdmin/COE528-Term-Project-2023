package com.example.coe528finalprojectgroup36.Backend;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class Book implements Cloneable{

    private String name;
    private double price;

    private SimpleBooleanProperty selectedProperty;


    public Book(String name, double price){
        this.name = name;
        this.price = price;
        this.selectedProperty = new SimpleBooleanProperty(false);

    }

    public String getName() {
        return name;
    }
    public double getPrice(){
        return price;
    }
    public SimpleBooleanProperty selectedProperty(){
        return this.selectedProperty;
    }
    public void setSelected(boolean val){
        selectedProperty.set(val);
    }

}
