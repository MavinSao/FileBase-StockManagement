package com.kshrd.views;

import com.kshrd.models.DTO.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        ArrayList<Product> p = new ArrayList();
        for (int i=0;i<10;i++){
            p.add(new Product(i,"coca",4.5,5,ld.toString()));
        }
        ArrayList<Product> p2 = p;
        for (Product pr : p2) {

        }

    }
}
