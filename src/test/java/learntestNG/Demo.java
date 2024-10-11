package learntestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
     @BeforeTest
     public void setup() {
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
	
	@Test(priority=1, groups= {"regression"})
	public void openapp() throws InterruptedException
	{
		
		System.out.println("opening the app");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void logocheck() throws InterruptedException 
	{
		System.out.println("checking logo");		
		boolean logo =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo is displayed " +" " +logo);
	}
	@Test(priority=3, dependsOnMethods= {"openapp","logocheck"} )
	public void login() throws InterruptedException
	{
		Thread.sleep(4000);
		System.out.println("login to app");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	}
	
    @Test(priority=4, dependsOnMethods = {"login"})
	public void logout() throws InterruptedException
	{
		System.out.println("logout to app");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='oxd-dropdown-menu']//following-sibling::li)[4]")).click();
	}
	
    @AfterTest
    void close()
    {
    	driver.close();
    }
}
