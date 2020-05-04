package conditional.probability;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

public class ConditionalProbability {

    public static void main(String[] args) throws Exception {
        Method method = new Method();

        File file = new File("D:\\NU School Files\\6th Term\\QuaMet\\cancer_test_data.xls");
        Workbook wb = Workbook.getWorkbook(file);
        Sheet s = wb.getSheet(0);
        int row = s.getRows();
        int col = s.getColumns();

        String txt = "";
        String txt1 = null, txt2 = null, txt3 = null;

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                Cell c = s.getCell(y, x);
                if (x == 0) {
                    if (y == 0) {
                        txt1 = c.getContents();
                    } else if (y == 1) {
                        txt2 = c.getContents();
                    } else {
                        txt3 = c.getContents();
                    }
                } else {
                    if (y == 0) {
                        txt1 = c.getContents();
                    } else if (y == 1) {
                        txt2 = c.getContents();
                    } else {
                        txt3 = c.getContents();
                    }
                }
            }
            method.insert(txt1, txt2, txt3);
            txt1 = "";
            txt2 = "";
            txt3 = "";
        }

        method.show();
        method.count();

    }

}
