package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
/*
Step1: Load ServiceNow application URL 
Step2: Enter username (Check for frame before entering the username)
Step3: Enter password 
Step4: Click Login
Step5: Search “incident “ Filter Navigator
Step6: Click “All”
Step7: Click New button
Step8: Select a value for Caller and Enter value for short_description
Step9: Read the incident number and save it a variable
Step10: Click on Submit button
Step 11: Search the same incident number in the next search screen as below
Step12: Verify the incident is created successful and take snapshot of the created incident.
 */
public class Servicenow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://dev76574.service-now.com"); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.switchTo().frame(0);
		WebElement Username = driver.findElement(By.name("user_name"));
		Username.sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("gJOBntpDH23i");
		driver.findElement(By.name("not_important")).click();
		WebElement search = driver.findElement(By.xpath("//input[@id='filter']"));
		search.sendKeys("incident");
		search.click();
		driver.findElement(By.linkText("All")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("David Loo");
		driver.findElement(By.id("incident.short_description")).sendKeys("Incident - Short_description");
		String elementval = driver.findElement(By.xpath("(//span[text()='Number']/following::input)[2]")).getAttribute("value");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		System.out.println("Submitted");
		
		WebElement INCNO = driver.findElement(By.xpath("//span[@class='sr-only']/following-sibling::input[1]"));
		INCNO.sendKeys(elementval);
		INCNO.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String INC= driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		System.out.println(INC +" Incident is created successfully");  
		
	}

}
