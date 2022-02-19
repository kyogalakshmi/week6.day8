package week6.day2;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 1.Take the the screenshot of the click me button of first frame
2.Find the number of frames
  - find the Elements by tagname - iframe
  - Store it in a list
  - Get the size of the list. (This gives the count of the frames visible to the main page)
 */
public class Assignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/frame.html");
		WebElement Insideframe = driver.findElement(By.xpath("//iframe[@src='default.html']"));
		driver.switchTo().frame(Insideframe);
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,
				new File("D:\\MavenProject2\\src\\main\\resources\\Screenshots\\FrameScreenshot.png"));
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		int size = driver.findElements(By.xpath("//iframe")).size();
		System.out.println(size);
	}

}
