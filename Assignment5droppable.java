package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5droppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable");

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		// Actions class method to drag and drop
		Actions builder = new Actions(driver);

		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		builder.dragAndDrop(from, to).perform();

		WebElement droptext = driver.findElement(By.xpath("//div[@id='droppable']//following::p"));
		System.out.println(droptext.getText());



	}

}
