package practise;

import org.testng.annotations.Test;

import com.genericUtilities.ExcelUtility;

public class DataProvider {
	ExcelUtility eu= new ExcelUtility();
	
	@org.testng.annotations.DataProvider(name="data")
	public Object[][] dataProvider() throws Throwable
	{
		int row = eu.getLastRowNo("Payment");
		
		Object[][] obj=new Object[3][2];
		
		obj[0][0]=eu.readDataFromExcel("Payment", 0, 0);
		obj[0][1]=eu.readDataFromExcel("Payment", 0, 1);
		
		obj[1][0]=eu.readDataFromExcel("Payment", 1, 0);
		obj[1][1]=eu.readDataFromExcel("Payment", 1, 1);
		
		obj[2][0]=eu.readDataFromExcel("Payment", 2, 0);
		obj[2][1]=eu.readDataFromExcel("Payment", 2, 1);
		
		return obj;
		
	}
	
	@Test(dataProviderClass =practise.DataProvider.class, dataProvider = "data")
	public void test(String a,String b)
	{
		System.out.println(a+" = "+b);
	}

}
