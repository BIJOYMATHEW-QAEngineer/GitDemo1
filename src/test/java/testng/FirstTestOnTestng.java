package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestOnTestng {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {

		 driver = new ChromeDriver();

		driver.get("https://www.google.com");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}

	@Test(priority=1,groups="title")
	public void googleTitleTest() {
		String text = driver.getTitle();
		System.out.println(text);
	}
	
	@Test(priority=2,groups="logo")
	public void googleLogoTest()
	{
		boolean a= driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	System.out.println(a);
	}

	@Test(priority=3,groups="link")
	public void googlelinkTest()
	{
		boolean b=driver.findElement(By.linkText("Gmaill")).isDisplayed();
		System.out.println(b);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
