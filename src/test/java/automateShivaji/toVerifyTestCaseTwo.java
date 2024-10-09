package automateShivaji;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class toVerifyTestCaseTwo {

	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		op.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
            put("credentials_enable_service", false);
            put("profile.password_manager_enabled", false);
        }});
		WebDriver driver = new ChromeDriver(op);
		
		
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
		//Thread.sleep(5000);
		
		driver.close();

	}

}
