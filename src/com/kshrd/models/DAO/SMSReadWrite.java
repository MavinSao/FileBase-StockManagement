package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SMSReadWrite {
    String path ="cheata.txt";
    public void writeObj(){
        ArrayList<Product> products = new ArrayList<>();
        LocalDate ld = LocalDate.now();
        for(int i=1; i<=1000; i++)
        {
            products.add(new Product(i, "coca", 22.5, 5, ld.toString()));

        }
        try {
            ObjectOutputStream write1 = new ObjectOutputStream(new FileOutputStream(path));
            write1.writeObject(products);
            write1.close();
            System.out.println("Write Complete!");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public ArrayList<Product> readObj(){
        ArrayList<Product> products = new ArrayList<>();
        try
        {
            ObjectInputStream read1= new ObjectInputStream(new FileInputStream(path));
            products =(ArrayList<Product>) read1.readObject();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return products;
    }

}
