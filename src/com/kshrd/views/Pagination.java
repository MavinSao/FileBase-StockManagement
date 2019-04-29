package com.kshrd.views;

import java.util.ArrayList;


public class Pagination {
    ListProduct lp = new ListProduct();
    int i = 0;
    void first(ArrayList v){
        ListProduct.CurrentPage = 0;
        ListProduct.page = 1;
        lp.display(v);
    }
    void previouse(ArrayList v){
        ListProduct.page--;
        if(ListProduct.page<1){
            ListProduct.CurrentPage = v.size()-ListProduct.numberOfRow;
            ListProduct.page = v.size()/ListProduct.numberOfRow;
            lp.display(v);
        }else {
            ListProduct.CurrentPage-=ListProduct.numberOfRow;
            lp.display(v);
        }
    }
    void next(ArrayList v){


        ListProduct.CurrentPage += ListProduct.numberOfRow;
        if(ListProduct.CurrentPage>=v.size()){
            ListProduct.CurrentPage = 0;
            ListProduct.page = 1;
            lp.display(v);
        }else {
            ListProduct.page+=1;
            lp.display(v);
        }
    }
     void last(ArrayList v){
         ListProduct.CurrentPage = v.size()-ListProduct.numberOfRow;
         ListProduct.page = v.size()/ListProduct.numberOfRow;
         lp.display(v);
      }
     void goTo(ArrayList v,int go){
        ListProduct.CurrentPage = (ListProduct.numberOfRow * go)-ListProduct.numberOfRow;
        ListProduct.page = go;
        lp.display(v);
    }
    void setRow(int row){
        ListProduct.numberOfRow = row;
    }

}
