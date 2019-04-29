package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSAccess {
     Table tb = new Table(2, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
     LocalDate ld = LocalDate.now();
     Scanner sc = new Scanner(System.in);
     //Insert Object
     public ArrayList<Product> write(ArrayList v){
         int id = v.size() + 1;
         System.out.println("Product ID : "+ id);
         System.out.println("Product's name : ");
         String name = sc.next();
             System.out.println("Product's Price : ");
             double price = sc.nextDouble();
         System.out.println("Product's Qty : ");
         int qty = sc.nextInt();

         Product pro = new Product(id,name,price,qty,ld.toString());
         v.add(pro);
         tb.setColumnWidth(0,15,15);
         tb.setColumnWidth(1,15,15);
         tb.addCell("ID");
         tb.addCell(pro.getId()+"");
         tb.addCell("Name");
         tb.addCell(pro.getName());
         tb.addCell("Unit Price");
         tb.addCell(pro.getUnitPrice()+"");
         tb.addCell("Qty");
         tb.addCell(pro.getQty()+"");
         tb.addCell("Imported Date");
         tb.addCell(pro.getImportDate()+"");
         System.out.println(tb.render());

         return v;
     }
        public void search(ArrayList<Product> productList)
        {
            Table ts = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            String nameToSearch="";
            System.out.println("Please Enter something you want to search :");
            Scanner sc = new Scanner(System.in);
            nameToSearch = sc.next();
            ArrayList<Product> rs = new ArrayList<>();
            String msg = "";
               for(Product product : productList)
               {
                   if (nameToSearch.equalsIgnoreCase(product.getName())){
                        rs.add(product);
                   }
                   else msg = "Not Found";
               }
               System.out.println(msg);

            ts.setColumnWidth(0, 8, 16);
            ts.setColumnWidth(1, 8, 16);
            ts.setColumnWidth(2, 8, 16);
            ts.setColumnWidth(3, 8, 16);
            ts.setColumnWidth(4, 8, 16);

            ts.addCell("ID");
            ts.addCell("Name" );
            ts.addCell("Unit Price");
            ts.addCell("Quantity");
            ts.addCell("Import Data");
            for (int i = 0 ; i<rs.size(); i++) {
                ts.addCell(rs.get(i).getId()+"");
                ts.addCell(rs.get(i).getName()+"");
                ts.addCell(rs.get(i).getUnitPrice()+"$");
                ts.addCell(rs.get(i).getQty()+"");
                ts.addCell(rs.get(i).getImportDate()+"");
            }
            System.out.println(ts.render());
        }


}



