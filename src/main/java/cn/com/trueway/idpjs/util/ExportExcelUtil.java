package cn.com.trueway.zdcy.util;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExportExcelUtil {
	/**
     * 导出Excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param values 内容
     * @param wb HSSFWorkbook对象
     * @return
     */
    public HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if(wb == null){
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1);
            for(int j=0;j<values[i].length;j++){
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }
    
    /**
     * @param names 标题数组
     * @param columns map中key
     * @param list 数据map
     * @return
     */
	public HSSFWorkbook OutExcelUtil(String[] names, String[] columns,
			List<Map<String, String>> list) {
		
		// 新建工作簿
		HSSFWorkbook workBook = new HSSFWorkbook();
		// 新建sheet页
		Sheet sheet = ((HSSFWorkbook) workBook).createSheet();// 2003
		// 新建第0行（标题行）
		Row row = sheet.createRow(0);
		for (int i = 0; i < names.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(names[i]);
		}
		
		for (int k = 0; k < list.size(); k++) {
			Map<String, String> map = list.get(k);
			Row row2 = sheet.createRow(k + 1);
			for (int j = 0; j < columns.length; j++) {
				Cell cell = row2.createCell(j);
				cell.setCellValue(map.get(columns[j]));
			}
		}
		return workBook;
	}
	
	/**
	 * 特殊需求写出
     * @param names 标题数组
     * @param columns map中key
     * @param list 数据map
     * @return
     */
	public HSSFWorkbook OutExcelUtilLinkedHashMap(HSSFWorkbook workBook,String[] names, String[] columns,
			List<LinkedHashMap<String, Object>> list, int sheetNum, String sheetTitle) {
		
		// 新建工作簿
	//	HSSFWorkbook workBook = new HSSFWorkbook();
		// 新建sheet页
		Sheet sheet = ((HSSFWorkbook) workBook).createSheet();// 2003
		workBook.setSheetName(sheetNum, sheetTitle);
		// 新建第0行（标题行）
		Row row = sheet.createRow(0);
		for (int i = 0; i < names.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(names[i]);
		}
		
		for (int k = 0; k < list.size(); k++) {
			Map<String, Object> map = list.get(k);
			if (map == null) {
				continue;
			}
			Row row2 = sheet.createRow(k + 1);
			for (int j = 0; j < columns.length; j++) {
				Cell cell = row2.createCell(j);
				cell.setCellValue((String)map.get(columns[j])==null?"":(String)map.get(columns[j]));
			}
		}
		return workBook;
	}
	
	//发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
