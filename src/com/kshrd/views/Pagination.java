package com.kshrd.views;

import java.util.ArrayList;


public class Pagination {
    ListProduct lp = new ListProduct();
    void first(ArrayList v){
        lp.setCurrentPage(1);
        lp.display(v);
    }
    int i=2;
    void previouse(ArrayList v){
        i--;
        lp.setCurrentPage(i);
        lp.display(v);
    }
    void next(ArrayList v){
        i++;
        lp.setCurrentPage(i);
        lp.display(v);
    }

    void last(ArrayList v){
        int index = v.size()-3;
        lp.setCurrentPage(index);
        lp.display(v);
    }
}
