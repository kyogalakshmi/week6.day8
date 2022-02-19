package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement5resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable");

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		builder.clickAndHold(element).moveByOffset(150, 100).perform();  
	
		
	}

}
