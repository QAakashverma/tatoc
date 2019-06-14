package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;

public class Test 
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.get("D:\\html\\test.html");
		
		WebElement proceed = driver.findElement(By.linkText("Proceed"));
		
		proceed.click();
	}
}
