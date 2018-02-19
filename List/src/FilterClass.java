import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FilterClass {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DHEERAJ\\Documents\\New folder\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		/*System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();*/
		driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		//a[@title='Women']
		WebElement womenLink=driver.findElement(By.xpath("//a[@title='Women']"));
		womenLink.click();
		Thread.sleep(2000);
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		WebElement orangeColor=driver.findElement(By.xpath("//a[contains(text(),'Orange')]/parent::*/preceding-sibling::input[1]"));
          js.executeScript("arguments[0].scrollIntoView(true);",orangeColor);
          orangeColor.click();
          Thread.sleep(5000);
          List<WebElement> filteredList=driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
          int count=filteredList.size();
          if(count==3){
        	  System.out.println("Pass  :::  There are 3 filetered clothes for orange color");
          }
          else{
        	  System.out.println("test case failed");
          }
          
	}

}
