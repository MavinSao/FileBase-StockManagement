package com.kshrd.views;


import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;

public class ListProduct {
        int CurrentPage = 1;


    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public void display(ArrayList<Product> list) {
            CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.right);
            Table t = new Table(5, BorderStyle.UNICODE_DOUBLE_BOX,
                    ShownBorders.ALL);
            t.setColumnWidth(0, 8, 16);
            t.setColumnWidth(1, 8, 16);
            t.setColumnWidth(2, 8, 16);
            t.setColumnWidth(3, 8, 16);
            t.setColumnWidth(4, 8, 16);

            t.addCell("ID");
            t.addCell("Name" );
            t.addCell("Unit Price", numberStyle);
            t.addCell("Quantity", numberStyle);
            t.addCell("Import Data");
            for (int i = CurrentPage-1 ; i<CurrentPage+1; i++) {
                t.addCell(list.get(i).getId()+"",numberStyle);
                t.addCell(list.get(i).getName()+"");
                t.addCell(list.get(i).getUnitPrice()+"$",numberStyle);
                t.addCell(list.get(i).getQty()+"",numberStyle);
                t.addCell(list.get(i).getImportDate()+"");
            }
            Table tp = new Table(2, BorderStyle.DESIGN_CURTAIN_HEAVY,
                    ShownBorders.SURROUND);
            tp.setColumnWidth(0,35,38);
            tp.setColumnWidth(1,25,25);
            tp.addCell("Page : "+" of " + (list.size()/2));
            tp.addCell("Total Record : "+ list.size());
            System.out.println(t.render());
            System.out.println(tp.render());
        }

}



