package testScenarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CompareWebTableData {

	ArrayList<String> exp_Data=new ArrayList<String>();
	ArrayList<String> act_Data=new ArrayList<String>();
	
	FileReader fr;
	BufferedReader br;
	String src="C:\\selenium2\\sarah\\data.txt";
		@Test(priority=1)
		public void readFrmTextFile() throws IOException
		{
			fr= new FileReader(src);
			br=new BufferedReader(fr);
			String content=null;
			while((content=br.readLine())!=null)
			{
				//System.out.println(content);
				exp_Data.add(content);
				
			}
			br.close();
		}
		@Test(priority=2)
		public void readFrmWebTable()
		{
			WebDriver driver=new EdgeDriver();
			driver.get("https://www.w3schools.com/html/html_tables.asp");
			driver.manage().window().maximize();
			WebElement myTable=driver.findElement(By.id("customers"));
			List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
			System.out.println("total rows="+allRows.size());
			for(int i=1;i<allRows.size();i++)
			{
				List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
				for(int j=0;j<allCols.size();j++)
				{
					act_Data.add(allCols.get(j).getText());
				}
			}
			
			
			driver.quit();
		}
		@Test(priority=3)
		public void compareWebTable()
		{
			for(int i=0;i<exp_Data.size();i++)
			{
				if(exp_Data.get(i).equals(act_Data.get(i)))
				{
					System.out.println("Item Matched..");
				}
				else
				{
					System.out.println("Item not Matched..");
				}
			}
		}
}
