package com.kshrd.views;

import java.util.ArrayList;


public class Pagination {
    ListProduct lp = new ListProduct();
    int i = 0;
    void first(ArrayList v){
        lp.setCurrentPage(0);
        lp.display(v);
        i=0;
    }
    void previouse(ArrayList v){
        if(i==0){
            last(v);
        }
        else {
            i--;
            lp.setCurrentPage(i);
            lp.display(v);
        }

    }
    void next(ArrayList v){

        int lastIndex = v.size();
        if (i==lastIndex-1){
            first(v);
        }else {
            i++;
            lp.setCurrentPage(i);
            lp.display(v);
        }
    }

     void last(ArrayList v){
          int index = v.size()-1;
          lp.setCurrentPage(index);
          lp.display(v);
          i=index;
      }
}
