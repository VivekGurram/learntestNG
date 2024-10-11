package listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;


 
public class listeners {
	WebDriver driver;
	
    @BeforeClass
    public void setup() {
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
    }
	
	@Test(priority=1)
	public void openapp() throws InterruptedException
	{
		
		System.out.println("opening the app");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	@Test(priority=2, dependsOnMethods = {"openapp"})
	public void logocheck() throws InterruptedException 
	{
		System.out.println("checking logo");		
		boolean logo =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo is displayed " +" " +logo);
	}
	@Test(priority=3, dependsOnMethods= {"openapp"})
	public void login() throws InterruptedException
	{
		Thread.sleep(4000);
		System.out.println("login to app");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	boolean	status=driver.findElement(By.xpath("//div[@class='oxd-topbar-header-title']")).isDisplayed();
	System.out.println(status);
	Assert.assertEquals(status, true);
	
	
	}
	
   @Test(priority=4, dependsOnMethods = {"login"})
	public void logout() throws InterruptedException
	{
		System.out.println("logout to app");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='oxd-dropdown-menu']//following-sibling::li)[4]")).click();
	}
	
   @AfterClass
   void close()
   {
   	//driver.close();
   }
}
