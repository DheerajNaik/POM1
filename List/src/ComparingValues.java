import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComparingValues {
	
	public void tc() throws IOException{
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.freecrm.com/register/");
		System.out.println("Page launched");
		List<WebElement> actualResult = driver
				.findElements(By.xpath("//input[@class='form-control input-text' and @type!='hidden']"));
		ArrayList<String> expectedResult= readExcelData(0);
		int count = actualResult.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			if(actualResult.equals(expectedResult)){
				System.out.println( expectedResult + "is equal to " +actualResult);
			}
		}
	}

	public ArrayList<String> readExcelData(int col) throws IOException {
		FileInputStream file = new FileInputStream("C://Users//DHEERAJ//Desktop//AllFields.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> it = sheet.iterator();

		it.next();

		ArrayList<String> expectedResult = new ArrayList<String>();

		while (it.hasNext()) {
			expectedResult.add(it.next().getCell(col).getStringCellValue());

		}
		System.out.println(expectedResult);
		return expectedResult;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		ComparingValues compare = new ComparingValues();
		compare.readExcelData(0);
	}
}
