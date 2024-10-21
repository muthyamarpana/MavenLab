package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SwitchingWind {

	WebDriver driver;
	@Test
	public void winswitch()
	{
		driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		//to store window ids opened by the driver object
		Set<String> allWinIds=driver.getWindowHandles();//brings all the window session id opend by this driver
			//getwindowHandle()-- gets only the window id focused by the driver object
		System.out.println("total windows opened="+allWinIds.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWinIds.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println(win1);
		System.out.println(win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title="+driver.getTitle());
		boolean chkLogin=driver.findElement(By.linkText("Log in")).isEnabled();
		System.out.println(chkLogin);
		Assert.assertEquals(chkLogin, true);
		
//		driver.close();
		driver.quit();
		
	}
}
