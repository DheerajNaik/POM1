import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Local {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\DHEERAJ\\Documents\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get(
				"https://www.w3schools.com/html/html_tables.asp"); // url
		
		String ExpectedValue = "Island Trading";
		String actualValue=driver.findElement(By.xpath("//td[contains(text(),'Island Trading')]")).getText();
		if(actualValue.equals(ExpectedValue)){
			System.out.println("Test case pass " + actualValue);
		}
		else{
			System.out.println("Test case fail");
		}

	}
}