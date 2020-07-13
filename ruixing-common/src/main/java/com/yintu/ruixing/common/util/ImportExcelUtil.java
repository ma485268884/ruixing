package com.yintu.ruixing.common.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.expression.spel.ast.NullLiteral;

/**
 * @author:mlf
 * @date:2020/7/8 18:50
 */
public class ImportExcelUtil {

    /**
     * 取出后缀为.xls的表格文件内容
     *
     * @param title        标题
     * @param hssfWorkbook ...
     * @return
     */
    public static String[][] getHSSFData(String title, HSSFWorkbook hssfWorkbook) {
        HSSFSheet hssfSheet = hssfWorkbook.getSheet(title);
        int index = 2;//内容开始行下标
        int rowNum = hssfSheet.getLastRowNum() + 1;//内容总行数
        int columnNum = hssfSheet.getRow(1).getLastCellNum();//标题总列数
        String[][] context = new String[rowNum - index][columnNum];//定义内容行跟列二维数组
        for (int i = 0; i < context.length; i++) {
            for (int j = 0; j < context[i].length; j++) {
                HSSFCell value = hssfSheet.getRow(index + i).getCell(j);
                context[i][j] = value == null ? null : value.toString();
            }
        }
        return context;
    }

    /**
     * 取出后缀为.xlsx的表格文件内容
     *
     * @param title        标题
     * @param xssfWorkbook ...
     * @return
     */
    public static String[][] getXSSFData(String title, XSSFWorkbook xssfWorkbook) {
        XSSFSheet xssfSheet = xssfWorkbook.getSheet(title);
        int index = 2;//内容开始行下标
        int rowNum = xssfSheet.getLastRowNum() + 1;//内容总行数
        int columnNum = xssfSheet.getRow(1).getLastCellNum();//标题总列数
        String[][] context = new String[rowNum - index][columnNum];//定义内容行跟列二维数组
        for (int i = 0; i < context.length; i++) {
            for (int j = 0; j < context[i].length; j++) {
                XSSFCell value = xssfSheet.getRow(index + i).getCell(j);
                context[i][j] = value == null ? null : value.toString();
            }
        }
        return context;
    }

}
