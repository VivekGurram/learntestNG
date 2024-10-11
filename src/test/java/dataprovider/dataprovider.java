package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider 
{
WebDriver driver;

 @BeforeClass
 public void setup()
 {
	 driver =new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 }
	
 @Test(dataProvider = "dp")
 public void login(String email, String password)
 {
	 driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	 driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 boolean text= driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).isDisplayed();
	 System.out.println(text);
	 if(text == true)
	 {
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		 Assert.assertTrue(true);		 
	 }
	 else {
		 Assert.fail();
	 }
 }
 
 @DataProvider(name= "dp", indices= {1})
 String[][] logindata()
 {
	 String data[][] = {{"vivek@gmail.com","test@123"},{"pavanol123@gmail.com","test@123"},{"ram@gmail.com","test@123"}};
	 return data;
 }
 
 @AfterClass
 public void logout()
 {
	 driver.close();
 }
   
 
}
