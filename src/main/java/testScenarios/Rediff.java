package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Rediff {

	WebDriver driver;
	@Test(description="Launch app",priority=1)
	public void openRediff()
	{
		System.out.println("Open Rediff");
		driver = new EdgeDriver();
		driver.get("https://www.rediff.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();
		
	}
	@Test(description="login-Hard",priority=2,enabled=false)
	public void login1()
	{
		System.out.println("Login Rediff");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Rediffmail");  // Hard Assert
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("jack");
		driver.findElement(By.id("password")).sendKeys("jack123");
		driver.findElement(By.id("remember")).click();
	}
	@Test(description="login-Soft",priority=2)
	public void login()
	{
		SoftAssert assertion = new SoftAssert();
		System.out.println("Login Rediff");
		String title=driver.getTitle();
		assertion.assertEquals(title, "Rediffmail");  // soft Assert
		System.out.println("Assert Executed...");
		driver.findElement(By.id("login1")).sendKeys("jack");
		driver.findElement(By.id("password")).sendKeys("jack123");
		driver.findElement(By.id("remember")).click();
		assertion.assertAll();
	}
	@Test(description="Close app",priority=3)
	public void closeRediff()
	{
		System.out.println("Close Rediff");
		driver.quit();
	}
}
