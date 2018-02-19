
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\DHEERAJ\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		// List<WebElement>itemList =
		// driver.findElements(By.xpath("//ul[@class='product_list grid
		// row']/l"));
		WebElement e = driver.findElement(By.xpath("//img[@title='Blouse']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", e);
		e.click();
		WebElement plus = driver.findElement(By.xpath("//i[@class='icon-plus']"));

		for (int i = 1; i < 4; i++) {
			plus.click();
		}
		WebElement clothsize = driver
				.findElement(By.xpath("//select[@class='form-control attribute_select no-print']"));
		Select select = new Select(clothsize);
		select.selectByValue("2");
		WebElement addTocartButton = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
		addTocartButton.click();
		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']"));
		Thread.sleep(2000);
		WebElement cross = driver.findElement(By.xpath("//span[@class='cross']"));
		cross.click();
		driver.findElement(By.xpath("//div[@class='shopping_cart']//b")).click();
		WebElement c2 = driver.findElement(By.xpath("//p[@class='product-name']//a[contains(text(),'Blouse')]"));
		String z = c2.getAttribute("innerHTML");
		System.out.println(z);
		if (z.contains("Blouse")) {
			System.out.println("The product is displayed");
		} else {
			System.out.println("Product is not displayed");

		}
	}

}
