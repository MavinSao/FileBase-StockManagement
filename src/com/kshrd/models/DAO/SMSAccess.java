package com.kshrd.models.DAO;

import com.kshrd.models.DTO.Product;
import com.kshrd.views.SMSView;
import com.kshrd.views.Validate;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSAccess {

     LocalDate ld = LocalDate.now();
     Scanner sc = new Scanner(System.in);
     //Insert Object
     public void write(){
         String pri;
         String qty;
         Table tb = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
         int id = SMSView.products.size() + 1;
         System.out.print("Product ID : "+ id);
         System.out.println();
         System.out.print("Product's name : ");
         String name = sc.next();
         do {
             System.out.print("Product's Price : ");
             pri = sc.next();
         }while (!Validate.isNumber(pri));
         double price = Double.parseDouble(pri);
         do {
             System.out.print("Product's Qty : ");
             qty = sc.next();
         }while (!Validate.isNumber(qty));
         int quantity = Integer.parseInt(qty);

         System.out.println();
         System.out.println("===Product Information===");
         Product pro = new Product(id,name,price,quantity,ld.toString());
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
         System.out.println();
         System.out.print("Are you sure for add this record ? [Y/y]/[N/n] :");
         String an = sc.next();
         if(an.equalsIgnoreCase("y")||an.equalsIgnoreCase("yes")){
             System.out.println();
             SMSView.products.add(pro);
             System.out.println("Successful inserted!!!");
         }else {
             System.out.println("Canceled !!!");
         }


     }
        public void search()
        {
            Table ts = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            String nameToSearch="";
            System.out.println("Please Enter Name you want to search :");
            Scanner sc = new Scanner(System.in);
            nameToSearch = sc.next();
            ArrayList<Product> rs = new ArrayList<>();
            boolean isFound = false;
               for(Product product : SMSView.products)
               {
                   if (nameToSearch.equalsIgnoreCase(product.getName())){
                        rs.add(product);
                        isFound = true;
                   }

               }
            if (isFound == true) {


                ts.addCell("ID");
                ts.addCell("Name");
                ts.addCell("Unit Price");
                ts.addCell("Quantity");
                ts.addCell("Import Data");
                for (int i = 0; i < rs.size(); i++) {
                    ts.addCell(rs.get(i).getId() + "");
                    ts.addCell(rs.get(i).getName() + "");
                    ts.addCell(rs.get(i).getUnitPrice() + "$");
                    ts.addCell(rs.get(i).getQty() + "");
                    ts.addCell(rs.get(i).getImportDate() + "");
                    System.out.println(ts.render());
                }
            }
            else System.out.println("Not Found");

        }
        public void read(){
            Table tr = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            String idr;
            do {
                System.out.print("Read by ID : ");
                idr = sc.next();
            }while (!Validate.isNumber(idr));
                int id = Integer.parseInt(idr);
            boolean isFound = false;
            for(Product product : SMSView.products)
            {
                if (id == product.getId()){
                    tr.addCell("ID");
                    tr.addCell(product.getId() + "");
                    tr.addCell("Name");
                    tr.addCell(product.getName() + "");
                    tr.addCell("Unit Price");
                    tr.addCell(product.getUnitPrice() + "$");
                    tr.addCell("Quantity");
                    tr.addCell(product.getQty() + "");
                    tr.addCell("Import Date");
                    tr.addCell(product.getImportDate() + "");
                    System.out.println(tr.render());
                    isFound = true;
                    break;
                }

            }
            if (isFound == false) {
                System.out.println("Invalid ID !!!");
            }
        }
        public void delete(){
         String idd;
            do {
                System.out.print("Please input ID of Product : ");
                idd = sc.next();
            }while (!Validate.isNumber(idd));
            int id = Integer.parseInt(idd);
            Table tl = new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            boolean isFound = false;
            for(Product product : SMSView.products)
            {
                if (id == product.getId()){
                    tl.addCell("ID");
                    tl.addCell(product.getId() + "");
                    tl.addCell("Name");
                    tl.addCell(product.getName() + "");
                    tl.addCell("Unit Price");
                    tl.addCell(product.getUnitPrice() + "$");
                    tl.addCell("Quantity");
                    tl.addCell(product.getQty() + "");
                    tl.addCell("Import Date");
                    tl.addCell(product.getImportDate() + "");
                    System.out.println(tl.render());
                    isFound = true;
                    System.out.print("Are you sure want to delete this record ? [Y/y] or [N/n] :");
                    String an = sc.next();
                    if(an.equalsIgnoreCase("y")){

                        SMSView.products.remove((product.getId()-1));
                        System.out.println();
                        System.out.println("Delete Successful");
                    }else {
                        System.out.println();
                        System.out.println("Delete Canceled!!!");
                    }
                    break;
                }

            }
            if (isFound == false) {
                System.out.println("Invalid ID !!!");
            }
        }




}



