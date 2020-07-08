package com.yintu.ruixing.common.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
        int index = 2;
        int rowNum = hssfSheet.getLastRowNum();
        int cellNum = hssfSheet.getRow(index).getLastCellNum();
        String[][] values = new String[rowNum][cellNum];
        for (int i = index; i < rowNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                values[i][j] = hssfSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return values;
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
        int index = 2;
        int rowNum = xssfSheet.getLastRowNum();
        int cellNum = xssfSheet.getRow(index).getLastCellNum();
        String[][] values = new String[rowNum][cellNum];
        for (int i = index; i < rowNum; i++) {
            for (int j = 0; j < cellNum; j++) {
                values[i][j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return values;
    }

}
