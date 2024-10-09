package automateShivaji;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class toVerifyTestCaseOne 
{
   // WebDriver driver;
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		 
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://console.tevi.co/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("signinSrEmail")).sendKeys("tevicouser@gmail.com");
		driver.findElement(By.id("signupSrPassword")).sendKeys("@10724e2eF");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement intro = driver.findElement(By.xpath("(//div[@class='row'])[4]/div/div/div/h2"));
		
		String itext = intro.getText();
		
		Assert.assertEquals(itext, "Welcome to Tevico");
		if(itext.equals("Welcome to Tevico"))
		{
			System.out.println("User is successfully logged in, Thank you");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div/div/div[3])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//aside[@id='sidebar']/div/div/a/following-sibling::button")).click();
		Thread.sleep(2000);
		/*
		//WebElement foot = driver.findElement(By.xpath("//app-footer/div/div/div/div/ul/li[3]"));
		WebElement load = driver.findElement(By.xpath("//tbody/tr/td/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		*/
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement load = driver.findElement(By.xpath("//tbody/tr/td/a"));
		wait.until(ExpectedConditions.visibilityOf(load));
		
		load.click();
		Thread.sleep(2000);
		
		WebElement popup = driver.findElement(By.xpath("//div[@class='modal-content']"));
		
		if(popup.isDisplayed())
		{
			WebElement icon = driver.findElement(By.xpath("//div[@class='modal-header']/p/following-sibling::button"));
			String greet = driver.findElement(By.xpath("//div[@class='modal-content']/ng-component/div/p")).getText();
			System.out.println(greet);
			icon.click();
			Thread.sleep(2000);
		}
        driver.close();
	}

}
