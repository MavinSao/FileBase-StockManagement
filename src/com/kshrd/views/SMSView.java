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
    LocalDate ld = LocalDate.now();
    static SMSAccess sa = new SMSAccess();
    public static ListProduct listProduct = new ListProduct();
    public static ArrayList<Product> products = new ArrayList<>();
    public void display() throws IOException {



            Scanner sc = new Scanner(System.in);
            Pagination page = new Pagination();



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
                        System.out.println("                 --List Product--");
                        listProduct.display();
                        break;
                    case "w":
                        sa.write();
                        break;
                    case "r":
                        sa.read();
                        break;
                    case "u":
                        System.out.println("update");
                        break;
                    case "d":

                        break;
                    case "f":
                        System.out.println("first");
                        page.first();
                        break;
                    case "p":
                        System.out.println("previous");
                        page.previouse();
                        break;
                    case "n":
                        page.next();
                        break;
                    case "l":
                        page.last();

                        break;
                    case "s":
                        sa.search();
                        break;
                    case "g":
                        System.out.print("Wish page do you want to go : "); int goTo = sc.nextInt();
                        page.goTo(goTo);
                        break;
                    case "se":
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
                    case "#10m":
                        System.out.println("Please Wait Loading.....!");
                        for(int i=1;i<=10000000;i++){
                            products.add(new Product(i,"coca",4.5,5,ld.toString()));
                        }
                        System.out.println("Done!!");

                        break;
                    default:
                        System.out.println("Input Invalid");

                }
            }
        }
    }



