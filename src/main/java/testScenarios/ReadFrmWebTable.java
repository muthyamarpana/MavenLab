package testScenarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ReadFrmWebTable {

	FileWriter fw;
	BufferedWriter bw;
	String src="C:\\selenium2\\sarah\\data.txt";
	@Test
	public void readFrmTable() throws IOException
	{
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
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
//				System.out.println(allCols.get(j).getText());
				bw.write(allCols.get(j).getText());
				bw.newLine();
			}
		}
		bw.close();
		
		driver.quit();
	}
}
