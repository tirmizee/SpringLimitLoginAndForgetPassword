package com.tirmizee.backend.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

@Service 
public class ExcelServiceImpl implements ExcelService{

	@Override
	@SuppressWarnings("resource")
	public ByteArrayOutputStream test() {
		try {
			Workbook xlsFile = new HSSFWorkbook(); 
			Sheet sheet1 = xlsFile.createSheet("Sheet #1");
			Row row = sheet1.createRow(0);
			row.createCell(0).setCellValue("sssssssssssssssssssssssssssssssssssssssssss");
			xlsFile.getSheetAt(0).autoSizeColumn(0);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			xlsFile.write(bos);
			return bos;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
		
	}
	
}
