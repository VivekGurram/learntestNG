package learntestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
WebDriver driver; 

@Test(groups = {"sanity"})
public void openGoogle()
{
	driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.close();
}


}
