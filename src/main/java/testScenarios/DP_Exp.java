package testScenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Exp {

	Object[][] data;
	
	@DataProvider(name="data")
	public Object[][] setData()
	{
		data=new Object[3][2];
		data[0][0]="test";
		data[0][1]="test1";
		
		data[1][0]="check";
		data[1][1]="check1";
		
		data[2][0]="temp";
		data[2][1]="temp1";
		return data;
	}
	@Test(dataProvider = "data")
	public void login(String un,String pwd)
	{
		System.out.println(un+"\t"+pwd);
	}
}
