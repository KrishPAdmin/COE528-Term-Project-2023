package com.example.coe528finalprojectgroup36.Backend;
import java.lang.Cloneable;

public abstract class User{

    private String username;
    private String password;

    public User(String username, String password){

        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    //public?
    public String getPassword () {
        return password;
    }

 /*   @Override
    protected Object clone() throws CloneNotSupportedException {
        return (User)super.clone();
    } */
}
