package week6.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	/*Amazon:
		1.Load the uRL https://www.amazon.in/
		2.search as oneplus 9 pro 
		3.Get the price of the first product
		4. Print the number of customer ratings for the first displayed product
		5. click on the stars 
		6. Get the percentage of ratings for the 5 star.
		7. Click the first text link of the first image
		8. Take a screen shot of the product displayed
		9. Click 'Add to Cart' button
		10. Get the cart subtotal and verify if it is correct.
		*/
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.get("https://www.amazon.in/"); 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
	WebElement ratings =driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
	System.out.println("Customer Ratings for the First Displayed Product :  "
			+ ""+ratings.getText());
	Thread.sleep(3000);	
driver.findElement(By.xpath("//a[@href='javascript:void(0)']//i")).click();
Thread.sleep(4000);	

WebElement Percent =driver.findElement(By.xpath("(//span[@class='a-size-base']//a)[2]"));
System.out.println("Percentage for ratings for 5 star:  "
		+ ""+Percent.getText());
WebElement FirstTitle = driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[1]"));
FirstTitle.click();
System.out.println("First Product displayed - " +FirstTitle.getText());

Thread.sleep(3000);

Set <String> window = driver.getWindowHandles();
List<String> list = new ArrayList<String>(window);
driver.switchTo().window(list.get(1));
 
File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot,
		new File("D:\\MavenProject2\\src\\main\\resources\\Screenshots\\AMAZON_PRODUCT.png"));


JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,900)");
Thread.sleep(3000);
driver.findElement(By.id("add-to-cart-button")).click();
	  Thread.sleep(3000);	
		
WebElement subtotal = driver.findElement(By.cssSelector("span#attach-accessory-cart-subtotal"));
String subTotal = subtotal.getText().replace("/d","");
subTotal = subTotal.replaceAll("\\D", "");

System.out.println("Added to cart - "+subTotal);		
Thread.sleep(3000);
driver.findElement(By.cssSelector("span#attach-sidesheet-view-cart-button>span>input")).click();
	Thread.sleep(3000);
	WebElement checkouttotal  = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
	
	System.out.println("Checkout Total - "+checkouttotal.getText());	
		
	}

}
