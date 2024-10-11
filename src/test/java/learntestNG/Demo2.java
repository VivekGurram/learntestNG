package learntestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo2 {
	
	WebDriver driver = new ChromeDriver();
	//@BeforeClass
	
	
	
	@BeforeTest
	public void bm() throws InterruptedException
	{
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 Thread.sleep(3000);
	 boolean logo =driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
     System.out.println("logo is displayed " +" " +logo);
	}

	
	
	@BeforeMethod
	public void m2()
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	}
	
	@Test
	public void m3() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")).click();
		
	}
	@AfterMethod
	public void am() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='oxd-dropdown-menu']//following-sibling::li)[4]")).click();
	}
	@AfterTest
	public void at()
	{
		//driver.close();
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
