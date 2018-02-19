import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\DHEERAJ\\Documents\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.shopclues.com/");
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();

		Actions action = new Actions(driver);
		try {
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Men')]"))).build().perform();
            driver.findElement(By.xpath("//a[contains(text(),'Budget')]")).click();
		} catch (Exception e) {
             System.out.println("The exception is :" +e.getMessage());
		}
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total number of windows is " + count);
		for (String child : allWindows) {
			if (!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
			}
		}
	}
}
