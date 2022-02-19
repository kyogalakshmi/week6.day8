package week6.day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); 
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		
		driver.get("https://www.nykaa.com/"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));        
       WebElement Username = driver.findElement(By.xpath("(//a[@class='css-38r9y0'])[2]"));
	    Actions action = new Actions(driver);
		action.moveToElement(Username).perform();
		WebElement Filter = driver.findElement(By.xpath("//div[@class='SearchIcon']/following-sibling::input[1]"));
		Filter.sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//div[@class='css-ov2o3v']//a")).click();
		String Title = driver.getTitle();
		if(Title.contains("L'Oreal"))
		{
			System.out.println("Title----"+Title);  
		}
		driver.findElement(By.xpath("//button[@class=' css-p2rfnw']")).click();
		WebElement radio1 = driver.findElement(By.xpath("(//label[@for='radio_customer top rated_undefined']//div)[2]"));	
		radio1.click();	
		driver.findElement(By.xpath("//div[@id='first-filter']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//label[@for='checkbox_Shampoo_316']//div)[2]")).click();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
	WebElement selected = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		String selected1 = selected.getText();
		if(selected.isSelected());
		{
		System.out.println(selected1+"------Selected");
		}
       driver.getWindowHandle();
		driver.findElement(By.xpath("//div[@class='css-43m2vm']//img")).click();
		Set <String> Handles = driver.getWindowHandles();
		for (String newwindow: Handles)
		{
			driver.switchTo().window(newwindow);
		}
		Select Dropdwon = new Select(driver.findElement(By.xpath("//div[@class='css-11wjdq4']//select[1]")));
		Dropdwon.selectByVisibleText("360ml");
		String Price = driver.findElement(By.xpath("//span[@class='css-1888qy']/following-sibling::span[1]")).getText();
		String replaceAll = Price.replaceAll("\\D", "");
		int MRP = Integer.parseInt(replaceAll);
		System.out.println("MRP: " + MRP); 
		driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
		driver.findElement(By.xpath("//span[text()='1']")).click();
		driver.switchTo().frame(0);
		String gt1 = driver.findElement(By.xpath("//div[@class='first-col']/div")).getText();
		String replaceAll1 = gt1.replaceAll("\\D", "");
		int grandTotal1 = Integer.parseInt(replaceAll1);
		System.out.println("Grand Total amount1: " + grandTotal1);
		String grandTotal11 = Integer.toString(grandTotal1);
		driver.findElement(By.xpath("//button[contains(@class,'btn full')]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,'btn full')])[2]")).click();
		String gt2= driver.findElement(By.xpath("(//div[@class='value']//span)[2]")).getText();
		String replaceAll2 = gt2.replaceAll("\\D", "");
		int grandTotal2 = Integer.parseInt(replaceAll2);
		System.out.println("Grand Total amount2: " + grandTotal2);
		String grandTotal22 = Integer.toString(grandTotal2);
		if(grandTotal11.equals(grandTotal22))
		{
			System.out.println("Both grand total are same");
		}
		else
		{
			System.out.println("Grand total are not same");
		}
		
	}

}
