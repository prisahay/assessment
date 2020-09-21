package Assignment_3;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import Assignment_3.excelReader.ExcelReader;
import Assignment_3.excelReader.ObjectDataReader;
import Assignment_3.library.Keywords;

public class HybridTest {
	ExcelReader excel = new ExcelReader(); // Creating an object of the class that holds code to read data from excel.
	ObjectDataReader object_reader = new ObjectDataReader();
	Keywords keywords = new Keywords();

	@Test
	public void runTests() {
		excel.initialize(); // Initialize Excel Workbook
		Sheet sheet = excel.getSheet(0); // Get first sheet
		System.out.println("Num rows: " + (sheet.getLastRowNum() - sheet.getFirstRowNum()));
		
		try {
			Properties object_props = object_reader.getObjectRepository(); // Read properties

			int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();
			for (int i = 1; i < rows + 1; i++) {
				Row row = sheet.getRow(i);
				System.out.println(row.getFirstCellNum() + "," + row.getLastCellNum());
				if (row.getFirstCellNum() == 0) // New test cases
				{
					System.out.println("======== Test-Case: " + row.getCell(0).toString() + " =======");
					continue;
				}

				String object = "", type = "", test_data = "";
				String keyword = row.getCell(1).toString();
				if (row.getCell(2) != null)
					object = row.getCell(2).toString();
				if (row.getCell(3) != null)
					type = row.getCell(3).toString();
				if (row.getCell(4) != null)
					test_data = row.getCell(4).toString();
				
				keywords.perform(keyword, object, type, test_data, object_props);
				System.out.println("Performed Step: " + keyword);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	   	@Test
//	  	public void searchKeys(){
//	         	System.out.println("----Let us start searching the keywords----");
//	         	//Entering keyword in search box and searching it
//	         	WebElement srchBox = driver.findElement(By.id("twotabsearchtextbox"));   	
//	         	srchBox.sendKeys(excel.getData(2, 2) + "\n");  //Will read the second row-first column from the excel sheet#0
//	                	//Printing the title of the new page
//	         	String title = driver.getTitle();
//	         	System.out.println("The title is : " +title);
//	  	}
//	  	@After
//	  	public void tearDown(){
//	         	System.out.println("----We're now closing our test----");
//	         	driver.quit();
}
