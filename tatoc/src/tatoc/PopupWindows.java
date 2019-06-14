package tatoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PopupWindows
{
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc/basic/windows");
		
		WebElement launchPopup = driver.findElement(By.linkText("Launch Popup Window"));
		launchPopup.click();
		
		//Switch tab
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		
		String parentWindow = driver.getWindowHandle();
		System.out.println( "Parent ID = " + parentWindow);
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		it.next();
		String childWindow = it.next();
		System.out.println("Child Window = " + childWindow);
		
		driver.switchTo().window(childWindow);
		
		//Work to do on reaching desired window
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("Akash Verma");
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		
		//Go to parent window to click proceed
		driver.switchTo().window(parentWindow);
		WebElement proceed = driver.findElement(By.linkText("Proceed"));
		proceed.click();
	}
}
