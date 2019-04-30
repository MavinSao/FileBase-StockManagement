package com.kshrd.views;


import com.kshrd.models.DTO.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;

public class ListProduct {
        public static int CurrentPage = 0;
        public static int page = 1,numberOfRow=1;

    public void display() {
            ArrayList<Product> list = SMSView.products;
            CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.right);
            Table t = new Table(5, BorderStyle.UNICODE_DOUBLE_BOX,
                    ShownBorders.ALL);
            if (SMSView.products.size() == 0) {
                    System.out.println("404 not found!!!");
                    System.out.println("No record yet!! please input some record!!");
            } else {
                    t.addCell("ID");
                    t.addCell("Name");
                    t.addCell("Unit Price", numberStyle);
                    t.addCell("Quantity", numberStyle);
                    t.addCell("Import Data");
                    for (int i = CurrentPage; i < CurrentPage + numberOfRow; i++) {
                            t.addCell(list.get(i).getId() + "", numberStyle);
                            t.addCell(list.get(i).getName() + "");
                            t.addCell(list.get(i).getUnitPrice() + "$", numberStyle);
                            t.addCell(list.get(i).getQty() + "", numberStyle);
                            t.addCell(list.get(i).getImportDate() + "");
                    }
                    Table tp = new Table(2, BorderStyle.DESIGN_CURTAIN_HEAVY,
                            ShownBorders.SURROUND);
                    tp.setColumnWidth(0, 25, 30);
                    tp.addCell("Page : " + page + " of " + (list.size() / numberOfRow));
                    tp.addCell("Total Record : " + list.size());
                    System.out.println(t.render());
                    System.out.println(tp.render());
            }
    }

}



