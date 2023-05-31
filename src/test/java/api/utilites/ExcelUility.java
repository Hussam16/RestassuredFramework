package api.utilites;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUility {

	public Object[][] getDataFromExcel(String NameSheet) throws EncryptedDocumentException, IOException {

		String filePath = "E:\\Projects\\Restassured\\file.xlsx";
		String sheetName = NameSheet;

		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
 
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount]; 

		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		}

		workbook.close();
		file.close();

		return data;
	}

}
