package week6.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment5Sortable {
//https://jqueryui.com/sortable
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable");

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		 List<WebElement> dragAndDropElement = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		    System.out.println(dragAndDropElement.size());
		    
		    for(int i =1;i<dragAndDropElement.size();i++) {
		        
		        WebElement element = driver.findElement(By.xpath("((//ul[@id='sortable']/li)["+i+"])"));
		        
		        WebElement destination1 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[1])"));
		        WebElement destination2 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[2])"));
		        WebElement destination3 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[3])"));
		        WebElement destination4 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[4])"));
		        WebElement destination5 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[5])"));
		        WebElement destination6 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[6])"));
		        WebElement destination7 = driver.findElement(By.xpath("((//ul[@id='sortable']/li)[7])"));
		        
		        Actions action = new Actions(driver);
		        
		        if(element!=null) {
		            
		            action.dragAndDrop(destination7,element).perform();
		            action.dragAndDrop(destination6,element).perform();
		            action.dragAndDrop(destination5,element).perform();
		            action.dragAndDrop(destination4,element).perform();
		            action.dragAndDrop(destination3,element).perform();
		            action.dragAndDrop(destination2,element).perform();
		            action.dragAndDrop(destination1,element).perform();
		            
		            break;
		            
		        }
		        
		    }
		
	}
	
	

}
