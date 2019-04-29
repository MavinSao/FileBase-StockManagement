package com.kshrd.views;

import com.kshrd.models.DAO.SMSAccess;
import com.kshrd.models.DAO.SMSReadWrite;
import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SMSView {
    public static void main(String[] args) throws IOException {

            SMSReadWrite sw = new SMSReadWrite();
            SMSAccess sa = new SMSAccess();
            ListProduct listProduct = new ListProduct();
            ArrayList<Product> v = new ArrayList<>();
            v = sw.readObj();
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



