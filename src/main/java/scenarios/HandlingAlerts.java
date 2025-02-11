package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class HandlingAlerts {
WebDriver driver;
	@Test
	public void alerts_demo() throws InterruptedException
	{
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		String alertMssg=driver.switchTo().alert().getText();
		System.out.println(alertMssg);
		driver.switchTo().alert().sendKeys("George");
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		driver.quit();
		
		
	}
}
