package com.kody.kiwi.excel;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/excel_do")
public class ExcelController {

    @PostMapping("xss")
    public void xssCreate() throws Exception{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowNum = 0;
        int cellNum = 0;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(cellNum);
    }

    @PostMapping("sxss")
    public void sxssCreate() throws Exception{
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowNum = 0;
        int cellNum = 0;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(cellNum);
    }

    @PostMapping("hss")
    public void hxssCreate() throws Exception{
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowNum = 0;
        int cellNum = 0;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(cellNum);
    }

}
