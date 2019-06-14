package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;


public class GridGate
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc/basic/grid/gate");
		
		//Get Green box
		WebElement green = driver.findElement(By.className("greenbox"));
		
		green.click();
	}
}
