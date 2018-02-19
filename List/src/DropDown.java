import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.dropbox.com/help/desktop-web/locate-dropbox-folder");
		System.out.println("one");
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'Categories')]"));
		
		element.click();
		driver.findElement(By.xpath("//a[@class='categories__link categories__link--active dropdown__content-link'and contains(text(),'Mobile')]")).click();
		//List<WebElement> list =driver.findElements(By.xpath("//ul[@class='help-nav__categories-list dropdown__content-list']//li//a"));
        //int count=list.size();
        //System.out.println(list.size());
        
      /* for (int i=0;i<=count;i++){
                list.get(i).getText();
                 System.out.println( list.get(i).getText());
                 if( list.get(i).getText().contains("Mobile")){
                	list.get(i).click();
                 }
        }*/
	}
}


