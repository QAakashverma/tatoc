package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.WebElement;

public class FrameDungeon
{
	public static void main(String []args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\akash.verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Navigate to URL
		driver.navigate().to("http://10.0.1.86/tatoc/basic/frame/dungeon");
		
		
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
			
//			System.out.println(box2Color);
			
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
	
	}//main()
}// class FrameDungeon
