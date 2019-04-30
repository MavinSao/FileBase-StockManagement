package com.kshrd.views;

import com.kshrd.models.DTO.Product;

import java.util.ArrayList;


public class Pagination {
    ListProduct lp = new ListProduct();
    ArrayList<Product> v = SMSView.products;
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
     void goTo(int go){
        ListProduct.CurrentPage = (ListProduct.numberOfRow * go)-ListProduct.numberOfRow;
        ListProduct.page = go;
        lp.display();
    }
    void setRow(int row){
        ListProduct.numberOfRow = row;
    }

}
