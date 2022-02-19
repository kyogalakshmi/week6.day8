package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver"); 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebElement frames = driver.findElement(By.id("frame1"));
	    driver.switchTo().frame(frames);
	    driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Frames");
	    WebElement innerframes = driver.findElement(By.id("frame3"));
	    driver.switchTo().frame(innerframes);
	    driver.findElement(By.cssSelector("input#a")).click();
	    driver. switchTo().defaultContent();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebElement frame2 = driver.findElement(By.id("frame2"));
	    driver.switchTo().frame(frame2);
	    WebElement animalsCatBabyCatBig = driver.findElement(By.className("col-lg-3")); 
	    new Select(animalsCatBabyCatBig).selectByVisibleText("Avatar"); 
	    System.out.println("Selected dropdown is - "+animalsCatBabyCatBig.getAttribute("value"));
	    }

}
