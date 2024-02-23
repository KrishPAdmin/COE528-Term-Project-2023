package com.example.coe528finalprojectgroup36.Backend;

import java.util.*;
import java.io.*;

public class Data {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static void save() {
        try {
            FileWriter writer = new FileWriter("books.txt", false); // overwrite the file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Book book : bookList) {
                bufferedWriter.write(book.getName() + ", " + book.getPrice());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Successfully wrote bookList to file book.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing bookList to file book.txt");
        }
        try {
            FileWriter writer = new FileWriter("customers.txt", false); // overwrite the file
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getPoints());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            System.out.println("Successfully wrote customerList to file customers.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing customerList to file customers.txt");
        }
    }
    
    public static void load() {
        try {
            FileReader reader = new FileReader("books.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                Book book = new Book(name, price);
                bookList.add(book);
            }
            bufferedReader.close();
            System.out.println("Successfully read bookList from file book.txt");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading bookList from file book.txt");
        }
        try {
            FileReader reader = new FileReader("customers.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(", ");
                String username = parts[0];
                String password = parts[1];
                int points = Integer.parseInt(parts[2]);
                //System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
                Customer customer = new Customer(username, password, points);
                customerList.add(customer);
            }
            bufferedReader.close();
            System.out.println("Successfully read customerList from file customers.txt");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading customerList from file customers.txt");
        }
    }

    public static void addCustomer(Customer c) {
        for (Customer customer : customerList) {
            if (customer.getUsername().equals(c.getUsername())) {
                return;
            }
        }
        customerList.add(c);
    }

    public static void removeCustomer(ArrayList<Customer> customers) {
       customerList = customers;
    }

    public static Customer getCustomer(String username) {
         for (Customer customer : customerList) {
             if (customer.getUsername().equals(username)) {
                 return customer;
             }
         }
        return null;
    }

    public static void addBook(Book book) {
        bookList.add(book);
    }


    public static ArrayList<Customer> getCustomers() {
        return (ArrayList<Customer>) customerList.clone();
    }

    public static ArrayList<Book> getBooks() {
        return (ArrayList<Book>) bookList.clone();
    }

    public static void removeBook(ArrayList<Book> booklist) {
        bookList = booklist;
    }


}