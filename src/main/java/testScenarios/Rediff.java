package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rediff {

	WebDriver driver=new EdgeDriver();
	
	@Test(description="Launch",priority=1)
	public void openRediff()
	{
		System.out.println("Launch Rediff...");
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		
	}
	@Test(description="Login",priority=2)
	public void loginRediff()
	{
		System.out.println("Login Rediff..");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Rediffmail - Free Email for Login with Secure Access");
		System.out.println("Assert Executed..");
		System.out.println("title is matching...");
		
	}
	@Test(description="Close",priority=3)
	public void closeRediff()
	{
		System.out.println("Close Rediff.");
		driver.quit();
		
	}
}
