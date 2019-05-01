package com.kshrd.views;

import com.kshrd.models.DTO.Product;

import java.util.ArrayList;
import java.util.Scanner;


public class Pagination {
    ListProduct lp = new ListProduct();
    ArrayList<Product> v = SMSView.products;
    Scanner sc = new Scanner(System.in);
    int row = 0;
    void first(){
        ListProduct.CurrentPage = 0;
        ListProduct.page = 1;
        lp.display();
    }
    void previouse(){
        ListProduct.page--;
        if(ListProduct.page<1){
            last();
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
             if (v.size()%ListProduct.numberOfRow==0){
             ListProduct.totalPage = (SMSView.products.size() / ListProduct.numberOfRow);
                 ListProduct.CurrentPage += ListProduct.numberOfRow;

             }
             else {

                 ListProduct.CurrentPage = (v.size()- ListProduct.numberOfRow)+(v.size()%ListProduct.numberOfRow);
                 ListProduct.totalPage = (SMSView.products.size() / ListProduct.numberOfRow)+1;
                 ListProduct.numberOfRow = v.size()-ListProduct.CurrentPage;
             }
             ListProduct.page = ListProduct.totalPage;
             lp.display();
             ListProduct.numberOfRow = row;

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
            row = Integer.parseInt(rows);
            if(SMSView.products.size()%row==0) {
                ListProduct.numberOfRow = row;
            }else {
                ListProduct.numberOfRow = row;
                ListProduct.totalPage = (SMSView.products.size() / ListProduct.numberOfRow)+1;
            }
    }

}
