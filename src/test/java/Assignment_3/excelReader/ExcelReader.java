package Assignment_3.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	private static final String EXCEL_FILE_LOCATION = "C:\\Users\\PriSahay\\eclipse-workspace\\cucumber_test\\src\\test\\java\\Assignment_3\\TestExcelFile.xls";
	Workbook workbook = null;
	
	public void initialize()
	{
		try {
			File f = new File(EXCEL_FILE_LOCATION);


			if (!f.exists())
				System.out.println("BAD");
			else
				System.out.println("GOOD");
			FileInputStream inputStream = new FileInputStream(new File(EXCEL_FILE_LOCATION));
			workbook = new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		if (workbook != null)
			System.out.println("Successfully opened workbook");
		else
			System.out.println("Could not open workbook");

		//System.out.println("Cell (0, 0): " + workbook.getSheet(0).getCell(0, 0).toString());
	}
	
	public Sheet getSheet(int index) {
		return workbook.getSheetAt(index);
	
	}
}