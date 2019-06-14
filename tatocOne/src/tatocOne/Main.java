package tatocOne;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class Main 
{
	public static void main(String []args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc");
		
		driver.findElement(By.linkText("Basic Course")).click();
		
		gridGate(driver);
		frameDungeon(driver);
		dragAround(driver);
		popupWindow(driver);
		cookieHandling(driver);
	}
	
	public static void gridGate(WebDriver driver)
	{
		//Get Green box
		WebElement green = driver.findElement(By.className("greenbox"));
						
		green.click();
	}
	
	public static void frameDungeon(WebDriver driver)
	{
		//Switch to main frame
				driver.switchTo().frame("main");
				WebElement box1 = driver.findElement(By.id("answer"));
				String box1Color = box1.getAttribute("class");
				
				
				while(true)
				{
					//Switching frame to child
					driver.switchTo().frame("child");
					WebElement box2 = driver.findElement(By.id("answer"));
					String box2Color = box2.getAttribute("class");
					
//					System.out.println(box2Color);
					
					if(! box1Color.equals(box2Color))
					{
						System.out.println(box1Color + "!=" + box2Color);
						//Switch to parent(main) frame to access repaint of main
						driver.switchTo().parentFrame();
						WebElement repaint = driver.findElement(By.linkText("Repaint Box 2"));
						repaint.click();
					}// end if
					else
						break;
				}
				
				//Switching frame to parent(main)
				driver.switchTo().parentFrame();
				WebElement proceed = driver.findElement(By.linkText("Proceed"));
				proceed.click();
	}
	
	public static void dragAround(WebDriver driver)
	{
		WebElement toDrag = driver.findElement(By.id("dragbox"));
		WebElement dropbox = driver.findElement(By.id("dropbox"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(toDrag, dropbox).build().perform();
		
		WebElement proceed = driver.findElement(By.linkText("Proceed"));
		proceed.click();
	}
	
	public static void popupWindow(WebDriver driver)
	{
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
	
	public static void cookieHandling(WebDriver driver)
	{
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
