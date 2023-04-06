package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	@Test(dataProvider="data")
	public void getData(String frm,String to)
	{
		System.out.println("From---"+frm+"   To----"+to);
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="qspider";
		obj[0][1]="testyantra";
		obj[1][0]="testyantra";
		obj[1][1]="Sony";
		obj[2][0]="Sony";
		obj[2][1]="Infosys";
		return obj;
	}

}
