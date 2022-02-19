package week6.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on contacts Button
	 * 	
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 
	 * 7. Click on Widget of From Contact
	 * 
	 * 8. Click on First Resulting Contact
	 * 
	 * 9. Click on Widget of To Contact
	 * 
	 * 10. Click on Second Resulting Contact
	 * 
	 * 11. Click on Merge button using Xpath Locator
	 * 
	 * 12. Accept the Alert
	 * 
	 * 13. Verify the title of the page
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();

		// 8. Click on First Resulting Contact
		Set<String> handlesFrom = driver.getWindowHandles();
		List<String> windowFrom = new ArrayList<String>(handlesFrom);
		driver.switchTo().window(windowFrom.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[1]")).click();

		// 9. Click on Widget of To Contact
		driver.switchTo().window(windowFrom.get(0));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
		Set<String> handlesTo = driver.getWindowHandles();
		List<String> windowTo = new ArrayList<String>(handlesTo);
		driver.switchTo().window(windowTo.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(windowFrom.get(0));
		Thread.sleep(2000);
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());

	}

}
