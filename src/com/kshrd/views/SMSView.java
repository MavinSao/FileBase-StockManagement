package com.kshrd.views;

import com.kshrd.models.DAO.SMSAccess;
import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SMSView {
    public static void main(String[] args) throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        LocalDate ld = LocalDate.now();
       for(int i=1; i<=1000000; i++)
       {
           products.add(new Product(i, "coca", 22.5, 5, ld.toString()));

       }
       String path ="cheata.txt";
        try {
            ObjectOutputStream write1 = new ObjectOutputStream(new FileOutputStream(path));
           write1.writeObject(products);
           write1.close();
            System.out.println("Write Complete!");
       }
       catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
      }
        ArrayList<Product> v = new ArrayList<>();
        try
        {
            ObjectInputStream read1= new ObjectInputStream(new FileInputStream(path));
            v =(ArrayList<Product>) read1.readObject();
            Iterator<Product> iter = v.iterator();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



            ListProduct listProduct = new ListProduct();
            Scanner sc = new Scanner(System.in);
            Pagination page = new Pagination();
            Table sh = new Table(5, BorderStyle.DESIGN_CAFE_WIDE, ShownBorders.ALL);



            System.out.println("Please Wait Loading.....!");
            System.out.println("Current time loading : ......");


            CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.right);
            Table tm = new Table(10, BorderStyle.CLASSIC_COMPATIBLE_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            for (int i = 0; i <= 9; i++) {
                tm.setColumnWidth(i, 5, 10);
            }
            tm.addCell("*)Display");
            tm.addCell("W)rite");
            tm.addCell("R)ead");
            tm.addCell("U)pdate");
            tm.addCell("D)elete");
            tm.addCell("F)irst");
            tm.addCell("P)revious");
            tm.addCell("N)ext");
            tm.addCell("L)ast");
            tm.addCell("S)earch");
            tm.addCell("G)oto");
            tm.addCell("Se)t row");
            tm.addCell("Sa)ve");
            tm.addCell("Ba)ck");
            tm.addCell("Re)store");
            tm.addCell("He)lp");
            tm.addCell("E)xit");
            while (true) {
                System.out.println("                                      --Menu--");
                System.out.println(tm.render());
                System.out.print("Command --> ");
                String cmd = sc.next();

                switch (cmd) {
                    case "*":
                        System.out.println("                --List Product--");
                        listProduct.display(v);
                        break;
                    case "w":
                        System.out.println("write data..");
                        break;
                    case "r":
                        System.out.println("read");
                        break;
                    case "u":
                        System.out.println("update");
                        break;
                    case "d":
                        System.out.println("delete");
                        break;
                    case "f":
                        System.out.println("first");
                        page.first(v);
                        break;
                    case "p":
                        System.out.println("previous");
                        page.previouse(v);
                        break;
                    case "n":
                        System.out.println("next");
                        page.next(v);
                        break;
                    case "l":
                        System.out.println("last");
                        page.last(v);
                        break;
                    case "s":
                        sh.setColumnWidth(0,8,9);
                        sh.setColumnWidth(1,8,9);
                        sh.setColumnWidth(2,15,2);
                        sh.setColumnWidth(3,15,15);
                        sh.setColumnWidth(4,15,15);
                        System.out.println("search: ");
                        String name = sc.next();
                        ArrayList<Product> listsearch = SMSAccess.search(v,name);
                        sh.addCell("ID");
                        sh.addCell("Name" );
                        sh.addCell("Unit Price", numberStyle);
                        sh.addCell("Quantity", numberStyle);
                        sh.addCell("Import Data");
                        for (Product p : listsearch) {
                            sh.addCell(p.getId()+"",numberStyle);
                            sh.addCell(p.getName()+"");
                            sh.addCell(p.getUnitPrice()+"$",numberStyle);
                            sh.addCell(p.getQty()+"",numberStyle);
                            sh.addCell(p.getImportDate()+"");
                        }
                        System.out.println(sh.render());
                        break;
                    case "g":
                        System.out.println("goto");
                        break;
                    case "se":
                        System.out.println("setrow");
                        break;
                    case "sa":
                        System.out.println("save");
                        break;
                    case "ba":
                        System.out.println("back up");
                        break;
                    case "re":
                        System.out.println("Restore");
                        break;
                    case "h":
                        System.out.println("help");
                        break;
                    case "e":
                        System.out.println("exit");
                        break;

                }
            }
        }
    }



