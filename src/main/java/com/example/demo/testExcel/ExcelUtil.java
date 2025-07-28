package com.example.demo.testExcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    /**
     *
     * @描述：是否是2003的excel，返回true是2003
     *
     * @返回值：boolean
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     *
     * @描述：是否是2007的excel，返回true是2007
     *
     * @返回值：boolean
     */

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
    /**
     *
     * @描述：根据流读取Excel文件
     *
     */
    public Map<String, Object> read(InputStream inputStream, boolean isExcel2003) throws Exception {
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            if (isExcel2003) {
                wb = new HSSFWorkbook(inputStream);
            } else {
                wb = new XSSFWorkbook(inputStream);
            }
            return read(wb);
        } catch (IOException e) {
            throw new Exception("读取Excel文件出错!");
        }
    }
    /**
     * 读取excel文件内容，默认读取第一列的数据
     *
     * @描述：读取第一列数据
     */
    private Map<String, Object> read(Workbook wb) {

        int totalRows = 0;// 总行数
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String data = new String();
            /** 得到第一个shell */
            Sheet sheet = wb.getSheetAt(0);//得到Excel文件中的第一个工作簿
            /** 得到Excel的总行数 */
            totalRows = sheet.getPhysicalNumberOfRows();
            for (int r = 0; r < totalRows; r++) {//遍历文件
                Row row = sheet.getRow(r);//得到工作簿中的指定行
                if (row == null) {
                    continue;
                }
                Cell cell = row.getCell(0);//getCell(0)代表获得第一列
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                /** 保存第r行的数据 */
                data = cellValue;
//                map.put("data", data);
                System.out.println("=====>"+data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("D://test.xlsx");
        ExcelUtil util = new ExcelUtil();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        util.read(inputStream,false);
        System.out.println(sdf.format(new Date()));
    }
}
