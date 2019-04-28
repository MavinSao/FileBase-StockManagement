package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class SMSAccess {
    public static ArrayList<Product> search(ArrayList<Product> productList,String nameToSearch)
    {
        ArrayList<Product> larch = new ArrayList<>();
        Iterator<Product> iterator = productList.iterator();
           while (iterator.hasNext()) {
               Product product = iterator.next();
               for (char c:nameToSearch.toCharArray()){
                   String r = Character.toString(c);
                   if (Pattern.matches(r,product.getName())){
                       larch.add(product);
                       break;
                   }
               }
           }

           return larch;
 }
}



