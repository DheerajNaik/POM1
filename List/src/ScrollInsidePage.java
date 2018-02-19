import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScrollInsidePage {
	static WebDriver driver = new FirefoxDriver();
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		EventFiringWebDriver fire= new EventFiringWebDriver(driver);
		fire.executeScript("document.querySelector('//div[@class='w3-light-grey']').scrollTop=500");
    System.out.println("pass");
	}

	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	public static void scrollIntoView(WebElement element){
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		}
	
	
}
