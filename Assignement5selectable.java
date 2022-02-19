package week6.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignement5selectable {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable");

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		List<WebElement> Selectable = driver.findElements(By.xpath("//*[@id='selectable']/*"));
		Actions x = new Actions(driver);

		x.keyDown(Keys.CONTROL)
		 .click(Selectable.get(0))
		 .click(Selectable.get(1))
		 .click(Selectable.get(2))
		 .click(Selectable.get(3))
		 .click(Selectable.get(4))
		 .keyUp(Keys.CONTROL)
		 .build().perform();

	}

}
