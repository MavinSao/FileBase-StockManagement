package com.kshrd.views;

import com.kshrd.models.DAO.SMSAccess;
import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSView {
    public void display() throws IOException {

            LocalDate ld = LocalDate.now();
            SMSAccess sa = new SMSAccess();
            ListProduct listProduct = new ListProduct();
            ArrayList<Product> v = new ArrayList<>();
            for(int i=1;i<=25;i++){
                v.add(new Product(i,"coca",4.5,5,ld.toString()));
            }
            Scanner sc = new Scanner(System.in);
            Pagination page = new Pagination();
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
                        System.out.println("write");
                        v=sa.write(v);
                        break;
                    case "r":
                        System.out.println("read");
                        break;
                    case "u":
                        System.out.println("update");
                        break;
                    case "d":
                        System.out.println("delete");
                        System.out.println("Enter ID :");
                        int id = sc.nextInt();
                        int index = id-1;
                        v.remove(index);
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
                        page.last(v);

                        break;
                    case "s":
                        sa.search(v);
                        break;
                    case "g":
                        System.out.print("Wish page do you want to go : "); int goTo = sc.nextInt();
                        page.goTo(v,goTo);

                        break;
                    case "se":
                        System.out.println("setrow");
                        System.out.print("How many row you want to set ? :");
                        int row =sc.nextInt();
                        page.setRow(row);
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
                        System.exit(0);
                        break;

                }
            }
        }
    }



