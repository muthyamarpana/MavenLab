package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CheckAndRadBtns {

	WebDriver driver;
	
	@Test
	public void verifyChkAndRadBtns()
	{
		driver=new EdgeDriver();
		driver.get("https://www.letskodeit.com/practice");
		driver.manage().window().maximize();
		WebElement radBMW=driver.findElement(By.id("bmwradio"));
		radBMW.click();
		boolean chkRadBMW=radBMW.isSelected();
		if(chkRadBMW==true)
		{
			System.out.println("Radio button BMW is selected..");
		}
		else
		{
			System.out.println("Radio button BMW is not selected..");
		}
		WebElement chkBenz=driver.findElement(By.id("benzcheck"));
		WebElement chkHonda=driver.findElement(By.id("hondacheck"));
		chkBenz.click();
		chkHonda.click();
		if(chkBenz.isSelected() && chkHonda.isSelected())
		{
			System.out.println("Benz and Honda are selected");
		}
		driver.quit();
	}
}
