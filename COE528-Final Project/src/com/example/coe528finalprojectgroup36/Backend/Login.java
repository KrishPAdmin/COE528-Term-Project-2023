package com.example.coe528finalprojectgroup36.Backend;
import com.example.coe528finalprojectgroup36.Main;
import java.util.ArrayList;

public class Login{

    private Customer customer;
    private boolean loggedIn;
    private boolean ownerLogin;

    public Login (String username, String password){
        if(!isOwner(username,password)){
            for(Customer c : Data.getCustomers()){
                if(c.getPassword().equals(password) && c.getUsername().equals(username)){
                    loggedIn = true;
                }
            }
        }
    }

    public boolean isOwner(String username, String password){
        if (username.equals("admin") && password.equals("admin")) {
            this.ownerLogin = true;
            return true;
        }
        else
            return false;
    }

    public boolean ownerLog(){
        return this.ownerLogin;
    }

    public boolean userLog(){
        return this.loggedIn;
    }

}