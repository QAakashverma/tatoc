package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragAround
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc/basic/drag");
		
		WebElement toDrag = driver.findElement(By.id("dragbox"));
		WebElement dropbox = driver.findElement(By.id("dropbox"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(toDrag, dropbox).build().perform();
		
		WebElement proceed = driver.findElement(By.linkText("Proceed"));
		proceed.click();
	}
}
