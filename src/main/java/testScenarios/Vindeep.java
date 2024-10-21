package testScenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Vindeep {

	@Test
	public void vindeep() throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver obj = new ChromeDriver();
		ArrayList<String> exp_Data=new ArrayList<String>();
		exp_Data.add("Days");
		exp_Data.add("Months");
		exp_Data.add("Years");
		WebDriver obj = new EdgeDriver();
		obj.get("https://vindeep.com/Calculators/FDCalc.aspx");
		obj.manage().window().maximize();
		String title=obj.getTitle();
		System.out.println("title="+title);
		Thread.sleep(5000);
		if(title.equals("Fixed Deposit Calculator | Calculate FD Interest, Maturity value"))
		{
			System.out.println("Title Matched...");
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("200000");
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).clear();
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).sendKeys("70");
			Select opts=new Select(obj.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown")));
			opts.selectByVisibleText("Days");
			List<WebElement> allItems=opts.getOptions();
			for(int i=0;i<allItems.size();i++)
			{
				System.out.println(allItems.get(i).getText());
				if(exp_Data.get(i).equals(allItems.get(i).getText()))
				{
					System.out.println("Item Matched..");
				}
				else
				{
					System.out.println("Item not Matched...");
				}
			}
			System.out.println("Total Items="+allItems.size());   //3
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).clear();  //clears
			obj.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).sendKeys("5.40");  //enters data in Rate of Interest
			obj.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnFDMAmount")).click();
			Thread.sleep(5000);
			String fdMaturityAmount=obj.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox")).getAttribute("value");
			System.out.println("FD Maturity Amount="+fdMaturityAmount);

		}
		else
		{
			System.out.println("title not matched...");
		}
		obj.quit();

	}

}
