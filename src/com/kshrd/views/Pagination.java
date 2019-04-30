package com.kshrd.views;

import com.kshrd.models.DTO.Product;

import java.util.ArrayList;
import java.util.Scanner;


public class Pagination {
    ListProduct lp = new ListProduct();
    ArrayList<Product> v = SMSView.products;
    Scanner sc = new Scanner(System.in);
    int i = 0;
    void first(){
        ListProduct.CurrentPage = 0;
        ListProduct.page = 1;
        lp.display();
    }
    void previouse(){

        ListProduct.page--;
        if(ListProduct.page<1){
            ListProduct.CurrentPage = v.size()-ListProduct.numberOfRow;
            ListProduct.page = v.size()/ListProduct.numberOfRow;
            lp.display();
        }else {
            ListProduct.CurrentPage-=ListProduct.numberOfRow;
            lp.display();
        }
    }
    void next(){
        ListProduct.CurrentPage += ListProduct.numberOfRow;
        if(ListProduct.CurrentPage>=v.size()){
               ListProduct.CurrentPage = 0;
                ListProduct.page = 1;
            lp.display();
        }else {
            ListProduct.page+=1;
            lp.display();
        }
    }
     void last(){
         ListProduct.CurrentPage = v.size()-ListProduct.numberOfRow;
         ListProduct.page = v.size()/ListProduct.numberOfRow;
         lp.display();
      }
     void goTo(){
        String goTo;
        do {
            System.out.print("Wish page do you want to go : ");
            goTo = sc.next();
        }while (!Validate.isNumber(goTo));
        int Goto = Integer.parseInt(goTo);
        ListProduct.CurrentPage = (ListProduct.numberOfRow * Goto)-ListProduct.numberOfRow;
        ListProduct.page = Goto;
        lp.display();
    }
    void setRow(){
        String rows;
        do {
            System.out.print("How many row you want to set ? :");
            rows = sc.next();
        }while (!Validate.isNumber(rows));
            int row = Integer.parseInt(rows);
        ListProduct.numberOfRow = row;
    }

}
