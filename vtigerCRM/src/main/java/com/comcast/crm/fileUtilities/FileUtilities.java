package com.comcast.crm.fileUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtilities {

	public String accessDatafromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mchet\\OneDrive\\Desktop\\vtigerapplication\\vtigerCRM\\src\\main\\resources\\crmCommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String key_data = prop.getProperty(key);
		return key_data;
	}

	public String accessDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mchet\\OneDrive\\Desktop\\vtigerapplication\\vtigerCRM\\src\\main\\resources\\crmTestScriptData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		return cell.getStringCellValue();
	}

}
