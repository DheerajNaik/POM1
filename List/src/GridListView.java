import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GridListView {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		WebElement listViewButton= driver.findElement(By.xpath("//i[@class='icon-th-list']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", listViewButton);
		//listViewButton.click();
		
		System.out.println("List view button clicked");
		WebElement gridViewButton= driver.findElement(By.xpath("//i[@class='icon-th-large']"));
		gridViewButton.click();
		WebElement addToCartButton=driver.findElement(By.xpath("//span[contains(text(),'Add')]"));
		if(addToCartButton.isDisplayed()){
			System.out.println("The page is in List View");
			}
		else{
			System.out.println("The Page is in Grid View");
		}
	//	WebElement gridViewButton= driver.findElement(By.xpath("//i[@class='icon-th-large']"));
		//gridViewButton.click();
		

}
}
