import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Listing {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\DHEERAJ\\Documents\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.freecrm.com/register/"); //url

		

		List<WebElement> list= driver.findElements(By.xpath("//div[@class='form-group has-feedback']/small"));

		int count = list.size();
		System.out.println("The size is " +count);

		for (int i = 0; i < count; i++) {

			String fieldName = list.get(i).getAttribute("data-bv-validator-for");
			System.out.println("The mandatory field is " + fieldName);
			String errorMessage = list.get(i).getAttribute("innerHTML");
			System.out.println("The error message is " + errorMessage);
			/*String labelName = element.getAttribute("innerHTML");
			System.out.println("The mandatory field is " + labelName);

		}*/

	}

	}
}
