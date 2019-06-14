package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;

public class CookieHandling
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc/basic/cookie");
		
		//Click on generate token
		WebElement generateToken = driver.findElement(By.linkText("Generate Token"));
		generateToken.click();
		
		//Copy token
		WebElement webtoken = driver.findElement(By.id("token"));
		String token = webtoken.getText();
		
		System.out.println(token);
		
		String []temp = token.split(": ");
		String cookieName = temp[0];
		String cookieValue = temp[1];
		
		
		Cookie cookie = new Cookie(cookieName, cookieValue);
		
		driver.manage().addCookie(cookie);
		
		WebElement proceed = driver.findElement(By.linkText("Proceed"));
		proceed.click();
	}
}
